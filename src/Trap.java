public class Trap extends Thing {
    private Player trappedPlayer = null;


    @Override
    void collideWith(Thing t, Direction direction) {

    }

    @Override
    protected void hitByOther(Other other, Direction direction) {
        other.paralyze();
    }

    @Override
    protected void hitByFirst(First first, Direction direction) {
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
