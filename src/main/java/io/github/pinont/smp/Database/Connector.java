package io.github.pinont.smp.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static io.github.pinont.smp.Core.plugin;

public class Connector {
    public static Connection connection;

    public static Connection init() throws SQLException {
        String host = plugin.getConfig().getString("host");
        String port = plugin.getConfig().getString("port");
        String database = plugin.getConfig().getString("database");
        String username = plugin.getConfig().getString("username");
        String password = plugin.getConfig().getString("password");
        return connection = DriverManager.getConnection(
                "jdbc:mysql://" + host + ":" + port + "/" + database + "?user=" + username + "&password=" +  password + "&useSSL=true&verifyServerCertificate=false"
        );
    }

}
