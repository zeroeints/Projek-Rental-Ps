public class Ps3 extends Konsol {

    private final int hari = 75000;
    private final int minggu = 450000;
    private final int bulan = 1350000;

    public void display() {
        super.display(hari, minggu, bulan, 3);
    }

    public int tampung() {
        int total = super.tampung(userInput, hari, minggu, bulan);
        return total;
    }
}
