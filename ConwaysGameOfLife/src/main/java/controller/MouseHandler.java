package controller;

import model.GameOfLife;
import view.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class MouseHandler extends MouseAdapter {

    private static final int LMB = MouseEvent.BUTTON1; // left mouse button
    private boolean isDragging = false;
    private GameOfLife gameOfLife;
    private GamePanel gamePanel;
    private boolean currentCellState;
    private final Point p;

    public MouseHandler(GameOfLife gameOfLife, GamePanel gamePanel) {
        this.gameOfLife = gameOfLife;
        this.gamePanel = gamePanel;
        p = new Point();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        toggleCell(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() != LMB) return;
        currentCellState = gameOfLife.getGrid().getCell(p.x, p.y).isAlive();
        toggleCell(e);
    }

    private void toggleCell(MouseEvent e) {
        p.x = e.getX() / gamePanel.getCellSize();
        p.y = e.getY() / gamePanel.getCellSize();
        if (p.x >= 0 && p.x < gameOfLife.getGrid().getWidth() && p.y >= 0 && p.y < gameOfLife.getGrid().getHeight()) {
            gameOfLife.getGrid().getCell(p.x, p.y).setAlive(!currentCellState);
            gamePanel.repaint();
        }
    }

    private static class Point {
        int x, y;
        public Point() {
        }
    }



}


