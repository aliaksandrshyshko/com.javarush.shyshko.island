package main.java.com.javarush.shyshko.island;

import main.java.com.javarush.shyshko.island.model.*;

public class Application {
     static void main() {

        IslandMap islandMap = new IslandMap(10, 10);
        Location startLocation = islandMap.getLocation(5, 5);

        Wolf wolf = new Wolf();
        wolf.setMyLocation(startLocation);
        startLocation.addOrganism(wolf);

        System.out.println("Начальная позиция волка: [" + wolf.getMyLocation().getX() + ", " + wolf.getMyLocation().getY() + "]");

        wolf.move(islandMap);

        System.out.println("Новая позиция волка: [" + wolf.getMyLocation().getX() + ", " + wolf.getMyLocation().getY() + "]");

    }
}
