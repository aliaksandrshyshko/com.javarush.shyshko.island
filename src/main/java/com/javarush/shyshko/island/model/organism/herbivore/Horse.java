package main.java.com.javarush.shyshko.island.model.organism.herbivore;

import main.java.com.javarush.shyshko.island.model.organism.abstraction.Herbivore;

public class Horse extends Herbivore {

    public Horse() {
        super("Лошадь",400, 5, 4, 60);
    }

    @Override
    public String getIcon() {
        return "\uD83D\uDC0E";
    }
}
