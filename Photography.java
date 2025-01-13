public class Photography implements Service {
    private String fotografer;
    private double biayaFotografi;

    public Photography(String fotografer) {
        this.fotografer = fotografer;
        this.biayaFotografi = 0.0;
    }

    // Menambahkan biaya berdasarkan pilihan fotografer
    private double hitungBiayaFotografi() {
        if (fotografer.equalsIgnoreCase("Budi")) {
            return 150000; // Harga untuk fotografer A
        } else if (fotografer.equalsIgnoreCase("Bambang")) {
            return 200000; // Harga untuk fotografer B
        }else if (fotografer.equalsIgnoreCase("Rizki")) {
            return 200000; // Harga untuk fotografer B
        }
        return 0;
    }

    @Override
    public void beriLayanan() {
        System.out.println("Layanan fotografi dengan fotografer: " + fotografer);
    }

    @Override
    public double hitungBiaya() {
        biayaFotografi = hitungBiayaFotografi();
        return biayaFotografi;
    }



    public void tampilkanDetail() {
        System.out.println("Detail Fotografi:");
        System.out.println("Fotografer: " + fotografer);
        System.out.println("Total Biaya: " + hitungBiaya());
    }
}
