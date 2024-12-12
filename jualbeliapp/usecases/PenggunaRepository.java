package jualbeliapp.usecases;

public interface PenggunaRepository {
    void simpanPengguna(Pengguna pengguna);
    Pengguna cariPengguna(String username, String password);
}

// PenggunaRepositoryImpl.java
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

// AkunGameRepository.java
public interface AkunGameRepository {
    void simpanAkunGame(AkunGame akunGame);
    AkunGame cariAkunGame(String namaGame);
}

// AkunGameRepositoryImpl.java
import java.util.ArrayList;
import java.util.List;

public class AkunGameRepositoryImpl implements AkunGameRepository {
    private final List<AkunGame> akunGameList = new ArrayList<>();

    @Override
    public void simpanAkunGame(AkunGame akunGame) {
        akunGameList.add(akunGame);
    }

    @Override
    public AkunGame cariAkunGame(String namaGame) {
        for (AkunGame akunGame : akunGameList) {
            if (akunGame.getNamaGame().equalsIgnoreCase(namaGame)) {
                return akunGame;
            }
        }
        return null;
    }
}
