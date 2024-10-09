package com.conexion;

import static com.conexion.Conexion.*;
import com.objects.Entidad;
//import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author juanj
 */
public class EntidadDAO {
    private static final String SQL_SELECT = "SELECT identidad, nom_entidad FROM entidades";
    private static final String SQL_INSERT = "INSERT INTO entidades(identidad, nom_entidad) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE entidades set identidad = ?, nom_entidad = ? WHERE identidad = ?";
    private static final String SQL_DELETE = "DELETE FROM entidades WHERE identidad = ?";
    
    public List<Entidad> seleccionar(){
        Connection conn = null;        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Entidad entidad = null;
        
        List<Entidad> entidades = new ArrayList<>();
        
        try
        {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                int identidad = rs.getInt("identidad");
                String nom_entidad = rs.getString("nom_entidad");
                
                entidad = new Entidad(identidad, nom_entidad);
                
                entidades.add(entidad);
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace(System.out);
        }
        finally{
            try
            {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex)
            {
                ex.printStackTrace(System.out);
            }
        }
        return entidades;
    }
    
    public int insertar(Entidad entidad){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try
        {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, entidad.getIdentidad());
            stmt.setString(2, entidad.getNom_entidad());
            registros = stmt.executeUpdate();
        } catch(SQLIntegrityConstraintViolationException ex)
        {
            JOptionPane.showMessageDialog(null, "El id que intentas ingresar ya existe");
        } catch (SQLException ex)
        {
            ex.printStackTrace(System.out);
        } 
        finally {
            try
            {
                close(stmt);
                close(conn);
            } catch (SQLException ex)
            {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int actualizar(Entidad entidad, int anterior){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try
        {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, entidad.getIdentidad());
            stmt.setString(2, entidad.getNom_entidad());
            stmt.setInt(3, anterior);
            
            registros = stmt.executeUpdate();
        }catch(SQLIntegrityConstraintViolationException ex)
        {
            JOptionPane.showMessageDialog(null, "El id que intentas ingresar ya existe");
        }catch (SQLException ex)
        {
            ex.printStackTrace(System.out);
        } 
        finally {
            try
            {
                close(stmt);
                close(conn);
            } catch (SQLException ex)
            {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int eliminar(Entidad entidad){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try
        {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, entidad.getIdentidad());
            registros = stmt.executeUpdate();
        } catch (SQLException ex)
        {
            ex.printStackTrace(System.out);
        } 
        finally {
            try
            {
                close(stmt);
                close(conn);
            } catch (SQLException ex)
            {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
