import java.io.*;
import java.util.*;

public class User {

    Ps2 ps2 = new Ps2();
    Ps3 ps3 = new Ps3();
    Ps4 ps4 = new Ps4();
    Ps5 ps5 = new Ps5();
    Login login = new Login();
    Tampilan tampilan = new Tampilan();
    Konsol konsol = new Konsol();
    Scanner scan = new Scanner(System.in);
    ArrayList<String> data = new ArrayList<String>();
    String nama;
    String alamat;

    int notlp;
    int harga = 0;
    int tes;
    boolean isExist = true;

    public void tulisData(String nama, String alamat, String notlp) throws IOException {
        BufferedWriter memberWriter = new BufferedWriter(new FileWriter("Data.txt", true));
        
        memberWriter.write(nama + "_" + alamat + "_" + notlp + "_Rp." + printTotal() + "_" + konsol.setTotalhari()+" Hari");
        memberWriter.newLine();
        memberWriter.close();
        System.out.println("Terimakasih telah menyewa di tempat kami )");
    }
    public void tulisData() throws IOException {
        BufferedWriter memberWriter = new BufferedWriter(new FileWriter("Data.txt", true));
        
        memberWriter.write(tampilan.login.gettemp(0) + "_" + tampilan.login.gettemp(1) + "_" + tampilan.login.gettemp(2) + "_Rp." + printTotal() + "_" + konsol.setTotalhari()+" Hari");
        memberWriter.newLine();
        memberWriter.close();
        System.out.println("Terimakasih telah menyewa di tempat kami )");
    }

    public int printTotal() {
        int tempTotsl = 0;

        for (int totall : konsol.getTotal()) {
            tempTotsl += totall;
        }

        return tempTotsl;

    }

    public void setdata(String nama, String alamat, String notlp) {

        data.add(0, nama);
        data.add(1, alamat);
        data.add(2, notlp);
    }

    public void showps2() throws IOException {
        while (isExist) {
            ps2.display();
            ps2.userInput = ps2.choose();
            konsol.getHari(ps2.userInput);
            konsol.setTotal(ps2.tampung());
            isExist = getYesorNo("Apakah ingin menambah ?");
        }
        isExist = true;

    }

    public void showps3() throws IOException {
        while (isExist) {
            ps3.display();
            ps3.userInput = ps3.choose();
            konsol.getHari(ps3.userInput);
            konsol.setTotal(ps3.tampung());

            isExist = getYesorNo("Apakah ingin menambah ?");

        }
        isExist = true;
    }

    public void showps4() throws IOException {
        while (isExist) {
            ps4.display();
            ps4.userInput = ps4.choose();
            konsol.getHari(ps4.userInput);
            konsol.setTotal(ps4.tampung());

            isExist = getYesorNo("Apakah ingin menambah ?");

        }
        isExist = true;
    }

    public void showps5() throws IOException {
        while (isExist) {
            ps5.display();
            ps5.userInput = ps5.choose();
            konsol.getHari(ps5.userInput);
            konsol.setTotal(ps5.tampung());

            isExist = getYesorNo("Apakah ingin menambah ?");

        }
        isExist = true;
    }

    public static void diplay() {
        System.out.println("        RENTAL PS BAROKAH      ");
        System.out.println("===============================");
        System.out.println("| No |       Menu utama       |");
        System.out.println("===============================");
        System.out.println("| 1. | Rental PlayStation 2   |");
        System.out.println("| 2. | Rental PlayStation 3   |");
        System.out.println("| 3. | Rental PlayStation 4   |");
        System.out.println("| 4. | Rental PlayStation 5   |");;
        System.out.println("| 5. | Tambahan Aksesoris     |");
        System.out.println("| 6. | Registrasi             |");
        System.out.println("| 7. |         BAYAR          |");
        System.out.println("===============================");
        

    }

    public boolean getYesorNo(String message) throws IOException {

        System.out.print("\n" + message + " (y/n)? ");
        String pilihanUser = scan.next();
        scan.nextLine();
        while (!pilihanUser.equalsIgnoreCase("y") && !pilihanUser.equalsIgnoreCase("n")) {
            System.err.println("Pilihan anda bukan y atau n");
            System.out.print("\n" + message + " (y/n) ? ");
            pilihanUser = scan.next();
            scan.nextLine();
        }
        return pilihanUser.equalsIgnoreCase("y");

    }
}
