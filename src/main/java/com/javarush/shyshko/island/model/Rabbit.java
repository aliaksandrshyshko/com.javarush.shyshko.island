package main.java.com.javarush.shyshko.island.model;

public class Rabbit extends Animal{
    public Rabbit() {
        super(2.0, 150, 2, 0.45, "🐇");
    }

    @Override
    protected Animal spawnChild() {
        return new Rabbit();
    }
}
