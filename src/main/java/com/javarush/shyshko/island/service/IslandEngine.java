package main.java.com.javarush.shyshko.island.service;

import main.java.com.javarush.shyshko.island.model.Animal;
import main.java.com.javarush.shyshko.island.model.IslandMap;
import main.java.com.javarush.shyshko.island.model.Location;
import main.java.com.javarush.shyshko.island.model.Organism;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class IslandEngine {
    private final IslandMap islandMap;

    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);

    public IslandEngine(IslandMap islandMap) {
        this.islandMap = islandMap;
    }

    public void startSimulation() {
        executor.scheduleAtFixedRate(this::runParallelStep,0,1, TimeUnit.SECONDS);
    }

    public void runParallelStep() {
        for(int y = 0; y<islandMap.getHeight(); y++) {
            final int currentRow = y;

            executor.submit(() -> {
                for (int x = 0; x < islandMap.getWidth(); x++) {
                    Location loc = islandMap.getLocation(x, currentRow);

                    for (Organism o : new ArrayList<>(loc.getOrganisms())) {
                        if (o instanceof Animal animal) {
                            if (animal.isDead()) {
                                continue;
                            }
                            animal.eat(loc);
                            animal.multiply(loc);
                            animal.move(islandMap);
                            animal.passStep();
                        }
                    }

                }
            });

        }
    }
}
