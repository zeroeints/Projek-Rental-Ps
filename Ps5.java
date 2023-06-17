public class Ps5 extends Konsol {

    private int hari = 150000;
    private int minggu = 900000;
    private int bulan = 2700000;
   
    public void display (){
        super.display(hari, minggu, bulan,5);
    }
    public int tampung(){
        int total = super.switchHarga(userInput, hari, minggu, bulan);
          return total;
       
      }
}
