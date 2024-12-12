package jualbeliapp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private final String dbName;
    private final String userName;
    private final String password;
    private final String host;
    private final String port;
    private Connection connection;

    /**
     * Constructor to initialize the database configuration.
     *
     * @param dbName    The database name
     * @param userName  The database username
     * @param password  The database password
     * @param host      The database host (e.g., localhost)
     * @param port      The database port (e.g., 3306)
     */
    public Database(final String dbName, final String userName, final String password, final String host, final String port) {
        this.dbName = dbName;
        this.userName = userName;
        this.password = password;
        this.host = host;
        this.port = port;
    }

    /**
     * Method to retrieve the current database connection.
     *
     * @return The active database connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Setup the database connection using the provided configuration details.
     * This will initialize the database connection and print a success message.
     */
    public void setup() {
        // Define MySQL connection URL template
        String mysqlConnUrlTemplate = "jdbc:mysql://%s:%s/%s";

        try {
            // Ensure that the MySQL JDBC driver is loaded
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection to the database
            connection = DriverManager.getConnection(
                    String.format(mysqlConnUrlTemplate, host, port, dbName),
                    userName, password
            );

            // Success message
            System.out.println("Database connected!");

        } catch (SQLException | ClassNotFoundException e) {
            // Throw a runtime exception if any error occurs
            System.err.println("Database connection failed: " + e.getMessage());
            throw new RuntimeException("Failed to connect to the database.", e);
        }
    }

    /**
     * Close the database connection if it is not null.
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
}
