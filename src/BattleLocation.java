import java.util.Random;

public abstract class BattleLocation extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLocation(String name, Player player, Obstacle obstacle, String award, int maxObstacle) {
        super(name, player);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("Şuan Buradasınız : " + this.getName());
        System.out.println("Dikkatli ol!!! Burada " + obsNumber + " tane " + this.getObstacle().getName() + " yaşıyor !");
        System.out.print("<S>avaş veya <K>aç : ");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if(selectCase.equals("S") && combat(obsNumber)){
            System.out.println(this.getPlayer().getName() + " tüm düşmanları yendiniz\n");
            return true;
        }

        if(this.getPlayer().getHealth() <= 0){
            System.out.println("Öldünüz");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber){
        for(int i = 1; i <= obsNumber;i++){
            this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
            playerStats();
            obstacleStats(i);
            while(this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0){
                System.out.print("<V>ur veya <K>aç : ");
                String selectCombat = input.nextLine().toUpperCase();
                if(selectCombat.equals("V")){
                    int obstacleNewHealth = this.getObstacle().getHealth() - this.getPlayer().getTotalDamage();
                    this.getObstacle().setHealth(obstacleNewHealth);
                    System.out.println("Siz vurdunuz ");
                    afterHit();
                    if(this.getObstacle().getHealth() > 0){
                        System.out.println();
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if(obstacleDamage < 0){
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                        System.out.println(this.getObstacle().getName() + " size vurdu");
                        afterHit();
                    }
                }
                else{
                    return false;
                }
            }
            if(this.getObstacle().getHealth() < this.getPlayer().getHealth()){
                System.out.println("Düşmanı yendiniz");
                System.out.println(this.getObstacle().getMoney() + " para kazandınız");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getMoney());
                System.out.println("Güncel paranız : " + this.getPlayer().getMoney());
            }
            else {
                return false;
            }
        }
        return true;
    }

    public void afterHit(){
        System.out.println("Canınız : " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " canı : " + this.getObstacle().getHealth());
        System.out.println();
    }

    public void playerStats(){
        System.out.println(this.getPlayer().getName() + " Oyuncusunun değerleri");
        System.out.println("---------------------------");
        System.out.println("Sağlık : " + this.getPlayer().getHealth());
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println("Zırh : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para : " + this.getPlayer().getMoney());
        System.out.println();

    }

    public void obstacleStats(int i){
        System.out.println(i + ". " + this.getObstacle().getName() + " Değerleri : ");
        System.out.println("-----------------------------");
        System.out.println("Sağlık : " + this.getObstacle().getHealth());
        System.out.println("Hasar : " + this.getObstacle().getDamage());
        System.out.println("Para : " + this.getObstacle().getMoney());
        System.out.println();
    }

    public int randomObstacleNumber(){
        Random random = new Random();
        return random.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}



