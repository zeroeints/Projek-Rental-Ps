
import java.util.Scanner;

public abstract class Konsol {
    Scanner scan = new Scanner(System.in);
    private int temp;
    int userInput;
    
    public void display(int hari, int minggu, int bulan,int jenis) {
        System.out.println("==========================================");
        System.out.println("           Rental PlayStation "+jenis+"           ");
        System.out.println("==========================================");
        System.out.println("| 1. | Harga sewa per hari: Rp." + hari + "\t |");
        System.out.println("| 2. | Harga sewa per minggu: Rp." + minggu + "\t |");
        System.out.println("| 3. | Harga sewa per bulan: Rp." + bulan + "\t |");
        System.out.println("==========================================");
    }

    public int tampung(int inputUser, int hari, int minggu, int bulan) {
        switch (inputUser) {
            case 1 -> temp = hari;                                                                                                                                                                                                                                                                                                          
            case 2 -> temp = minggu;
            case 3 -> temp = bulan;
        }
       
        return temp;
    }
  
    public int choose() {
        System.out.print("Masukan pilihan : ");
        int userInput = scan.nextInt();
        return userInput;
    }
    

}
