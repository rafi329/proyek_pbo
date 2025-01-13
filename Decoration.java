public class Decoration implements Service {
    private String gaya;  // Gaya dekorasi yang dipilih
    private String bahanDekorasi;  // Bahan dekorasi yang digunakan
    private double biayaDekorasi;  // Biaya dekorasi yang dihitung berdasarkan bahan

    // Constructor untuk menginisialisasi gaya dan bahan dekorasi
    public Decoration(String gaya, String bahanDekorasi) {
        this.gaya = gaya;
        this.bahanDekorasi = bahanDekorasi;
        this.biayaDekorasi = 0.0;
    }

    // Menghitung biaya dekorasi berdasarkan bahan
    private double hitungBiayaDekorasi() {
        double biaya = 0;
        
        // Menentukan biaya berdasarkan bahan dekorasi
        if (bahanDekorasi.equalsIgnoreCase("bunga")) {
            biaya += 150000;
        } else if (bahanDekorasi.equalsIgnoreCase("lampu")) {
            biaya += 50000;
        } else if (bahanDekorasi.equalsIgnoreCase("kain")) {
            biaya += 30000;
        }
        
        return biaya;
    }

    // Implementasi metode beriLayanan() untuk memberikan informasi layanan dekorasi
    @Override
    public void beriLayanan() {
        System.out.println("Layanan dekorasi dengan gaya: " + gaya);
        System.out.println("Bahan dekorasi yang digunakan: " + bahanDekorasi);
    }

    // Implementasi metode hitungBiaya() untuk menghitung total biaya dekorasi
    @Override
    public double hitungBiaya() {
        biayaDekorasi = hitungBiayaDekorasi();  // Menghitung biaya berdasarkan bahan
        return biayaDekorasi;
    }

    // Menampilkan detail layanan dekorasi
    public void tampilkanDetail() {
        System.out.println("Detail Dekorasi:");
        System.out.println("Gaya: " + gaya);
        System.out.println("Bahan: " + bahanDekorasi);
        System.out.println("Total Biaya: " + hitungBiaya());
    }
}
