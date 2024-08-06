package view;

import model.*;
import model.Point;


import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Point2D;
import java.util.Map;
import java.util.Set;
import java.awt.geom.AffineTransform;

public class GamePanel extends JPanel {

    private final GameOfLife gameOfLife;
    private int cellSize;
    private int width, height;
    private Grid grid;
    private Set<Point> overlay;
    private boolean drawMode;
    private boolean displayGridLines;
    private double zoom = 0;
    private int initialZoom;
    private Point2D.Double zoomCenter;

    private int index = 0;
    private Color[] colorsFiery = {Color.RED, Color.YELLOW, Color.ORANGE};
    private Color[] colorsCool = {Color.BLUE, Color.CYAN, Color.WHITE};
    private Color[] colorsGrayScale = {Color.WHITE, Color.GRAY, Color.LIGHT_GRAY, Color.DARK_GRAY};
    private Color[] colorsRainbow = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA};
    private Color[] colorsCanadian = {Color.WHITE, Color.RED};
    private Color[] colorsAmerican = {Color.RED, Color.WHITE, Color.BLUE};
    private Color[] colorsIronMan = {Color.RED, Color.ORANGE};
    private Color[] colorsHue = {Color.RED, Color.GREEN, Color.BLUE};
    private final int MAX_ZOOM = 1000;

    private int getColor(int n) {
        return index++ % n;
    }

    private int flag;

    public GamePanel(GameOfLife gameOfLife) {
        this.gameOfLife = gameOfLife;
        this.grid = gameOfLife.getGrid();
        setCellSize(5);
        displayGridLines = false;
        flag = 3;
        zoom = cellSize;
        initialZoom = cellSize;
        zoomCenter = new Point2D.Double(0, 0);
        addMouseWheelListener(new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int notches = e.getWheelRotation();
                System.out.println("Notches: " + notches);
                if (notches < 0) {
                    zoom *= 1.1;
                } else {
                    zoom /= 1.1;
                }
                if (zoom < initialZoom) {
                    zoom = initialZoom;
                } else if (zoom > MAX_ZOOM) {
                    zoom = MAX_ZOOM;
                }

                zoomCenter = new Point2D.Double(e.getPoint().getX(), e.getPoint().getY());

                setCellSize((int) Math.round(zoom));
                repaint();
            }
        });
    }

    public void setOverlay(Set<Point> overlay, boolean drawMode) {
        this.overlay = overlay;
        this.drawMode = drawMode;
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Graphics2D g2d = (Graphics2D) g;
        //AffineTransform at = g2d.getTransform();


        //at.translate(zoomCenter.getX(), zoomCenter.getY());





        Color cellColor;
        for (int i = 0; i < gameOfLife.getGrid().getWidth(); i++) {
            for (int j = 0; j < gameOfLife.getGrid().getHeight(); j++) {
                cellColor = gameOfLife.getGrid().getCell(i, j).getColor();
                g.setColor(cellColor);
                /*
                if (gameOfLife.getGrid().getCell(i, j).isAlive())
                    g.setColor(cellColor);
                else if (!gameOfLife.getGrid().getCell(i, j).isAlive() && !gameOfLife.getGrid().getCell(i, j).isDead())
                    //g.setColor(new Color(cellColor.getRed()/2, cellColor.getGreen()/2, cellColor.getBlue()/2));
                    g.setColor(cellColor);
                else {
                    g.setColor(cellColor);
                }

                 */



                g.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
            }
        }




        /*
        for (Map.Entry<Integer, Color> entry : gameOfLife.getRecentStateChangeMap().entrySet()) {
            int packedCoordinate = entry.getKey();
            int x = packedCoordinate & 0x3FFF;
            int y = (packedCoordinate >> 14) & 0x3FFF;
            Color state = entry.getValue();
            g.setColor(state);
            g.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
        }

         */

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
