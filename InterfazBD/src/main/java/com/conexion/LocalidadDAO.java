package com.conexion;

import static com.conexion.Conexion.close;
import static com.conexion.Conexion.getConnection;
import com.objects.Localidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanj
 */
public class LocalidadDAO {
    private static final String SQL_SELECT = "SELECT identidad, idmunicipio, idlocalidad, nom_localidad FROM localidades";
    private static final String SQL_INSERT = "INSERT INTO localidades(identidad, idmunicipio, idlocalidad, nom_localidad) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE localidades set identidad = ?, idmunicipio = ?, idlocalidad = ?, nom_localidad = ? WHERE identidad = ? AND idmunicipio = ? AND idlocalidad = ?";
    private static final String SQL_DELETE = "DELETE FROM localidades WHERE identidad = ? AND idmunicipio = ? AND idlocalidad = ?";
    
    public List<Localidad> seleccionar(){
        Connection conn = null;        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Localidad localidad = null;
        
        List<Localidad> localidades = new ArrayList<>();
        
        try
        {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                int identidad = rs.getInt("identidad");
                int idmunicipio = rs.getInt("idmunicipio");
                int idlocalidad = rs.getInt("idlocalidad");
                String nom_municipio = rs.getString("nom_localidad");
                
                localidad = new Localidad(identidad, idmunicipio, idlocalidad, nom_municipio);
                
                localidades.add(localidad);
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
        return localidades;
    }
    
    public int insertar(Localidad localidad){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try
        {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, localidad.getIdentidad());
            stmt.setInt(2, localidad.getIdmunicipio());
            stmt.setInt(3, localidad.getIdlocalidad());
            stmt.setString(4, localidad.getNom_localidad());
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
    
    public int actualizar(Localidad localidad, int antEntidad, int antMunicipio, int antLocalidad){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try
        {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, localidad.getIdentidad());
            stmt.setInt(2, localidad.getIdmunicipio());
            stmt.setInt(3, localidad.getIdlocalidad());
            stmt.setString(4, localidad.getNom_localidad());
            
            stmt.setInt(5, antEntidad);
            stmt.setInt(6, antMunicipio);
            stmt.setInt(7, antLocalidad);
            
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
    
    public int eliminar(Localidad localidad){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try
        {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, localidad.getIdentidad());
            stmt.setInt(2, localidad.getIdmunicipio());
            stmt.setInt(3, localidad.getIdlocalidad());
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