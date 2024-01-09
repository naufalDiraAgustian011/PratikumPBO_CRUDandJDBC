package tiketcenter;

import java.util.InputMismatchException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class TiketCenterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> metodePembayaran = new ArrayList<>();
        metodePembayaran.add("credit");
        metodePembayaran.add("debit");

        // Menampilkan metode pembayaran yang tersedia
        System.out.println("Metode pembayaran yang tersedia:");
        for (int i = 0; i < metodePembayaran.size(); i++) {
            System.out.println((i + 1) + ". " + metodePembayaran.get(i));
        }
        System.out.println("Daftar Tiket Yang Tersedia:");
        showDb myDbViewer = new showDb();
        myDbViewer.displayData(); // Memanggil metode displayData dari objek myDbViewer
        System.out.println("====================================");

        createDataTiket.insertEmployeeData();
        updateDataTiket.updateEmployeeCredentials(scanner);
        deleteDataTiket.deleteEmployeeById();

        int pilihanMetode = 0;
        do {
            try {
                System.out.print("Pilih metode pembayaran (1 atau 2): ");
                pilihanMetode = scanner.nextInt();
                if (pilihanMetode < 1 || pilihanMetode > metodePembayaran.size()) {
                    System.out.println("Pilihan tidak valid. Harap masukkan 1 atau 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Terjadi kesalahan input. Harap masukkan angka.");
                scanner.nextLine(); // Membersihkan buffer
            }
        } while (pilihanMetode < 1 || pilihanMetode > metodePembayaran.size());

        // Mendapatkan metode pembayaran yang dipilih
        String metodePembayaranTerpilih = metodePembayaran.get(pilihanMetode - 1);
        System.out.println("Metode pembayaran yang dipilih: " + metodePembayaranTerpilih);

        // Memasukkan data pembeli dan barang
        try {
            scanner.nextLine(); // Membersihkan buffer sebelum membaca string

            System.out.print("Masukkan Nama Pembeli: ");
            String namaPembeli = scanner.nextLine();

            System.out.print("Masukkan Alamat Pembeli: ");
            String alamatPembeli = scanner.nextLine();

            System.out.print("Masukkan Nama Petugas: ");
            String namaPetugas = scanner.nextLine();

            // Input data pembelian barang
            System.out.print("Masukkan Nama Barang: ");
            String namaBarang = scanner.nextLine();

            System.out.print("Masukkan Harga Barang: ");
            int hargaBarang = scanner.nextInt();

            System.out.print("Masukkan Jumlah Barang: ");
            int jumlahBarang = scanner.nextInt();

            // Membuat objek penjualan dengan data yang diinputkan
            penjualan penjualanInstance = new penjualan(namaPembeli, alamatPembeli, namaBarang, namaPetugas, hargaBarang, jumlahBarang);

            // Memanggil metode cetakFaktur dari objek penjualan
            penjualanInstance.cetakFaktur();
        } catch (InputMismatchException e) {
            System.out.println("Terjadi kesalahan input. Pastikan harga dan jumlah barang diisi dengan angka.");
        } finally {
            // Menutup Scanner
            scanner.close();
        }
    }
}
