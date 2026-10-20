package main.java.com.javarush.shyshko.island.model.organism.herbivore;

import main.java.com.javarush.shyshko.island.model.organism.abstraction.Herbivore;

public class Deer extends Herbivore {

    public Deer() {
        super("Олень",300, 5, 4, 50);
    }

    @Override
    public String getIcon() {
        return "\uD83E\uDD8C";
    }
}
