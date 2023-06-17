public class Ps4 extends Konsol {

    private int hari = 100000;
    private int minggu = 600000;
    private int bulan = 1800000;
    
    public void display() {
        super.display(hari, minggu, bulan,4);
    }
    
    public int tampung() {
        int total = super.switchHarga(userInput, hari, minggu, bulan);
        return total;
    }
}
