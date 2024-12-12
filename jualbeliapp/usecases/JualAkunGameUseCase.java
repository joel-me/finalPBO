package jualbeliapp.usecases;

import jualbeliapp.entities.AkunGame;
import jualbeliapp.repositories.AkunGameRepository;

public class JualAkunGameUseCase {
    private final AkunGameRepository akunGameRepository;

    // Constructor to initialize repository
    public JualAkunGameUseCase(AkunGameRepository akunGameRepository) {
        this.akunGameRepository = akunGameRepository;
    }

    // Define the execute method that takes necessary parameters
    public void execute(String namaGame, String username, double harga, String deskripsi) {
        // Create a new AkunGame object with the provided data
        AkunGame akunGame = new AkunGame(namaGame, username, harga, deskripsi);  // Using the constructor with necessary parameters
        // Save the game account to the repository
        akunGameRepository.simpanAkunGame(akunGame);
        System.out.println("Akun game berhasil dijual!");
    }
}
