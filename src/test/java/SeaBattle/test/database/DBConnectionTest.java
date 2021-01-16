package SeaBattle.test.database;

import SeaBattle.database.DBConnection;
import SeaBattle.database.DataStorage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class DBConnectionTest {

    private static Connection connection;

    @Before
    public void init() throws SQLException {
        connection = DBConnection.getConnection();
    }
    @After
    public void close() throws SQLException {
        connection.close();
    }

    @Test
    public void shouldGetJdbcConnection() throws SQLException {
        try(Connection connection = DBConnection.getConnection()) {
            assertTrue(connection.isValid(1));
            Assert.assertFalse(connection.isClosed());
        }
    }

    @Test
    public void shouldCreateShipTable() throws SQLException {
//        DataStorage.saveToDb(new Ship(0, 0, 2, 0));
        //DataStorage.saveToDb(new Ship(3, 5, 3, 1));
        connection.createStatement().execute("SELECT * FROM ships");
        //connection.createStatement().execute("DELETE FROM SHIPS");
        System.out.println(DataStorage.getAllShips());
    }
    @Test
    public void shoudGetMetadata() throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet result = metaData.getTables("TEST", "PUBLIC", "%", null);
        List<String> tables = new ArrayList<>();
        while(result.next()) {
            tables.add(result.getString(2) + "." + result.getString(3));
        }
        assertTrue(tables.contains("PUBLIC.CUSTOMERS"));
    }
}
