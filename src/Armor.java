public class Armor {
    private int id;
    private String name;
    private int block;
    private int price;

    public Armor(int id, String name, int block, int price) {
        this.id = id;
        this.name = name;
        this.block = block;
        this.price = price;
    }

    /*zırhların listesi */
    public static Armor[] armors(){
        Armor[] armorList = {new Armor(1,"Hafif",1,15)
                            ,new Armor(2,"Orta",3,25)
                            ,new Armor(3,"Ağır",5,40)
        };
        return armorList;
    }

    /*parametreyle gelen id armor id ye eşit mi*/
    public static Armor getArmorObjByID(int id){
        for(Armor armor : Armor.armors()){
            if(armor.getId() == id){
                return armor;
            }
        }
        return null;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
