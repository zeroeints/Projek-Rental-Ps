import java.io.*;
import java.util.*;

public class Admin {
    Scanner scan = new Scanner(System.in);

    public void display() {
        System.out.println("        RENTAL PS BAROKAH      ");
        System.out.println("===============================");
        System.out.println("| No |       Menu utama       |");
        System.out.println("===============================");
        System.out.println("| 1. | Buat pesanan           |");
        System.out.println("| 2. | Baca data              |");
        System.out.println("| 3. | Ubah data              |");
        System.out.println("| 4. | Hapus data             |");
        System.out.println("===============================");

    }

    public int chose() {
        int userInput;
        System.out.print("Masukan pilihan : ");
        userInput = scan.nextInt();
        return userInput;
    }

    public void pilihanUser(int userInput) throws IOException {
        switch (userInput) {
            // case 1 -> tampilkanData();
            case 2 -> tampilkanData();
            // case 3 -> user.showps4();
            // case 4 -> ;

            // case 10 -> konsol.tambah(user.harga);

        }
    }

    public static void tampilkanData() throws IOException {

        FileReader fileInput;
        BufferedReader bufferInput;

        try {

            fileInput = new FileReader("Data.txt");
            bufferInput = new BufferedReader(fileInput);
        } catch (Exception c) {
            System.err.println("Database Tidak ditemukan");
            System.err.println("tambah data");
            return;
        }
System.out.println("========================================================================================");
System.out.println("| No |       Nama      |       Alamat        |     NoTlp     |    Total    |    Waktu  |");
System.out.println("========================================================================================");
String data = bufferInput.readLine();
int nomorData = 0;
while (data != null) {
    nomorData++;
    StringTokenizer stringToken = new StringTokenizer(data, "_");

    String nomorDataFormatted = String.format("%2d", nomorData);
    String namaFormatted = String.format("%-15s", stringToken.nextToken());
    String alamatFormatted = String.format("%-19s", stringToken.nextToken());
    String noTlpFormatted = String.format("%-13s", stringToken.nextToken());
    String totalFormatted = String.format("%-11s", stringToken.nextToken());
    String waktuFormatted = String.format("%-9s", stringToken.nextToken());

    System.out.printf("| %2s | %15s | %19s | %13s | %11s | %9s |\n",
            nomorDataFormatted, namaFormatted, alamatFormatted, noTlpFormatted, totalFormatted, waktuFormatted);

    data = bufferInput.readLine();
}
System.out.println("========================================================================================");
bufferInput.close();

    }

}
