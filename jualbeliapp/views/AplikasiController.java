package jualbeliapp.views;

import jualbeliapp.entities.Pengguna;
import jualbeliapp.usecases.JualAkunGameUseCase;
import jualbeliapp.usecases.LoginUseCase;
import jualbeliapp.usecases.RegistrasiUseCase;

import java.util.Scanner;

public class AplikasiController {
    private final Scanner input;
    private final RegistrasiUseCase registrasiUseCase;
    private final LoginUseCase loginUseCase;
    private final JualAkunGameUseCase jualAkunGameUseCase;
    private Pengguna penggunaAktif = null;

    // Constructor that only takes the necessary parameters
    public AplikasiController(Scanner input,
                              RegistrasiUseCase registrasiUseCase,
                              LoginUseCase loginUseCase,
                              JualAkunGameUseCase jualAkunGameUseCase) {
        this.input = input;
        this.registrasiUseCase = registrasiUseCase;
        this.loginUseCase = loginUseCase;
        this.jualAkunGameUseCase = jualAkunGameUseCase;
    }

    public void start() {
        boolean isRunning = true;
        while (isRunning) {
            if (penggunaAktif == null) {
                tampilkanMenu();
                int pilihan = input.nextInt();
                input.nextLine(); // Konsumsi newline

                switch (pilihan) {
                    case 1:
                        registrasi();
                        break;
                    case 2:
                        login();
                        break;
                    case 3:
                        isRunning = false; // Exit the application
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
                        penggunaAktif = null; // Logout
                        System.out.println("Anda berhasil logout.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            }
        }
    }

    private void tampilkanMenu() {
        System.out.println("1. Registrasi");
        System.out.println("2. Login");
        System.out.println("3. Keluar");
        System.out.print("Pilih menu: ");
    }

    private void tampilkanMenuPengguna() {
        System.out.println("1. Jual Akun Game");
        System.out.println("2. Logout");
        System.out.print("Pilih menu: ");
    }

    private void registrasi() {
        System.out.print("Masukkan username: ");
        String username = input.nextLine();
        System.out.print("Masukkan password: ");
        String password = input.nextLine();
        registrasiUseCase.execute(username, password);
        System.out.println("Registrasi berhasil!");
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

    private void jualAkunGame() {
        System.out.print("Masukkan nama game: ");
        String namaGame = input.nextLine();
        System.out.print("Masukkan deskripsi game: ");
        String deskripsi = input.nextLine();
        jualAkunGameUseCase.execute(namaGame, deskripsi);
    }
}
