package main.java.com.javarush.shyshko.island.model.organism.predator;

import main.java.com.javarush.shyshko.island.model.organism.abstraction.Predator;

public class Eagle extends Predator {

    public Eagle() {
        super("Орел",6, 5, 3, 1.0);
    }

    @Override
    public String getIcon() {
        return "\uD83E\uDD85";
    }
}
