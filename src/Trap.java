public class Trap extends Thing {
    private Player trappedPlayer = null;
    Trap(Field placeHere){
        this.field = placeHere;
        this.field.setThingOnField(this);
    }

    @Override
    void collideWith(Thing t, Direction direction) {

    }

    @Override
    protected void hitByOther(Other other, Direction direction) {
        System.out.println("Paralyzed: " + other);
        other.paralyze();
    }

    @Override
    protected void hitByFirst(First first, Direction direction) {
        System.out.println("Paralyzed: " + first);
        first.paralyze();
    }

    @Override
    protected void hitByIceCube(IceCube iceCube, Direction direction) {

    }

    @Override
    protected void interactWithNeighbors(Other other) {

    }

    @Override
    protected void handleIceCubeNeighborArrival() {

    }


}
