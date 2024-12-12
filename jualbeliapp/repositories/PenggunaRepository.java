package jualbeliapp.repositories;

import jualbeliapp.entities.Pengguna;

public interface PenggunaRepository {
    Pengguna cariPengguna(String username); // Find user by username
}
