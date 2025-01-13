public abstract class Event {
    private String namaAcara;
    private String tanggal;
    private String lokasi;
    private int jumlahTamu;

    public Event(String namaAcara, String tanggal, String lokasi, int jumlahTamu) {
        this.namaAcara = namaAcara;
        this.tanggal = tanggal;
        this.lokasi = lokasi;
        this.jumlahTamu = jumlahTamu;
    }

    public String getNamaAcara() {
        return namaAcara;
    }

    public void setNamaAcara(String namaAcara) {
        this.namaAcara = namaAcara;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public int getJumlahTamu() {
        return jumlahTamu;
    }

    public void setJumlahTamu(int jumlahTamu) {
        this.jumlahTamu = jumlahTamu;
    }

    public abstract float hitungBiaya();

    public abstract void tampilkanDetail();
}
