package main.java.com.javarush.shyshko.island.model;

import lombok.Getter;

@Getter
public class IslandMap {
    private final int width;
    private final int height;
    private final Location[][] grid;

    public IslandMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new Location[height][width];
        initGrid();
    }

    private void initGrid() {
        for(int y=0; y<height; y++) {
            for (int x=0; x<width; x++) {
                grid[y][x] = new Location(x,y);
            }
        }
    }

    public Location getLocation(int x, int y) {
        if(x >= 0 && x < width && y >=0 && y < height) {
            return grid[y][x];
        }
        return null;
    }

}
