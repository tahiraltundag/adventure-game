public class SafeHouse extends NormalLocation{

    public SafeHouse(Player player) {
        super("Güvenli Ev", player);
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli evdesiniz ");
        System.out.println("Canınız yenilendi ");
        this.getPlayer().setHealth(this.getPlayer().getOrjinalHealth());
        return true;
    }
}
