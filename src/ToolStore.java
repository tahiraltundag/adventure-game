public class ToolStore extends NormalLocation{

    public ToolStore(Player player) {
        super("Mağaza", player);
    }

    @Override
    public boolean onLocation() {
        System.out.println("\nMağazaya hoşgeldiniz");
        boolean showMenu = true;
        while(showMenu){
            System.out.println("1 - Silahlar");
            System.out.println("2 - Zırhlar");
            System.out.println("3 - Çıkış Yap");
            System.out.print("Bir işlem seç : ");
            int selectCase = input.nextInt();

            while (selectCase < 1 && selectCase > 3){
                System.out.print("Geçersiz değer girdiniz. tekrar deneyiniz : ");
                selectCase = input.nextInt();
            }

            switch (selectCase){
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Yine bekleriz");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    /*Silah listesi*/
    public void printWeapon(){
        System.out.println("\n####### SİLAHLAR #######");
        for(Weapon weapon : Weapon.weapons()){
            System.out.println(weapon.getId() + " - " + weapon.getName()
                                + " <Para : " + weapon.getPrice()
                                + " , Hasar : " + weapon.getDamage() + ">");
        }
        System.out.println("0 - Çıkış Yap");

    }

    /*silah alımı*/
    public void buyWeapon(){
        System.out.print("Bir silah seçiniz : ");
        int selectWeaponID = input.nextInt();

        while(selectWeaponID < 0 && selectWeaponID > Weapon.weapons().length){
            System.out.println("Geçersiz değer girdiniz, tekrar deneyin : ");
            selectWeaponID = input.nextInt();
        }

        if(selectWeaponID != 0){
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);
            if(selectedWeapon != null){
                if(selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli paranız bulunmamaktadır\n");
                }
                else {
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println(selectedWeapon.getName() + " silahını satın aldınız");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız : " + this.getPlayer().getMoney());

                }
            }
        }
    }

    /*armor listesi*/
    public void printArmor(){
        System.out.println("\n###### ZIRHLAR ######");
        for (Armor armor : Armor.armors()){
            System.out.println(armor.getId() + " - " + armor.getName()
                    + " <Para : " + armor.getPrice()
                    + " , Engel : " + armor.getBlock() + ">");
        }
        System.out.println("0 - Çıkış Yap");
    }

    /*armor alımı*/
    public void buyArmor(){
        System.out.print("Bir Zırh seçiniz : ");
        int selectArmorID = input.nextInt();

        while(selectArmorID < 0 && selectArmorID > Armor.armors().length){
            System.out.println("Geçersiz değer girdiniz, tekrar deneyin : ");
            selectArmorID = input.nextInt();
        }

        if(selectArmorID != 0) {
            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);
            if(selectedArmor != null){
                if(selectedArmor.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli paranız bulunmamaktadır\n");
                }
                else{
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println(selectedArmor.getName() + " zırhını satın aldınız");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("kalan paranız : " + this.getPlayer().getMoney());

                }
            }
        }

    }
}
















