import java.io.IOException;

public class Ps2 extends Konsol {

    private int hari = 50000;
    private int minggu = 300000;
    private int bulan = 900000;
    // private int stok = 3;

    public void display() throws IOException {

        super.display(hari, minggu, bulan, 2);
    }

    public int tampung() {
        int total = super.tampung(userInput, hari, minggu, bulan);
        return total;
    }
}
