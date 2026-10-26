package main.java.com.javarush.shyshko.island.service;

import main.java.com.javarush.shyshko.island.factory.OrganismFactory;
import main.java.com.javarush.shyshko.island.factory.OrganismType;
import main.java.com.javarush.shyshko.island.model.*;
import main.java.com.javarush.shyshko.island.model.organism.abstraction.Animal;
import main.java.com.javarush.shyshko.island.model.organism.abstraction.Organism;

import java.util.Random;

public class IslandInitializer {

    private static final Random RAND = new Random();

    public static void populateIsland(Island island) {
        for (int y = 0; y < island.getHeight(); y++) {
            for (int x = 0; x < island.getWidth(); x++) {
                populateLocation(island.getLocation(x, y));
            }
        }
        System.out.println("Остров успешно заселён.");
    }

    private static void populateLocation(Location loc) {
        if (loc == null) return;

        for (OrganismType type : OrganismFactory.getAvailableTypes()) {

            int maxOnCell = OrganismFactory.getMaxOnCell(type);
            if (maxOnCell <= 0) continue;

            int countToSpawn = RAND.nextInt(maxOnCell + 1);

            for (int i = 0; i < countToSpawn; i++) {
                Organism organism = OrganismFactory.createOrganism(type);
                if (organism instanceof Animal animal) {
                    animal.setMyLocation(loc);
                    animal.setDead(false);
                }
                loc.addOrganism(organism);
            }
        }
    }
}
