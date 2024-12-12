package jualbeliapp.entities;

public class AkunGame {
    private int id;
    private String namaGame;
    private String username;
    private double harga;
    private String deskripsi;

    // Constructor with all fields
    public AkunGame(int id, String namaGame, String username, double harga, String deskripsi) {
        this.id = id;
        this.namaGame = namaGame;
        this.username = username;
        this.harga = harga;
        this.deskripsi = deskripsi;
    }

    // Constructor without 'id' (for creating new game records)
    public AkunGame(String namaGame, String username, double harga, String deskripsi) {
        this.namaGame = namaGame;
        this.username = username;
        this.harga = harga;
        this.deskripsi = deskripsi;
    }

    // Constructor for creating an AkunGame with just 'namaGame' and 'deskripsi'
    public AkunGame(String namaGame, String deskripsi) {
        this.namaGame = namaGame;
        this.deskripsi = deskripsi;
        // Default values for username and harga (you can modify as needed)
        this.username = "";
        this.harga = 0.0;
    }

    // Getter and Setter methods for all fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaGame() {
        return namaGame;
    }

    public void setNamaGame(String namaGame) {
        this.namaGame = namaGame;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
