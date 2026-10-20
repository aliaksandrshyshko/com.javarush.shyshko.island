package main.java.com.javarush.shyshko.island.service;

import main.java.com.javarush.shyshko.island.model.Animal;
import main.java.com.javarush.shyshko.island.model.IslandMap;
import main.java.com.javarush.shyshko.island.model.Location;
import main.java.com.javarush.shyshko.island.model.Organism;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class IslandEngine {
    private final IslandMap islandMap;

    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);
    private int dayCount = 0;

    public IslandEngine(IslandMap islandMap) {
        this.islandMap = islandMap;
    }

    public void startSimulation() {
        executor.scheduleAtFixedRate(this::runParallelTact,0,2, TimeUnit.SECONDS);
    }

    public void runParallelTact() {
        List<Future<?>> futures = new ArrayList<>();

        for(int y = 0; y<islandMap.getHeight(); y++) {
            final int currentRow = y;

            futures.add(executor.submit(() -> {
                for (int x = 0; x < islandMap.getWidth(); x++) {
                    Location loc = islandMap.getLocation(x, currentRow);

                    for (Organism o : new ArrayList<>(loc.getOrganisms())) {
                        if (o instanceof Animal animal) {

                            long currentVersion = animal.getVersionSnapshot();
                            if (animal.tryLockUpdate(currentVersion)) {
                                animal.eat(loc);
                                animal.multiply(loc);
                                animal.move(islandMap);
                                animal.passTact();
                            }
                        }
                    }

                }
            }));

        }

        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (Exception e) {
                System.err.println("Критическая ошибка выполнения потока строки: " + e.getMessage());
            }
        }

        dayCount++;

        boolean standardAnimalAlive = false;
        for (int y = 0; y < islandMap.getHeight(); y++) {
            for (int x = 0; x < islandMap.getWidth(); x++) {
                Location loc = islandMap.getLocation(x, y);
                for (Organism o : loc.getOrganisms()) {
                    if (o instanceof Animal animal && !animal.isDead()) {
                        standardAnimalAlive = true;
                        break;
                    }
                }
                if (standardAnimalAlive) break;
            }
            if (standardAnimalAlive) break;
        }


        IslandVisualizer.drawGrid(islandMap, dayCount);


        if (!standardAnimalAlive) {
            System.out.println("На острове не осталось живой фауны!");
            executor.shutdown();
        }
    }
}
