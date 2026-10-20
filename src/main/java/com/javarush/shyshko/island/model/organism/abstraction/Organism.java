package main.java.com.javarush.shyshko.island.model.organism.abstraction;

import lombok.Getter;
import lombok.Setter;
import main.java.com.javarush.shyshko.island.model.Location;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;


@Getter
@Setter
public abstract class Organism {

    private static final AtomicInteger idGenerator = new AtomicInteger(1);
    private final int id;
    protected double weight;
    protected Location myLocation;
    protected final int maxOnCell;
    private final AtomicLong version = new AtomicLong(0);

    public Organism(double weight, int maxOnCell) {
        this.id = idGenerator.getAndIncrement();
        this.weight = weight;
        this.maxOnCell = maxOnCell;
    }

    public abstract String getIcon();

    public boolean tryLockUpdate(long expectedVersion) {
        return version.compareAndSet(expectedVersion, expectedVersion + 1);
    }

    public long getVersionSnapshot() {
        return version.get();
    }

}
