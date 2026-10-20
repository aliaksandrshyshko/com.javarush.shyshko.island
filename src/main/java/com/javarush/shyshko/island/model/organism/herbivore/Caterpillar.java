package main.java.com.javarush.shyshko.island.model.organism.herbivore;

import main.java.com.javarush.shyshko.island.model.organism.abstraction.Herbivore;

public class Caterpillar extends Herbivore {

    public Caterpillar() {
        super("Гусеница",0.01, 5, 0, 0);
    }

    @Override
    public String getIcon() {
        return "\uD83D\uDC1B";
    }
}
