package main.java.com.javarush.shyshko.island.model.organism.abstraction;

import lombok.Getter;
import lombok.Setter;
import main.java.com.javarush.shyshko.island.model.Location;
import main.java.com.javarush.shyshko.island.factory.OrganismType;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;


@Getter
@Setter
public abstract class Organism {

    private static final AtomicInteger idGenerator = new AtomicInteger(1);
    private final int id;
    private final OrganismType type;
    protected double weight;
    protected String name;
    protected Location myLocation;

    protected final int maxOnCell;
    private final AtomicLong version = new AtomicLong(0);

    public Organism(OrganismType type, String name, double weight) {
        this.id = idGenerator.getAndIncrement();
        this.type = type;
        this.name = name;
        this.weight = weight;
        this.maxOnCell = type.getMaxOnCell();
    }

    public abstract String getIcon();


}
