package juanp.conexionmysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {

    public static void main(String[] args) {
        ConexionMySQL mysql = ConexionMySQL.getInstance();
        Connection conn = mysql.getConnection();

        String query = "INSERT INTO cliente (nombres, apellidos) VALUES (?,?)";
        PreparedStatement ps;
        
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, "Carmen Laura");
            ps.setString(2, "Lara Hurtado");
            
            if (ps.executeUpdate() > 0) {
                System.out.println("¡INSERT exitoso!");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        mysql.close();
    }
}
