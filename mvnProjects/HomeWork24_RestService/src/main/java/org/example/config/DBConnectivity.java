package org.example.config;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectivity {
    private static Connection connection;
    private static String serverTimeZone = "UTC";
    private static String servername = "localhost";
    private static String databaseName = "hillel_orders";
    private static int databasePort = 3306;
    private static String user = "root";
    private static String password = "RootRoot2024";

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUseSSL(false);
            dataSource.setServerTimezone(serverTimeZone);
            dataSource.setServerName(servername);
            dataSource.setDatabaseName(databaseName);
            dataSource.setPortNumber(databasePort);
            dataSource.setUser(user);
            dataSource.setPassword(password);
            dataSource.setAllowPublicKeyRetrieval(true);
            connection = dataSource.getConnection();
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
            connection = null;
        }
    }
}
