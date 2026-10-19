package main.java.com.javarush.shyshko.island.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public abstract class Organism {
    protected double weight;
    protected Location myLocation;

    public Organism(double weight) {
        this.weight = weight;
    }

    public abstract String getIcon();

}
