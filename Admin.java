import java.io.*;
import java.util.*;

public class Admin extends User {
    Scanner scan = new Scanner(System.in);

    public static void display() {
        System.out.println("        RENTAL PS BAROKAH      ");
        System.out.println("===============================");
        System.out.println("| No |       Menu utama       |");
        System.out.println("===============================");
        System.out.println("| 1. | Buat pesanan           |");
        System.out.println("| 2. | Baca data pesanan      |");
        System.out.println("| 3. | Ubah data              |");
        System.out.println("| 4. | Hapus data             |");
        System.out.println("===============================");
    }

    public int chose() {
        int userInput;
        System.out.print("Masukkan pilihan: ");
        userInput = scan.nextInt();
        return userInput;
    }

    public void pilihanUser(int userInput) throws IOException {
        switch (userInput) {
            case 1:
                Tampilan.menuUser();
                break;
            case 2:
                tampilkanData();
                break;
            case 3:
                ubahData();
                break;
            case 4:
                hapusData();
                break;
            default:
                System.out.println("Pilihan tidak tersedia");
                break;
        }
    }

    private void ubahData() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Data.txt"));
        StringBuilder sb = new StringBuilder();
        String line = reader.readLine();
        int currentLineNumber = 1;
        tampilkanData();

        System.out.print("Masukkan nomor baris yang ingin diubah: ");
        int nomorBaris = scan.nextInt();

        scan.nextLine();
        System.out.print("Masukkan kata yang ingin diubah: ");
        String kata = scan.nextLine();
        System.out.print("\nMasukkan kata baru: ");
        String kataBaru = scan.nextLine();

        while (line != null) {
            if (currentLineNumber == nomorBaris) {
                if (line.contains(kata)) {
                    line = line.replace(kata, kataBaru);
                }
            }
            sb.append(line + "\r\n");
            line = reader.readLine();
            currentLineNumber++;
        }
        reader.close();

        FileWriter writer = new FileWriter("Data.txt");
        writer.write(sb.toString());
        writer.close();
    }

    private void hapusData() throws IOException {
        tampilkanData();
        System.out.println("");
        System.out.print("Masukkan nomor data yang ingin dihapus: ");
        int number = scan.nextInt();

        BufferedReader reader = new BufferedReader(new FileReader("Data.txt"));
        String dataLama = "";

        String line = reader.readLine();
        int pembanding = 1;
        boolean isLanjut = getYesOrNo("Apakah Anda yakin akan menghapus data?");

        if (isLanjut) {
            while (line != null) {
                if (pembanding != number) {
                    dataLama += line + "\r\n";
                }
                line = reader.readLine();
                pembanding++;
            }
            reader.close();

            if (number > pembanding) {
                System.out.println("Baris yang diinginkan tidak ditemukan di file.");
            } else {
                FileWriter writer = new FileWriter("Data.txt");
                writer.write(dataLama);
                writer.close();
            }
        }
    }

    private static void tampilkanData() throws IOException {
        FileReader fileInput;
        BufferedReader bufferInput;

        try {
            fileInput = new FileReader("Data.txt");
            bufferInput = new BufferedReader(fileInput);
        } catch (Exception c) {
            System.err.println("Database Tidak ditemukan");
            System.err.println("Tambah data");
            return;
        }

        System.out.println(
                "===================================================================================================================================");
        System.out.println(
                "| No |         Nama         |      Alamat      |   NoTlp   |                     Total Ps                       |      Total      |");
        System.out.println(
                "===================================================================================================================================");
        String data = bufferInput.readLine();
        int nomorData = 0;

        while (data != null) {
            nomorData++;
            StringTokenizer stringToken = new StringTokenizer(data, "_");

            String nomorDataFormatted = String.format("%2d", nomorData);
            String namaFormatted = String.format("%-20s", stringToken.nextToken());
            String alamatFormatted = String.format("%-16s", stringToken.nextToken());
            String noTlpFormatted = String.format("%-9s", stringToken.nextToken());

            String total = String.format("%-50s", stringToken.nextToken());
            String totalFormatted = String.format("%-15s", stringToken.nextToken());

            System.out.printf(
                    "| %2s | %20s | %16s | %7s | %50s | %10s |\n",
                    nomorDataFormatted, namaFormatted, alamatFormatted, noTlpFormatted, total, totalFormatted);

            data = bufferInput.readLine();
        }
        System.out.println(
                "===================================================================================================================================");
        bufferInput.close();
    }

}
