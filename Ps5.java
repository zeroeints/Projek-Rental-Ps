public class Ps5 extends Konsol {


    int hari = 150000;
    int minggu = 900000;
    int bulan = 2700000;
   


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
