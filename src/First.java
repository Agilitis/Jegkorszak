public class First extends Player {
    @Override
    void movePlayer(Direction direction) {
        Field moveHere = field.getNeighboor(direction);
        moveHere.accept(this,direction);
    }

    @Override
    void replaceField(Field where) {

        field.remove(this);
        field = where;

    }

    @Override
    protected void interactWithNeighbors(Other other) {

    }

    @Override
    protected void handleIceCubeNeighborArrival() {

    }


    @Override
    void collideWith(Thing t, Direction direction) {
        t.hitByFirst(this, direction);
    }

    @Override
    protected void hitByOther(Other other, Direction direction) {

    }

    @Override
    protected void hitByFirst(First first, Direction direction) {

    }

    @Override
    protected void hitByIceCube(IceCube iceCube, Direction direction) {

    }


}


