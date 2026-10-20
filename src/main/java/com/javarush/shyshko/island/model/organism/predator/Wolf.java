package main.java.com.javarush.shyshko.island.model.organism.predator;

import main.java.com.javarush.shyshko.island.config.SimulationConfig;
import main.java.com.javarush.shyshko.island.model.organism.abstraction.Predator;

public class Wolf extends Predator {
    public Wolf() {
        super("Волк",5, 5, 3, 8.0);
    }

    @Override
    public String getIcon() {
        return "\uD83D\uDC3A";
    }
}
