package main.java.com.javarush.shyshko.island.model;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private final int x;
    private final int y;

    private final List<Organism> organisms = new ArrayList<>();

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Organism> getOrganisms() {
        return organisms;
    }

    public void addOrganism(Organism o) {
        organisms.add(o);
    }

    public void removeOrganism(Organism o) {
        organisms.remove(o);
    }


}
