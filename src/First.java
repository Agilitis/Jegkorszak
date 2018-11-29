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

    @Override
    public void increaseUnitCounter() {
        Game game = Game.getInstance();
        game.setFirstCounter(game.getFirstCounter() + 1);

    }

    First(Field placeHere){
        this.field = placeHere;
        this.field.setThingOnField(this);
        increaseUnitCounter();
    }
    @Override
    protected void interactWithNeighbors(Other other) {

    }

    @Override
    protected void handleIceCubeNeighborArrival() {

    }

    @Override
    public void decreaseUnitCounter() {
        Game game = Game.getInstance();
        game.setFirstCounter(game.getFirstCounter() - 1);
        if(game.getFirstCounter()==0){
            game.endGame();
        }
    }


    @Override
    void collideWith(Thing t, Direction direction) {
        t.hitByFirst(this, direction);
    }


    @Override
    protected void hitByOther(Other other, Direction direction) {
        freeze();
    }

    private void freeze() {
        decreaseUnitCounter();
        field.remove(this);
        System.out.println("I froze!");
        field.setThingOnField(new IceCube(field));
    }

    @Override
    protected void hitByFirst(First first, Direction direction) {

    }

    @Override
    protected void hitByIceCube(IceCube iceCube, Direction direction) {

    }


}


