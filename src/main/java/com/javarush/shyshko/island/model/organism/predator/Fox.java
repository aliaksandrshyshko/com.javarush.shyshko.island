package main.java.com.javarush.shyshko.island.model.organism.predator;

import main.java.com.javarush.shyshko.island.model.organism.abstraction.Predator;

public class Fox extends Predator {

    public Fox() {
        super("Лиса",8, 5, 2, 2.0);
    }

    @Override
    public String getIcon() {
        return " \uD83E\uDD8A";
    }
}
