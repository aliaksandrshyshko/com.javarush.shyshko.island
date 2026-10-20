package main.java.com.javarush.shyshko.island.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import lombok.Getter;
import main.java.com.javarush.shyshko.island.model.organism.abstraction.Organism;

@Getter
public class Location {
    private final int x;
    private final int y;

    private final List<Organism> organisms = new CopyOnWriteArrayList<>();

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
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


}
