package jualbeliapp.repositories;

import jualbeliapp.entities.AkunGame;

public interface AkunGameRepository {
    // Method to save a game account
    void simpanAkunGame(AkunGame akunGame);

    // Method to search for a game account by name
    AkunGame cariAkunGame(String namaGame);
}
