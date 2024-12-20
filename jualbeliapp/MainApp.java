package jualbeliapp;

import jualbeliapp.config.Database;
import jualbeliapp.repositories.PenggunaRepository;
import jualbeliapp.repositories.PenggunaRepositoryImpl;
import jualbeliapp.repositories.AkunGameRepository;
import jualbeliapp.repositories.AkunGameRepositoryImpl;
import jualbeliapp.usecases.BeliAkunGameUseCase;
import jualbeliapp.usecases.RegistrasiUseCase;
import jualbeliapp.usecases.LoginUseCase;
import jualbeliapp.usecases.JualAkunGameUseCase;
import jualbeliapp.views.AplikasiController;

import java.sql.Connection;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Initialize database configuration
        Database database = new Database("my_database", "root", "", "localhost", "3306");

        // Set up database connection
        database.setup();
        Connection connection = database.getConnection();  // Get the active connection

        // Initialize repositories and use cases
        PenggunaRepository penggunaRepository = new PenggunaRepositoryImpl(connection);
        AkunGameRepository akunGameRepository = new AkunGameRepositoryImpl(connection);

        // Initialize use cases
        RegistrasiUseCase registrasiUseCase = new RegistrasiUseCase(penggunaRepository);
        LoginUseCase loginUseCase = new LoginUseCase(penggunaRepository);
        JualAkunGameUseCase jualAkunGameUseCase = new JualAkunGameUseCase(akunGameRepository);
        BeliAkunGameUseCase beliAkunGameUseCase = new BeliAkunGameUseCase(akunGameRepository);


        // Initialize controller
        AplikasiController controller = new AplikasiController(input, registrasiUseCase, loginUseCase, jualAkunGameUseCase, beliAkunGameUseCase);

        // Start the application
        controller.start();

        // Close database connection when done
        database.closeConnection();
    }
}
