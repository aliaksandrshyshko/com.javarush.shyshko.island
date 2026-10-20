package main.java.com.javarush.shyshko.island.model.organism.herbivore;

import main.java.com.javarush.shyshko.island.model.organism.abstraction.Herbivore;

public class Boar extends Herbivore {

    public Boar() {
        super("Кабан",400, 5, 2, 50.0);
    }

    @Override
    public String getIcon() {
        return "\uD83D\uDC17";
    }
}
