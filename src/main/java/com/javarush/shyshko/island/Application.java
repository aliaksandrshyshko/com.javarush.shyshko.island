package main.java.com.javarush.shyshko.island;

import main.java.com.javarush.shyshko.island.model.*;
import main.java.com.javarush.shyshko.island.service.IslandEngine;
import main.java.com.javarush.shyshko.island.service.IslandInitializer;
import main.java.com.javarush.shyshko.island.service.IslandVisualizer;


public class Application {
   public static void main(String[] args) {
         Island map = new Island(3, 3);
         IslandInitializer.populateIsland(map);
         IslandEngine engine = new IslandEngine(map);
         engine.startSimulation();
    }
}
