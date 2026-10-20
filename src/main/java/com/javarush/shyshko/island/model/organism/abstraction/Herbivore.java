package main.java.com.javarush.shyshko.island.model.organism.abstraction;

import main.java.com.javarush.shyshko.island.config.SimulationConfig;

import java.util.function.BiPredicate;

public abstract class Herbivore extends Animal {

    public Herbivore(String name, double maxWeight, int maxOnCell, int maxSpeed, double foodNeeded) {
        super(name, maxWeight, maxOnCell, maxSpeed, foodNeeded,
                (attacker, food) -> SimulationConfig.getProbability(attacker.getClass(), food.getClass()) > 0
        );
    }
}
