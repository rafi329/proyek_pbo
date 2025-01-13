public class Schedule {
    private String tanggalMulai;
    private String tanggalSelesai;
    private String lokasi;

    public Schedule(String tanggalMulai, String tanggalSelesai, String lokasi) {
        this.tanggalMulai = tanggalMulai;
        this.tanggalSelesai = tanggalSelesai;
        this.lokasi = lokasi;
    }

    public void tampilkanJadwal() {
        System.out.println("Jadwal: " + tanggalMulai + " hingga " + tanggalSelesai + " di " + lokasi);
    }
}
