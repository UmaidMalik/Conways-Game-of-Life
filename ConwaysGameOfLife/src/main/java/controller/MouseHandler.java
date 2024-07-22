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
    private List<Point> points;

    public MouseHandler(GameOfLife gameOfLife, GamePanel gamePanel) {
        this.gameOfLife = gameOfLife;
        this.gamePanel = gamePanel;
        points = new ArrayList<>();
    }



    @Override
    public void mouseDragged(MouseEvent e) {
        if (!isDragging) return;
        toggleCell(e);
        System.out.println("Mouse dragged" + e.getX() + " " + e.getY());
        points.add(new Point(e.getX(), e.getY()));
        for (Point p : points) {
            int x = p.getX() / gamePanel.getCellSize();
            int y = p.getY() / gamePanel.getCellSize();
            if (x >= 0 && x < gameOfLife.getGrid().getWidth() && y >= 0 && y < gameOfLife.getGrid().getHeight()) {
                gameOfLife.getGrid().getCell(x, y).setAlive(true);
                gamePanel.repaint();
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        isDragging = false;

        points.clear();
        System.out.println("Mouse released");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        isDragging = true;
        toggleCell(e);
        System.out.println("Mouse pressed");
    }



    private void toggleCell(MouseEvent e) {
        if (e.getButton() != LMB) return;
        int x = e.getX() / gamePanel.getCellSize();
        int y = e.getY() / gamePanel.getCellSize();
        if (x >= 0 && x < gameOfLife.getGrid().getWidth() && y >= 0 && y < gameOfLife.getGrid().getHeight()) {
            gameOfLife.getGrid().getCell(x, y).setAlive(!gameOfLife.getGrid().getCell(x, y).isAlive());
            gamePanel.repaint();
        }
        System.out.println("X: " + x + " Y: " + y);
    }

    private class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }


    }

}


