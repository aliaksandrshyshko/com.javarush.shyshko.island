package main.java.com.javarush.shyshko.island.model;

public class Rabbit extends Animal{
    public Rabbit() {
        super(2.0, 150, 2, 0.45, "🐇",
                (attacker, food) -> food instanceof Plant);
    }
}
