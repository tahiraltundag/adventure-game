public abstract class NormalLocation extends Location{

    public NormalLocation(String name, Player player) {
        super(name, player);
    }

    @Override
    public boolean onLocation() {
        return true;
    }
}
