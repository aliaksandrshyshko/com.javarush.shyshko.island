package main.java.com.javarush.shyshko.island.model;

public class Wolf extends Animal{
    public Wolf() {
        super(50.0, 30, 3, 8.0, "🐺",
                (attacker, food) -> food instanceof Rabbit r && !r.isDead());
    }
}
