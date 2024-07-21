package model;

public class Cell {
    boolean isAlive;

    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean isAlive() {
        return isAlive;
    }
}
