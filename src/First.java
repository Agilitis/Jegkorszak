public class First extends Player {
    @Override
    void movePlayer(Direction direction) {
        if(!isParalyzed){
            Field moveHere = field.getNeighboor(direction);
            moveHere.accept(this, direction);
        }
    }

    @Override
    void replaceField(Field where) {

        field.remove(this);
        field = where;

    }

    First(Field placeHere){
        this.field = placeHere;
        this.field.setThingOnField(this);
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
        field.setThingOnField(new IceCube(field));
    }

    @Override
    protected void hitByFirst(First first, Direction direction) {

    }

    @Override
    protected void hitByIceCube(IceCube iceCube, Direction direction) {

    }


}


