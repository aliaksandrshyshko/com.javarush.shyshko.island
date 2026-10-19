package main.java.com.javarush.shyshko.island;

import main.java.com.javarush.shyshko.island.model.Location;
import main.java.com.javarush.shyshko.island.model.Plant;

public class Application {
     static void main() {

        Location testLocation = new Location(0, 0);
        Plant testPlant = new Plant();
        testPlant.setMyLocation(testLocation);
        testLocation.addOrganism(testPlant);
        System.out.println("Создана клетка, в неё добавлено растение " + testPlant.getIcon());
    }
}
