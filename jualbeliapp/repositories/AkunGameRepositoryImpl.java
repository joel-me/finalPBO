package jualbeliapp.repositories;

import jualbeliapp.entities.AkunGame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AkunGameRepositoryImpl implements AkunGameRepository {
    private final Connection connection;

    // Constructor that accepts a Connection parameter
    public AkunGameRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    // Implementing the simpanAkunGame method to save AkunGame into a database
    @Override
    public void simpanAkunGame(AkunGame akunGame) {
        String query = "INSERT INTO akun_game (nama_game, username, harga, deskripsi) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, akunGame.getNamaGame());
            statement.setString(2, akunGame.getUsername());
            statement.setDouble(3, akunGame.getHarga());
            statement.setString(4, akunGame.getDeskripsi());  // Make sure to set description
            statement.executeUpdate();  // Execute the query to insert into the database
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Implementing the cariAkunGame method to find an AkunGame from the database
    @Override
    public AkunGame cariAkunGame(String namaGame) {
        String query = "SELECT * FROM akun_game WHERE nama_game = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, namaGame);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new AkunGame(
                        resultSet.getInt("id"),
                        resultSet.getString("nama_game"),
                        resultSet.getString("username"),
                        resultSet.getDouble("harga"),
                        resultSet.getString("deskripsi")  // Make sure to get description
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // Return null if no account with the given name is found
    }
}
