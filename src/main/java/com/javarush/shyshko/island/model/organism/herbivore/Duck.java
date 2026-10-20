package main.java.com.javarush.shyshko.island.model.organism.herbivore;

import main.java.com.javarush.shyshko.island.model.organism.abstraction.Herbivore;

public class Duck extends Herbivore {

    public Duck() {
        super("Утка",1, 5, 4, 0.15);
    }

    @Override
    public String getIcon() {
        return "\uD83E\uDD86";
    }
}
