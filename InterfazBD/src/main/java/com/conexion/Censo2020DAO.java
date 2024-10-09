package com.conexion;

/**
 *
 * @author juanj
 */


import static com.conexion.Conexion.close;
import static com.conexion.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.objects.Censo2020;

/**
 *
 * @author juanj
 */
public class Censo2020DAO {
    private static final String SQL_SELECT = "SELECT * FROM censo2020";
    private static final String SQL_INSERT = "INSERT INTO censo2020(identidad, idmunicipio, idlocalidad, pob_total, pob_femenina, pob_masculina) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE censo2020 set identidad = ?, idmunicipio = ?, idlocalidad = ?, pob_total = ?, pob_femenina = ?, pob_masculina = ? WHERE identidad = ? AND idmunicipio = ? AND idlocalidad = ?";
    private static final String SQL_DELETE = "DELETE FROM censo2020 WHERE identidad = ? AND idmunicipio = ? AND idlocalidad = ?";
    
    public List<Censo2020> seleccionar(){
        Connection conn = null;        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Censo2020 censo2020 = null;
        
        List<Censo2020> censos2020 = new ArrayList<>();
        
        try
        {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while(rs.next()){
                int identidad = rs.getInt("identidad");
                int idmunicipio = rs.getInt("idmunicipio");
                int idlocalidad = rs.getInt("idlocalidad");
                int pobTotal = rs.getInt("pob_total");
                int pobFemenina = rs.getInt("pob_femenina");
                int pobMasculina = rs.getInt("pob_masculina");
                
                censo2020 = new Censo2020(identidad, idmunicipio, idlocalidad, pobTotal, pobFemenina, pobMasculina);
                
                censos2020.add(censo2020);
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
        return censos2020;
    }
    
    public int insertar(Censo2020 censo2020){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try
        {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, censo2020.getIdentidad());
            stmt.setInt(2, censo2020.getIdmunicipio());
            stmt.setInt(3, censo2020.getIdlocalidad());
            stmt.setInt(4, censo2020.getPob_total());
            stmt.setInt(5, censo2020.getPob_femenina());
            stmt.setInt(6, censo2020.getPob_masculina());
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
    
    public int actualizar(Censo2020 censo2020, int antEntidad, int antMunicipio, int antLocalidad){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try
        {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, censo2020.getIdentidad());
            stmt.setInt(2, censo2020.getIdmunicipio());
            stmt.setInt(3, censo2020.getIdlocalidad());
            stmt.setInt(4, censo2020.getPob_total());
            stmt.setInt(5, censo2020.getPob_femenina());
            stmt.setInt(6, censo2020.getPob_masculina());
            
            stmt.setInt(7, antEntidad);
            stmt.setInt(8, antMunicipio);
            stmt.setInt(9, antLocalidad);
            
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
    
    public int eliminar(Censo2020 censo2020){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try
        {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, censo2020.getIdentidad());
            stmt.setInt(2, censo2020.getIdmunicipio());
            stmt.setInt(3, censo2020.getIdlocalidad());
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
