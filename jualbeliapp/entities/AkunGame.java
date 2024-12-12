// AkunGame.java
package jualbeliapp.entities;  // Pastikan sesuai dengan paket proyek Anda

public class AkunGame {
    private int id;           // Tambahkan ID jika dibutuhkan di database
    private String namaGame;
    private String username;  // Tambahkan atribut username
    private double harga;     // Tambahkan atribut harga
    private String deskripsi;
    private boolean terjual;

    // Konstruktor untuk inisialisasi nama game, deskripsi, username, dan harga
    public AkunGame(int id, String namaGame, String username, double harga, String deskripsi) {
        this.id = id;
        this.namaGame = namaGame;
        this.username = username;
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.terjual = false;  // Default nilai terjual adalah false
    }

    // Konstruktor tanpa ID (untuk insert baru)
    public AkunGame(String namaGame, String username, double harga, String deskripsi) {
        this.namaGame = namaGame;
        this.username = username;
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.terjual = false;  // Default nilai terjual adalah false
    }

    // Getter dan Setter untuk semua atribut

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

    public boolean isTerjual() {
        return terjual;
    }

    public void setTerjual(boolean terjual) {
        this.terjual = terjual;
    }
}
