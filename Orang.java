public class Orang {
    private String nama;
    private String kontak;

    public Orang(String nama, String kontak) {
        this.nama = nama;
        this.kontak = kontak;
    }

    // Getter untuk nama
    public String getNama() {
        return nama;
    }

    // Setter untuk nama
    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter untuk kontak
    public String getKontak() {
        return kontak;
    }

    // Setter untuk kontak
    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

    // Metode infoOrang untuk mencetak informasi orang
    public String infoOrang() {
        return "Nama: " + nama + ", Kontak: " + kontak;
    }
}
