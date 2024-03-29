import java.io.*;
import java.util.*;

public class Login extends User {
    private boolean isLanjut = true;
    private boolean cek = false;
    private boolean cekMember = true;
    private ArrayList<String> temp = new ArrayList<String>();

    public void Regristrasi() throws IOException {
        if (Tampilan.getCek()) {
            System.out.println("=================================");
            System.out.println("|           Regristrasi         |");
            System.out.println("=================================");
            System.out.print("| User name :");
            String namaMember = read.readLine();
            System.out.println("=================================");
            System.out.print("| Password :");
            String PasswordMember = read.readLine();
            System.out.println("=================================");
            System.out.print("| Alamat :");
            String AlamatMember = read.readLine();
            System.out.println("=================================");
            System.out.print("| NO tlp :");
            String TlpMember = read.readLine();
            System.out.println("=================================");
            if (cekString(namaMember, PasswordMember, TlpMember, AlamatMember)) {

                cekMember(PasswordMember, namaMember);
                if (cekMember) {
                    tulis(PasswordMember, namaMember, AlamatMember, TlpMember);

                    System.out.println("Akun berhasil dibuat. Silakan login kembali.");
                } else {
                    System.out.println("akun yang anda buat saudah ada");
                }
            }else{
                System.out.println("Kata tidak boleh mengandung _");
            }

        } else {
            System.out.println("Anda telah memiliki akun silakan logout untuk membuat akun");
        }

    }

    public void loginUser() throws IOException {

        while (isLanjut) {
            System.out.println("=================================");
            System.out.println("|             login             |");
            System.out.println("=================================");
            System.out.print("| Nama Member : ");
            String NamaMember = read.readLine();
            System.out.println("=================================");
            System.out.print("| Password : ");
            String PasswordMember = read.readLine();
            System.out.println("=================================");
            cekUser(NamaMember, PasswordMember);
        }
    }

    private void cekUser(String NamaMember, String PasswordMember) throws IOException {
        try (BufferedReader memberBuffer = new BufferedReader(
                new FileReader("C:\\Coding\\Java_Oop\\Rental PS barokah\\dataMember.txt"))) {
            String cekID;
            String password;
            String username;
            String role = "i";

            while ((cekID = memberBuffer.readLine()) != null) {
                StringTokenizer stringToken = new StringTokenizer(cekID, "_");
                password = stringToken.nextToken();
                username = stringToken.nextToken();

                if (username.equals(NamaMember) && password.equals(PasswordMember)) {
                    // System.out.println(PasswordMember);
                    role = stringToken.nextToken();
                    this.temp.add(0, username);
                    this.temp.add(1, stringToken.nextToken());
                    this.temp.add(2, stringToken.nextToken());

                    this.cek = role.equals("admin");
                    this.isLanjut = false;
                    break;
                }
            }
            if (isLanjut) {
                System.out.println("password salah");
            }

        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    private void tulis(String PasswordMember, String namaMember, String AlamatMember, String TlpMember)
            throws IOException {
        try (BufferedWriter memberWriter = new BufferedWriter(new FileWriter("dataMember.txt", true))) {
            memberWriter.write(PasswordMember + "_" + namaMember + "_member_" + AlamatMember + "_" + TlpMember);
            memberWriter.newLine();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    public boolean retUrn() {
        return this.cek;
    }

    public String gettemp(int no) {
        String coba = temp.get(no);

        return coba;

    }

    private boolean cekString(String nama, String password, String no, String alamat) {
        return !nama.contains("_") && !password.contains("_") && !no.contains("_") && !alamat.contains("_");
    }

    private void cekMember(String pass, String User) throws IOException {
        try (BufferedReader memberBuffer = new BufferedReader(
                new FileReader("C:\\Coding\\Java_Oop\\Rental PS barokah\\dataMember.txt"))) {

            String cekId;
            String password;
            String username;
            while ((cekId = memberBuffer.readLine()) != null) {
                StringTokenizer stringToken = new StringTokenizer(cekId, "_");
                password = stringToken.nextToken();
                username = stringToken.nextToken();
                if (username.equals(User) && password.equals(pass)) {
                    cekMember = false;
                }
                stringToken.nextToken();
                stringToken.nextToken();
                stringToken.nextToken();
            }
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }

    }
}
