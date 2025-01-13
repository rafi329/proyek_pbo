public class Client extends Orang {

    // Konstruktor untuk Client, memanggil konstruktor Orang
    public Client(String nama, String kontak) {
        super(nama, kontak);  // Memanggil konstruktor induk (Orang)
    }

    @Override
    public String infoOrang() {
        return "Nama: " + getNama() + ", Kontak: " + getKontak();
    }
}
