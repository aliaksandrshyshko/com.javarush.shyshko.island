package main.java.com.javarush.shyshko.island.model.organism.herbivore;

import main.java.com.javarush.shyshko.island.factory.OrganismType;
import main.java.com.javarush.shyshko.island.model.organism.abstraction.Herbivore;

public class Buffalo extends Herbivore {

    public Buffalo() {
        super(OrganismType.BUFFALO, "Буйвол",700,  3, 100.0);
    }

    @Override
    public String getIcon() {
        return "\uD83D\uDC03";
    }
}
