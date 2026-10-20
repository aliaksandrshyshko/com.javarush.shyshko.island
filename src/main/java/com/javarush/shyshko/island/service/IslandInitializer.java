package main.java.com.javarush.shyshko.island.service;

import main.java.com.javarush.shyshko.island.factory.OrganismFactory;
import main.java.com.javarush.shyshko.island.model.*;

import java.util.Random;

public class IslandInitializer {
    private static final String[] ORGANISM_TYPES = {
            "wolf", "rabbit", "plant"
    };

    public static void populateIsland(IslandMap islandMap) {
        Random rand = new Random();

        for (int y = 0; y < islandMap.getHeight(); y++) {
            for (int x = 0; x < islandMap.getWidth(); x++) {
                Location loc = islandMap.getLocation(x, y);

                for (String type : ORGANISM_TYPES) {

                    Organism firstOrganism = OrganismFactory.createOrganism(type, true);

                    int maxOnCell = 0;
                    if (firstOrganism instanceof Animal animal) {
                        maxOnCell = animal.getMaxOnCell();
                    } else if (firstOrganism instanceof Plant plant) {
                        maxOnCell = plant.getMaxOnCell();
                    }

                    if (maxOnCell <= 0) continue;

                    int countToSpawn = rand.nextInt(maxOnCell + 1);

                    if (countToSpawn > 0) {
                        if (firstOrganism instanceof Animal animal) {
                            animal.setMyLocation(loc);
                            animal.setDead(false);
                        }

                        loc.addOrganism(firstOrganism);

                        for (int i = 1; i < countToSpawn; i++) {
                            Organism organism = OrganismFactory.createOrganism(type, true);
                            if (organism instanceof Animal animal) {
                                animal.setMyLocation(loc);
                            }
                            loc.addOrganism(organism);
                        }
                    }
                }
            }
        }
        System.out.println("Остров успешно заселён.");
    }
}
