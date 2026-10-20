package main.java.com.javarush.shyshko.island.factory;

import main.java.com.javarush.shyshko.island.model.organism.abstraction.Organism;
import main.java.com.javarush.shyshko.island.model.organism.Plant;
import main.java.com.javarush.shyshko.island.model.organism.herbivore.*;
import main.java.com.javarush.shyshko.island.model.organism.predator.*;

public class OrganismFactory {
    public static Organism createOrganism(String type,  boolean isGameCycle) {
        Organism organism = switch(type.toLowerCase()) {
            case "wolf" -> new Wolf();
            case "rabbit" -> new Rabbit();
            case "plant" -> new Plant();
            case "bear" -> new Bear();
            case "fox" -> new Fox();
            case "eagle" -> new Eagle();
            case "boa" -> new Boa();
            case "boar" -> new Boar();
            case "buffalo" -> new Buffalo();
            case "caterpillar" -> new Caterpillar();
            case "deer" -> new Deer();
            case "duck" -> new Duck();
            case "goat" -> new Goat();
            case "horse" -> new Horse();
            case "mouse" -> new Mouse();
            case "sheep" -> new Sheep();
            default -> throw new IllegalArgumentException("Неизвестный организм: " + type);
        };
        if (!isGameCycle) {
            System.out.println("Фабрика создала: " + organism.getIcon() + organism.getName() + " [ID: " + organism.getId() + "]");
        }
        return organism;
    }
}
