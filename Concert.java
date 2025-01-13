public class Concert extends Event {
    private String artis;

    public Concert(String namaAcara, String tanggal, String lokasi, int jumlahTamu, String artis) {
        super(namaAcara, tanggal, lokasi, jumlahTamu);
        this.artis = artis;
    }

    public String getArtis() {
        return artis;
    }

    public void setArtis(String artis) {
        this.artis = artis;
    }

    @Override
    public float hitungBiaya() {
        return getJumlahTamu() * 1000;
    }

    @Override
    public void tampilkanDetail() {
        System.out.println("Concert: " + getNamaAcara() + ", Artis: " + artis);
    }
}
