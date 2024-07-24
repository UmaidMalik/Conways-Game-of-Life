package view;

import model.*;
import controller.*;
import model.Point;


import javax.swing.JPanel;
import java.awt.*;
import java.util.Set;

public class GamePanel extends JPanel {

    private final GameOfLife gameOfLife;
    private int cellSize;
    private int width, height;
    private Grid grid;
    private Set<Point> overlay;
    private boolean drawMode;

    public GamePanel(GameOfLife gameOfLife) {
        this.gameOfLife = gameOfLife;
        this.grid = gameOfLife.getGrid();
        setCellSize(10);
    }

    public void setOverlay(Set<Point> overlay, boolean drawMode) {
        this.overlay = overlay;
        this.drawMode = drawMode;
    }

    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponent(g);

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
        drawOverlay(g);
        //drawGridLines(g);
    }

    public void drawOverlay(Graphics g) {
        if (overlay != null) {
            for (Point p : overlay) {
                g.setColor(Color.GRAY);
                g.drawRect(p.getX() * cellSize, p.getY() * cellSize, cellSize, cellSize);
            }
        }
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
