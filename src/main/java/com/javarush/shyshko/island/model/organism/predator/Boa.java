package main.java.com.javarush.shyshko.island.model.organism.predator;

import main.java.com.javarush.shyshko.island.model.organism.abstraction.Predator;

public class Boa extends Predator {

    public Boa() {
        super("Удав",15, 5, 1, 3.0);
    }

    @Override
    public String getIcon() {
        return "\uD83D\uDC0D";
    }
}
