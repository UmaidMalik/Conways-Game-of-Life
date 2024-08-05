package model;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class GameOfLife extends JPanel {
    //TODO: Add observer for getting the generation count

    private Grid grid;
    private int generation;
    //private static GameOfLife gameOfLife;
    private Grid nextGenerationGrid;
    private Set<Integer> surviveRules;
    private Set<Integer> birthRules;
    private boolean isEdgeWrapped;
    private List<Color> parentColors;
    private Color backgroundColor;
    private Map<Integer, Color> recentStateChangeMap;
    private float colorSaturation = 0.9f;

    public GameOfLife() {
        generation = 0;
        surviveRules = new HashSet<>();
        birthRules = new HashSet<>();
        isEdgeWrapped = false;
        parentColors = new LinkedList<>();
        backgroundColor = Color.BLACK;
        recentStateChangeMap = new HashMap<>();
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

    public void setBriansBrainRule() {
        birthRules.clear();
        surviveRules.clear();
        birthRules.add(2);
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

    public void setDryLifeRule() {
        birthRules.clear();
        surviveRules.clear();
        birthRules.add(3);
        birthRules.add(7);
        surviveRules.add(2);
        surviveRules.add(3);
    }

    public void setSeedRule() {
        birthRules.clear();
        surviveRules.clear();
        birthRules.add(2);
    }

    private void update() {
        createCopyOfGrid();
        for (int i = 0; i < grid.getWidth(); i++) {
            for (int j = 0; j < grid.getHeight(); j++) {
                int aliveNeighbours = countAliveNeighbors(i, j);
                applyGameOfLifeRule(i, j, aliveNeighbours);
                parentColors.clear();
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
                   parentColors.add(grid.getCell(xCoordinate, yCoordinate).getColor());
                   aliveNeighbors++;
               }
            }
        }
        return aliveNeighbors;
    }

    private void applyGameOfLifeRule(int i, int j, int aliveNeighbours) {
        // game of life rule
        //setDefaultGameOfLifeRule();
        //setDryLifeRule();
        //setDefaultAmoebaRule();
        //setMyRule();
        //setBriansBrainRule();
        //setSeedRule();
        int packedCoordinate;
        Color averageParentColor = calculateAverageColorOfParents();
        boolean isAlive = grid.getCell(i,j).isAlive(); // TODO bug reported as null
        boolean shouldSurvive = isAlive && surviveRules.contains(aliveNeighbours);
        boolean shouldBeBorn = !isAlive && birthRules.contains(aliveNeighbours);

        int cellState = grid.getCell(i,j).getState();
        if (cellState == 0 && aliveNeighbours == 2) {
            nextGenerationGrid.setCell(i, j, 1, averageParentColor);

        } else if (cellState == 0) {
            nextGenerationGrid.setCell(i, j, 0, backgroundColor);
        }
        else {
            nextGenerationGrid.setCell(i, j, ++cellState%grid.getMaxCellState(), averageParentColor);
        }

        /*
        if (shouldSurvive) {
            nextGenerationGrid.setCell(i, j, 1, averageParentColor);
        } else if (shouldBeBorn) {
            nextGenerationGrid.setCell(i, j, 1, averageParentColor);
            //packedCoordinate = (i & 0x3FFF) | ((j & 0x3FFF) << 14);
            //recentStateChangeMap.put(packedCoordinate, averageParentColor);
        } else {
            nextGenerationGrid.setCell(i, j, 0, backgroundColor);

            //if (isAlive) {
               // packedCoordinate = (i & 0x3FFF) | ((j & 0x3FFF) << 14);
              //  recentStateChangeMap.put(packedCoordinate, backgroundColor);
            //}


        }

         */



        //nextGenerationGrid.setCell(i, j, shouldSurvive || shouldBeBorn, averageParentColor);
    }

    private void createCopyOfGrid() {
        nextGenerationGrid = new Grid(grid.getWidth(), grid.getHeight());
        for (int i = 0; i < grid.getWidth(); i++) {
            for (int j = 0; j < grid.getHeight(); j++) {
                nextGenerationGrid.setNewCell(i, j, new Cell(grid.getCell(i,j).getState()),
                        grid.getCell(i,j).getColor()); // TODO bug reported as null
            }
        }

        recentStateChangeMap.clear();
    }

    public void createGrid(int width, int height) {
        grid = new Grid(width, height);
    }

    public Map<Integer, Color> getRecentStateChangeMap() {
        return recentStateChangeMap;
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

    private List<Color> getParentColors() {
        return parentColors;
    }

    private Color calculateAverageColorOfParents() {
        if (parentColors.isEmpty()) return backgroundColor;
        int red = 0;
        int green = 0;
        int blue = 0;
        int rgb = 0;
        //hsv color model
        float hue = 0.0f;
        float saturation = 1.0f;
        float value = 1.0f;
        for (Color color : parentColors) {
            //hue = Color.getHSBColor(color.getRed(), color.getGreen(), color.getBlue());
            red += color.getRed();
            green += color.getGreen();
            blue += color.getBlue();
            rgb += color.getRGB();
        }
        red = (int) Math.round((double) red / parentColors.size());
        green = (int) Math.round((double) green / parentColors.size());
        blue = (int) Math.round((double) blue / parentColors.size());
        float[] hsvData = Color.RGBtoHSB(red, green, blue, null);

        //rgb = Math.round((float) rgb / parentColors.size());
        //return new Color(red, green, blue);
        return Color.getHSBColor(hsvData[0], colorSaturation, 1.0f);
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
