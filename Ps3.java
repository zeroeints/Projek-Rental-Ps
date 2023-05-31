public class Ps3 extends Konsol {
    
    int hari = 75000;
    int minggu = 450000;
    int bulan = 1350000;
    
    public void display (){
        System.out.println("==========================================");
        System.out.println("           Rental PlayStation 3           ");
        super.display(hari, minggu, bulan);
    }
    public int tampung(){
        int total = super.switchHarga(userInput, hari, minggu, bulan);
          return total;
       
      }

    
    

}
