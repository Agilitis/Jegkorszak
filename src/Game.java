public class Game {
    public int getFirstCounter() {
        return firstCounter;
    }

    public void setFirstCounter(int firstCounter) {
        this.firstCounter = firstCounter;
    }

    public int getOtherCounter() {
        return otherCounter;
    }

    public void setOtherCounter(int otherCounter) {
        this.otherCounter = otherCounter;
    }

    private static int firstCounter = 0;
    private static int otherCounter = 0;
    private static Game instance = null;

    private Game(){

    }

    static Game getInstance(){
        if(instance == null){
            instance = new Game();
        }
        return instance;
    }

    public static void main(String[] args) {
        startGame();

    }

    static void startGame() {
        Field f1 = new Field();
        Field f2 = new Field();
        Field f3 = new Field();
        Field f4 = new Field();
        Field f5 = new Field();
        Field f6 = new Field();
        Field f7 = new Field();
        Field f8 = new Field();
        Field f9 = new Field();
        Field f10 = new Field();
        Field f11 = new Field();
        Field f12 = new Field();
        Field f13 = new Field();
        Field f14 = new Field();
        Field f15 = new Field();
        Field f16 = new Field();

        Paralyzer.getInstance().start();
        f1.addNeighboor(Direction.RIGHT, f2);
        f1.addNeighboor(Direction.DOWN, f5);


        f2.addNeighboor(Direction.RIGHT, f3);
        f2.addNeighboor(Direction.DOWN, f6);
        f2.addNeighboor(Direction.LEFT, f1);


        f3.addNeighboor(Direction.RIGHT, f4);
        f3.addNeighboor(Direction.LEFT, f2);
        f3.addNeighboor(Direction.DOWN, f7);

        f4.addNeighboor(Direction.LEFT, f3);
        f4.addNeighboor(Direction.DOWN, f8);

        f5.addNeighboor(Direction.UP, f1);
        f5.addNeighboor(Direction.RIGHT, f6);
        f5.addNeighboor(Direction.DOWN, f9);

        f6.addNeighboor(Direction.LEFT, f5);
        f6.addNeighboor(Direction.RIGHT, f7);
        f6.addNeighboor(Direction.UP, f2);
        f6.addNeighboor(Direction.DOWN, f10);

        f7.addNeighboor(Direction.LEFT, f6);
        f7.addNeighboor(Direction.RIGHT, f8);
        f7.addNeighboor(Direction.UP, f3);
        f7.addNeighboor(Direction.DOWN, f11);

        f8.addNeighboor(Direction.LEFT, f7);
        f8.addNeighboor(Direction.UP, f4);
        f8.addNeighboor(Direction.DOWN, f12);

        f9.addNeighboor(Direction.RIGHT, f10);
        f9.addNeighboor(Direction.UP, f5);
        f9.addNeighboor(Direction.DOWN, f13);

        f10.addNeighboor(Direction.LEFT, f9);
        f10.addNeighboor(Direction.RIGHT, f11);
        f10.addNeighboor(Direction.UP, f6);
        f10.addNeighboor(Direction.DOWN, f14);

        f11.addNeighboor(Direction.LEFT, f10);
        f11.addNeighboor(Direction.RIGHT, f12);
        f11.addNeighboor(Direction.UP, f7);
        f11.addNeighboor(Direction.DOWN, f15);

        f12.addNeighboor(Direction.LEFT, f11);
        f12.addNeighboor(Direction.UP, f8);
        f12.addNeighboor(Direction.DOWN, f16);

        f13.addNeighboor(Direction.RIGHT, f14);
        f13.addNeighboor(Direction.UP, f9);

        f14.addNeighboor(Direction.LEFT, f13);
        f14.addNeighboor(Direction.RIGHT, f15);
        f14.addNeighboor(Direction.UP, f10);
        f14.addNeighboor(Direction.DOWN, f15);

        f15.addNeighboor(Direction.LEFT, f14);
        f15.addNeighboor(Direction.RIGHT, f16);
        f15.addNeighboor(Direction.UP, f11);

        f16.addNeighboor(Direction.LEFT, f15);
        f16.addNeighboor(Direction.UP, f12);
        First first = new First(f1);
        Other other = new Other(f2);
        System.out.println(otherCounter);
        System.out.println(firstCounter);
        IceCube i1 = new IceCube(f5);
        IceCube i2 = new IceCube(f7);
        IceCube i3 = new IceCube(f10);
        IceCube i4 = new IceCube(f3);
//        Boulder b1 = new Boulder(f3);
        other.movePlayer(Direction.LEFT);
        i4.move(Direction.LEFT);
    }

    void endGame() {
        System.out.println(otherCounter>firstCounter?"The game has ended others won":"The game has ended, firsts won!");
    }
}
