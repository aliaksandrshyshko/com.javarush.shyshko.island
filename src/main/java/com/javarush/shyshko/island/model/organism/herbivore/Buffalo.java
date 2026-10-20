package main.java.com.javarush.shyshko.island.model.organism.herbivore;

import main.java.com.javarush.shyshko.island.model.organism.abstraction.Herbivore;

public class Buffalo extends Herbivore {

    public Buffalo() {
        super("Буйвол",700, 5, 3, 100.0);
    }

    @Override
    public String getIcon() {
        return "\uD83D\uDC03";
    }
}
