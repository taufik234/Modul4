package LatihanPraktikum;

import java.util.HashMap;
import java.util.Scanner;

public class Mahasiswa {
    String nama, kelas, matkulPraktikum;
    int nim;

    public Mahasiswa(String nm, String kl, String mat, int ni) {
        nama = nm;
        kelas = kl;
        matkulPraktikum = mat;
        nim = ni;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String, Mahasiswa> mhs = new HashMap<>();
        String input;
        Mahasiswa data;

        mhs.put("1", new Mahasiswa("putri", "3H", "Struktur Data", 20200000));
        mhs.put("2", new Mahasiswa("agus", "3A", "Matematika", 2021));
        mhs.put("3", new Mahasiswa("Arroy", "3D", "Pemograman", 2022));
        System.out.print("Masukan ID : ");
        input = in.nextLine();
        data = mhs.get(input);

        if (data != null) {
            System.out.println(
                    "Data Mahasiswa : " + data.nama + " " + data.kelas + " " + data.matkulPraktikum + " " + data.nim);
        }
        in.close();

    }
}
