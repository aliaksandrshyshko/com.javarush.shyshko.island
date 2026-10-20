package main.java.com.javarush.shyshko.island.model;

public class Plant extends Organism {
    public Plant() {
        super(1, 3);
    }


    @Override
    public String getIcon() {
        return "\uD83C\uDF3F";
    }
}
