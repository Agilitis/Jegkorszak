
public class Other extends Player {

    private int cubeCoutner = 0;


    @Override
    void movePlayer(Direction direction) {
        if (!isParalyzed) {
            Field moveHere = field.getNeighboor(direction);
            moveHere.accept(this, direction);
        }

    }

    @Override
    void replaceField(Field where) {
        field.remove(this);
        field = where;
        cubeCoutner = 0;
        field.getNeighboors().forEach((direction, field) -> {
            if (field.getThingOnField() != null) {
                field.getThingOnField().interactWithNeighbors(this);
            }
        });
    }

    @Override
    public void increaseUnitCounter() {
        Game game = Game.getInstance();
        game.setOtherCounter(game.getOtherCounter() + 1);
    }

    @Override
    public void decreaseUnitCounter() {
        Game game = Game.getInstance();
        game.setOtherCounter(game.getFirstCounter() - 1);
        if(game.getOtherCounter()==0) {
            game.endGame();
        }
    }

    @Override
    protected void interactWithNeighbors(Other other) {

    }

    @Override
    protected void handleIceCubeNeighborArrival() {
        iceCubeCallback();
    }

    Other(Field placeHere) {
        this.field = placeHere;
        this.field.setThingOnField(this);
        increaseUnitCounter();
    }

    void iceCubeCallback() {
        cubeCoutner++;
        if (cubeCoutner >= 4) {
            this.freeze();
        }
    }

    private void freeze() {
        decreaseUnitCounter();
        field.remove(this);
        System.out.println("I froze!");
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
        iceCube.stopMovement();
    }


}
