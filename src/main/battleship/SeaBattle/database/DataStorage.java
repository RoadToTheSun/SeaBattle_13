package SeaBattle.database;

import SeaBattle.model.Ship;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static SeaBattle.database.DBConnection.getConnection;

public class DataStorage {

//TODO
    public static void createTable() throws SQLException {
        try (Connection c = getConnection()) {
            Statement statement = c.createStatement();
            statement.executeUpdate("CREATE TABLE ships " +
                    "(x INTEGER, y INTEGER, type INTEGER, direction INTEGER)");
        }
    }

    public static Ship saveToDb(Ship ship) throws SQLException {
        //createTable();
        try (Connection c = getConnection()) {
            PreparedStatement statement = c.prepareStatement("insert into ships (x, y, type, direction) values (?, ?, ?, ?)");
//            statement.setInt(1, ship.getX());
//            statement.setInt(2, ship.getY());
//            statement.setInt(3, ship.getType());
//            statement.setInt(4, ship.getDirection());
            statement.executeUpdate();
        }
        return ship;
    }

    public static List<Ship> getAllShips() throws SQLException {
        List<Ship> result = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select x, y, type, direction from ships");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
//                Ship f = new Ship(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
//                result.add(f);
            }
            return result;
        } catch (SQLException exception) {
            throw new SQLException("Cannot load flowers", exception);
        }
    }
}
