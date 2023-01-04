package juanp.conexionmysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {
    
    public static void main(String[] args) {
        ConexionMySQL mysql = ConexionMySQL.getInstance();
        Connection conn = mysql.getConnection();

        String query = "SELECT * FROM cliente";
        Statement st;
        ResultSet rs;
        
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            int id;
            String nombres;
            String apellidos;
            
            while (rs.next()) {
                id = rs.getInt("id");
                nombres = rs.getString("nombres");
                apellidos = rs.getString("apellidos");
                System.out.println("Cliente(" + id + ", " + nombres + ", " + apellidos + ")");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        mysql.close();
    }
}
