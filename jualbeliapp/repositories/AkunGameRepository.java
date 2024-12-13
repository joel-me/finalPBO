package jualbeliapp.repositories;

import jualbeliapp.entities.AkunGame;
import java.util.List;

public interface AkunGameRepository {
    void simpanAkunGame(AkunGame akunGame);

    // Menambahkan method untuk mendapatkan semua akun game
    List<AkunGame> getAllAkunGame();

    // Menambahkan method untuk mendapatkan akun game berdasarkan ID
    AkunGame getAkunGameById(int id);

    // Menambahkan method untuk memperbarui akun game (set terjual)
    void updateAkunGame(AkunGame akunGame);
}
