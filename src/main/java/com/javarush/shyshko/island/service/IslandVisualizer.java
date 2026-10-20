package main.java.com.javarush.shyshko.island.service;

import main.java.com.javarush.shyshko.island.model.*;
import main.java.com.javarush.shyshko.island.model.organism.Plant;
import main.java.com.javarush.shyshko.island.model.organism.abstraction.Organism;
import main.java.com.javarush.shyshko.island.model.organism.herbivore.Rabbit;
import main.java.com.javarush.shyshko.island.model.organism.predator.Wolf;

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
                        case Wolf w when !w.isDead()        -> String.format("Волк      ID:%-5d", w.getId());
                        case Rabbit r when !r.isDead()      -> String.format("Кролик    ID:%-5d", r.getId());
                        case Plant p                        -> String.format("Растение  ID:%-5d", p.getId());
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
