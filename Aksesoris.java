public class Aksesoris extends Konsol {
    int controler2 = 25000;
    int controler3 = 50000;
    int controler4 = 50000;
    int controler5 = 75000;
    int vr = 250_000;
    int gameFifa = 25_000;
    int gameGta5 = 50_000;
    int temp =0;

    public void display() {
        System.out.println("1.DUALSHOCK 2 Controller: Rp. 25.000/hari");
        System.out.println("2.DUALSHOCK 3 Controller: Rp. 50.000/hari");
        System.out.println("3.DUALSHOCK 4 Controller: Rp. 50.000/hari");
        System.out.println("4.DUALSHOCK 5 Controller: Rp. 75.000/hari");
        System.out.println("5.VR Headset: Rp. 250.000/hari");
        System.out.println("6.Game FIFA 23: Rp. 25.000/hari");
        System.out.println("7.Game Grand Theft Auto V: Rp. 50.000/hari");
        choose();

    }
    public int tampung (int pilihan){
        switch (pilihan) {
            case 1-> temp = controler2;
            case 2-> temp = controler3;
            case 3-> temp = controler4;
            case 4-> temp = controler5;
            case 5-> temp = vr;
            case 6-> temp = gameFifa;
            case 7-> temp = gameGta5;
        
            default->System.out.println("Pilihan anda tidak tersedia");
              
        }
        return temp;
    }
   

}
