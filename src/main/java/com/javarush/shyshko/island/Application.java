package main.java.com.javarush.shyshko.island;

import main.java.com.javarush.shyshko.island.model.*;
import main.java.com.javarush.shyshko.island.service.IslandEngine;
import main.java.com.javarush.shyshko.island.service.IslandInitializer;
import main.java.com.javarush.shyshko.island.service.IslandVisualizer;


public class Application {
     static void main() {


         IslandMap map = new IslandMap(3, 3);

         IslandInitializer.populateIsland(map);

         IslandVisualizer.drawGrid(map, 0);

         IslandEngine engine = new IslandEngine(map);
         engine.startSimulation();
    }
}
