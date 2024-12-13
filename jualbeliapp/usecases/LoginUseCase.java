package jualbeliapp.usecases;

import jualbeliapp.entities.Pengguna;
import jualbeliapp.repositories.PenggunaRepository;

import java.util.Optional;

public class LoginUseCase {
    private final PenggunaRepository penggunaRepository;

    public LoginUseCase(PenggunaRepository penggunaRepository) {
        this.penggunaRepository = penggunaRepository;
    }

    public Pengguna execute(String username, String password) {
        // Cari pengguna berdasarkan username
        Optional<Pengguna> penggunaOpt = penggunaRepository.cariPengguna(username);

        // Cek apakah pengguna ditemukan dan password cocok
        if (penggunaOpt.isPresent()) {
            Pengguna pengguna = penggunaOpt.get();
            System.out.println("Pengguna ditemukan: " + pengguna.getUsername());
            if (pengguna.getPassword().equals(password)) {
                return pengguna;  // Login berhasil
            } else {
                System.out.println("Password salah.");
            }
        } else {
            System.out.println("Pengguna tidak ditemukan.");
        }

        return null;  // Login gagal
    }
}
