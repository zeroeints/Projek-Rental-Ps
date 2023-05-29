import java.io.IOException;
// import java.util.ArrayList;

public class Ps2 extends Konsol {
    
    int hari = 50000;
    int minggu = 300000;
    int bulan = 900000;
    
    public void display () throws IOException{
            System.out.println("==========================================");
            System.out.println("           Rental PlayStation 2           ");
            super.display(hari, minggu, bulan);
    }
    public int tampung(){
      int total = super.switchHarga(userInput, hari, minggu, bulan);
        return total;
     
    }
    
}
