package controller;

import model.*;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static view.ControlPanel.*;


public class GameController implements ActionListener {


    private GameOfLife gameOfLife;
    //private Timer timer;
    private MouseHandler mouseHandler;
    private ControlPanel controlPanel;
    private int delay_ms = 25;
    private int delay_ns = 0;
    private long elapsed_time_ms = 0;
    private long elapsed_time_ns = 0;
    private Thread gameThread;
    private volatile boolean paused = true;
    private final static int MICRO_SECONDS = 1000;
    // TODO: may need to add synchronize block to prevent a race condition when reducing the delay


    public GameController(GameOfLife gameOfLife, GamePanel gamePanel, ControlPanel controlPanel) {
        this.gameOfLife = gameOfLife;
        this.controlPanel = controlPanel;

        mouseHandler = new MouseHandler(gameOfLife, gamePanel);
        //this.timer = new Timer(delay_ms, this);
        mouseHandler.addMouseListener();
        mouseHandler.addMouseMotionListener();
        controlPanel.addControlListener(this);
        createGameThread();
    }

    private void createGameThread() {
        gameThread = new Thread(() -> {
            while (true) {
                if (paused) {
                    waitHere();
                    continue;
                }
                try {
                    gameOfLife.nextGeneration();
                    mouseHandler.getGamePanel().repaint();
                    Thread.sleep(delay_ms, delay_ns);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case START:
                start();
                break;
            case STOP:
                stop();
                break;
            case SAVE:
                save();
                break;
            case LOAD:
                load();
                break;
            case CLEAR:
                clear();
                break;
            case STEP_OVER:
                stepOver();
                break;
            case GRID_LINES:
                gridLines();
                break;
            case SPEED_UP:
                speedUp();
                break;
            case SLOW_DOWN:
                slowDown();
                break;
            }
    }

    public void start() {
        System.out.println("Start button clicked");
        if (!gameThread.isAlive()) {
            gameThread.start();
        }
        paused = false;
    }

    public void stop() {
        System.out.println("Stop button clicked");
        paused = true;
    }

    public void save() {
        System.out.println("Save button clicked");
        Grid saveGrid = gameOfLife.getGrid();
        paused = true;
        for (int i = 0; i < saveGrid.getWidth(); i++) {
            for (int j = 0; j < saveGrid.getHeight(); j++) {
                System.out.print(saveGrid.getCell(i, j).isAlive() ? "1" : "0");
            }
            System.out.println();
        }
        paused = false;
    }

    public void load() {
        System.out.println("Load button clicked");
    }

    public void clear() {
        System.out.println("Clear button clicked");
        gameOfLife.getGrid().initializeGrid();
        mouseHandler.getGamePanel().repaint();
    }
    public void stepOver() {
        System.out.println("Random button clicked");
        paused = true;
        gameOfLife.nextGeneration();
        mouseHandler.getGamePanel().repaint();
    }

    public void gridLines() {
        System.out.println("Grid Lines button clicked");
        mouseHandler.getGamePanel().setDisplayGridLines(!mouseHandler.getGamePanel().getDisplayGridLines());
        mouseHandler.getGamePanel().repaint();
    }

    public int getTimeDelayMilli() {
        return delay_ms;
    }

    public int getTimeDelayNano() {
        return delay_ns;
    }

    public void setTimeDelayMilli(int delay) {
        delay_ms = delay;
    }

    public void setTimeDelayNano(int delay) {
        delay_ns = delay;
    }

    public void slowDown() {
        delay_ms = (int) (1.1 * delay_ms);
        System.out.println("Delay ms: " + delay_ms);
    }

    public void speedUp() {

        delay_ms = (int) (0.9 * delay_ms);
        System.out.println("Delay ms: " + delay_ms);
    }

    private void updateElapsedTime() {
        elapsed_time_ms += System.currentTimeMillis();
        elapsed_time_ns = System.nanoTime();
    }

    private void waitHere() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
