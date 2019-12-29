package db;

import lombok.SneakyThrows;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static db.DatabaseContract.*;
import static java.sql.DriverManager.getConnection;

public class DatabaseHelper {
    protected Statement statement;

    public DatabaseHelper() {
        try {
            statement = getConnection(BASE_URL).createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public ArrayList<Entity> query(String query) {
        ArrayList<Entity> entities = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                entities.add(new Entity(
                                resultSet.getInt(KEY_ID),
                                resultSet.getString(KEY_NAME)
                        )
                );
            }
            return entities;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            getConnection(BASE_URL).close();
        }
        return entities;
    }
}