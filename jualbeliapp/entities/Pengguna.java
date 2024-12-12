package jualbeliapp.entities;

public class Pengguna {
    private int id;
    private String username;
    private String password;

    // Constructor that accepts id, username, and password
    public Pengguna(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    // Getter and setter methods for each field (optional but recommended for access and modification)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
