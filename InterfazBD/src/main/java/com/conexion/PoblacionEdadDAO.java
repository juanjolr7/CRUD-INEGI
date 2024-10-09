package com.conexion;

import static com.conexion.Conexion.close;
import static com.conexion.Conexion.getConnection;
import com.objects.PoblacionEdad;
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
public class PoblacionEdadDAO {

    private static final String SQL_SELECT = "SELECT * FROM poblacion_edad";
    private static final String SQL_INSERT = "INSERT INTO poblacion_edad(identidad, idmunicipio, idlocalidad,P_0A2_F, P_0A2_M, P_3YMAS_F, P_3YMAS_M, P_5YMAS_F, P_5YMAS_M, P_12YMAS_F, P_12YMAS_M, P_15YMAS_F, P_15YMAS_M, P_18YMAS_F, P_18YMAS_M, P_3A5_F, P_3A5_F, P_6A11_F, P_6A11_M, P_8A14_F, P_8A14_M, P_12A14_F, P_12A14_M, P_15A17_F, P_15A17_M, P_18A24_F, P_18A24_M, P_15A49_F, P_60YMAS_F, P_60YMAS_M) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE poblacion_edad set identidad = ?, idmunicipio = ?, idlocalidad = ?, P_0A2_F = ?, P_0A2_M = ?, P_3YMAS_F = ?, P_3YMAS_M = ?, P_5YMAS_F = ?, P_5YMAS_M = ?, P_12YMAS_F = ?, P_12YMAS_M = ?, P_15YMAS_F = ?, P_15YMAS_M = ?, P_18YMAS_F = ?, P_18YMAS_M = ?, P_3A5_F = ?, P_3A5_F = ?, P_6A11_F = ?, P_6A11_M = ?, P_8A14_F = ?, P_8A14_M = ?, P_12A14_F = ?, P_12A14_M = ?, P_15A17_F = ?, P_15A17_M = ?, P_18A24_F = ?, P_18A24_M = ?, P_15A49_F = ?, P_60YMAS_F = ?, P_60YMAS_M  = ? WHERE identidad = ? AND idmunicipio = ? AND idlocalidad = ?";
    private static final String SQL_DELETE = "DELETE FROM poblacion_edad WHERE identidad = ? AND idmunicipio = ? AND idlocalidad = ?";

    public List<PoblacionEdad> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PoblacionEdad poblacionEdad = null;

        List<PoblacionEdad> poblaciones = new ArrayList<>();

        try
        {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next())
            {
                int identidad = rs.getInt("identidad");
                int idmunicipio = rs.getInt("idmunicipio");
                int idlocalidad = rs.getInt("idlocalidad");

                int P_0A2_F = rs.getInt("P_0A2_F");
                int P_0A2_M = rs.getInt("P_0A2_M");
                int P_3YMAS_F = rs.getInt("P_3YMAS_F");
                int P_3YMAS_M = rs.getInt("P_3YMAS_M");
                int P_5YMAS_F = rs.getInt("P_5YMAS_F");
                int P_5YMAS_M = rs.getInt("P_5YMAS_M");
                int P_12YMAS_F = rs.getInt("P_12YMAS_F");
                int P_12YMAS_M = rs.getInt("P_12YMAS_M");
                int P_15YMAS_F = rs.getInt("P_15YMAS_F");
                int P_15YMAS_M = rs.getInt("P_15YMAS_M");
                int P_18YMAS_F = rs.getInt("P_18YMAS_F");
                int P_18YMAS_M = rs.getInt("P_18YMAS_M");
                int P_3A5_F = rs.getInt("P_3A5_F");
                int P_3A5_M = rs.getInt("P_3A5_M");
                int P_6A11_F = rs.getInt("P_6A11_F");
                int P_6A11_M = rs.getInt("P_6A11_M");
                int P_8A14_F = rs.getInt("P_8A14_F");
                int P_8A14_M = rs.getInt("P_8A14_M");
                int P_12A14_F = rs.getInt("P_12A14_F");
                int P_12A14_M = rs.getInt("P_12A14_M");
                int P_15A17_F = rs.getInt("P_15A17_F");
                int P_15A17_M = rs.getInt("P_15A17_M");
                int P_18A24_F = rs.getInt("P_18A24_F");
                int P_18A24_M = rs.getInt("P_18A24_M");
                int P_15A49_F = rs.getInt("P_15A49_F");
                int P_60YMAS_F = rs.getInt("P_60YMAS_F");
                int P_60YMAS_M = rs.getInt("P_60YMAS_M");

                poblacionEdad = new PoblacionEdad(identidad, idmunicipio, idlocalidad, P_0A2_F, P_0A2_M, P_3YMAS_F, P_3YMAS_M, P_5YMAS_F, P_5YMAS_M, P_12YMAS_F, P_12YMAS_M, P_15YMAS_F, P_15YMAS_M, P_18YMAS_F, P_18YMAS_M, P_3A5_F, P_3A5_M, P_6A11_F, P_6A11_M, P_8A14_F, P_8A14_M, P_12A14_F, P_12A14_M, P_15A17_F, P_15A17_M, P_18A24_F, P_18A24_M, P_15A49_F, P_60YMAS_F, P_60YMAS_M);

                poblaciones.add(poblacionEdad);
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace(System.out);
        } finally
        {
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
        return poblaciones;
    }

    public int insertar(PoblacionEdad poblacionEdad) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try
        {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, poblacionEdad.getIdentidad());
            stmt.setInt(2, poblacionEdad.getIdmunicipio());
            stmt.setInt(3, poblacionEdad.getIdlocalidad());
            stmt.setInt(4, poblacionEdad.getP_0A2_F());
            stmt.setInt(5, poblacionEdad.getP_0A2_M());
            stmt.setInt(6, poblacionEdad.getP_12A14_F());
            stmt.setInt(7, poblacionEdad.getP_12A14_M());
            stmt.setInt(8, poblacionEdad.getP_12YMAS_F());
            stmt.setInt(9, poblacionEdad.getP_12YMAS_M());
            stmt.setInt(10, poblacionEdad.getP_15A17_F());
            stmt.setInt(11, poblacionEdad.getP_15A17_M());
            stmt.setInt(12, poblacionEdad.getP_15A49_F());
            stmt.setInt(13, poblacionEdad.getP_15YMAS_F());
            stmt.setInt(14, poblacionEdad.getP_15YMAS_M());
            stmt.setInt(15, poblacionEdad.getP_18A24_F());
            stmt.setInt(16, poblacionEdad.getP_18A24_M());
            stmt.setInt(17, poblacionEdad.getP_18YMAS_F());
            stmt.setInt(18, poblacionEdad.getP_18YMAS_M());
            stmt.setInt(19, poblacionEdad.getP_3A5_F());
            stmt.setInt(20, poblacionEdad.getP_3A5_M());
            stmt.setInt(21, poblacionEdad.getP_3YMAS_F());
            stmt.setInt(22, poblacionEdad.getP_3YMAS_M());
            stmt.setInt(23, poblacionEdad.getP_5YMAS_F());
            stmt.setInt(24, poblacionEdad.getP_5YMAS_M());
            stmt.setInt(25, poblacionEdad.getP_60YMAS_F());
            stmt.setInt(26, poblacionEdad.getP_60YMAS_M());
            stmt.setInt(27, poblacionEdad.getP_6A11_F());
            stmt.setInt(28, poblacionEdad.getP_6A11_M());
            stmt.setInt(29, poblacionEdad.getP_8A14_F());
            stmt.setInt(30, poblacionEdad.getP_8A14_M());
            registros = stmt.executeUpdate();
        } catch (SQLException ex)
        {
            ex.printStackTrace(System.out);
        } finally
        {
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

    public int actualizar(PoblacionEdad poblacionEdad, int antEntidad, int antMunicipio, int antLocalidad) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try
        {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, poblacionEdad.getIdentidad());
            stmt.setInt(2, poblacionEdad.getIdmunicipio());
            stmt.setInt(3, poblacionEdad.getIdlocalidad());
            stmt.setInt(4, poblacionEdad.getP_0A2_F());
            stmt.setInt(5, poblacionEdad.getP_0A2_M());
            stmt.setInt(6, poblacionEdad.getP_12A14_F());
            stmt.setInt(7, poblacionEdad.getP_12A14_M());
            stmt.setInt(8, poblacionEdad.getP_12YMAS_F());
            stmt.setInt(9, poblacionEdad.getP_12YMAS_M());
            stmt.setInt(10, poblacionEdad.getP_15A17_F());
            stmt.setInt(11, poblacionEdad.getP_15A17_M());
            stmt.setInt(12, poblacionEdad.getP_15A49_F());
            stmt.setInt(13, poblacionEdad.getP_15YMAS_F());
            stmt.setInt(14, poblacionEdad.getP_15YMAS_M());
            stmt.setInt(15, poblacionEdad.getP_18A24_F());
            stmt.setInt(16, poblacionEdad.getP_18A24_M());
            stmt.setInt(17, poblacionEdad.getP_18YMAS_F());
            stmt.setInt(18, poblacionEdad.getP_18YMAS_M());
            stmt.setInt(19, poblacionEdad.getP_3A5_F());
            stmt.setInt(20, poblacionEdad.getP_3A5_M());
            stmt.setInt(21, poblacionEdad.getP_3YMAS_F());
            stmt.setInt(22, poblacionEdad.getP_3YMAS_M());
            stmt.setInt(23, poblacionEdad.getP_5YMAS_F());
            stmt.setInt(24, poblacionEdad.getP_5YMAS_M());
            stmt.setInt(25, poblacionEdad.getP_60YMAS_F());
            stmt.setInt(26, poblacionEdad.getP_60YMAS_M());
            stmt.setInt(27, poblacionEdad.getP_6A11_F());
            stmt.setInt(28, poblacionEdad.getP_6A11_M());
            stmt.setInt(29, poblacionEdad.getP_8A14_F());
            stmt.setInt(30, poblacionEdad.getP_8A14_M());

            stmt.setInt(31, poblacionEdad.getIdentidad());
            stmt.setInt(32, poblacionEdad.getIdmunicipio());
            stmt.setInt(33, poblacionEdad.getIdlocalidad());
            
            registros = stmt.executeUpdate();
        } catch (SQLException ex)
        {
            ex.printStackTrace(System.out);
        } finally
        {
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

    public int eliminar(PoblacionEdad poblacionEdad) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try
        {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, poblacionEdad.getIdentidad());
            stmt.setInt(2, poblacionEdad.getIdmunicipio());
            stmt.setInt(3, poblacionEdad.getIdlocalidad());
            registros = stmt.executeUpdate();
        } catch (SQLException ex)
        {
            ex.printStackTrace(System.out);
        } finally
        {
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
