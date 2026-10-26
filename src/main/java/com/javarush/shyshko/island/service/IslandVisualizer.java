package main.java.com.javarush.shyshko.island.service;

import main.java.com.javarush.shyshko.island.model.*;
import main.java.com.javarush.shyshko.island.model.organism.abstraction.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IslandVisualizer {
    private static final int CELL_WIDTH = 15;
    
    public static void printMap(Island island, int day) {
        
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("КАРТА ОСТРОВА ( День " + (day+1) + " ):");

        for (int y = 0; y < island.getHeight(); y++) {
            printHorizontalBorder(island.getWidth());

            int maxLinesInRow = 1;
            List<List<String>> rowData = new ArrayList<>();

            for (int x = 0; x < island.getWidth(); x++) {
                Location loc = island.getLocation(x, y);

                Map<String, Long> stats = loc.getOrganisms().stream()
                        .filter(o -> !(o instanceof Animal animal) || !animal.isDead())
                        .collect(Collectors.groupingBy(
                                o -> o.getIcon() + " " + o.getName(),
                                Collectors.counting()
                        ));

                List<String> cellLines = stats.entrySet().stream()
                        .map(entry -> String.format("%s: %d", entry.getKey(), entry.getValue()))
                        .collect(Collectors.toList());

                if (cellLines.size() > maxLinesInRow) {
                    maxLinesInRow = cellLines.size();
                }

                rowData.add(cellLines);
            }

            for (int lineIdx = 0; lineIdx < maxLinesInRow; lineIdx++) {
                StringBuilder lineBuilder = new StringBuilder("|");

                for (int x = 0; x < island.getWidth(); x++) {
                    String formattedContent = getString(rowData, x, lineIdx);

                    lineBuilder.append(formattedContent).append("|");
                }
                System.out.println(lineBuilder);
            }
        }

        printHorizontalBorder(island.getWidth());
    }

    private static String getString(List<List<String>> rowData, int x, int lineIdx) {
        List<String> cellLines = rowData.get(x);
        String content = "";

        if (lineIdx < cellLines.size()) {
            content = cellLines.get(lineIdx);
        }

        String formattedContent = String.format("%-" + CELL_WIDTH + "s", content);
        if (formattedContent.length() > CELL_WIDTH) {
            formattedContent = formattedContent.substring(0, CELL_WIDTH);
        }
        return formattedContent;
    }

    private static void printHorizontalBorder(int width) {
        StringBuilder border = new StringBuilder("|");
        for (int i = 0; i < width; i++) {
            border.append("-".repeat(CELL_WIDTH)).append("|");
        }
        System.out.println(border);
    }
}
