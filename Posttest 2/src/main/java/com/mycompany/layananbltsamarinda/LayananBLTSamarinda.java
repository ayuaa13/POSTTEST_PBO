package com.mycompany.layananbltsamarinda;

import java.util.ArrayList;
import java.util.Scanner;

class PenerimaBantuan {

    private String nama;
    private String nik;
    private String alamat;

    public PenerimaBantuan(String nama, String nik, String alamat) {
        this.nama = nama;
        this.nik = nik;
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void tampilkanData() {
        System.out.println("Nama   : " + nama);
        System.out.println("NIK    : " + nik);
        System.out.println("Alamat : " + alamat);
        System.out.println("------------------------");
    }
}

public class LayananBLTSamarinda {

    static ArrayList<PenerimaBantuan> daftarPenerima = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int pilihan;

        do {
            System.out.println("\n===== SISTEM LAYANAN BLT SAMARINDA =====");
            System.out.println("1. Tambah Data Penerima");
            System.out.println("2. Lihat Data Penerima");
            System.out.println("3. Hapus Data");
            System.out.println("4. Edit Data");
            System.out.println("5. Keluar");
            System.out.print("Pilihan Anda: ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                case 1:
                    tambahData();
                    break;

                case 2:
                    lihatData();
                    break;

                case 3:
                    hapusData();
                    break;

                case 4:
                    editData();
                    break;

                case 5:
                    System.out.println("Terima kasih. Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

        } while (pilihan != 5);
    }

    // CREATE
    static void tambahData() {

        System.out.print("Masukkan Nama   : ");
        String nama = input.nextLine();

        System.out.print("Masukkan NIK    : ");
        String nik = input.nextLine();

        System.out.print("Masukkan Alamat : ");
        String alamat = input.nextLine();

        PenerimaBantuan penerima = new PenerimaBantuan(nama, nik, alamat);
        daftarPenerima.add(penerima);

        System.out.println("Data berhasil ditambahkan!");
    }

    // READ
    static void lihatData() {

        if (daftarPenerima.isEmpty()) {
            System.out.println("Belum ada data penerima bantuan.");
            return;
        }

        System.out.println("\n===== DAFTAR PENERIMA BLT =====");

        for (int i = 0; i < daftarPenerima.size(); i++) {
            System.out.println("Data ke-" + (i + 1));
            daftarPenerima.get(i).tampilkanData();
        }
    }

    // DELETE
    static void hapusData() {

        lihatData();

        if (daftarPenerima.isEmpty()) return;

        System.out.print("Masukkan nomor data yang akan dihapus: ");
        int index = input.nextInt();
        input.nextLine();

        if (index >= 1 && index <= daftarPenerima.size()) {

            daftarPenerima.remove(index - 1);
            System.out.println("Data berhasil dihapus.");

        } else {

            System.out.println("Nomor data tidak valid.");

        }
    }

    // UPDATE
    static void editData() {

        lihatData();

        if (daftarPenerima.isEmpty()) return;

        System.out.print("Masukkan nomor data yang akan diedit: ");
        int index = input.nextInt();
        input.nextLine();

        if (index >= 1 && index <= daftarPenerima.size()) {

            PenerimaBantuan penerima = daftarPenerima.get(index - 1);

            System.out.println("Masukkan data baru (kosongkan jika tidak ingin mengubah)");

            System.out.print("Nama lama (" + penerima.getNama() + ") : ");
            String namaBaru = input.nextLine();

            System.out.print("NIK lama (" + penerima.getNik() + ") : ");
            String nikBaru = input.nextLine();

            System.out.print("Alamat lama (" + penerima.getAlamat() + ") : ");
            String alamatBaru = input.nextLine();

            if (!namaBaru.isEmpty()) {
                penerima.setNama(namaBaru);
            }

            if (!nikBaru.isEmpty()) {
                penerima.setNik(nikBaru);
            }

            if (!alamatBaru.isEmpty()) {
                penerima.setAlamat(alamatBaru);
            }

            System.out.println("Data berhasil diperbarui.");

        } else {

            System.out.println("Nomor data tidak valid.");

        }
    }
}