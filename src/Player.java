import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int orjinalHealth;
    private int money;
    private String charName;
    private String name;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;


    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar(){
        GameCharacter[] charList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("KARAKTERLER");
        System.out.println("####################################################################");
        for(GameCharacter gameCharacter : charList){
            System.out.println("Karakter: "
                                + " \t ID: " + gameCharacter.getId()
                                + " \t Adı: " + gameCharacter.getName()
                                + " \t Hasar: " + gameCharacter.getDamage()
                                + " \t Sağlık: " + gameCharacter.getHealth()
                                + " \t Fiyat: " + gameCharacter.getMoney());
        }
        System.out.println("####################################################################");
        System.out.print("Lütfen bir karakter seçiniz : ");
        int selectCharacter = input.nextInt();
        switch (selectCharacter){
            case 1:
                initPlayer(new Samurai());
                break;

            case 2:
                initPlayer(new Archer());
                break;

            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        /*
        System.out.println("Karakter: " + this.getCharName()
                        + ", Hasar: " + this.getDamage()
                        + ", Sağlık: " + this.getHealth()
                        + ", Fiyat: " + this.getMoney()); */
    }

    public void initPlayer(GameCharacter gameCharacter){
        this.setCharName(gameCharacter.getName());
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealth());
        this.setOrjinalHealth(gameCharacter.getHealth());
        this.setMoney(gameCharacter.getMoney());
    }

    public void printInfo(){
        System.out.println(
                "Adınız : " + this.getCharName() +
                ", Silahınız : " + this.getInventory().getWeapon().getName() +
                ", Zırhınız : " + this.getInventory().getArmor().getName() +
                ", Bloklama : " + this.getInventory().getArmor().getBlock() +
                ", Hasarınız : " + this.getTotalDamage() +
                ", Sağlığınız : " + this.getHealth() +
                ", Paranız : " + this.getMoney());
    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health < 0){
            health = 0;
        }
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }
}
