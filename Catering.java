public class Catering implements Service {
    private String menu;
    private double biayaCatering;

    public Catering(String menu) {
        this.menu = menu;
        this.biayaCatering = 0.0;
    }

    // Menambahkan menu catering dan menghitung biaya
    private double hitungBiayaCatering() {
        if (menu.equalsIgnoreCase("Buffet")) {
            return 50000; // Harga buffet
        } else if (menu.equalsIgnoreCase("Plated")) {
            return 70000; // Harga plated meal
        } else if (menu.equalsIgnoreCase("Snack")) {
            return 30000; // Harga snack box
        }
        return 0;
    }

    @Override
    public void beriLayanan() {
        System.out.println("Layanan catering dengan menu: " + menu);

    }

    @Override
    public double hitungBiaya() {
        biayaCatering = hitungBiayaCatering();
        return biayaCatering;
    }

    public void tampilkanDetail() {
        System.out.println("Detail Catering:");
        System.out.println("Menu: " + menu);
        System.out.println("Total Biaya: " + hitungBiaya());
    }
}
