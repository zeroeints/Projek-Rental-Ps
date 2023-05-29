import java.io.*;
import java.util.*;

public class Tampilan {
    
    static Scanner scan = new Scanner(System.in);
    static Admin admin = new Admin();
    static Login login = new Login();
    static User user = new User();
    static boolean isExist = true;
    static boolean cek = true;
    static int userInput;

    public static void main(String[] args) throws IOException {
        clearScreen();
        boolean isLanjut = false;

        isLanjut = getYesorNo("Apakah Anda memiliki akun member ? ");

        // while (isLanjut) {
        // isLanjut = false;
        // login.loginUser();
        // }
        if (isLanjut) {
            login.loginUser();
        } else {
            menuUser();
        }

        if (login.retUrn()) {
            menuAdmin();
        } else {
            cek = false;
            menuUser();
        }

    }

    public static void pilihanUser(int userInput) throws IOException {
        switch (userInput) {
            case 1 -> user.showps2();
            case 2 -> user.showps3();
            case 3 -> user.showps4();
            case 4 -> user.showps5();
            case 8 -> login.Regristrasi();
            case 9 -> bayar();
            // case 10 -> konsol.tambah(user.harga);

        }

    }

    public static void menuAdmin() throws IOException {
        boolean menuAdmin = true;

        while (menuAdmin) {
            admin.display();
            admin.pilihanUser(admin.chose());

            menuAdmin = getYesorNo("Apakah Anda ingin kembali ke menu utama ");
        }
    }

    public static void menuUser() throws IOException {
        boolean menuUser = true;
        while (menuUser) {

            clearScreen();
            User.diplay();
            chose();
            pilihanUser(userInput);

            menuUser = getYesorNo("Apakah Anda ingin kembali ke menu utama ");
        }
    }

    public static void chose() {
        System.out.print("Masukan pilihan : ");
        userInput = scan.nextInt();
        System.out.println("\n");

    }

    public static void formUser() throws IOException {

        System.out.print("Masukan nama : ");
        String nama = scan.next();
        System.out.print("Masukan alamat :");
        String alamat = scan.next();
        System.out.print("Masukan no tlp :");
        String notlp = scan.next();

        // user.setdata(nama, alamat, notlp);
        user.tulisData(nama, alamat, notlp);

    }

    public static void bayar() throws IOException {
        System.out.println("Total belanjaan anda : Rp." + user.printTotal() );
        if (user.printTotal() != 0) {
            boolean isbayar = getYesorNo("Apakah ingin melanjutkan pembayaran ");
            if (isbayar) {
                if (cek) {
                    formUser();
                } else {
                    user.tulisData();

                }

            }
        } else {
            System.out.println("Anda belum memesan apapun !");
        }

    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[h\033[2J");
                System.out.flush();
            }
        } catch (Exception ex) {
            System.err.println("tidak bisa clear screen");
        }
    }

    public static boolean getYesorNo(String message) throws IOException {

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