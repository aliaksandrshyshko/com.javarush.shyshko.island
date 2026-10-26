package main.java.com.javarush.shyshko.island.model.organism;

import main.java.com.javarush.shyshko.island.factory.OrganismType;
import main.java.com.javarush.shyshko.island.model.organism.abstraction.Organism;

public class Plant extends Organism {
    public Plant() {
        super(OrganismType.PLANT, "Растение", 1);
    }


    @Override
    public String getIcon() {
        return "\uD83C\uDF3F";
    }
}
