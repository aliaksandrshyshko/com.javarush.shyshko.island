package main.java.com.javarush.shyshko.island.factory;

import main.java.com.javarush.shyshko.island.model.Organism;
import main.java.com.javarush.shyshko.island.model.Plant;
import main.java.com.javarush.shyshko.island.model.Rabbit;
import main.java.com.javarush.shyshko.island.model.Wolf;

public class OrganismFactory {
    public static Organism createOrganism(String type) {
        return switch(type.toLowerCase()) {
            case "wolf" -> new Wolf();
            case "rabbit" -> new Rabbit();
            case "plant" -> new Plant();
            default -> throw new IllegalArgumentException("Неизвестный организм: " + type);
        };
    }
}
