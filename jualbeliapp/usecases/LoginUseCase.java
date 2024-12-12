package jualbeliapp.usecases;

import jualbeliapp.entities.Pengguna;
import jualbeliapp.repositories.PenggunaRepository;

public class LoginUseCase {
    private final PenggunaRepository penggunaRepository;

    public LoginUseCase(PenggunaRepository penggunaRepository) {
        this.penggunaRepository = penggunaRepository;
    }

    public Pengguna execute(String username, String password) {
        Pengguna pengguna = penggunaRepository.cariPengguna(username);

        // Check if the user exists and the password matches
        if (pengguna != null && pengguna.getPassword().equals(password)) {
            return pengguna; // Return the user if login is successful
        }

        return null; // Return null if login fails
    }
}
