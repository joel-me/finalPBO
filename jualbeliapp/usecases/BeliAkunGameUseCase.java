package jualbeliapp.usecases;

import jualbeliapp.repositories.AkunGameRepository;
import jualbeliapp.entities.AkunGame;

public class BeliAkunGameUseCase {
    private final AkunGameRepository akunGameRepository;

    public BeliAkunGameUseCase(AkunGameRepository akunGameRepository) {
        this.akunGameRepository = akunGameRepository;
    }

    // Menampilkan akun game yang tersedia untuk dibeli
    public void tampilkanAkunGame() {
        // Mendapatkan semua akun game yang belum terjual
        akunGameRepository.getAllAkunGame().forEach(akunGame -> {
            if (!akunGame.isTerjual()) {
                System.out.println("ID: " + akunGame.getId() + ", Nama Game: " + akunGame.getNamaGame() + ", Harga: " + akunGame.getHarga());
            }
        });
    }

    // Membeli akun game berdasarkan ID dan menghapusnya dari database
    public void beliAkunGame(int idAkun) {
        AkunGame akunGame = akunGameRepository.getAkunGameById(idAkun);
        if (akunGame != null && !akunGame.isTerjual()) {
            akunGame.setTerjual(true);
            akunGameRepository.updateAkunGame(akunGame);
            System.out.println("Akun game berhasil dibeli: " + akunGame.getNamaGame());
        } else {
            System.out.println("Akun game tidak ditemukan atau sudah terjual.");
        }
    }
}
