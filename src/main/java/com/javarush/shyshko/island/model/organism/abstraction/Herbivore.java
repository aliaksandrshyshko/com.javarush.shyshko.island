package main.java.com.javarush.shyshko.island.model.organism.abstraction;

import java.util.function.BiPredicate;

public abstract class Herbivore extends Animal {

    public Herbivore(double maxWeight, int maxOnCell, int maxSpeed, double foodNeeded, String icon, BiPredicate<Animal, Organism> huntingStrategy) {
        super(maxWeight, maxOnCell, maxSpeed, foodNeeded, icon, huntingStrategy);
    }
}
