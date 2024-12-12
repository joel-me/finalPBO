package jualbeliapp.usecases;

import jualbeliapp.entities.AkunGame;
import jualbeliapp.repositories.AkunGameRepository;

public class JualAkunGameUseCase {
    private final AkunGameRepository akunGameRepository;

    // Constructor to initialize repository
    public JualAkunGameUseCase(AkunGameRepository akunGameRepository) {
        this.akunGameRepository = akunGameRepository;
    }

    // Define the execute method that takes two String parameters
    public void execute(String namaGame, String deskripsi) {
        // Create a new AkunGame object with the provided data
        AkunGame akunGame = new AkunGame(namaGame, deskripsi);  // Using the new constructor
        // Save the game account to the repository
        akunGameRepository.simpanAkunGame(akunGame);
        System.out.println("Akun game berhasil dijual!");
    }
}
