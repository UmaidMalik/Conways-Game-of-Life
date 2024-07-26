package model;

import java.awt.*;

public class Grid {

    private Cell[][] cells;
    private int width, height;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        initializeGrid();
    }

    public void initializeGrid() {
        cells = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j] = new Cell(false);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setCell(int x, int y, boolean isAlive) {
        cells[x][y].setAlive(isAlive);
    }

    public void setCell(int x, int y, boolean isAlive, Color color) {
        cells[x][y].setAlive(isAlive);
        cells[x][y].setColor(color);
    }

    public void setNewCell(int x, int y, Cell cell, Color color) {
        cells[x][y] = cell;
        cells[x][y].setColor(color);
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
