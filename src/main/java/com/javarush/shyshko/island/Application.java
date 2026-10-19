package main.java.com.javarush.shyshko.island;

import main.java.com.javarush.shyshko.island.config.SimulationConfig;
import main.java.com.javarush.shyshko.island.model.*;

public class Application {
     static void main() {

         SimulationConfig config = SimulationConfig.builder()
                 .mapWidth(100)
                 .mapHeight(20)
                 .build();

         System.out.println("Установленные размеры игрового поля: " + config.getMapWidth() + "x" + config.getMapHeight());

         int wolfEatRabbit = SimulationConfig.getProbability(Wolf.class, Rabbit.class);
         int rabbitEatPlant = SimulationConfig.getProbability(Rabbit.class, Plant.class);
         int wolfEatPlant = SimulationConfig.getProbability(Wolf.class, Plant.class);

         System.out.println("Шанс у Волка съесть Кролика: " + wolfEatRabbit + "% (Ожидается: 60%)");
         System.out.println("Шанс у Кролика съесть Траву: " + rabbitEatPlant + "% (Ожидается: 100%)");
         System.out.println("Шанс у Волка съесть Траву: " + wolfEatPlant + "% (Ожидается: 0%)");


    }
}
