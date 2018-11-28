public class Boulder extends Thing {

    Boulder(Field field){
        this.field = field;
        this.field.setThingOnField(this);

    }
    @Override
    void collideWith(Thing t, Direction direction) {

    }

    @Override
    protected void hitByOther(Other other, Direction direction) {

    }

    @Override
    protected void hitByFirst(First first, Direction direction) {

    }

    @Override
    protected void hitByIceCube(IceCube iceCube, Direction direction) {
        iceCube.stopMovement();
    }

    @Override
    protected void interactWithNeighbors(Other other) {

    }

    @Override
    protected void handleIceCubeNeighborArrival() {

    }


}
