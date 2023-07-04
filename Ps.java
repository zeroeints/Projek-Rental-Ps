import java.io.IOException;

public class Ps extends Konsol {
    private int hari ;
    private int minggu ;
    private int bulan ;
    private int jenis ;

    Ps(int hari, int minggu, int bulan ,int jenis) {
        this.hari=hari;
        this.minggu=minggu;
        this.bulan=bulan;
        this.jenis=jenis;
    }
    Ps(){}
    public void display() throws IOException {
        super.display(hari, minggu, bulan, jenis);
    }

    public int tampung() {
        int total = super.tampung(userInput, hari, minggu, bulan);
        return total;
    } 



}
