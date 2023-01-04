package juanp.conexionmysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    
    public static void main(String[] args) {
        ConexionMySQL mysql = ConexionMySQL.getInstance();
        Connection conn = mysql.getConnection();

        String query = "DELETE FROM cliente WHERE id = ?";
        PreparedStatement ps;
        
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, 5);
            
            if (ps.executeUpdate() > 0) {
                System.out.println("¡DELETE exitoso!");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        mysql.close();
    }
}
