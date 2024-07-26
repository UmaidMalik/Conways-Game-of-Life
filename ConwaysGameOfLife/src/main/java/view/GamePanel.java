package view;

import model.*;
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
    private boolean displayGridLines;


    private int index = 0;
    private Color[] colorsFiery = {Color.RED, Color.YELLOW, Color.ORANGE};
    private Color[] colorsCool = {Color.BLUE, Color.CYAN, Color.WHITE};
    private Color[] colorsGrayScale = {Color.WHITE, Color.GRAY, Color.LIGHT_GRAY, Color.DARK_GRAY};
    private Color[] colorsRainbow = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA};
    private Color[] colorsCanadian = {Color.WHITE, Color.RED};
    private Color[] colorsAmerican = {Color.RED, Color.WHITE, Color.BLUE};
    private Color[] colorsIronMan = {Color.RED, Color.ORANGE};
    private Color[] colorsHue = {Color.RED,  Color.GREEN, Color.BLUE };

    private int getColor(int n) {
        return index++ % n;
    }


    public GamePanel(GameOfLife gameOfLife) {
        this.gameOfLife = gameOfLife;
        this.grid = gameOfLife.getGrid();
        setCellSize(10);
        displayGridLines = false;
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
                    //g.setColor(Color.WHITE);
                    g.setColor(gameOfLife.getGrid().getCell(i, j).getColor());

                    //g.setColor(colorsFiery[getColor(colorsFiery.length)]);
                    //g.setColor(colorsGrayScale[getColor(colorsGrayScale.length)]);
                    //g.setColor(colorsCool[getColor(colorsCool.length)]);
                    //g.setColor(colorsRainbow[getColor(colorsRainbow.length)]);
                    //g.setColor(colorsCanadian[getColor(colorsCanadian.length)]);
                    //g.setColor(colorsAmerican[getColor(colorsAmerican.length)]);
                    //g.setColor(colorsIronMan[getColor(colorsIronMan.length)]);
                    //g.setColor(colorsHue[getColor(colorsHue.length)]);
                } else {
                    g.setColor(Color.BLACK);
                }
                g.fillRect(i*cellSize, j*cellSize, cellSize, cellSize);
            }
        }
        drawOverlay(g);
        if (displayGridLines) {
            drawGridLines(g);
        }
    }

    public void drawOverlay(Graphics g) {
        if (overlay != null) {
            for (Point p : overlay) {
                g.setColor(Color.CYAN);
                if (!displayGridLines) {
                    g.drawRect(p.getX() * cellSize, p.getY() * cellSize, cellSize, cellSize);
                } else {
                    g.fill3DRect(p.getX() * cellSize, p.getY() * cellSize, cellSize, cellSize, false);
                }
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

    public void setDisplayGridLines(boolean displayGridLines) {
        this.displayGridLines = displayGridLines;
    }

    public boolean getDisplayGridLines() {
        return displayGridLines;
    }
}
