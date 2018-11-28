
public class Other extends Player {

    private int cubeCoutner = 0;




    @Override
    void movePlayer(Direction direction) {
        Field moveHere = field.getNeighboor(direction);
        moveHere.accept(this, direction);
    }

    @Override
    void replaceField(Field where) {
        field.remove(this);
        field = where;
        cubeCoutner=0;
        field.getNeighboors().forEach((direction,field)->{
            if(field.getThingOnField() != null){
                field.getThingOnField().interactWithNeighbors(this);
            }
        });
    }

    @Override
    protected void interactWithNeighbors(Other other) {

    }

    @Override
    protected void handleIceCubeNeighborArrival() {
        iceCubeCallback();
    }

    void iceCubeCallback(){
        cubeCoutner++;
        if(cubeCoutner >= 4){
            this.freeze();
        }
    }

    private void freeze() {
        field.remove(this);
        field.setThingOnField(new IceCube(field));
    }


    @Override
    void collideWith(Thing t, Direction direction) {
        t.hitByOther(this, direction);
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
