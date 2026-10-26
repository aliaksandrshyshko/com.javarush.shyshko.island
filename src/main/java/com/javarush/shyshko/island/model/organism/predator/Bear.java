package main.java.com.javarush.shyshko.island.model.organism.predator;

import main.java.com.javarush.shyshko.island.factory.OrganismType;
import main.java.com.javarush.shyshko.island.model.organism.abstraction.Predator;

public class Bear extends Predator {

    public Bear() {
        super(OrganismType.BEAR, "Медведь",500, 2, 80.0);
    }

    @Override
    public String getIcon() {
        return "\uD83D\uDC3B";
    }
}
