package main.java.com.javarush.shyshko.island.model;

public abstract class Organism {
    protected double weight;
    protected Location myLocation;

    public Organism(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public Location getMyLocation() {
        return myLocation;
    }

    public void setMyLocation(Location loc) {
        this.myLocation = loc;
    }

    public abstract String getIcon();

}
