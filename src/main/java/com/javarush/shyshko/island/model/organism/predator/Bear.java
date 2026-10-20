package main.java.com.javarush.shyshko.island.model.organism.predator;

import main.java.com.javarush.shyshko.island.model.organism.abstraction.Predator;

public class Bear extends Predator {

    public Bear() {
        super("Медведь",500, 5, 2, 80.0);
    }

    @Override
    public String getIcon() {
        return "\uD83D\uDC3B";
    }
}
