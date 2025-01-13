public class Faktur {
    private int nomorFaktur;
    private Orang client;  // Menggunakan objek Client
    private float totalBiaya;

    public Faktur(int nomorFaktur, Orang client, float totalBiaya) {
        this.nomorFaktur = nomorFaktur;
        this.client = client;
        this.totalBiaya = totalBiaya;
    }

    // Overloading metode buatFakturAcara untuk diskon
    public void buatFakturAcara() {
        if (client != null) {
            System.out.println("Faktur #" + nomorFaktur + " untuk Klien: " + client.getNama() + ", Total: " + totalBiaya);
        } else {
            System.out.println("Faktur #" + nomorFaktur + " untuk Klien tidak diketahui, Total: " + totalBiaya);
        }
    }

    // Menambahkan diskon jika jumlah tamu lebih dari 1000
    public void buatFakturAcara(int jumlahTamu) {
        if (jumlahTamu > 1000) {
            float diskon = totalBiaya * 0.1f;  // Diskon 10%
            totalBiaya -= diskon;
            System.out.println("Faktur #" + nomorFaktur + " untuk Klien: " + client.getNama() + ", Total setelah diskon: " + totalBiaya);
        } else {
            buatFakturAcara();  // Panggil yang tanpa diskon jika tamu kurang dari 1000
        }
    }
}
