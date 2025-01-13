import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    // Data penyimpanan sementara
    private static List<Orang> clients = new ArrayList<>();
    private static List<Event> events = new ArrayList<>();
    private static List<Vendor> vendors = new ArrayList<>();
    private static List<Faktur> fakturs = new ArrayList<>();
    private static List<Staff> staffs = new ArrayList<>();
    private static float totalBiaya = 0;

    public static void main(String[] args) {
        int pilihan;

        do {
            tampilkanMenu();
            System.out.print("Pilih menu (1-5, 0 untuk keluar): ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membaca newline

            switch (pilihan) {
                case 1:
                    kelolaKlien();
                    break;
                case 2:
                    pilihPaketLayanan();
                    break;
                case 3:
                    aturJadwalAcara();
                    break;
                case 4:
                    tampilkanRingkasanBiaya();
                    break;
                case 5:
                    kelolaVendor();
                    break;
                case 0:
                    System.out.println("Terima kasih! Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan coba lagi.");
            }
        } while (pilihan != 0);
    }

    private static void tampilkanMenu() {
        System.out.println("\n=== SISTEM MANAJEMEN ACARA ===");
        System.out.println("1. Tambah/Hapus/Perbarui Klien");
        System.out.println("2. Pilih Paket Layanan");
        System.out.println("3. Atur Jadwal Acara");
        System.out.println("4. Tampilkan Ringkasan Biaya");
        System.out.println("5. Kelola Vendor");
        System.out.println("0. Keluar");
    }

    // Kelola Klien
    private static void kelolaKlien() {
        System.out.println("\n--- KELOLA KLIEN ---");
        System.out.println("1. Tambah Klien");
        System.out.println("2. Hapus Klien");
        System.out.println("3. Perbarui Klien");
        System.out.print("Pilih opsi: ");
        int opsi = scanner.nextInt();
        scanner.nextLine();

        if (opsi == 1) {
            // Tambah klien
            System.out.print("Nama Klien: ");
            String nama = scanner.nextLine();
            System.out.print("Kontak Klien: ");
            String kontak = scanner.nextLine();
            clients.add(new Orang(nama, kontak));  // Menambahkan objek Orang (bisa ganti dengan subclass jika perlu)
            System.out.println("Klien berhasil ditambahkan!");
        } else if (opsi == 2) {
            // Hapus klien
            if (clients.isEmpty()) {
                System.out.println("Tidak ada klien untuk dihapus.");
                return;
            }
            System.out.println("Daftar Klien:");
            for (int i = 0; i < clients.size(); i++) {
                System.out.println((i + 1) + ". " + clients.get(i).getNama());
            }
            System.out.print("Pilih nomor klien untuk dihapus: ");
            int index = scanner.nextInt();
            if (index > 0 && index <= clients.size()) {
                clients.remove(index - 1);
                System.out.println("Klien berhasil dihapus.");
            } else {
                System.out.println("Nomor tidak valid.");
            }
        } else if (opsi == 3) {
            // Perbarui klien
            if (clients.isEmpty()) {
                System.out.println("Tidak ada klien untuk diperbarui.");
                return;
            }
            System.out.println("Daftar Klien:");
            for (int i = 0; i < clients.size(); i++) {
                System.out.println((i + 1) + ". " + clients.get(i).getNama());
            }
            System.out.print("Pilih nomor klien untuk diperbarui: ");
            int index = scanner.nextInt();
            scanner.nextLine(); // Mengabaikan newline

            if (index > 0 && index <= clients.size()) {
                Orang klien = clients.get(index - 1);  // Mengambil objek klien

                // Memperbarui nama atau kontak
                System.out.println("Pilih informasi yang ingin diperbarui:");
                System.out.println("1. Nama Klien");
                System.out.println("2. Kontak Klien");
                System.out.print("Pilih opsi: ");
                int updateOption = scanner.nextInt();
                scanner.nextLine(); // Mengabaikan newline

                if (updateOption == 1) {
                    System.out.print("Masukkan nama baru: ");
                    String namaBaru = scanner.nextLine();
                    klien.setNama(namaBaru);
                    System.out.println("Nama klien berhasil diperbarui!");
                } else if (updateOption == 2) {
                    System.out.print("Masukkan kontak baru: ");
                    String kontakBaru = scanner.nextLine();
                    klien.setKontak(kontakBaru);
                    System.out.println("Kontak klien berhasil diperbarui!");
                } else {
                    System.out.println("Opsi tidak valid.");
                }
            } else {
                System.out.println("Nomor tidak valid.");
            }
        } else {
            System.out.println("Opsi tidak valid.");
        }
    }

    // Pilih Paket Layanan
    private static void pilihPaketLayanan() {
        if (clients.isEmpty()) {
            System.out.println("Harap masukkan klien terlebih dahulu.");
            return;
        }

        // Tambah Staff
        System.out.println("\n--- TAMBAH STAFF ---");
        System.out.print("Masukkan ID Staff: ");
        int idStaff = scanner.nextInt();
        scanner.nextLine(); // Mengabaikan newline
        System.out.print("Masukkan Nama Staff: ");
        String namaStaff = scanner.nextLine();
        System.out.print("Masukkan Kontak Staff: ");
        String kontakStaff = scanner.nextLine();

        Staff staff = new Staff(idStaff, namaStaff, kontakStaff);
        staffs.add(staff);
        System.out.println("Staff berhasil ditambahkan!");

        // Pilih staff terlebih dahulu
        System.out.println("\n--- PILIH STAFF ---");
        for (int i = 0; i < staffs.size(); i++) {
            System.out.println((i + 1) + ". " + staffs.get(i).getNama());
        }
        System.out.print("Pilih staff: ");
        int staffIndex = scanner.nextInt();
        scanner.nextLine(); // Mengabaikan newline
        if (staffIndex < 1 || staffIndex > staffs.size()) {
            System.out.println("Staff yang dipilih tidak valid.");
            return;
        }
        Staff selectedStaff = staffs.get(staffIndex - 1);
        selectedStaff.infoOrang();  // Menampilkan informasi staff yang dipilih

        // Pilih paket layanan
        System.out.println("\n--- PILIH PAKET LAYANAN ---");
        System.out.println("1. Catering");
        System.out.println("2. Decoration");
        System.out.println("3. Photography");

        System.out.print("Pilih layanan: ");
        int opsi = scanner.nextInt();
        scanner.nextLine();

        if (opsi == 1) {
            System.out.println("Menu Catering");
            System.out.println("1. Buffet");
            System.out.println("2. Plated");
            System.out.println("3. Snack");
            System.out.print("Masukkan menu catering: ");
            String menu = scanner.nextLine();
            Service catering = new Catering(menu);

            catering.beriLayanan();
            System.out.println("Total biaya catering: " + catering.hitungBiaya());
        } else if (opsi == 2) {
            System.out.print("Masukkan gaya dekorasi: ");
            String gaya = scanner.nextLine();
            System.out.println("Masukkan bahan dekorasi (bunga, kain, lampu): ");
            String bahan = scanner.nextLine();
            
            // Membuat objek Decoration dengan gaya dan bahan dekorasi
            Service decoration = new Decoration(gaya, bahan);
            
            decoration.beriLayanan();  // Menampilkan layanan dekorasi
            System.out.println("Total biaya dekorasi: " + decoration.hitungBiaya());
            
        } else if (opsi == 3) {
            System.out.println("Nama Fotografer");
            System.out.println("1. Budi");
            System.out.println("2. Bambang");
            System.out.println("3. Rizki");
            System.out.print("Masukkan fotografer: ");
            String fotografer = scanner.nextLine();
            Service photography = new Photography(fotografer);

            photography.beriLayanan();
            System.out.println("Total biaya fotografi: " + photography.hitungBiaya());
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    // Atur Jadwal Acara
    private static void aturJadwalAcara() {
        System.out.println("\n--- ATUR JADWAL ACARA ---");
        System.out.print("Nama Acara: ");
        String namaAcara = scanner.nextLine();
        System.out.print("Tanggal Mulai (dd/mm/yyyy): ");
        String tanggalMulai = scanner.nextLine();
        System.out.print("Tanggal Selesai (dd/mm/yyyy): ");
        String tanggalSelesai = scanner.nextLine();
        System.out.print("Lokasi: ");
        String lokasi = scanner.nextLine();
        System.out.print("Jumlah Tamu: ");
        int jumlahTamu = scanner.nextInt();
        scanner.nextLine();
    
        System.out.println("Jenis Acara: ");
        System.out.println("1. Wedding");
        System.out.println("2. Seminar");
        System.out.println("3. Concert");
        System.out.print("Pilih jenis acara: ");
        int jenis = scanner.nextInt();
        scanner.nextLine();
    
        Event event;
        if (jenis == 1) {
            System.out.print("Tema Pernikahan: ");
            String tema = scanner.nextLine();
            event = new Wedding(namaAcara, tanggalMulai, lokasi, jumlahTamu, tema);
        } else if (jenis == 2) {
            System.out.print("Topik Seminar: ");
            String topik = scanner.nextLine();
            event = new Seminar(namaAcara, tanggalMulai, lokasi, jumlahTamu, topik);
        } else if (jenis == 3) {
            System.out.print("Artis Konser: ");
            String artis = scanner.nextLine();
            event = new Concert(namaAcara, tanggalMulai, lokasi, jumlahTamu, artis);
        } else {
            System.out.println("Pilihan jenis acara tidak valid.");
            return;
        }
    
        // Pilih klien yang terdaftar
System.out.println("Daftar Klien:");
for (int i = 0; i < clients.size(); i++) {
    System.out.println((i + 1) + ". " + clients.get(i).infoOrang());
}
System.out.print("Pilih nomor klien: ");
int klienIndex = scanner.nextInt();
scanner.nextLine();
Orang client = (Orang) clients.get(klienIndex - 1);  // Dapatkan objek klien yang dipilih

// Buat faktur dengan menggunakan objek client
totalBiaya += event.hitungBiaya();
Faktur faktur = new Faktur(fakturs.size() + 1, client, totalBiaya);
if (jumlahTamu > 1000) {
    faktur.buatFakturAcara(jumlahTamu);  // Panggil yang ada diskonnya jika jumlah tamu lebih dari 1000
} else {
    faktur.buatFakturAcara();  // Panggil yang tanpa diskon
}

fakturs.add(faktur);
System.out.println("Jadwal acara berhasil dibuat.");

    }
    

    // Tampilkan Ringkasan Biaya
    private static void tampilkanRingkasanBiaya() {
        System.out.println("\n--- RINGKASAN BIAYA ---");
        for (Faktur faktur : fakturs) {
            faktur.buatFakturAcara();
        }
        if (fakturs.isEmpty()) {
            System.out.println("Harap masukkan acara dulu.");
            return;
        }
    }
    
    // Kelola Vendor
    private static void kelolaVendor() {
        if (events.isEmpty()) {
            System.out.println("Tidak ada acara terdaftar. Harap atur acara terlebih dahulu.");
            return;
        }

        System.out.println("\n--- KELOLA VENDOR ---");
        System.out.print("Nama Vendor: ");
        String nama = scanner.nextLine();
        System.out.print("Jenis Layanan: ");
        String layanan = scanner.nextLine();

        vendors.add(new Vendor(nama, layanan));
        System.out.println("Vendor berhasil ditambahkan!");
    }
}
