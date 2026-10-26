package main.java.com.javarush.shyshko.island.service;

import main.java.com.javarush.shyshko.island.model.Island;
import main.java.com.javarush.shyshko.island.model.Location;
import main.java.com.javarush.shyshko.island.model.organism.abstraction.Animal;

import java.util.concurrent.Callable;

public class AnimalTask implements Callable<Void> {
    private final Island island;
    private final Animal animal;
    private final Location initialLocation;

    public AnimalTask(Island island, Animal animal) {
        this.island = island;
        this.animal = animal;
        this.initialLocation = animal.getMyLocation();
    }

    @Override
    public Void call() throws Exception {
        if (animal.isDead() || animal.getMyLocation() != initialLocation || initialLocation == null) {
            return null;
        }

        initialLocation.getLock().lockInterruptibly();
        try {
            if (animal.isDead()) {
                return null;
            }

            animal.eat(initialLocation);
            animal.multiply(initialLocation);
            animal.passTact();

        } finally {
            initialLocation.getLock().unlock();
        }

        if (!animal.isDead()) {
            animal.move(island);
        }

        return null;
    }
}