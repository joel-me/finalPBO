package jualbeliapp.views;

import jualbeliapp.entities.Pengguna;
import jualbeliapp.usecases.BeliAkunGameUseCase;
import jualbeliapp.usecases.RegistrasiUseCase;
import jualbeliapp.usecases.LoginUseCase;
import jualbeliapp.usecases.JualAkunGameUseCase;

import java.util.Scanner;

/**
 * Kelas Controller untuk aplikasi jual beli akun game.
 */
public class AplikasiController {
    private final Scanner input;
    private final RegistrasiUseCase registrasiUseCase;
    private final LoginUseCase loginUseCase;
    private final JualAkunGameUseCase jualAkunGameUseCase;
    private final BeliAkunGameUseCase beliAkunGameUseCase;  // Use case untuk beli akun game

    private Pengguna penggunaAktif = null;

    // Konstruktor AplikasiController
    public AplikasiController(Scanner input,
                              RegistrasiUseCase registrasiUseCase,
                              LoginUseCase loginUseCase,
                              JualAkunGameUseCase jualAkunGameUseCase,
                              BeliAkunGameUseCase beliAkunGameUseCase) {  // Menambahkan parameter beliAkunGameUseCase
        this.input = input;
        this.registrasiUseCase = registrasiUseCase;
        this.loginUseCase = loginUseCase;
        this.jualAkunGameUseCase = jualAkunGameUseCase;
        this.beliAkunGameUseCase = beliAkunGameUseCase;  // Menginisialisasi use case beli akun game
    }

    public void start() {
        boolean isRunning = true;
        while (isRunning) {
            if (penggunaAktif == null) {
                tampilkanMenuLogin();
                int pilihan = input.nextInt();
                input.nextLine(); // Konsumsi newline

                switch (pilihan) {
                    case 1:
                        login();
                        break;
                    case 2:
                        registrasi();  // Panggil fungsi registrasi
                        break;
                    case 3:
                        isRunning = false; // Exit aplikasi
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } else {
                tampilkanMenuPengguna();
                int pilihan = input.nextInt();
                input.nextLine(); // Konsumsi newline

                switch (pilihan) {
                    case 1:
                        jualAkunGame();
                        break;
                    case 2:
                        beliAkunGame();  // Panggil fungsi beli akun game
                        break;
                    case 3:
                        penggunaAktif = null; // Logout
                        System.out.println("Anda berhasil logout.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            }
        }
    }

    private void tampilkanMenuLogin() {
        System.out.println("1. Login");
        System.out.println("2. Registrasi");
        System.out.println("3. Keluar");
        System.out.print("Pilih menu: ");
    }

    private void tampilkanMenuPengguna() {
        System.out.println("1. Jual Akun Game");
        System.out.println("2. Beli Akun Game");
        System.out.println("3. Logout");
        System.out.print("Pilih menu: ");
    }

    private void login() {
        System.out.print("Masukkan username: ");
        String username = input.nextLine();
        System.out.print("Masukkan password: ");
        String password = input.nextLine();
        penggunaAktif = loginUseCase.execute(username, password);
        if (penggunaAktif != null) {
            System.out.println("Login berhasil!");
        } else {
            System.out.println("Username atau password salah.");
        }
    }

    private void registrasi() {
        System.out.print("Masukkan username: ");
        String username = input.nextLine();
        System.out.print("Masukkan password: ");
        String password = input.nextLine();
        registrasiUseCase.execute(username, password);
        System.out.println("Registrasi berhasil! Silakan login.");
    }

    private void jualAkunGame() {
        System.out.print("Masukkan nama game: ");
        String namaGame = input.nextLine();
        System.out.print("Masukkan deskripsi game: ");
        String deskripsi = input.nextLine();

        // Ambil username dari pengguna yang sedang login
        String username = penggunaAktif.getUsername();

        // Minta harga dari pengguna
        System.out.print("Masukkan harga game: ");
        double harga = input.nextDouble();
        input.nextLine(); // Konsumsi newline

        // Panggil use case untuk menjual akun game
        jualAkunGameUseCase.execute(namaGame, username, harga, deskripsi);
    }

    // Fungsi untuk membeli akun game
    private void beliAkunGame() {
        System.out.println("Daftar akun game yang tersedia untuk dibeli:");
        // Tampilkan daftar akun game yang tersedia dari database
        // Panggil method di use case untuk mendapatkan daftar akun game
        beliAkunGameUseCase.tampilkanAkunGame();  // Tampilkan daftar akun game yang bisa dibeli

        System.out.print("Masukkan ID akun yang ingin dibeli: ");
        int idAkun = input.nextInt();
        input.nextLine(); // Konsumsi newline

        // Panggil method untuk membeli akun game dan hapus dari database
        beliAkunGameUseCase.beliAkunGame(idAkun);
    }
}
