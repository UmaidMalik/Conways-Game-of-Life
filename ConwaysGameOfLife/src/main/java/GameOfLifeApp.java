import controller.*;
import model.*;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameOfLifeApp implements Runnable {

    public static void launch() {
        System.out.println("Starting Conway's Game of Life...");
        SwingUtilities.invokeLater(new GameOfLifeApp());
    }

    @Override
    public void run() {
        buildAndDisplayGUI();
    }

    private void buildAndDisplayGUI() {
        JFrame frame = new JFrame("Conway's Game of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setResizable(true);
        Color cellColor = Color.WHITE;

        int X, Y, R;
        R = 200;
        int state = 1;



        //Grid grid = new Grid(2048, 1152);
        //Grid grid = new Grid(512, 288);
        //Grid grid = new Grid(256, 144);
        Grid grid = new Grid(512, 267);


        grid.setCell(2, 4, state, cellColor);
        grid.setCell(4, 1, state, cellColor);
        grid.setCell(5, 2, state, cellColor);
        grid.setCell(5, 3, state, cellColor);
        grid.setCell(5, 4, state, cellColor);
        grid.setCell(5, 5, state, cellColor);
        grid.setCell(4, 5, state, cellColor);
        grid.setCell(3, 5, state, cellColor);
        Random random = new Random();
            for (int i = -R; i <= R; i++) {
                X = (int) Math.round(Math.sqrt(R * R - i * i));

                for (int u = -X; u <= X; u++) {


                    grid.setCell(i + 40, u + 40, random.nextInt(2), Color.RED);
                    grid.setCell(u + 40, i + 40, random.nextInt(2), Color.BLUE);

                }
                //grid.setCell(X + 40, i + 40, true, Color.RED);
                //grid.setCell(-X + 40, i + 40, true, Color.RED);
                //grid.setCell(i + 40, X + 40, true, Color.RED);
                //grid.setCell(i + 40, -X + 40, true, Color.RED);
            }



        grid.setCell(2, 24, state, cellColor);
        grid.setCell(4, 21, state, cellColor);
        grid.setCell(5, 22, state, cellColor);
        grid.setCell(5, 23, state, cellColor);
        grid.setCell(5, 24, state, cellColor);
        grid.setCell(5, 25, state, cellColor);
        grid.setCell(4, 25, state, cellColor);
        grid.setCell(3, 25, state, cellColor);


        grid.setCell(32, 4, state, cellColor);
        grid.setCell(34, 1, state, cellColor);
        grid.setCell(35, 2, state, cellColor);
        grid.setCell(35, 3, state, cellColor);
        grid.setCell(35, 4, state, cellColor);
        grid.setCell(35, 5, state, cellColor);
        grid.setCell(34, 5, state, cellColor);
        grid.setCell(33, 5, state, cellColor);


        grid.setCell(52, 24, state, cellColor);
        grid.setCell(54, 21, state, cellColor);
        grid.setCell(55, 22, state, cellColor);
        grid.setCell(55, 23, state, cellColor);
        grid.setCell(55, 24, state, cellColor);
        grid.setCell(55, 25, state, cellColor);
        grid.setCell(54, 25, state, cellColor);
        grid.setCell(53, 25, state, cellColor);

        int x_offset = 100;
        int y_offset = 100;
        // oscillator
        // top left
        grid.setCell(0 + x_offset, 2 + y_offset, state, cellColor);
        grid.setCell(0 + x_offset, 3 + y_offset, state, cellColor);
        grid.setCell(0 + x_offset, 4 + y_offset, state, cellColor);
        grid.setCell(2 + x_offset, 0 + y_offset, state, cellColor);
        grid.setCell(3 + x_offset, 0 + y_offset, state, cellColor);
        grid.setCell(4 + x_offset, 0 + y_offset, state, cellColor);
        grid.setCell(5 + x_offset, 2 + y_offset, state, cellColor);
        grid.setCell(5 + x_offset, 3 + y_offset, state, cellColor);
        grid.setCell(5 + x_offset, 4 + y_offset, state, cellColor);
        grid.setCell(2 + x_offset, 5 + y_offset, state, cellColor);
        grid.setCell(3 + x_offset, 5 + y_offset, state, cellColor);
        grid.setCell(4 + x_offset, 5 + y_offset, state, cellColor);

        grid.setCell(2 + x_offset, 7 + y_offset, state, cellColor);
        grid.setCell(3 + x_offset, 7 + y_offset, state, cellColor);
        grid.setCell(4 + x_offset, 7 + y_offset, state, cellColor);
        grid.setCell(x_offset, 8 + y_offset, state, cellColor);
        grid.setCell(x_offset, 9 + y_offset, state, cellColor);
        grid.setCell(x_offset, 10 + y_offset, state, cellColor);
        grid.setCell(5 + x_offset, 8 + y_offset, state, cellColor);
        grid.setCell(5 + x_offset, 9 + y_offset, state, cellColor);
        grid.setCell(5 + x_offset, 10 + y_offset, state, cellColor);
        grid.setCell(2 + x_offset, 12 + y_offset, state, cellColor);
        grid.setCell(3 + x_offset,12  + y_offset, state, cellColor);
        grid.setCell(4 + x_offset,12  + y_offset, state, cellColor);

        grid.setCell(7 + x_offset, 2 + y_offset, state, cellColor);
        grid.setCell(7 + x_offset, 3 + y_offset, state, cellColor);
        grid.setCell(7 + x_offset, 4 + y_offset, state, cellColor);
        grid.setCell(8 + x_offset, 0 + y_offset, state, cellColor);
        grid.setCell(9 + x_offset, 0 + y_offset, state, cellColor);
        grid.setCell(10 + x_offset,0 + y_offset, state, cellColor);
        grid.setCell(8 + x_offset, 5 + y_offset, state, cellColor);
        grid.setCell(9 + x_offset, 5 + y_offset, state, cellColor);
        grid.setCell(10 + x_offset,5 + y_offset, state, cellColor);
        grid.setCell(12 + x_offset,2 + y_offset, state, cellColor);
        grid.setCell(12 + x_offset,3 + y_offset, state, cellColor);
        grid.setCell(12 + x_offset,4  + y_offset, state, cellColor);

        grid.setCell(7 + x_offset,8 + y_offset, state, cellColor);
        grid.setCell(7 + x_offset,9 + y_offset, state, cellColor);
        grid.setCell(7 + x_offset,10 + y_offset, state, cellColor);
        grid.setCell(8 + x_offset,7 + y_offset, state, cellColor);
        grid.setCell(9 + x_offset,7 + y_offset, state, cellColor);
        grid.setCell(10 + x_offset,7 + y_offset, state, cellColor);
        grid.setCell(8 + x_offset,12 + y_offset, state, cellColor);
        grid.setCell(9 + x_offset,12 + y_offset, state, cellColor);
        grid.setCell(10 + x_offset,12 + y_offset, state, cellColor);
        grid.setCell(12 + x_offset,8 + y_offset, state, cellColor);
        grid.setCell(12 + x_offset,9 + y_offset, state, cellColor);
        grid.setCell(12 + x_offset,10 + y_offset, state, cellColor);


        // horizontal glider
        grid.setCell(5 + 50, 0 + 40, state);
        grid.setCell(6 + 50, 1 + 40, state);
        grid.setCell(6 + 50, 2 + 40, state);
        grid.setCell(6 + 50, 3 + 40, state);
        grid.setCell(50, 2 + 40, state);
        grid.setCell(1 + 50, 3 + 40, state);
        grid.setCell(2 + 50, 3 + 40, state);
        grid.setCell(3 + 50, 3 + 40, state);
        grid.setCell(4 + 50, 3 + 40, state);
        grid.setCell(5 + 50, 3 + 40, state);
        grid.setCell(6 + 50, 3 + 40, state);

        //GameOfLife gameOfLife = GameOfLife.getInstance();
        GameOfLife gameOfLife = new GameOfLife();
        ControlPanel controlPanel = new ControlPanel();
        gameOfLife.setGrid(grid);
        GamePanel gamePanel = new GamePanel(gameOfLife);
        new GameController(gameOfLife, gamePanel, controlPanel);
        // Set layout and add panels

        frame.setLayout(new BorderLayout());
        frame.add(gamePanel, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);

        // Make the frame visible
        frame.setVisible(true);
        gamePanel.paintComponent(frame.getGraphics());
    }
}
/*
JFrame frame = new JFrame("Conway's Game of Life");








        while (true) {
            //grid.printGrid();
            //grid.update();
            //gamePanel.repaint();
            gamePanel.paintComponent(frame.getGraphics());
            gameOfLife.nextGeneration();


            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
 */