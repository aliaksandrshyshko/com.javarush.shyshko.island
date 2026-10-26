package main.java.com.javarush.shyshko.island.model;

import lombok.Getter;

@Getter
public class Island {
    private final int width;
    private final int height;
    private final Location[][] locations;

    public Island(int width, int height) {
        this.width = width;
        this.height = height;
        this.locations = new Location[height][width];
        initLocations();
    }

    private void initLocations() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                locations[y][x] = new Location(x, y);
            }
        }
    }

    public Location getLocation(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return locations[y][x];
        }
        return null;
    }

}
