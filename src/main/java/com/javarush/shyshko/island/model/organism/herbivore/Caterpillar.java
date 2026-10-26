package main.java.com.javarush.shyshko.island.model.organism.herbivore;

import main.java.com.javarush.shyshko.island.factory.OrganismType;
import main.java.com.javarush.shyshko.island.model.organism.abstraction.Herbivore;

public class Caterpillar extends Herbivore {

    public Caterpillar() {
        super(OrganismType.CATERPILLAR,"Гусеница",0.01,  0, 0);
    }

    @Override
    public String getIcon() {
        return "\uD83D\uDC1B";
    }
}
