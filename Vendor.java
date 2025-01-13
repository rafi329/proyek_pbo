public class Vendor {
    private String namaVendor;
    private String jenisLayanan;

    public Vendor(String namaVendor, String jenisLayanan) {
        this.namaVendor = namaVendor;
        this.jenisLayanan = jenisLayanan;
    }

    public String infoVendor() {
        return "Vendor: " + namaVendor + ", Layanan: " + jenisLayanan;
    }
}
