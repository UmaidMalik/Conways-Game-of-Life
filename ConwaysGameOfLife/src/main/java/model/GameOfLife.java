package model;

import javax.swing.*;
import java.awt.*;

public class GameOfLife extends JPanel {
    //TODO: Add observer for getting the generation count
    private Grid grid;
    private int generation;
    //private static GameOfLife gameOfLife;
    private Grid nextGenerationGrid;

    public GameOfLife() {
        generation = 0;
    }

    /*
    public static GameOfLife getInstance() {
        if (gameOfLife == null) {
            gameOfLife = new GameOfLife();
        }
        return gameOfLife;
    }

     */

    public void nextGeneration() {
        update();
        generation++;
    }

    private void update() {
        createCopyOfGrid();
        for (int i = 0; i < grid.getWidth(); i++) {
            for (int j = 0; j < grid.getHeight(); j++) {
                int aliveNeighbours = countAliveNeighbors(i, j);
                applyGameOfLifeRule(i, j, aliveNeighbours);
            }
        }
        grid = nextGenerationGrid;
    }

    public int countAliveNeighbors(int i, int j) {
        int aliveNeighbors = 0;
        for (int x = i - 1; x <= i + 1; x++) {
            for (int y = j - 1; y <= j + 1; y++) {
                if (x >= 0 && x < grid.getWidth() &&
                        y >= 0 && y < grid.getHeight() &&
                        !(x == i && y == j) && grid.getCell(x,y).isAlive()) {
                    aliveNeighbors++;
                }
            }
        }
        return aliveNeighbors;
    }

    private void applyGameOfLifeRule(int i, int j, int aliveNeighbours) {
        if (grid.getCell(i,j).isAlive()) {
            if (aliveNeighbours != 3 && aliveNeighbours != 2) {
                nextGenerationGrid.setCell(i, j, false);
            }
        } else {
            if (aliveNeighbours == 3) {
                nextGenerationGrid.setCell(i, j, true);
            }
        }
    }

    private void createCopyOfGrid() {
        nextGenerationGrid = new Grid(grid.getWidth(), grid.getHeight());
        for (int i = 0; i < grid.getWidth(); i++) {
            for (int j = 0; j < grid.getHeight(); j++) {
                nextGenerationGrid.setNewCell(i, j, new Cell(grid.getCell(i,j).isAlive()));
            }
        }
    }

    public void createGrid(int width, int height) {
        grid = new Grid(width, height);
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public int getGeneration() {
        return generation;
    }




}
