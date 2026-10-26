package main.java.com.javarush.shyshko.island.factory;

import main.java.com.javarush.shyshko.island.model.organism.abstraction.Organism;
import main.java.com.javarush.shyshko.island.model.organism.Plant;
import main.java.com.javarush.shyshko.island.model.organism.herbivore.*;
import main.java.com.javarush.shyshko.island.model.organism.predator.*;

import java.util.EnumMap;
import java.util.Map;

public class OrganismFactory {

    private static final Map<OrganismType, Integer> maxOnCellCache = new EnumMap<>(OrganismType.class);

    static {
        for (OrganismType type : OrganismType.values()) {
            try {
                Organism sample = createOrganism(type);
                maxOnCellCache.put(type, sample.getMaxOnCell());
            } catch (Exception e) {
                maxOnCellCache.put(type, 0);
            }
        }
    }


    public static int getMaxOnCell(OrganismType type) {
        return maxOnCellCache.getOrDefault(type, 0);
    }

    public static OrganismType[] getAvailableTypes() {
        return OrganismType.values();
    }

    public static Organism createOrganism(OrganismType type) {
        return switch (type) {
            case WOLF -> new Wolf();
            case RABBIT -> new Rabbit();
            case PLANT -> new Plant();
            case BEAR -> new Bear();
            case FOX -> new Fox();
            case EAGLE -> new Eagle();
            case BOA -> new Boa();
            case BOAR -> new Boar();
            case BUFFALO -> new Buffalo();
            case CATERPILLAR -> new Caterpillar();
            case DEER -> new Deer();
            case DUCK -> new Duck();
            case GOAT -> new Goat();
            case HORSE -> new Horse();
            case MOUSE -> new Mouse();
            case SHEEP -> new Sheep();
        };
    }
}
