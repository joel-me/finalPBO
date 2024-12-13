package jualbeliapp.repositories;

import jualbeliapp.entities.AkunGame;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AkunGameRepositoryImpl implements AkunGameRepository {
    private final Connection connection;

    public AkunGameRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void simpanAkunGame(AkunGame akunGame) {
        // Implementasi penyimpanan akun game
    }

    @Override
    public List<AkunGame> getAllAkunGame() {
        List<AkunGame> akunGames = new ArrayList<>();
        String query = "SELECT * FROM akun_game WHERE terjual = FALSE";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                AkunGame akunGame = new AkunGame(
                        resultSet.getInt("id"),
                        resultSet.getString("nama_game"),
                        resultSet.getString("username"),
                        resultSet.getDouble("harga"),
                        resultSet.getString("deskripsi")
                );
                akunGames.add(akunGame);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return akunGames;
    }

    @Override
    public AkunGame getAkunGameById(int id) {
        String query = "SELECT * FROM akun_game WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new AkunGame(
                        resultSet.getInt("id"),
                        resultSet.getString("nama_game"),
                        resultSet.getString("username"),
                        resultSet.getDouble("harga"),
                        resultSet.getString("deskripsi")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateAkunGame(AkunGame akunGame) {
        String query = "UPDATE akun_game SET terjual = TRUE WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, akunGame.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
