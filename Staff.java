public class Staff extends Orang {
    private int idStaff;

    // Konstruktor
    public Staff(int idStaff, String namaStaff, String kontak) {
        super(namaStaff, kontak);  // Memanggil konstruktor induk (Orang)
        this.idStaff = idStaff;
    }

    // Getter untuk idStaff
    public int getIdStaff() {
        return idStaff;
    }

    @Override
    public String infoOrang() {
        // Menampilkan informasi staff dengan ID dan nama
        return "Staff: ID: " + idStaff + ", Nama: " + getNama() + ", Kontak: " + getKontak();
    }
}
