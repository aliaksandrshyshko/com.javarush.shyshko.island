package main.java.com.javarush.shyshko.island.model.organism.herbivore;

import main.java.com.javarush.shyshko.island.factory.OrganismType;
import main.java.com.javarush.shyshko.island.model.organism.abstraction.Herbivore;

public class Mouse extends Herbivore {

    public Mouse() {
        super(OrganismType.MOUSE, "Мышь",0.05,  1, 0.01);
    }

    @Override
    public String getIcon() {
        return "\uD83D\uDC01";
    }
}
