package jualbeliapp.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;  // Tambahkan import untuk ResultSet
import java.sql.SQLException;
import java.util.Optional;
import jualbeliapp.entities.Pengguna;

/**
 * Implementasi untuk repository pengguna, berinteraksi dengan database.
 */
public class PenggunaRepositoryImpl implements PenggunaRepository {
    private final Connection connection;

    public PenggunaRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    /**
     * Menyimpan pengguna baru ke dalam database.
     *
     * @param pengguna Pengguna yang akan disimpan
     */
    @Override
    public void simpanPengguna(Pengguna pengguna) {
        if (pengguna == null) {
            throw new IllegalArgumentException("Pengguna cannot be null.");
        }

        String query = "INSERT INTO pengguna (username, password) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, pengguna.getUsername());
            statement.setString(2, pengguna.getPassword());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pengguna berhasil disimpan!");
            }
        } catch (SQLException e) {
            System.err.println("Error while saving user: " + e.getMessage());
            e.printStackTrace();  // Gantilah dengan logger untuk produksi
        }
    }

    /**
     * Mencari pengguna berdasarkan username.
     *
     * @param username Nama pengguna yang akan dicari
     * @return Optional berisi Pengguna jika ditemukan, atau empty jika tidak ditemukan
     */
    @Override
    public Optional<Pengguna> cariPengguna(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty.");
        }

        String query = "SELECT * FROM pengguna WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(new Pengguna(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error while fetching user: " + e.getMessage());
            e.printStackTrace();  // Gantilah dengan logger untuk produksi
        }
        return Optional.empty();  // Kembalikan empty jika tidak ditemukan
    }
}
