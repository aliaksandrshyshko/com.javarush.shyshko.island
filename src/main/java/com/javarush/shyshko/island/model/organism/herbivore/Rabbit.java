package main.java.com.javarush.shyshko.island.model.organism.herbivore;

import main.java.com.javarush.shyshko.island.model.organism.Plant;
import main.java.com.javarush.shyshko.island.model.organism.abstraction.Herbivore;

public class Rabbit extends Herbivore {
    public Rabbit() {
        super(2.0, 2, 2, 0.45, "🐇",
                (attacker, food) -> food instanceof Plant);
    }
}
