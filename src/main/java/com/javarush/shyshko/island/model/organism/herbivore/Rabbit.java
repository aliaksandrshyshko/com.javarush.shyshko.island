package main.java.com.javarush.shyshko.island.model.organism.herbivore;

import main.java.com.javarush.shyshko.island.model.organism.abstraction.Herbivore;

public class Rabbit extends Herbivore {
    public Rabbit() {
        super("Кролик",2.0, 2, 2, 0.45);
    }

    @Override
    public String getIcon() {
        return "\uD83D\uDC07";
    }
}
