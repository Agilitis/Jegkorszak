public abstract class Player extends Thing {


    abstract void movePlayer(Direction direction);
    private boolean isParalyzed;
    abstract void replaceField(Field where);

    void paralyze(){
        isParalyzed = true;
        Paralyzer.getInstance().addPlayer(this, 3);
    }
    void deParalyze(){
        isParalyzed = false;
    }
}
