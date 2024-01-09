package tiketcenter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.text.DateFormatter;

class penjualan extends Pembeli{
    public String namaBarang;
    public Integer hargaBarang;
    public Integer jumlahBeli;
    public Integer totalBayar;
    public String petugas;

    public penjualan(String nama, String alamat, String namaBarang, String petugas, Integer hargaBarang, Integer jumlahBeli){
        super(nama, alamat);
        this.alamat = alamat;
        this.petugas = petugas;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.jumlahBeli = jumlahBeli;
        totalBayar = hargaBarang*jumlahBeli;
        cetakFaktur();
    }
    public void cetakFaktur(){
        System.out.println("-------TIKET CENTER------");
            DateTimeFormatter tgl = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDateTime lv =LocalDateTime.now();
        System.out.println("Tanggal     : " + tgl.format(lv));
            DateTimeFormatter wkt = DateTimeFormatter.ofPattern("HH:m:ss");
        System.out.println("Pukul      : " + wkt.format(lv) + "WIB" + "\n");
    
        for(int min =1; min<= 20; min++){
            System.out.print("=");
        }
        System.out.print("\nNama Pelanggan  : " + nama);

        System.out.print("\nAlamat  : " + super.alamat + "\n");
            for(int pls = 1; pls <= 20; pls++){
                System.out.print("+");
            }
        
        System.out.println("\nDATA PEMBELIAN BARANG");
        for(int min2 =1; min2<= 20; min2++){
            System.out.print("-");
        }

        System.out.print("\nNama Barang     : " + namaBarang);
        System.out.print("\nHarga Barang     : " + hargaBarang);
        System.out.print("\nJumlah Barang     : " + jumlahBeli);
        System.out.print("\n Total Harga     : " + totalBayar +"\n");
        for(int pls = 1; pls <= 30; pls++){
            System.out.print("+");
        }

        System.out.println("\npetugas       :" + petugas);

    }
    
}
