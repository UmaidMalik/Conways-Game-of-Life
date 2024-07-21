package view;

import model.*;
import controller.*;


import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel {

    private final GameOfLife gameOfLife;
    private int cellSize;
    private int width, height;
    private Grid grid;

    public GamePanel(GameOfLife gameOfLife) {
        this.gameOfLife = gameOfLife;
        this.grid = gameOfLife.getGrid();
        //this.width = grid.getWidth();
        //this.height = grid.getHeight();
        setCellSize(10);
    }

    @Override
    public void paintComponent(Graphics g) {

        for (int i = 0; i < gameOfLife.getGrid().getWidth(); i++) {
            for (int j = 0; j < gameOfLife.getGrid().getHeight(); j++) {
                if (gameOfLife.getGrid().getCell(i, j).isAlive()) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.BLACK);
                }
                g.fillRect(i*cellSize, j*cellSize, cellSize, cellSize);
            }
        }
        //drawGridLines(g);
    }


    public void drawGridLines(Graphics g) {
            g.setColor(Color.GRAY);
            for (int i = 0; i <= gameOfLife.getGrid().getWidth(); i++) {
                g.drawLine(i * cellSize, 0, i * cellSize, gameOfLife.getGrid().getHeight() * cellSize);
            }
            for (int i = 0; i <= gameOfLife.getGrid().getHeight(); i++) {
                g.drawLine(0, i * cellSize, gameOfLife.getGrid().getWidth() * cellSize, i * cellSize);
            }
    }


    public int getCellSize() {
        return cellSize;
    }

    public void setCellSize(int size){
        cellSize = size;
    }

}
