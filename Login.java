import java.io.*;
import java.util.*;

public class Login {
    Scanner scan = new Scanner(System.in);
    private boolean isLanjut = true;
    private boolean cek = false;

    public void Regristrasi() throws IOException {
        System.out.println("=================================");
        System.out.println("|           Regristrasi         |");
        System.out.println("=================================");
        System.out.print("| User name :");
        String namaMember = scan.next();
        System.out.println("=================================");
        System.out.print("| Password :");
        String PasswordMember = scan.next();
        System.out.println("=================================");
        System.out.print("| Alamat :");
        String AlamatMember = scan.next();
        System.out.println("=================================");
        System.out.print("| NO tlp :");
        String TlpMember = scan.next();
        System.out.println("=================================");

        tulis(PasswordMember, namaMember, AlamatMember, TlpMember);

        System.out.println("Akun berhasil dibuat. Silakan login kembali.");

    }

    public void loginUser() throws IOException {

        while (isLanjut) {
            System.out.println("=================================");
            System.out.println("|             login             |");
            System.out.println("=================================");
            System.out.print("| Nama Member : ");
            String NamaMember = scan.next();
            System.out.println("=================================");
            System.out.print("| Password : ");
            String PasswordMember = scan.next();
            System.out.println("=================================");
            cekUser(NamaMember, PasswordMember);
        }
    }

    private void cekUser(String NamaMember, String PasswordMember) throws IOException {
        try {
            BufferedReader memberbufer = new BufferedReader(
                    new FileReader("C:\\Coding\\Java_Oop\\Rental PS barokah\\dataMember.txt"));
            String cekID = memberbufer.readLine();
            String pasword;
            String username;
            String role = "i";

            while (cekID != null) {
                StringTokenizer stringToken = new StringTokenizer(cekID, "_");
                pasword = stringToken.nextToken();
                username = stringToken.nextToken();

                if (username.equals(NamaMember)) {
                    if (pasword.equals(PasswordMember)) {
                        role = stringToken.nextToken();
                        this.isLanjut = false;
                        break;
                    }
                    System.out.println("pasword salah");
                }
                cekID = memberbufer.readLine();

            }

            if (role.equals("admin")) {
                this.cek = true;
            } else if (role.equals("member")) {
                this.cek = false;
            }
            memberbufer.close();

        } catch (Exception e) {
            System.out.println("eror" + e.getMessage());

        }

    }

    private void tulis(String PasswordMember, String namaMember, String AlamatMember, String TlpMember)
            throws IOException {
        BufferedWriter memberWriter = new BufferedWriter(new FileWriter("dataMember.txt", true));

        memberWriter.write(PasswordMember + "_" + namaMember + "_member_" + AlamatMember + "_" + TlpMember);
        memberWriter.newLine();
        memberWriter.close();
    }

    public boolean retUrn() {
        return this.cek;
    }
}
