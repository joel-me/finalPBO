package jualbeliapp.usecases;

public class JualAkunGameUseCase {
    private final AkunGameRepository akunGameRepository;

    public JualAkunGameUseCase(AkunGameRepository akunGameRepository) {
        this.akunGameRepository = akunGameRepository;
    }

    public void execute(String namaGame, String deskripsi) {
        AkunGame akunGame = new AkunGame(namaGame, deskripsi);
        akunGameRepository.simpanAkunGame(akunGame);
        System.out.println("Akun game berhasil dijual!");
    }
}