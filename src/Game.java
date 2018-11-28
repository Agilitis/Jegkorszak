public class Game {

    public static void main(String[] args) {
        Field f1 = new Field();
        Field f2 = new Field();
        Field f3 = new Field();
        Field f4 = new Field();
        f1.addNeighboor(Direction.RIGHT, f2);
        f2.addNeighboor(Direction.RIGHT, f3);
        f3.addNeighboor(Direction.RIGHT, f4);
        IceCube i1 = new IceCube(f1);
        IceCube i2 = new IceCube(f2);
//        Boulder b1 = new Boulder(f3);
        i1.move(Direction.RIGHT);
    }

    void startGame() {

    }

    void endGame() {

    }

}
