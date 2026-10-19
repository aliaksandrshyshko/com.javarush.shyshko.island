package main.java.com.javarush.shyshko.island;

import main.java.com.javarush.shyshko.island.model.Location;
import main.java.com.javarush.shyshko.island.model.Plant;
import main.java.com.javarush.shyshko.island.model.Rabbit;
import main.java.com.javarush.shyshko.island.model.Wolf;

public class Application {
     static void main() {

        Location testLocation = new Location(0, 0);
        Wolf wolf = new Wolf();
        Rabbit rabbit = new Rabbit();
        Plant plant = new Plant();

        wolf.setMyLocation(testLocation);
        rabbit.setMyLocation(testLocation);
        plant.setMyLocation(testLocation);

        testLocation.addOrganism(wolf);
        testLocation.addOrganism(rabbit);
        testLocation.addOrganism(plant);

        System.out.println("Существ в клетке до симуляции: " + testLocation.getOrganisms().size());
        System.out.println("--- Фаза питания ---");

        rabbit.eat(testLocation);
        wolf.eat(testLocation);

        System.out.println("--- Окончание шага симуляции ---");
        wolf.passStep();
        rabbit.passStep();

        System.out.println("\nИтог: Волк жив? " + !wolf.isDead() + ", Кролик жив? " + !rabbit.isDead());

    }
}
