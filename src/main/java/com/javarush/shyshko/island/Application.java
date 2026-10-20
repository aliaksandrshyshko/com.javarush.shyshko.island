package main.java.com.javarush.shyshko.island;

import main.java.com.javarush.shyshko.island.config.SimulationConfig;
import main.java.com.javarush.shyshko.island.factory.OrganismFactory;
import main.java.com.javarush.shyshko.island.model.*;
import main.java.com.javarush.shyshko.island.service.IslandEngine;

import java.util.List;

public class Application {
     static void main() {

         IslandMap map = new IslandMap(10, 10);

         Location cellA = map.getLocation(0, 0);
         cellA.addOrganism(OrganismFactory.createOrganism("wolf", false));
         cellA.addOrganism(OrganismFactory.createOrganism("rabbit", false));
         cellA.addOrganism(OrganismFactory.createOrganism("plant", false));
         cellA.addOrganism(OrganismFactory.createOrganism("plant", false));
         cellA.addOrganism(OrganismFactory.createOrganism("plant", false));
         cellA.addOrganism(OrganismFactory.createOrganism("plant", false));
         cellA.addOrganism(OrganismFactory.createOrganism("plant", false));
         cellA.addOrganism(OrganismFactory.createOrganism("plant", false));
         cellA.addOrganism(OrganismFactory.createOrganism("plant", false));


         Location cellB = map.getLocation(1, 1);
         cellB.addOrganism(OrganismFactory.createOrganism("rabbit", false));
         cellB.addOrganism(OrganismFactory.createOrganism("rabbit", false));
         cellB.addOrganism(OrganismFactory.createOrganism("wolf", false));
         cellB.addOrganism(OrganismFactory.createOrganism("wolf", false));
         cellB.addOrganism(OrganismFactory.createOrganism("wolf", false));

         IslandEngine engine = new IslandEngine(map);

         engine.startSimulation();
    }
}
