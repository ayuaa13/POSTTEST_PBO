package com.mycompany.layananbltsamarinda;

import java.util.ArrayList;
import java.util.Scanner;

class PenerimaBantuan {

    protected String nama;
    protected String nik;
    protected String alamat;

    public PenerimaBantuan(String nama, String nik, String alamat) {
        this.nama = nama;
        this.nik = nik;
        this.alamat = alamat;
    }

    // Getter
    public String getNama() { return nama; }
    public String getNik() { return nik; }
    public String getAlamat() { return alamat; }

    // Setter
    public void setNama(String nama) {
        if (!nama.isEmpty()) this.nama = nama;
    }

    public void setNik(String nik) {
        if (nik.length() >= 10) this.nik = nik;
    }

    public void setAlamat(String alamat) {
        if (!alamat.isEmpty()) this.alamat = alamat;
    }

    public void tampilkanData() {
        System.out.println("Nama   : " + nama);
        System.out.println("NIK    : " + nik);
        System.out.println("Alamat : " + alamat);
    }

    // Overloading (parameter berbeda)
    public void tampilkanData(boolean detail) {
        tampilkanData();
        if (detail) {
            System.out.println("(Data ditampilkan dalam mode detail)");
        }
    }

    // Method umum
    public void jenisBantuan() {
        System.out.println("Jenis Bantuan: Umum");
    }
}

class PenerimaReguler extends PenerimaBantuan {

    public PenerimaReguler(String nama, String nik, String alamat) {
        super(nama, nik, alamat);
    }

    @Override
    public void jenisBantuan() {
        System.out.println("Jenis Bantuan: BLT Reguler");
    }
}

class PenerimaUMKM extends PenerimaBantuan {

    private String usaha;

    public PenerimaUMKM(String nama, String nik, String alamat, String usaha) {
        super(nama, nik, alamat);
        this.usaha = usaha;
    }

    // Overloading tambahan (BONUS 🔥)
    public void tampilkanData(String tambahan) {
        super.tampilkanData();
        System.out.println("Usaha  : " + usaha);
        System.out.println("Catatan: " + tambahan);
    }

    @Override
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println("Usaha  : " + usaha);
    }

    @Override
    public void jenisBantuan() {
        System.out.println("Jenis Bantuan: BLT UMKM");
    }
}

class PenerimaLansia extends PenerimaBantuan {

    private int umur;

    public PenerimaLansia(String nama, String nik, String alamat, int umur) {
        super(nama, nik, alamat);
        this.umur = umur;
    }

    @Override
    public void tampilkanData() {
        super.tampilkanData();
        System.out.println("Umur   : " + umur);
    }

    @Override
    public void jenisBantuan() {
        System.out.println("Jenis Bantuan: BLT Lansia");
    }
}

public class LayananBLTSamarinda {

    static ArrayList<PenerimaBantuan> daftar = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int pilihan;

        do {
            System.out.println("\n===== SISTEM BLT SAMARINDA =====");
            System.out.println("1. Tambah Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Hapus Data");
            System.out.println("4. Edit Data");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1: tambahData(); break;
                case 2: lihatData(); break;
                case 3: hapusData(); break;
                case 4: editData(); break;
                case 5: System.out.println("Program selesai."); break;
                default: System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 5);
    }

    // CREATE
    static void tambahData() {

        System.out.print("Nama   : ");
        String nama = input.nextLine();

        System.out.print("NIK    : ");
        String nik = input.nextLine();

        System.out.print("Alamat : ");
        String alamat = input.nextLine();

        System.out.println("Jenis Bantuan:");
        System.out.println("1. Reguler");
        System.out.println("2. UMKM");
        System.out.println("3. Lansia");
        int jenis = input.nextInt();
        input.nextLine();

        if (jenis == 1) {
            daftar.add(new PenerimaReguler(nama, nik, alamat));

        } else if (jenis == 2) {
            System.out.print("Usaha: ");
            String usaha = input.nextLine();
            daftar.add(new PenerimaUMKM(nama, nik, alamat, usaha));

        } else if (jenis == 3) {
            System.out.print("Umur: ");
            int umur = input.nextInt();
            input.nextLine();
            daftar.add(new PenerimaLansia(nama, nik, alamat, umur));
        }
    }

    // READ
    static void lihatData() {

        if (daftar.isEmpty()) {
            System.out.println("Belum ada data.");
            return;
        }

        int i = 1;
        for (PenerimaBantuan p : daftar) {
            System.out.println("Data ke-" + i++);
            p.tampilkanData(true); // pakai overloading
            p.jenisBantuan();      // overriding
            System.out.println("----------------------");
        }
    }

    // DELETE
    static void hapusData() {

        lihatData();
        if (daftar.isEmpty()) return;

        System.out.print("Nomor: ");
        int index = input.nextInt();
        input.nextLine();

        if (index >= 1 && index <= daftar.size()) {
            daftar.remove(index - 1);
            System.out.println("Data dihapus.");
        }
    }

    // UPDATE
    static void editData() {

        lihatData();
        if (daftar.isEmpty()) return;

        System.out.print("Nomor: ");
        int index = input.nextInt();
        input.nextLine();

        if (index >= 1 && index <= daftar.size()) {

            PenerimaBantuan p = daftar.get(index - 1);

            System.out.print("Nama baru: ");
            String nama = input.nextLine();

            System.out.print("NIK baru: ");
            String nik = input.nextLine();

            System.out.print("Alamat baru: ");
            String alamat = input.nextLine();

            if (!nama.isEmpty()) p.setNama(nama);
            if (!nik.isEmpty()) p.setNik(nik);
            if (!alamat.isEmpty()) p.setAlamat(alamat);

            System.out.println("Data diupdate.");
        }
    }
}