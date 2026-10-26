package main.java.com.javarush.shyshko.island.model.organism.abstraction;

import main.java.com.javarush.shyshko.island.config.SimulationConfig;
import main.java.com.javarush.shyshko.island.factory.OrganismType;

public abstract class Predator extends Animal {
    public Predator(OrganismType type, String name, double maxWeight, int maxSpeed, double foodNeeded) {
        super(type, name, maxWeight, maxSpeed, foodNeeded,
                (attacker, food) -> SimulationConfig.getProbability(attacker.getType(), food.getType()) > 0
        );
    }
}
