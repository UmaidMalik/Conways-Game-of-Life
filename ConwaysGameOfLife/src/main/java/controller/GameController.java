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
    private ControlPanel controlPanel;
    private int delay_ms = 25;
    private int delay_ns = 0;
    private Thread gameThread;
    private boolean running = true;


    public GameController(GameOfLife gameOfLife, GamePanel gamePanel, ControlPanel controlPanel) {
        this.gameOfLife = gameOfLife;
        this.controlPanel = controlPanel;

        mouseHandler = new MouseHandler(gameOfLife, gamePanel);
        this.timer = new Timer(delay_ms, this);
        mouseHandler.addMouseListener();
        mouseHandler.addMouseMotionListener();
        controlPanel.addControlListener(this);
        createGameThread();
    }

    private void createGameThread() {
        gameThread = new Thread(() -> {
            while (true) {
                System.out.println("Timer ticked");
                gameOfLife.nextGeneration();
                mouseHandler.getGamePanel().repaint();
                try {
                    Thread.sleep(delay_ms, delay_ns);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            System.out.println("Timer ticked");
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
        } else if (e.getSource() == controlPanel.stepOverButton) {
            random();
        }

    }

    public void start() {
        System.out.println("Start button clicked");
        //timer.start();
        if (!gameThread.isAlive()) {
            createGameThread();
            System.out.println("Game thread interrupted");
        }
        gameThread.start();
    }

    public void stop() {
        System.out.println("Stop button clicked");
        timer.stop();
        gameThread.interrupt();
    }

    public void save() {
        System.out.println("Save button clicked");
        Grid saveGrid = gameOfLife.getGrid();
        gameThread.interrupt();
        for (int i = 0; i < saveGrid.getWidth(); i++) {
            for (int j = 0; j < saveGrid.getHeight(); j++) {
                System.out.print(saveGrid.getCell(i, j).isAlive() ? "1" : "0");
            }
            System.out.println();
        }
    }

    public void load() {
        System.out.println("model.Load button clicked");
    }

    public void clear() {
        System.out.println("Clear button clicked");
        gameOfLife.getGrid().initializeGrid();
        mouseHandler.getGamePanel().repaint();
    }

    public void random() {
        System.out.println("Random button clicked");
        gameThread.interrupt();
            gameOfLife.nextGeneration();
            mouseHandler.getGamePanel().repaint();

    }

}
