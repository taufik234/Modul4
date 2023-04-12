import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class prak2 {
    static Scanner sc = new Scanner(System.in);
    private HashMap<String, String> tabelData;
    private HashMap<String, String> tabelSesiLogin;

    public prak2() {
        tabelData = new HashMap<>();
        tabelSesiLogin = new HashMap<>();
        tabelSesiLogin.put("admin@umm.ac.id", "admin");
        tabelSesiLogin.put("Taufik@umm.ac.id","centos");

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

    // Method untuk melakukan login
    public void login(String email, String password) {
        // Cek apakah email dan password sesuai dengan data yang tersimpan pada
        // tabelSesiLogin
        if (tabelSesiLogin.containsKey(email) && tabelSesiLogin.get(email).equals(password)) {
            // Cek apakah email menggunakan domain "@umm.ac.id"
            if (email.endsWith("@umm.ac.id")) {
                System.out.println("Login berhasil.");
                menu();
            } else {
                System.out.println("Login gagal. Email harus menggunakan domain @umm.ac.id");
            }
        } else {
            System.out.println("Login gagal. Email atau password salah.");
        }
    }

    /*
     * Metode Logout:
     * - User keluar dari program
     */
    
    public void logout() {
        System.out.println("Logout berhasil.");
        System.exit(0);
    }

    void menu() {
        String choice;
        Scanner input = new Scanner(System.in);
        prak2 dataPraktikan = new prak2();
        do {
            System.out.println("Menu:");
            System.out.println("1. Tambah Data Baru         5. Total Email");
            System.out.println("2. Tampilkan Data           6. Hapus Data");
            System.out.println("3. List NIM Praktikan       7. Edit Data");
            System.out.println("4. List Nama Asisten        8. Search");
            System.out.println("9. Logout");
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
                case 9:
                    System.out.println("==== Logout =====");
                    dataPraktikan.logout();
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
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

    public static void main(String[] args) {

        prak2 dataPraktikan = new prak2();
        System.out.println("==== Login ====");
        System.out.print("Masukkan email: ");
        String email = sc.next();
        System.out.print("Masukkan password: ");
        String password = sc.next();
        dataPraktikan.login(email, password);
    }
}
