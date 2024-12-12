package jualbeliapp.entities;

// Pengguna.java
class Pengguna {
    private String username;
    private String password;

    public Pengguna(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

// AkunGame.java
class AkunGame {
    private String namaGame;
    private String deskripsi;
    private boolean terjual;

    public AkunGame(String namaGame, String deskripsi) {
        this.namaGame = namaGame;
        this.deskripsi = deskripsi;
        this.terjual = false;
    }

    public String getNamaGame() {
        return namaGame;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public boolean isTerjual() {
        return terjual;
    }

    public void setTerjual(boolean terjual) {
        this.terjual = terjual;
    }
}
