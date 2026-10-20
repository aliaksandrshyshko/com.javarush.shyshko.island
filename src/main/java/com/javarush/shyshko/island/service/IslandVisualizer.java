package main.java.com.javarush.shyshko.island.service;

import main.java.com.javarush.shyshko.island.model.*;
import main.java.com.javarush.shyshko.island.model.organism.Plant;
import main.java.com.javarush.shyshko.island.model.organism.abstraction.Organism;
import main.java.com.javarush.shyshko.island.model.organism.herbivore.*;
import main.java.com.javarush.shyshko.island.model.organism.predator.*;

import java.util.ArrayList;
import java.util.List;

public class IslandVisualizer {

    private static final int CELL_WIDTH = 22;

    public static void drawGrid(IslandMap islandMap, int day) {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("КАРТА ОСТРОВА ( ТАКТ " + day +" ):");

        for (int y = 0; y < islandMap.getHeight(); y++) {

            printHorizontalBorder(islandMap.getWidth());

            int maxLinesInRow = 1;
            List<List<String>> rowData = new ArrayList<>();

            for (int x = 0; x < islandMap.getWidth(); x++) {
                Location loc = islandMap.getLocation(x, y);
                List<String> cellLines = new ArrayList<>();


                for (Organism o : loc.getOrganisms()) {
                    String line = switch (o) {
                        case Wolf wolf when !wolf.isDead()        -> String.format("Волк      ID:%-5d", wolf.getId());
                        case Rabbit rabbit when !rabbit.isDead()      -> String.format("Кролик    ID:%-5d", rabbit.getId());
                        case Bear bear when !bear.isDead()        -> String.format("Медведь    ID:%-5d", bear.getId());
                        case Fox fox when !fox.isDead()        -> String.format("Лиса    ID:%-5d", fox.getId());
                        case Eagle eagle when !eagle.isDead()        -> String.format("Орел    ID:%-5d", eagle.getId());
                        case Boa boa when !boa.isDead()        -> String.format("Удав    ID:%-5d", boa.getId());
                        case Boar boar when !boar.isDead()        -> String.format("Кабан    ID:%-5d", boar.getId());
                        case Buffalo buffalo when !buffalo.isDead()  -> String.format("Буйвол    ID:%-5d", buffalo.getId());
                        case Caterpillar caterpillar when !caterpillar.isDead()  -> String.format("Гусеница    ID:%-5d", caterpillar.getId());
                        case Deer deer when !deer.isDead()  -> String.format("Олень    ID:%-5d", deer.getId());
                        case Duck duck when !duck.isDead()  -> String.format("Утка    ID:%-5d", duck.getId());
                        case Goat goat when !goat.isDead()  -> String.format("Коза    ID:%-5d", goat.getId());
                        case Horse horse when !horse.isDead()  -> String.format("Лошадь    ID:%-5d", horse.getId());
                        case Mouse mouse when !mouse.isDead()  -> String.format("Мышь    ID:%-5d", mouse.getId());
                        case Sheep sheep when !sheep.isDead()  -> String.format("Овца    ID:%-5d", sheep.getId());
                        case Plant plant                        -> String.format("Растение  ID:%-5d", plant.getId());
                        default -> null;
                    };

                    if (line != null) {
                        cellLines.add(line);
                    }
                }

                if (cellLines.size() > maxLinesInRow) {
                    maxLinesInRow = cellLines.size();
                }
                rowData.add(cellLines);
            }


            for (int lineIdx = 0; lineIdx < maxLinesInRow; lineIdx++) {
                StringBuilder lineBuilder = new StringBuilder("|");

                for (int x = 0; x < islandMap.getWidth(); x++) {
                    List<String> cellLines = rowData.get(x);
                    String content = "";

                    if (lineIdx < cellLines.size()) {
                        content = cellLines.get(lineIdx);
                    }


                    String formatted = String.format("%-" + CELL_WIDTH + "s", content);
                    lineBuilder.append(formatted).append("|");
                }
                System.out.println(lineBuilder);
            }
        }


        printHorizontalBorder(islandMap.getWidth());

    }

    private static void printHorizontalBorder(int width) {
        StringBuilder border = new StringBuilder("|");
        for (int i = 0; i < width; i++) {
            border.repeat("-", CELL_WIDTH).append("|");
        }
        System.out.println(border);
    }
}
