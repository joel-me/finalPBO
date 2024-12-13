package jualbeliapp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Kelas untuk mengelola koneksi database.
 */
public class Database {
    private final String dbName;
    private final String userName;
    private final String password;
    private final String host;
    private final String port;
    private Connection connection;

    /**
     * Konstruktor untuk menginisialisasi konfigurasi database.
     *
     * @param dbName    Nama database
     * @param userName  Username database
     * @param password  Password database
     * @param host      Host database (misalnya localhost)
     * @param port      Port database (misalnya 3306)
     */
    public Database(final String dbName, final String userName, final String password, final String host, final String port) {
        this.dbName = dbName;
        this.userName = userName;
        this.password = password;
        this.host = host;
        this.port = port;
    }

    /**
     * Mendapatkan koneksi database saat ini.
     *
     * @return Koneksi database aktif
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Mengatur koneksi database menggunakan detail konfigurasi yang diberikan.
     * Ini akan menginisialisasi koneksi ke database dan mencetak pesan keberhasilan.
     */
    public void setup() {
        // Menentukan template URL koneksi MySQL
        String mysqlConnUrlTemplate = "jdbc:mysql://%s:%s/%s";

        try {
            // Memastikan driver MySQL dimuat
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Membuat koneksi ke database
            connection = DriverManager.getConnection(
                    String.format(mysqlConnUrlTemplate, host, port, dbName),
                    userName, password
            );

            // Pesan keberhasilan koneksi
            if (connection != null && !connection.isClosed()) {
                System.out.println("Database connected!");
            }

        } catch (SQLException | ClassNotFoundException e) {
            // Menangani kesalahan jika terjadi kesalahan dalam koneksi
            System.err.println("Database connection failed: " + e.getMessage());
            throw new RuntimeException("Failed to connect to the database.", e);
        }
    }

    /**
     * Menutup koneksi database jika tidak null dan belum tertutup.
     */
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Error closing the database connection: " + e.getMessage());
        }
    }

    /**
     * Mengatur auto-commit untuk transaksi database.
     * Jika Anda ingin mengelola transaksi secara manual, pastikan auto-commit dimatikan.
     */
    public void disableAutoCommit() {
        try {
            if (connection != null && !connection.getAutoCommit()) {
                connection.setAutoCommit(false);  // Nonaktifkan auto-commit
                System.out.println("Auto-commit disabled.");
            }
        } catch (SQLException e) {
            System.err.println("Error disabling auto-commit: " + e.getMessage());
        }
    }

    /**
     * Melakukan commit secara manual jika auto-commit dinonaktifkan.
     */
    public void commitTransaction() {
        try {
            if (connection != null) {
                connection.commit();
                System.out.println("Transaction committed.");
            }
        } catch (SQLException e) {
            System.err.println("Error committing transaction: " + e.getMessage());
        }
    }

    /**
     * Melakukan rollback jika terjadi error dalam transaksi dan auto-commit dinonaktifkan.
     */
    public void rollbackTransaction() {
        try {
            if (connection != null) {
                connection.rollback();
                System.out.println("Transaction rolled back.");
            }
        } catch (SQLException e) {
            System.err.println("Error rolling back transaction: " + e.getMessage());
        }
    }
}
