package main.java.com.javarush.shyshko.island.service;

import main.java.com.javarush.shyshko.island.model.Island;
import main.java.com.javarush.shyshko.island.model.Location;
import main.java.com.javarush.shyshko.island.model.organism.abstraction.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class IslandEngine {
    private final Island island;
    private int dayCount = 0;

    private final ScheduledExecutorService schedule = Executors.newScheduledThreadPool(1);
    private final ExecutorService executorService = Executors.newFixedThreadPool(8);

    public IslandEngine(Island island) {
        this.island = island;
    }

    public void startSimulation() {
        IslandVisualizer.printMap(island, dayCount);
        schedule.scheduleWithFixedDelay(this::runParallelTact, 0, 2, TimeUnit.SECONDS);
    }

    public void runParallelTact() {

        List<Animal> animals = new ArrayList<>();
        for (Location[] row : island.getLocations()) {
            for (Location location : row) {
                if (location != null) {
                    animals.addAll(location.copyAnimal());
                }
            }
        }

        List<AnimalTask> taskList = new ArrayList<>();
        for (Animal animal : animals) {
            taskList.add(new AnimalTask(island, animal));
        }

        try {
            executorService.invokeAll(taskList, 2, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        boolean standardAnimalAlive = false;
        for (Location[] row : island.getLocations()) {
            for (Location loc : row) {
                if (loc != null) {
                    loc.cleanUpDeadOrMoved();

                    if (!loc.copyAnimal().isEmpty()) {
                        standardAnimalAlive = true;
                    }
                }
            }
        }
        dayCount++;
        IslandVisualizer.printMap(island, dayCount);

        if (!standardAnimalAlive) {
            System.out.println("На острове не осталось живой фауны!");
            schedule.shutdown();
            executorService.shutdown();
        } else if (dayCount >= 50) {
            System.out.println("Симуляция остановлена автоматически: достигнут лимит в 50 дней.");
            schedule.shutdown();
            executorService.shutdown();
        }

    }

}
