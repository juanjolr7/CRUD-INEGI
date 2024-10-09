package com.conexion;

import static com.conexion.Conexion.close;
import static com.conexion.Conexion.getConnection;
import com.objects.Municipio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author juanj
 */
public class MunicipioDAO {
    private static final String SQL_SELECT = "SELECT identidad, idmunicipio, nom_municipio FROM municipios";
    private static final String SQL_INSERT = "INSERT INTO municipios(identidad, idmunicipio, nom_municipio) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE municipios set identidad = ?, idmunicipio = ?, nom_municipio = ? WHERE identidad = ? AND idmunicipio = ?";
    private static final String SQL_DELETE = "DELETE FROM municipios WHERE identidad = ? AND idmunicipio = ?";
    
    public List<Municipio> seleccionar(){
        Connection conn = null;        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Municipio municipio = null;
        
        List<Municipio> municipios = new ArrayList<>();
        
        try
        {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                int identidad = rs.getInt("identidad");
                int idmunicipio = rs.getInt("idmunicipio");
                String nom_municipio = rs.getString("nom_municipio");
                
                municipio = new Municipio(identidad, idmunicipio, nom_municipio);
                
                municipios.add(municipio);
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
        return municipios;
    }
    
    public int insertar(Municipio municipio){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try
        {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, municipio.getIdentidad());
            stmt.setInt(2, municipio.getIdmunicipio());
            stmt.setString(3, municipio.getNom_municipio());
            registros = stmt.executeUpdate();
        }  catch(SQLIntegrityConstraintViolationException ex)
        {
            JOptionPane.showMessageDialog(null, "El id que intentas ingresar ya existe");
        }  catch (SQLException ex)
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
    
    public int actualizar(Municipio municipio, int antEntidad, int antMunicipio){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try
        {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, municipio.getIdentidad());
            stmt.setInt(2, municipio.getIdmunicipio());
            stmt.setString(3, municipio.getNom_municipio());
            stmt.setInt(4, antEntidad);
            stmt.setInt(5, antMunicipio);
            
            registros = stmt.executeUpdate();
        }  catch(SQLIntegrityConstraintViolationException ex)
        {
            JOptionPane.showMessageDialog(null, "El id que intentas ingresar ya existe");
        }   catch (SQLException ex)
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
    
    public int eliminar(Municipio municipio){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try
        {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, municipio.getIdentidad());
            stmt.setInt(2, municipio.getIdmunicipio());
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