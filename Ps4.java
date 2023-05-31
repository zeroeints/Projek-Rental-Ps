public class Ps4 extends Konsol {

    int hari = 100000;
    int minggu = 600000;
    int bulan = 1800000;
    
    public void display (){
        System.out.println("==========================================");
        System.out.println("           Rental PlayStation 2           ");
        super.display(hari, minggu, bulan);
    }
    public int tampung(){
        int total = super.switchHarga(userInput, hari, minggu, bulan);
          return total;
       
      }
    
    
}
