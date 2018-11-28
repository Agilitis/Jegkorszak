public class IceCube extends Thing {



    private IceCube pullThis = null;

    IceCube(Field placeHere){
        this.field = placeHere;
        this.field.setThingOnField(this);
    }


    void move(Direction direction){
        Field moveHere = field.getNeighboor(direction);
        moveHere.accept(this,direction);
    }

    @Override
    void collideWith(Thing t, Direction direction) {
        t.hitByIceCube(this, direction);
    }

    @Override
    protected void hitByOther(Other other, Direction direction) {

    }

    @Override
    protected void hitByFirst(First first, Direction direction) {
        move(direction);
    }

    @Override
    protected void hitByIceCube(IceCube iceCube, Direction direction) {
        pullThis=iceCube;
        move(direction);
    }

    @Override
    void replaceField(Field where){
        field.remove(this);
        System.out.println("Moving " + this + " to " + where);
        if(pullThis != null){
            pullThis.replaceField(this.field);
            System.out.println("Pulling: " + pullThis);
        }
        field = where;
        field.announceIceCube();
    }

    @Override
    protected void interactWithNeighbors(Other other) {
        other.iceCubeCallback();
    }

    @Override
    protected void handleIceCubeNeighborArrival() {

    }


    void stopMovement(){
        if(pullThis != null){
            pullThis.stopMovement();
            pullThis = null;
        }
    }

}
