package main.java.com.javarush.shyshko.island.factory;

public enum OrganismType {
    WOLF(30),
    RABBIT(15),
    PLANT(200),
    BEAR(50),
    FOX(30),
    EAGLE(20),
    BOA(30),
    BOAR(50),
    BUFFALO(10),
    CATERPILLAR(1000),
    DEER(20),
    DUCK(20),
    GOAT(14),
    HORSE(20),
    MOUSE(15),
    SHEEP(14);

    private final int maxOnCell;

    OrganismType(int maxOnCell) {
        this.maxOnCell = maxOnCell;
    }

    public int getMaxOnCell() {
        return this.maxOnCell;
    }
}