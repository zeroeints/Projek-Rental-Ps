import java.util.ArrayList;
import java.util.Scanner;

public class Konsol {
    Scanner scan = new Scanner(System.in);
    int temp;
    int userInput;
    private int totalHari=0;

    
    ArrayList<User> data = new ArrayList<User>();
    ArrayList<Integer> total = new ArrayList<>();
    
    public int setTotalhari (){
        return totalHari;
    }

    public void display(int hari, int minggu, int bulan) {
        System.out.println("==========================================");
        System.out.println("| 1. | Harga sewa per hari: Rp." + hari + "\t |");
        System.out.println("| 2. | Harga sewa per minggu: Rp." + minggu + "\t |");
        System.out.println("| 3. | Harga sewa per bulan: Rp." + bulan + "\t |");
        System.out.println("==========================================");
    }

    public int switchHarga(int inputUser, int hari, int minggu, int bulan) {
        switch (inputUser) {
            case 1 -> temp = hari;
            case 2 -> temp = minggu;
            case 3 -> temp = bulan;
        }
       
        return temp;

    }
    public void getHari(int input) {
        int hari=0;
        switch (input) {
            case 1 -> hari = 1;
            case 2 -> hari = 7;
            case 3 -> hari = 30;
        }
        totalHari += hari;
    }
   
    public int choose() {
        System.out.print("Masukan pilihan : ");
        int userInput = scan.nextInt();
        return userInput;
    }
    public void addUser(User user) {
        this.data.add(user);
    }

    public void setTotal(int harga) {
       
    total.add(harga);

    }

    public ArrayList<Integer> getTotal() {
        return total;
    }
    

}
