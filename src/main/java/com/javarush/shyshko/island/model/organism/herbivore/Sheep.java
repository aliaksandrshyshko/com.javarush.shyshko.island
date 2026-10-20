package main.java.com.javarush.shyshko.island.model.organism.herbivore;

import main.java.com.javarush.shyshko.island.model.organism.abstraction.Herbivore;

public class Sheep extends Herbivore {

    public Sheep() {
        super("Овца",70, 2, 3, 15);
    }

    @Override
    public String getIcon() {
        return "\uD83D\uDC11";
    }
}
