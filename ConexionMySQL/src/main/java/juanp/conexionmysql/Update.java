package juanp.conexionmysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    
    public static void main(String[] args) {
        ConexionMySQL mysql = ConexionMySQL.getInstance();
        Connection conn = mysql.getConnection();

        String query = "UPDATE cliente SET nombres = ? WHERE id = ?";
        PreparedStatement ps;
        
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, "Carmen Lorena");
            ps.setInt(2, 5);
            
            if (ps.executeUpdate() > 0) {
                System.out.println("¡UPDATE exitoso!");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        mysql.close();
    }
}
