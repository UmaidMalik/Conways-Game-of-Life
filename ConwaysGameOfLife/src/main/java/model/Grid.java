package model;

import java.awt.*;

public class Grid {

    private Cell[][] cells;
    private int width, height;
    private int maxCellState;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        initializeGrid();
        maxCellState = 2;
    }

    public void initializeGrid() {
        cells = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j] = new Cell(0);
            }
        }
    }

    public int getMaxCellState() {
        return maxCellState;
    }

    public void setMaxCellState(int maxCellState) {
        this.maxCellState = maxCellState;
    }

    public Cell getCell(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height)
            return null;
        return cells[x][y];
    }

    public void setCell(int x, int y, int state) {
        if (!(x < 0 || x >= width || y < 0 || y >= height))
            cells[x][y].setState(state);
    }

    public void setCell(int x, int y, int state, Color color) {
        if (!(x < 0 || x >= width || y < 0 || y >= height)) {
            cells[x][y].setState(state);
            cells[x][y].setColor(color);
        }
    }

    public void setCell(int x, int y, boolean state, Color color) {
        int intState = (state ? 1 : 0);
        if (!(x < 0 || x >= width || y < 0 || y >= height)) {
            cells[x][y].setState(intState);
            cells[x][y].setColor(color);
        }
    }

    public void setNewCell(int x, int y, Cell cell, Color color) {
        if (!(x < 0 || x >= width || y < 0 || y >= height)) {
            cells[x][y] = cell;
            cells[x][y].setColor(color);
        }
    }

    public void printGrid() {
        for (int i = 0; i < width; i++) {
            System.out.print("|");
            for (int j = 0; j < height; j++) {

                System.out.print(cells[i][j].isAlive() ? "X " : "  ");
            }
            System.out.print("|");
            System.out.println();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                sb.append(cells[i][j].isAlive() ? "X " : "  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
