package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {

    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=TheShoeShop;";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("SQL Server JDBC driver not found.");
        }
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }
}