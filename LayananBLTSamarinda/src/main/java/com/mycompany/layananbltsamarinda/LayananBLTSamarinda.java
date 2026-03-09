package com.mycompany.layananbltsamarinda;

import java.util.ArrayList;
import java.util.Scanner;

class PenerimaBantuan {

    String nama;
    String nik;
    String alamat;

    public PenerimaBantuan(String nama, String nik, String alamat) {
        this.nama = nama;
        this.nik = nik;
        this.alamat = alamat;
    }

    public void tampilkanData() {
        System.out.println("Nama   : " + nama);
        System.out.println("NIK    : " + nik);
        System.out.println("Alamat : " + alamat);
        System.out.println("-----------------------------");
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

            System.out.print("Pilih menu : ");
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
                    System.out.println("Program selesai");
                    break;

                default:
                    System.out.println("Menu tidak tersedia");

            }

        } while (pilihan != 5);

    }

    static void tambahData() {

        System.out.print("Nama   : ");
        String nama = input.nextLine();

        System.out.print("NIK    : ");
        String nik = input.nextLine();

        System.out.print("Alamat : ");
        String alamat = input.nextLine();

        daftar.add(new PenerimaBantuan(nama, nik, alamat));

        System.out.println("Data berhasil ditambahkan");
    }

    static void lihatData() {

        if (daftar.isEmpty()) {
            System.out.println("Belum ada data");
            return;
        }

        System.out.println("\n===== DATA PENERIMA =====");

        for (int i = 0; i < daftar.size(); i++) {

            System.out.println("Data ke-" + (i + 1));
            daftar.get(i).tampilkanData();

        }

    }

    static void hapusData() {

        lihatData();

        if (daftar.isEmpty()) return;

        System.out.print("Pilih nomor data : ");
        int index = input.nextInt();
        input.nextLine();

        if (index >= 1 && index <= daftar.size()) {

            daftar.remove(index - 1);
            System.out.println("Data berhasil dihapus");

        } else {

            System.out.println("Nomor tidak valid");

        }

    }

    static void editData() {

        lihatData();

        if (daftar.isEmpty()) return;

        System.out.print("Pilih nomor data : ");
        int index = input.nextInt();
        input.nextLine();

        if (index >= 1 && index <= daftar.size()) {

            PenerimaBantuan p = daftar.get(index - 1);

            System.out.print("Nama baru (" + p.nama + ") : ");
            String nama = input.nextLine();

            System.out.print("NIK baru (" + p.nik + ") : ");
            String nik = input.nextLine();

            System.out.print("Alamat baru (" + p.alamat + ") : ");
            String alamat = input.nextLine();

            if (!nama.isEmpty()) p.nama = nama;
            if (!nik.isEmpty()) p.nik = nik;
            if (!alamat.isEmpty()) p.alamat = alamat;

            System.out.println("Data berhasil diupdate");

        } else {

            System.out.println("Nomor tidak valid");

        }

    }
}