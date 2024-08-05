package model;

import java.awt.*;

public class Cell {
    //boolean isAlive;
    Color color;
    int cellState;


    public Cell(int cellState) {
        this.cellState = cellState;
        if (cellState == 0)
            color = Color.BLACK;
        else
            color = Color.WHITE;

    }

    public void setState(int state) {
        cellState = state;
    }

    public void nextState() {
        cellState++;
    }

    public int getState() {
        return cellState;
    }

    public boolean isState(int state) {
        return cellState == state;
    }

    public boolean isAlive() {
        return cellState == 1;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
