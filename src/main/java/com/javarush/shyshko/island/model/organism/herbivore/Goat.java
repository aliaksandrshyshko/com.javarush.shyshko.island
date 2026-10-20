package main.java.com.javarush.shyshko.island.model.organism.herbivore;

import main.java.com.javarush.shyshko.island.model.organism.abstraction.Herbivore;

public class Goat extends Herbivore {

    public Goat() {
        super("Коза",60, 5, 3, 10);
    }

    @Override
    public String getIcon() {
        return "\uD83D\uDC10";
    }
}
