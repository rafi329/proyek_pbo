public class Wedding extends Event {
    private String temaPernikahan;

    public Wedding(String namaAcara, String tanggal, String lokasi, int jumlahTamu, String temaPernikahan) {
        super(namaAcara, tanggal, lokasi, jumlahTamu);
        this.temaPernikahan = temaPernikahan;
    }

    public String getTemaPernikahan() {
        return temaPernikahan;
    }

    public void setTemaPernikahan(String temaPernikahan) {
        this.temaPernikahan = temaPernikahan;
    }

    @Override
    public float hitungBiaya() {
        return getJumlahTamu() * 500;
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("Wedding: " + getNamaAcara() + ", Tema: " + temaPernikahan);
    }
}
