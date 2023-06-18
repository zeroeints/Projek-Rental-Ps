public class Ps4 extends Konsol {

    private final int hari = 100000;
    private final int minggu = 600000;
    private final int bulan = 1800000;

    public void display() {
        super.display(hari, minggu, bulan, 4);
    }

    public int tampung() {
        int total = super.tampung(userInput, hari, minggu, bulan);
        return total;
    }
}
