package model;

import java.awt.*;

public class Cell {
    boolean isAlive;
    Color color;


    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
        this.color = Color.WHITE;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
