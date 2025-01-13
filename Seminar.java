public class Seminar extends Event {
    private String topik;

    public Seminar(String namaAcara, String tanggal, String lokasi, int jumlahTamu, String topik) {
        super(namaAcara, tanggal, lokasi, jumlahTamu);
        this.topik = topik;
    }

    public String getTopik() {
        return topik;
    }

    public void setTopik(String topik) {
        this.topik = topik;
    }

    @Override
    public float hitungBiaya() {
        return getJumlahTamu() * 200;
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("Seminar: " + getNamaAcara() + ", Topik: " + topik);
    }
}
