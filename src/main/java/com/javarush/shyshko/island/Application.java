package main.java.com.javarush.shyshko.island;

import main.java.com.javarush.shyshko.island.config.SimulationConfig;
import main.java.com.javarush.shyshko.island.model.*;

import java.util.List;

public class Application {
     static void main() {

         Location cell = new Location(0, 0);

         cell.addOrganism(new Wolf());
         cell.addOrganism(new Rabbit());
         cell.addOrganism(new Rabbit());
         cell.addOrganism(new Plant());

         System.out.println("Всего объектов в списке клетки: " + cell.getOrganisms().size());

         List<Wolf> wolves = cell.getOrganismsOfType(Wolf.class);
         List<Rabbit> rabbits = cell.getOrganismsOfType(Rabbit.class);
         List<Plant> plants = cell.getOrganismsOfType(Plant.class);

         System.out.println("\n--- Результаты фильтрации через Generics ---");
         System.out.println("Найдено волков: " + wolves.size() + " " + (wolves.isEmpty() ? "" : wolves.get(0).getIcon()));
         System.out.println("Найдено кроликов: " + rabbits.size() + " " + (rabbits.isEmpty() ? "" : rabbits.get(0).getIcon()));
         System.out.println("Найдено растений: " + plants.size() + " " + (plants.isEmpty() ? "" : plants.get(0).getIcon()));


    }
}
