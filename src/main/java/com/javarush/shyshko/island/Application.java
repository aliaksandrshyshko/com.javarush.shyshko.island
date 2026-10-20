package main.java.com.javarush.shyshko.island;

import main.java.com.javarush.shyshko.island.factory.OrganismFactory;
import main.java.com.javarush.shyshko.island.model.*;
import main.java.com.javarush.shyshko.island.service.IslandEngine;


public class Application {
     static void main() {

         IslandMap map = new IslandMap(6, 6);

         Location cellA = map.getLocation(0, 0);
         cellA.addOrganism(OrganismFactory.createOrganism("wolf", false));
         cellA.addOrganism(OrganismFactory.createOrganism("rabbit", false));
         cellA.addOrganism(OrganismFactory.createOrganism("rabbit", false));
         cellA.addOrganism(OrganismFactory.createOrganism("plant", false));


         IslandEngine engine = new IslandEngine(map);

         engine.startSimulation();
    }
}
