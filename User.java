import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.ArrayList;

public class User {
    Ps2 ps2 = new Ps2();
    Ps3 ps3 = new Ps3();
    Ps4 ps4 = new Ps4();
    Ps5 ps5 = new Ps5();
    Scanner scan = new Scanner(System.in);
    private ArrayList<String> data = new ArrayList<>();
    private boolean isExist = true;
    private int[] stok = { 10, 10, 10, 10 };
    private int[] ArayTotal = { 0, 0, 0, 0, 0, 0, 0, 0 };
    private StringBuilder temp = new StringBuilder();

    private LocalDate lamaPeminjaman(int hari) {
        LocalDate awal = LocalDate.now();
        LocalDate akhir = awal.plusDays(hari);
        return akhir;
    }

    private void cekPembelian() {
        if (ArayTotal[0] != 0) {
            temp.append("Ps2 " + ArayTotal[1] + " Hari,Sampai " + lamaPeminjaman(ArayTotal[1]));
        }
        if (ArayTotal[2] != 0) {
            temp.append("Ps3 " + ArayTotal[3] + " Hari,Sampai " + lamaPeminjaman(ArayTotal[3]));
        }
        if (ArayTotal[4] != 0) {
            temp.append("Ps4 " + ArayTotal[5] + " Hari,Sampai " + lamaPeminjaman(ArayTotal[5]));
        }
        if (ArayTotal[6] != 0) {
            temp.append("Ps5 " + ArayTotal[7] + " Hari,Sampai " + lamaPeminjaman(ArayTotal[7]));
        }

    }

    public static void display() {
        System.out.println("        RENTAL PS BAROKAH      ");
        System.out.println("===============================");
        System.out.println("| No |       Menu utama       |");
        System.out.println("===============================");
        System.out.println("| 1. | Rental PlayStation 2   |");
        System.out.println("| 2. | Rental PlayStation 3   |");
        System.out.println("| 3. | Rental PlayStation 4   |");
        System.out.println("| 4. | Rental PlayStation 5   |");
        System.out.println("| 5. | Registrasi             |");
        System.out.println("| 6. |         BAYAR          |");
        System.out.println("===============================");
    }

    public boolean getYesOrNo(String message) throws IOException {
        System.out.print("\n" + message + " (y/n)? ");
        String pilihanUser = scan.next();
        scan.nextLine();
        while (!pilihanUser.equalsIgnoreCase("y") && !pilihanUser.equalsIgnoreCase("n")) {
            System.err.println("Pilihan anda bukan y atau n");
            System.out.print("\n" + message + " (y/n)? ");
            pilihanUser = scan.next();
            scan.nextLine();
        }
        return pilihanUser.equalsIgnoreCase("y");
    }

    public void setdata(String nama, String alamat, String notlp) {
        data.add(0, nama);
        data.add(1, alamat);
        data.add(2, notlp);
    }

    public int printTotal() {
        int tempTotal = 0;

        for (int i=0 ;i<=7;i++) {
            if(i%2==0){

                tempTotal += ArayTotal[i];
            }
        }

        return tempTotal;
    }

    public void tulisData(String nama, String alamat, String notlp) throws IOException {
        cekPembelian();
        BufferedWriter memberWriter = new BufferedWriter(new FileWriter("Data.txt", true));

        memberWriter.write(
                nama + "_" + alamat + "_" + notlp + "_" + temp.toString() + "_" + "Rp." + printTotal());
        memberWriter.newLine();
        memberWriter.close();
        System.out.println("Terimakasih telah menyewa di tempat kami)");
        clearTotal();
    }

    public void tulisData() throws IOException {
        cekPembelian();
        BufferedWriter memberWriter = new BufferedWriter(new FileWriter("Data.txt", true));

        memberWriter.write(Tampilan.login.gettemp(0) + "_" + Tampilan.login.gettemp(1) + "_" + Tampilan.login.gettemp(2)
                + "_" + temp.toString() + "_" +
                "Rp." + printTotal());
        memberWriter.newLine();
        memberWriter.close();

        System.out.println("Terimakasih telah menyewa di tempat kami)");
        clearTotal();
    }

    public void showps2() throws IOException {
        if (Cekstok(0)) {
            stok[0] -= 1;
            while (isExist) {
                ps2.display();
                ps2.userInput = ps2.choose();
                ArayTotal[0] += ps2.tampung();
                ArayTotal[1] += getHari(ps2.userInput);
                isExist = getYesOrNo("Apakah ingin menambah?");
            }
            isExist = true;
        }
    }

    public void showps3() throws IOException {
        if (Cekstok(1)) {
            stok[1] -= 1;
            while (isExist) {
                ps3.display();
                ps3.userInput = ps3.choose();
                ArayTotal[2] += ps3.tampung();
                ArayTotal[3] += getHari(ps3.userInput);
                isExist = getYesOrNo("Apakah ingin menambah?");
            }
            isExist = true;
        }
    }

    public void showps4() throws IOException {
        if (Cekstok(2)) {
            stok[2] -= 1;
            while (isExist) {
                ps4.display();
                ps4.userInput = ps4.choose();
                ArayTotal[4] += ps4.tampung();
                ArayTotal[5] += getHari(ps4.userInput);

                isExist = getYesOrNo("Apakah ingin menambah?");
            }
            isExist = true;
        }
    }

    public void showps5() throws IOException {
        if (Cekstok(3)) {
            stok[3] -= 1;
            while (isExist) {
                ps5.display();
                ps5.userInput = ps5.choose();
                ArayTotal[6] += ps5.tampung();
                ArayTotal[7] += getHari(ps5.userInput);
                isExist = getYesOrNo("Apakah ingin menambah?");
            }
            isExist = true;
        }
    }

    private int getHari(int input) {
        int hari = 0;
        switch (input) {
            case 1 -> hari = 1;
            case 2 -> hari = 7;
            case 3 -> hari = 30;
            default -> System.out.println("pilihan anda tidak tersedia");
        }
        return hari;

    }

    private void clearTotal() {
        for (int i = 0; i <= 7; i++) {
            ArayTotal[i] = 0;
        }
    }

    private boolean Cekstok(int id) {
        boolean cek = false;
        if (stok[id] > 0) {
            cek = true;
        } else {
            System.out.println("Maaf stok ps Sudah habis ");
        }

        return cek;

    }

}
