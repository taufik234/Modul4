import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataPraktikan {
    static Scanner sc = new Scanner(System.in);
    private HashMap<String, String> tabelData;

    public DataPraktikan() {
        tabelData = new HashMap<>();
    }

    // Menambah data baru ke dalam tabelData
    // dengan syarat nimPraktikan belum terdaftar dan hanya menerima nim dengan
    // kombinasi kata "IF"
    public boolean tambahData(String nimPraktikan, String namaAsisten) {
        if (nimPraktikan.startsWith("IF") && !tabelData.containsKey(nimPraktikan)) {
            tabelData.put(nimPraktikan, namaAsisten);
            return true;
        } else {
            return false;
        }
    }

    // Menampilkan semua data nimPraktikan beserta namaAsisten yang telah berhasil
    // diinputkan
    public void tampil() {
        System.out.println("Data Praktikan:");
        for (Map.Entry<String, String> entry : tabelData.entrySet()) {
            System.out.println("NIM: " + entry.getKey() + " | Nama Asisten: " + entry.getValue());
        }
    }

    // Menampilkan semua data nimPraktikan yang telah berhasil diinputkan
    public void listNimPraktikan() {
        System.out.println("List NIM Praktikan:");
        for (String nimPraktikan : tabelData.keySet()) {
            System.out.println(nimPraktikan);
        }
    }

    // Menampilkan semua data namaAsisten yang telah berhasil diinputkan
    public void listNamaAsisten() {
        System.out.println("List Nama Asisten:");
        for (String namaAsisten : tabelData.values()) {
            System.out.println(namaAsisten);
        }
    }

    // Menghitung total data yang ada dalam tabelData
    public int totalEmail() {
        return tabelData.size();
    }

    // Menghapus data yang terdapat dalam tabelData dengan syarat nimPraktikan yang
    // dihapus memang terdaftar sebelumnya
    public boolean hapusData(String nimPraktikan) {
        if (tabelData.containsKey(nimPraktikan)) {
            tabelData.remove(nimPraktikan);
            return true;
        } else {
            return false;
        }
    }

    // Melakukan edit data yang terdapat dalam tabelData dengan syarat nimPraktikan
    // yang akan di edit memang terdaftar sebelumnya
    public void editData(String nimPraktikan, String namaAsisten) {
        if (tabelData.containsKey(nimPraktikan)) {
            tabelData.put(nimPraktikan, namaAsisten);
            System.out.println("Data berhasil diedit.");
        } else {
            System.out.println("NIM tidak ditemukan.");
        }
    }

    // Menampilkan listNimPraktikan yang memiliki namaAsisten dengan nama sama
    public void search(String namaAsisten) {
        System.out.println("List NIM Praktikan dengan Nama Asisten: " + namaAsisten);
        boolean found = false;
        for (Map.Entry<String, String> entry : tabelData.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(namaAsisten)) {
                System.out.println("NIM: " + entry.getKey());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Tidak ditemukan.");
        }
    }

    public static void main(String[] args) {
        String choice;
        Scanner input = new Scanner(System.in);
        DataPraktikan dataPraktikan = new DataPraktikan();
        do {
            System.out.println("Menu:");
            System.out.println("1. Tambah Data Baru         5. Total Email");
            System.out.println("2. Tampilkan Data           6. Hapus Data");
            System.out.println("3. List NIM Praktikan       7. Edit Data");
            System.out.println("4. List Nama Asisten        8. Search");
            System.out.print("Pilihan: ");
            int pilihan = sc.nextInt();
            switch (pilihan) {
                case 1:
                    System.out.println("==== Tambah Data Baru =====");
                    System.out.print("Masukkan NIM: ");
                    String nim = sc.next();
                    System.out.print("Masukkan Nama Asisten: ");
                    String nama = sc.next();
                    if (dataPraktikan.tambahData(nim, nama)) {
                        System.out.println("Data berhasil ditambahkan.");
                    } else {
                        System.out.println("Data gagal ditambahkan.");
                    }
                    break;
                case 2:
                    System.out.println("==== Tampilkan Data =====");
                    dataPraktikan.tampil();
                    break;
                case 3:
                    System.out.println("==== List NIM Praktikan =====");
                    dataPraktikan.listNimPraktikan();
                    break;
                case 4:
                    System.out.println("==== List Nama Asisten =====");
                    dataPraktikan.listNamaAsisten();
                    break;
                case 5:
                    System.out.println("==== Total Email =====");
                    System.out.println(dataPraktikan.totalEmail());
                    break;
                case 6:
                    System.out.println("==== Hapus Data =====");
                    System.out.print("Masukkan NIM: ");
                    String nimcek = sc.next();
                    if (dataPraktikan.hapusData(nimcek)) {
                        System.out.println("Data berhasil dihapus.");
                    } else {
                        System.out.println("Data gagal dihapus.");
                    }
                    break;
                case 7:
                    System.out.println("==== Edit Data =====");
                    System.out.print("Masukkan NIM: ");
                    String nimcek1 = sc.next();
                    System.out.print("Masukkan Nama Asisten: ");
                    String namacek = sc.next();
                    dataPraktikan.editData(nimcek1, namacek);
                    break;
                case 8:
                    System.out.println("==== Search =====");
                    System.out.print("Masukkan Nama Asisten: ");
                    String nama1 = sc.next();
                    dataPraktikan.search(nama1);
                    break;
            }
            System.out.println("Apakah Anda ingin melanjutkan? (y/n): ");
            choice = input.next();
            if (choice.equalsIgnoreCase("y")) {
                System.out.println("Anda memilih untuk melanjutkan.");
            } else if (choice.equalsIgnoreCase("n")) {
                System.out.println("Anda memilih untuk berhenti.");
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }

        } while (!choice.equalsIgnoreCase("n"));
    }
}
