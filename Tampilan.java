import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public abstract class Tampilan  {
    static Admin admin = new Admin();
    static Login login = new Login();
    static User user = new User();
    // private static boolean isExist = true;
    private static boolean cek = true;
    private static int userInput;
    private static boolean isLanjut = false;
    private static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    Tampilan() {

    }

    public static void main(String[] args) throws IOException {
        clearScreen();

        isLanjut = getYesorNo("Apakah Anda memiliki akun member?");

        if (isLanjut) {
            clearScreen();
            login.loginUser();
        } else {
            clearScreen();
            menuUser();
        }

        if (login.retUrn()) {
            clearScreen();
            menuAdmin();
        } else {
            clearScreen();
            cek = false;
            menuUser();
        }
    }

    public static void pilihanUser(int userInput) throws IOException {
        switch (userInput) {
            case 1:
                clearScreen();
                user.showps2();
                break;
            case 2:
                clearScreen();
                user.showps3();
                break;
            case 3:
                clearScreen();
                user.showps4();
                break;
            case 4:
                clearScreen();
                user.showps5();
                break;
            case 5:
                clearScreen();
                login.Regristrasi();
                break;
            case 6:
                clearScreen();
                bayar();
                break;
            default:
                System.out.println("pilihan anda tidak tersedia");
                break;
        }
    }

    public static void menuAdmin() throws IOException {
        boolean menuAdmin = true;

        while (menuAdmin) {
            Admin.display();
            System.out.println("Masukan pilihan: ");
            admin.pilihanUser(admin.chose());

            menuAdmin = getYesorNo("Apakah Anda ingin kembali ke menu utama?");
        }
    }

    public static void menuUser() throws IOException {
        boolean menuUser = true;

        while (menuUser) {
            clearScreen();
            User.display();
            chose();
            pilihanUser(userInput);

            menuUser = getYesorNo("Apakah Anda ingin kembali ke menu utama?");
        }
    }

    public static void bayar() throws IOException {
        System.out.println("Total belanjaan Anda: Rp." + user.printTotal());

        if (user.printTotal() != 0) {
            boolean isbayar = getYesorNo("Apakah ingin melanjutkan pembayaran?");

            if (isbayar) {
                if (cek) {
                    formUser();
                } else {
                    user.tulisData();
                }
            } else {
                user.clearTotal();
            }

        } else {
            System.out.println("Anda belum memesan apapun!");
        }
    }

    public static void formUser() throws IOException {
        System.out.print("Masukkan nama: ");
        String nama = read.readLine();
        System.out.print("Masukkan alamat: ");
        String alamat = read.readLine();
        System.out.print("Masukkan nomor telepon: ");
        String notlp = read.readLine();
        user.tulisData(nama, alamat, notlp);
    }

     public static int chose()throws IOException {
        // int userInput;
        while (true) {
            System.out.print("Masukkan pilihan: ");
            try {
                userInput = Integer.parseInt(read.readLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka.");
            }

        }
        return userInput;
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
            System.err.println("Tidak dapat membersihkan layar.");
        }
    }

    public static boolean getYesorNo(String message) throws IOException {
        System.out.print("\n" + message + " (y/n)? ");
        String pilihanUser = read.readLine();
        // scan.nextLine();

        while (!pilihanUser.equalsIgnoreCase("y") && !pilihanUser.equalsIgnoreCase("n")) {
            System.err.println("Pilihan Anda bukan y atau n");
            System.out.print("\n" + message + " (y/n)? ");
            pilihanUser = read.readLine();
            // scan.nextLine();
        }

        return pilihanUser.equalsIgnoreCase("y");
    }

    public static Boolean getCek() {
        return cek;
    }
}
