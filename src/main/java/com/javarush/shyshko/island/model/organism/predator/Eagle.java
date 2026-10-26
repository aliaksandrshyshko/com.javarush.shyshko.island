package main.java.com.javarush.shyshko.island.model.organism.predator;

import main.java.com.javarush.shyshko.island.factory.OrganismType;
import main.java.com.javarush.shyshko.island.model.organism.abstraction.Predator;

public class Eagle extends Predator {

    public Eagle() {
        super(OrganismType.EAGLE,"Орел",6,  3, 1.0);
    }

    @Override
    public String getIcon() {
        return "\uD83E\uDD85";
    }
}
