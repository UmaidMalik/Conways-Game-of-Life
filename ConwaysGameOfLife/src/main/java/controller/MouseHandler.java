package controller;

import model.GameOfLife;
import model.Point;
import view.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MouseHandler extends MouseAdapter {
    /* TODO: bug report when running with point overlay put on to screen in sequential order
        and there the full of life will apply to them before all points are placed on the grid
        leads to frustrating user experience
     */
    private GameOfLife gameOfLife;
    private GamePanel gamePanel;
    private boolean drawMode;
    private Point previousPoint;
    private Set<Point> newPoints;
    private Color drawColor;
    private String drawState;
    private Color[] colors = new Color[]{Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, new Color(0x8000DE),};
    private static final String OVERLAY = "OVERLAY";
    private static final String BRUSH = "BRUSH";

    public MouseHandler(GameOfLife gameOfLife, GamePanel gamePanel) {
        this.gameOfLife = gameOfLife;
        this.gamePanel = gamePanel;
        drawMode = true;
        previousPoint = null;
        newPoints = new HashSet<>();
        drawColor = Color.BLUE;
        drawState = OVERLAY;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (drawState) {
            case OVERLAY:
                applyOverlay();
                previousPoint = new Point(e.getX() / gamePanel.getCellSize(), e.getY() / gamePanel.getCellSize());
                drawMode = !gameOfLife.getGrid().getCell(previousPoint.getX(), previousPoint.getY()).isAlive();
                newPoints.clear();
                updateCellState(previousPoint);
                break;
            case BRUSH:
                
                break;
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        switch (drawState) {
            case OVERLAY:
                Point currentPoint = new Point(e.getX() / gamePanel.getCellSize(), e.getY() / gamePanel.getCellSize());
                newPoints.add(currentPoint);
                if (!currentPoint.equals(previousPoint)) {
                    updateCellState(currentPoint);
                    previousPoint = currentPoint;
                }
                break;
            case BRUSH:
                break;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (drawState) {
            case OVERLAY:
                previousPoint = null;
                applyOverlay();
                break;
            case BRUSH:
        }
    }

    private void updateCellState(Point p) {
        int x = p.getX();
        int y = p.getY();
        if (x >= 0 && x < gameOfLife.getGrid().getWidth() && y >= 0 && y < gameOfLife.getGrid().getHeight()) {
            //gameOfLife.getGrid().setCell(x, y, drawMode);
            newPoints.add(p);
            gamePanel.repaint();
        }
    }

    private void applyOverlay() {
        int width = gameOfLife.getGrid().getWidth();
        int height = gameOfLife.getGrid().getHeight();
        drawColor = getRandomColor();
        for (Point p : newPoints) {
            if ( p.getX() >= 0 && p.getX() < width && p.getY() >= 0 && p.getY() < height) {
                gameOfLife.getGrid().setCell(p.getX(), p.getY(), drawMode, drawColor);
            }
        }
        newPoints.clear();
        gamePanel.setOverlay(newPoints, drawMode);
        gamePanel.repaint();
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void addMouseListener() {
        gamePanel.addMouseListener(this);
    }

    public void addMouseMotionListener() {
        gamePanel.addMouseMotionListener(this);
    }

    public void setDrawColor(Color drawColor) {
        this.drawColor = drawColor;
    }

    public Color getDrawColor() {
        return drawColor;
    }

    public Color getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }
}


