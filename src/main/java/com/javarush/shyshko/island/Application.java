package main.java.com.javarush.shyshko.island;

import main.java.com.javarush.shyshko.island.config.SimulationConfig;
import main.java.com.javarush.shyshko.island.factory.OrganismFactory;
import main.java.com.javarush.shyshko.island.model.*;

import java.util.List;

public class Application {
     static void main() {

         Organism wolf = OrganismFactory.createOrganism("wolf");
         Organism rabbit = OrganismFactory.createOrganism("rabbit");
         Organism plant = OrganismFactory.createOrganism("plant");

         System.out.println("Создан объект класса: " + wolf.getClass().getSimpleName() + " " + wolf.getIcon());
         System.out.println("Создан объект класса: " + rabbit.getClass().getSimpleName() + " " + rabbit.getIcon());
         System.out.println("Создан объект класса: " + plant.getClass().getSimpleName() + " " + plant.getIcon());


    }
}
