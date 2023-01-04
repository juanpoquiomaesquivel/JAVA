package juanp.conexionmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {

    private static ConexionMySQL instance;
    private Connection connection;

    private ConexionMySQL() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/conexionmysql",
                    "root",
                    "admin");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static ConexionMySQL getInstance() {
        if (instance == null) {
            instance = new ConexionMySQL();
        }

        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
    
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            connection = null;
        }
    }
}
