public abstract class Thing {
    protected Field field = null;
    abstract void collideWith(Thing t, Direction direction);

    protected abstract void hitByOther(Other other, Direction direction);
    protected abstract void hitByFirst(First first, Direction direction);
    protected abstract void hitByIceCube(IceCube iceCube, Direction direction);
    void replaceField(Field where){
        field.remove(this);
        field = where;
    }
    protected abstract void interactWithNeighbors(Other other);
    protected abstract void handleIceCubeNeighborArrival();


}
