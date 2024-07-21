package controller;

import model.GameOfLife;
import view.GamePanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {

    private GameOfLife gameOfLife;
    private GamePanel gamePanel;

    public MouseHandler(GameOfLife gameOfLife, GamePanel gamePanel) {
        this.gameOfLife = gameOfLife;
        this.gamePanel = gamePanel;
    }



    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        int x = e.getX() / gamePanel.getCellSize();
        int y = e.getY() / gamePanel.getCellSize();
        toggleCell(x, y);
        System.out.println("Mouse dragged");
    }



    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX() / gamePanel.getCellSize();
        int y = e.getY() / gamePanel.getCellSize();
        toggleCell(x, y);
        System.out.println("Mouse pressed");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println("Mouse moved");
    }


    private void toggleCell(int x, int y) {
        gameOfLife.getGrid().setCell(x, y, !gameOfLife.getGrid().getCell(x, y).isAlive());
        gamePanel.repaint();
    }



}
