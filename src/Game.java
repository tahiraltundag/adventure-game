import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Macera Oyununa hoş geldiniz");
        System.out.print("Lütfen bir isim giriniz : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Sayın : " + player.getName() + " bu karanlık ve sisli ada ya hoşgeldiniz!");
        System.out.println("Burda yaşananların hepsi gerçek\n");
        player.selectChar();

        Location location = null;

        while(true){
            player.printInfo();
            System.out.println();
            System.out.println("BÖLGELER");
            System.out.println();
            System.out.println("1 - Güvenli Ev ------> Burası sizin için güvenli bir ev, düşman yoktur ! ");
            System.out.println("2 - Eşya Dükkanı ------> Silah veya Zırh satın alabilirsiniz ! ");
            System.out.println("3 - Mağaraya git ------> Ödül : <Yemek>, dikkatli ol Zombi çıkabilir !");
            System.out.println("4 - Ormana git ------> Ödül : <Odun>, dikkatli ol Vampir çıkabilir !");
            System.out.println("5 - Nehire git ------> Ödül : <Su>, dikkatli ol Ayı çıkabilir");
            System.out.println("0 - Çıkış Yap -------> Oyunu sonlandır.");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selectLocation = input.nextInt();

            switch (selectLocation){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz ! ");
            }

            if(location == null){
                System.out.println("Bu karanlık ve sisli adadan çabuk vazgeçtin !");
                break;
            }
            if(!location.onLocation()){
                System.out.println("GAME OVER");
                break;
            }
        }
    }
}










