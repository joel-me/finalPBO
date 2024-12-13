package jualbeliapp.repositories;

import jualbeliapp.entities.Pengguna;
import java.util.Optional;

public interface PenggunaRepository {
    /**
     * Menyimpan pengguna baru ke dalam database.
     *
     * @param pengguna Pengguna yang akan disimpan
     */
    void simpanPengguna(Pengguna pengguna);

    /**
     * Mencari pengguna berdasarkan username.
     *
     * @param username Nama pengguna yang akan dicari
     * @return Optional berisi Pengguna jika ditemukan, atau empty jika tidak ditemukan
     */
    Optional<Pengguna> cariPengguna(String username);
}
