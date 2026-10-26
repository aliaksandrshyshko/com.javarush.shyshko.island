package main.java.com.javarush.shyshko.island.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

import lombok.Getter;
import main.java.com.javarush.shyshko.island.model.organism.abstraction.Animal;
import main.java.com.javarush.shyshko.island.model.organism.abstraction.Organism;

@Getter
public class Location {

    private final int id;
    private final int x;
    private final int y;

    private final List<Organism> organisms = new CopyOnWriteArrayList<>();
    private final ReentrantLock lock = new ReentrantLock();

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
        this.id = y * 1000 + x;
    }

    public void addOrganism(Organism o) {
        organisms.add(o);
        o.setMyLocation(this);
    }

    public void removeOrganism(Organism o) {
        organisms.remove(o);
        o.setMyLocation(null);
    }

    public <T extends Organism> List<T> getOrganismsOfType(Class<T> clazz) {
        List<T> result = new CopyOnWriteArrayList<>();
        for(Organism o : organisms) {
            if(clazz.isInstance(o)) {
                result.add(clazz.cast(o));
            }
        }
        return result;
    }

    public void cleanUpDeadOrMoved() {
        lock.lock();
        try {
            organisms.removeIf(o -> (o instanceof Animal animal && animal.isDead()) || o.getMyLocation() != this);
        } finally {
            lock.unlock();
        }
    }

    public List<Animal> copyAnimal() {
        List<Animal> animals = new ArrayList<>();
        for (Organism o : organisms) {
            if (o instanceof Animal animal && !animal.isDead()) {
                animals.add(animal);
            }
        }
        return animals;
    }

    public void moveAnimal(Animal animal, Location newLocation) {
        if (newLocation == null || animal == null) return;

        ReentrantLock firstLock = this.id > newLocation.id ? this.getLock() : newLocation.getLock();
        ReentrantLock secondLock = this.id < newLocation.id ? this.getLock() : newLocation.getLock();

        firstLock.lock();
        try {
            secondLock.lock();
            try {
                long count = newLocation.getOrganisms().stream()
                        .filter(o -> o.getType() == animal.getType())
                        .count();

                if (count < animal.getMaxOnCell()) {
                    this.removeOrganism(animal);
                    newLocation.addOrganism(animal);
                }
            } finally {
                secondLock.unlock();
            }
        } finally {
            firstLock.unlock();
        }
    }
}
