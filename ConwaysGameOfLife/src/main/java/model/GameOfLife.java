package model;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameOfLife extends JPanel {
    //TODO: Add observer for getting the generation count
    private Grid grid;
    private int generation;
    //private static GameOfLife gameOfLife;
    private Grid nextGenerationGrid;
    private Set<Integer> surviveRules;
    private Set<Integer> birthRules;
    private boolean isEdgeWrapped;

    public GameOfLife() {
        generation = 0;
        surviveRules = new HashSet<>();
        birthRules = new HashSet<>();
        isEdgeWrapped = false;
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

    public void setBirthRule(List<Integer> rules) {
        birthRules.clear();
        birthRules.addAll(rules);
    }

    public void setSurviveRules(List<Integer> rules) {
        surviveRules.clear();
        surviveRules.addAll(rules);
    }

    public void setDefaultGameOfLifeRule() {
        birthRules.clear();
        surviveRules.clear();
        birthRules.add(3);
        surviveRules.add(2);
        surviveRules.add(3);
    }

    public void setDefaultAmoebaRule() {
        birthRules.clear();
        surviveRules.clear();
        birthRules.add(3);
        birthRules.add(5);
        birthRules.add(7);
        surviveRules.add(1);
        surviveRules.add(3);
        surviveRules.add(5);
        surviveRules.add(8);
    }

    public void setMyRule() {
        birthRules.clear();
        surviveRules.clear();
        birthRules.add(3);
        surviveRules.add(0);
        surviveRules.add(1);
        surviveRules.add(4);
        surviveRules.add(5);
        surviveRules.add(6);
        surviveRules.add(7);
        surviveRules.add(8);
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
        int xCoordinate;
       int yCoordinate;
       for (int x = i - 1; x <= i + 1; x++) {
           for (int y = j - 1; y <= j + 1; y++) {
               xCoordinate = (isEdgeWrapped) ? ((x + grid.getWidth()) % grid.getWidth()) : x;
               yCoordinate = (isEdgeWrapped) ? ((y + grid.getHeight()) % grid.getHeight()) : y;
               if (!(xCoordinate >= 0 && xCoordinate < grid.getWidth() &&
                       yCoordinate >= 0 && yCoordinate < grid.getHeight())) continue;
               if (!(x == i && y == j) && grid.getCell(xCoordinate, yCoordinate).isAlive()) {
                   aliveNeighbors++;
               }
            }
        }
        return aliveNeighbors;
    }

    private void applyGameOfLifeRule(int i, int j, int aliveNeighbours) {
        // game of life rule
        setDefaultGameOfLifeRule();
        //setDefaultAmoebaRule();
        //setMyRule();
        boolean isAlive = grid.getCell(i,j).isAlive();
        boolean shouldSurvive = isAlive && surviveRules.contains(aliveNeighbours); // 2!
        boolean shouldBeBorn = !isAlive && birthRules.contains(aliveNeighbours);
        nextGenerationGrid.setCell(i, j, shouldSurvive || shouldBeBorn, grid.getCell(i,j).getColor());
    }

    private void createCopyOfGrid() {
        nextGenerationGrid = new Grid(grid.getWidth(), grid.getHeight());
        for (int i = 0; i < grid.getWidth(); i++) {
            for (int j = 0; j < grid.getHeight(); j++) {
                nextGenerationGrid.setNewCell(i, j, new Cell(grid.getCell(i,j).isAlive()),
                        grid.getCell(i,j).getColor());
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

    public void toggleEdgeWrapping() {
        isEdgeWrapped = !isEdgeWrapped;
    }

    public boolean isEdgeWrapped() {
        return isEdgeWrapped;
    }
}
