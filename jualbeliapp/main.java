// MainApp.java
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Inisialisasi repository dan use case
        PenggunaRepository penggunaRepository = new PenggunaRepositoryImpl();
        AkunGameRepository akunGameRepository = new AkunGameRepositoryImpl();

        RegistrasiUseCase registrasiUseCase = new RegistrasiUseCase(penggunaRepository);
        LoginUseCase loginUseCase = new LoginUseCase(penggunaRepository);
        JualAkunGameUseCase jualAkunGameUseCase = new JualAkunGameUseCase(akunGameRepository);

        // Inisialisasi controller
        AplikasiController controller = new AplikasiController(input, registrasiUseCase, loginUseCase, jualAkunGameUseCase);

        // Jalankan aplikasi
        controller.start();
    }
}
