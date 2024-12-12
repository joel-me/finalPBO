package jualbeliapp.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jualbeliapp.entities.Pengguna;

public class PenggunaRepositoryImpl implements PenggunaRepository {
    private final Connection connection;

    public PenggunaRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Pengguna cariPengguna(String username) {
        String query = "SELECT * FROM pengguna WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Pengguna(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
