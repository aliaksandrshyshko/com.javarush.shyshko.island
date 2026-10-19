package main.java.com.javarush.shyshko.island.service;

import main.java.com.javarush.shyshko.island.model.Animal;
import main.java.com.javarush.shyshko.island.model.IslandMap;
import main.java.com.javarush.shyshko.island.model.Location;
import main.java.com.javarush.shyshko.island.model.Organism;

import java.util.ArrayList;
import java.util.List;

public class IslandEngine {
    private final IslandMap islandMap;

    public IslandEngine(IslandMap islandMap) {
        this.islandMap = islandMap;
    }

    public void runStepCycle() {
        for(int y = 0; y<islandMap.getHeight(); y++) {
            for(int x =0; x<islandMap.getWidth(); x++) {
                Location loc = islandMap.getLocation(x,y);

                List<Organism> snapshots = new ArrayList<>(loc.getOrganisms());
                for(Organism o : snapshots) {
                    if(o instanceof Animal animal) {
                        if(animal.isDead()) {
                            continue;
                        }
                        animal.eat(loc);
                        animal.multiply(loc);
                        animal.move(islandMap);
                        animal.passStep();
                    }
                }
            }
        }
    }
}
