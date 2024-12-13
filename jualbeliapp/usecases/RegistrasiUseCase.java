package jualbeliapp.usecases;

import jualbeliapp.entities.Pengguna;
import jualbeliapp.repositories.PenggunaRepository;

/**
 * Use case untuk menangani proses registrasi pengguna baru.
 */
public class RegistrasiUseCase {
    private final PenggunaRepository penggunaRepository;

    public RegistrasiUseCase(PenggunaRepository penggunaRepository) {
        this.penggunaRepository = penggunaRepository;
    }

    public void execute(String username, String password) {
        // Buat objek Pengguna baru
        Pengguna penggunaBaru = new Pengguna(0, username, password);
        // Simpan pengguna baru ke database
        penggunaRepository.simpanPengguna(penggunaBaru);
    }
}
