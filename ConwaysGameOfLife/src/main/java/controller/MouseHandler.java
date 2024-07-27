package controller;

import model.GameOfLife;
import model.Point;
import view.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;

public class MouseHandler extends MouseAdapter {

    private GameOfLife gameOfLife;
    private GamePanel gamePanel;
    private boolean drawMode;
    private Point previousPoint;
    private Set<Point> newPoints;

    public MouseHandler(GameOfLife gameOfLife, GamePanel gamePanel) {
        this.gameOfLife = gameOfLife;
        this.gamePanel = gamePanel;
        drawMode = true;
        previousPoint = null;
        newPoints = new HashSet<>();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        applyOverlay();
        previousPoint = new Point(e.getX() / gamePanel.getCellSize(), e.getY() / gamePanel.getCellSize());
        drawMode = !gameOfLife.getGrid().getCell(previousPoint.getX(), previousPoint.getY()).isAlive();
        newPoints.clear();
        updateCellState(previousPoint);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point currentPoint = new Point(e.getX() / gamePanel.getCellSize(), e.getY() / gamePanel.getCellSize());
        newPoints.add(currentPoint);
        if (!currentPoint.equals(previousPoint)) {
            updateCellState(currentPoint);
            previousPoint = currentPoint;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        previousPoint = null;
        applyOverlay(); // (if set to false, we use this as a draw hold)
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
        for (Point p : newPoints) {
            if ( p.getX() >= 0 && p.getX() < width && p.getY() >= 0 && p.getY() < height) {
                gameOfLife.getGrid().setCell(p.getX(), p.getY(), drawMode, Color.BLUE);
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
}


