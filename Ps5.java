public class Ps5 extends Konsol {

    private final int hari = 150000;
    private final int minggu = 900000;
    private final int bulan = 2700000;

    public void display() {
        super.display(hari, minggu, bulan, 5);
    }

    public int tampung() {
        int total = super.tampung(userInput, hari, minggu, bulan);
        return total;
    }
}
