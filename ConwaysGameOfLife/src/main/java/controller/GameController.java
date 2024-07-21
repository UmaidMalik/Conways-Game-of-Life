package controller;

import model.*;
import view.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {


    private GameOfLife gameOfLife;
    private Timer timer;
    private MouseHandler mouseHandler;
    private ControlListener controlListener;
    private ControlPanel controlPanel;
    private GamePanel gamePanel;
    private int delay = 1000;


    public GameController(GameOfLife gameOfLife, GamePanel gamePanel, ControlPanel controlPanel) {
        this.gameOfLife = gameOfLife;
        this.controlPanel = controlPanel;
        this.gamePanel = gamePanel;
        mouseHandler = new MouseHandler(gameOfLife, gamePanel);

        this.timer = new Timer(1000, this);
        controlPanel.addControlListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            System.out.println("Timer ticked");
            gameOfLife.nextGeneration();
            gamePanel.repaint();
        } else if (e.getSource() == controlPanel.startButton) {
            start();
        } else if (e.getSource() == controlPanel.stopButton) {
            stop();
        } else if (e.getSource() == controlPanel.saveButton) {
            save();
        } else if (e.getSource() == controlPanel.loadButton) {
            load();
        } else if (e.getSource() == controlPanel.clearButton) {
            clear();
        } else if (e.getSource() == controlPanel.randomButton) {
            random();
        }
    }

    public void start() {
        System.out.println("Start button clicked");
        gameOfLife.nextGeneration();
        gamePanel.repaint();
        controlPanel.addControlListener(this);
    }

    public void stop() {
        System.out.println("Stop button clicked");
    }

    public void save() {
        System.out.println("Save button clicked");
    }

    public void load() {
        System.out.println("Load button clicked");
    }

    public void clear() {
        System.out.println("Clear button clicked");
        gameOfLife.getGrid().initializeGrid();
        gamePanel.repaint();
    }

    public void random() {
        System.out.println("Random button clicked");
    }
}
