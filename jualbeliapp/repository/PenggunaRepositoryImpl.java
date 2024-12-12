package jualbeliapp.repository;

import java.util.HashMap;
import java.util.Map;

public class PenggunaRepositoryImpl implements PenggunaRepository {
    private final Map<String, Pengguna> penggunaData = new HashMap<>();

    @Override
    public void simpanPengguna(Pengguna pengguna) {
        penggunaData.put(pengguna.getUsername(), pengguna);
    }

    @Override
    public Pengguna cariPengguna(String username, String password) {
        Pengguna pengguna = penggunaData.get(username);
        if (pengguna != null && pengguna.getPassword().equals(password)) {
            return pengguna;
        }
        return null;
    }
}
