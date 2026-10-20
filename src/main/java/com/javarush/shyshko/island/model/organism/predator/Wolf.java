package main.java.com.javarush.shyshko.island.model.organism.predator;

import main.java.com.javarush.shyshko.island.model.organism.abstraction.Herbivore;
import main.java.com.javarush.shyshko.island.model.organism.abstraction.Predator;

public class Wolf extends Predator {
    public Wolf() {
        super(50.0, 3, 3, 8.0, "🐺",
                (attacker, food) -> food instanceof Herbivore );
    }
}
