package main.java.com.javarush.shyshko.island.factory;

import main.java.com.javarush.shyshko.island.model.organism.abstraction.Organism;
import main.java.com.javarush.shyshko.island.model.organism.Plant;
import main.java.com.javarush.shyshko.island.model.organism.herbivore.Rabbit;
import main.java.com.javarush.shyshko.island.model.organism.predator.Wolf;

public class OrganismFactory {
    public static Organism createOrganism(String type,  boolean isGameCycle) {
        Organism organism = switch(type.toLowerCase()) {
            case "wolf" -> new Wolf();
            case "rabbit" -> new Rabbit();
            case "plant" -> new Plant();
            default -> throw new IllegalArgumentException("Неизвестный организм: " + type);
        };
        if (!isGameCycle) {
            System.out.println("Фабрика создала: " + organism.getIcon() + " [ID: " + organism.getId() + "]");
        }
        return organism;
    }
}
