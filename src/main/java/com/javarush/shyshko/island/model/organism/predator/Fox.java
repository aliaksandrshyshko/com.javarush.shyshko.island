package main.java.com.javarush.shyshko.island.model.organism.predator;

import main.java.com.javarush.shyshko.island.factory.OrganismType;
import main.java.com.javarush.shyshko.island.model.organism.abstraction.Predator;

public class Fox extends Predator {

    public Fox() {
        super(OrganismType.FOX, "Лиса",8, 2, 2.0);
    }

    @Override
    public String getIcon() {
        return " \uD83E\uDD8A";
    }
}
