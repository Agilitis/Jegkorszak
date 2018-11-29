public abstract class Player extends Thing {


    abstract void movePlayer(Direction direction);
    protected boolean isParalyzed;
    abstract void replaceField(Field where);

    void paralyze(){
        System.out.println("I am paralized -> "+this);
        isParalyzed = true;
        Paralyzer.getInstance().addPlayer(this, 3);
    }
    void deParalyze(){
        System.out.println("I am free again! -> "+this);
        Paralyzer.getInstance().removePlayer(this);
        isParalyzed = false;
    }

    public abstract void increaseUnitCounter();
    public abstract void decreaseUnitCounter();
}
