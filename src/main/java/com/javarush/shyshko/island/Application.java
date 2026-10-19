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
         cellA.addOrganism(OrganismFactory.createOrganism("wolf"));
         cellA.addOrganism(OrganismFactory.createOrganism("rabbit"));
         cellA.addOrganism(OrganismFactory.createOrganism("plant"));

         Location cellB = map.getLocation(1, 1);
         cellB.addOrganism(OrganismFactory.createOrganism("rabbit"));
         cellB.addOrganism(OrganismFactory.createOrganism("rabbit"));

         IslandEngine engine = new IslandEngine(map);

         engine.runStepCycle();
    }
}
