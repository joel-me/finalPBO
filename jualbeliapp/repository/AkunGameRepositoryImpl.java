package jualbeliapp.repository;

import jualbeliapp.entities.AkunGame;

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