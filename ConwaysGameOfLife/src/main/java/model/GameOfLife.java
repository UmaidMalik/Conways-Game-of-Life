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
    private float colorDecay = 0.9999f;
    private int range = 1;

    public GameOfLife() {
        generation = 0;
        surviveRules = new HashSet<>();
        birthRules = new HashSet<>();
        isEdgeWrapped = false;
        parentColors = new LinkedList<>();
        backgroundColor = Color.BLACK;
        recentStateChangeMap = new HashMap<>();
    }

    public GameOfLife(Grid grid) {
        this();
        this.grid = grid;
        //setRule();
    }

    public void setRule() {
        setBannersRule();
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

    public void setBirthRules(List<Integer> rules) {
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
        grid.setMaxCellState(2);
        birthRules.add(3);
        surviveRules.add(2);
        surviveRules.add(3);
    }

    public void setDefaultAmoebaRule() {
        birthRules.clear();
        surviveRules.clear();
        grid.setMaxCellState(2);
        birthRules.add(3);
        birthRules.add(5);
        birthRules.add(7);
        surviveRules.add(1);
        surviveRules.add(3);
        surviveRules.add(5);
        surviveRules.add(8);
    }

    public void setCootiesRule() {
        birthRules.clear();
        surviveRules.clear();
        grid.setMaxCellState(8);
        birthRules.add(2);
        surviveRules.add(2);
        surviveRules.add(3);

    }

    public void setBriansBrainRule() {
        birthRules.clear();
        surviveRules.clear();
        grid.setMaxCellState(3);
        birthRules.add(2);
    }

    public void setBannersRule() {
        birthRules.clear();
        surviveRules.clear();
        grid.setMaxCellState(5);
        birthRules.add(3);
        birthRules.add(4);
        birthRules.add(5);
        birthRules.add(7);

        surviveRules.add(2);
        surviveRules.add(3);
        surviveRules.add(6);
        surviveRules.add(7);
    }

    public void setMyRule() {
        birthRules.clear();
        surviveRules.clear();
        grid.setMaxCellState(2);
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
        grid.setMaxCellState(2);
        birthRules.add(3);
        birthRules.add(7);
        surviveRules.add(2);
        surviveRules.add(3);
    }

    public void setSeedRule() {
        birthRules.clear();
        surviveRules.clear();
        grid.setMaxCellState(2);
        birthRules.add(2);
    }

    public void setFredkinRule() {
        birthRules.clear();
        surviveRules.clear();
        grid.setMaxCellState(2);
        birthRules.add(1);
        birthRules.add(3);
        birthRules.add(5);
        birthRules.add(7);
        surviveRules.add(0);
        surviveRules.add(2);
        surviveRules.add(4);
        surviveRules.add(6);
        surviveRules.add(8);
    }

    public void setGnarlRule() {
        birthRules.clear();
        surviveRules.clear();
        grid.setMaxCellState(2);
        birthRules.add(1);
        surviveRules.add(1);

    }

    public void setBoscosRule() {
        birthRules.clear();
        surviveRules.clear();
        grid.setMaxCellState(2);
        range = 5;
        for (int i = 34; i <= 45; i++) {
            birthRules.add(i);
        }
        for (int i = 33; i <= 57; i++) {
            surviveRules.add(i);
        }
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


       for (int x = i - range; x <= i + range; x++) {
           for (int y = j - range; y <= j + range; y++) {
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
        //setBannersRule();
        //setCootiesRule();
        //setDefaultGameOfLifeRule();
        //setBriansBrainRule();
        //setFredkinRule();
        setGnarlRule();
        //setDryLifeRule();
        //setMyRule();
        //setBoscosRule();
        int packedCoordinate;
        Color averageParentColor = calculateAverageColorOfParents(i, j);
        Color deadColor = grid.getCell(i,j).getColor();
        boolean isAlive = grid.getCell(i,j).isAlive(); // TODO bug reported as null
        boolean isDead = grid.getCell(i,j).isDead();
        boolean shouldSurvive = isAlive && surviveRules.contains(aliveNeighbours);
        boolean shouldBeBorn = isDead && birthRules.contains(aliveNeighbours);

        int cellState = grid.getCell(i,j).getState();
        if (shouldBeBorn) {
            nextGenerationGrid.setCell(i, j, 1, averageParentColor);
        } else if (isDead) {
            Color c = new Color(Math.max((int)(deadColor.getRed() * colorDecay), 0),
                                Math.max((int)(deadColor.getGreen() * colorDecay), 0),
                                Math.max((int)(deadColor.getBlue() * colorDecay), 0));
            nextGenerationGrid.setCell(i, j, 0, c);
        } else if (shouldSurvive) {
            nextGenerationGrid.setCell(i, j, 1, averageParentColor);
        } else {
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

    private Color calculateAverageColorOfParents(int i, int j) {
        if (parentColors.isEmpty()) return new Color(Math.max((int)(grid.getCell(i, j).getColor().getRed() * colorDecay), 0),
                                                    Math.max((int)(grid.getCell(i, j).getColor().getGreen() * colorDecay), 0),
                                                    Math.max((int)(grid.getCell(i, j).getColor().getBlue() * colorDecay), 0));
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
