package SeaBattle.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:h2:tcp://localhost/~/test";
        String user = "sa";
        String passwd = "";
        return DriverManager.getConnection(url, user, passwd);
    }
}
