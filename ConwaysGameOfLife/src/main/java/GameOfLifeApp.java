import controller.*;
import model.*;
import view.*;

import javax.swing.*;
import java.awt.*;

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

        Grid grid = new Grid(256, 144);
        grid.setCell(2, 4, true);
        grid.setCell(4, 1, true);
        grid.setCell(5, 2, true);
        grid.setCell(5, 3, true);
        grid.setCell(5, 4, true);
        grid.setCell(5, 5, true);
        grid.setCell(4, 5, true);
        grid.setCell(3, 5, true);


        grid.setCell(2, 24, true);
        grid.setCell(4, 21, true);
        grid.setCell(5, 22, true);
        grid.setCell(5, 23, true);
        grid.setCell(5, 24, true);
        grid.setCell(5, 25, true);
        grid.setCell(4, 25, true);
        grid.setCell(3, 25, true);


        grid.setCell(32, 4, true);
        grid.setCell(34, 1, true);
        grid.setCell(35, 2, true);
        grid.setCell(35, 3, true);
        grid.setCell(35, 4, true);
        grid.setCell(35, 5, true);
        grid.setCell(34, 5, true);
        grid.setCell(33, 5, true);


        grid.setCell(52, 24, true);
        grid.setCell(54, 21, true);
        grid.setCell(55, 22, true);
        grid.setCell(55, 23, true);
        grid.setCell(55, 24, true);
        grid.setCell(55, 25, true);
        grid.setCell(54, 25, true);
        grid.setCell(53, 25, true);

        int x_offset = 100;
        int y_offset = 100;
        // oscillator
        // top left
        grid.setCell(0 + x_offset, 2 + y_offset, true);
        grid.setCell(0 + x_offset, 3 + y_offset, true);
        grid.setCell(0 + x_offset, 4 + y_offset, true);
        grid.setCell(2 + x_offset, 0 + y_offset, true);
        grid.setCell(3 + x_offset, 0 + y_offset, true);
        grid.setCell(4 + x_offset, 0 + y_offset, true);
        grid.setCell(5 + x_offset, 2 + y_offset, true);
        grid.setCell(5 + x_offset, 3 + y_offset, true);
        grid.setCell(5 + x_offset, 4 + y_offset, true);
        grid.setCell(2 + x_offset, 5 + y_offset, true);
        grid.setCell(3 + x_offset, 5 + y_offset, true);
        grid.setCell(4 + x_offset, 5 + y_offset, true);

        grid.setCell(2 + x_offset, 7 + y_offset, true);
        grid.setCell(3 + x_offset, 7 + y_offset, true);
        grid.setCell(4 + x_offset, 7 + y_offset, true);
        grid.setCell(x_offset, 8 + y_offset, true);
        grid.setCell(x_offset, 9 + y_offset, true);
        grid.setCell(x_offset, 10 + y_offset, true);
        grid.setCell(5 + x_offset, 8 + y_offset, true);
        grid.setCell(5 + x_offset, 9 + y_offset, true);
        grid.setCell(5 + x_offset, 10 + y_offset, true);
        grid.setCell(2 + x_offset, 12 + y_offset, true);
        grid.setCell(3 + x_offset,12  + y_offset, true);
        grid.setCell(4 + x_offset,12  + y_offset, true);

        grid.setCell(7 + x_offset, 2 + y_offset, true);
        grid.setCell(7 + x_offset, 3 + y_offset, true);
        grid.setCell(7 + x_offset, 4 + y_offset, true);
        grid.setCell(8 + x_offset, 0 + y_offset, true);
        grid.setCell(9 + x_offset, 0 + y_offset, true);
        grid.setCell(10 + x_offset,0 + y_offset, true);
        grid.setCell(8 + x_offset, 5 + y_offset, true);
        grid.setCell(9 + x_offset, 5 + y_offset, true);
        grid.setCell(10 + x_offset,5 + y_offset, true);
        grid.setCell(12 + x_offset,2 + y_offset, true);
        grid.setCell(12 + x_offset,3 + y_offset, true);
        grid.setCell(12 + x_offset,4  + y_offset, true);

        grid.setCell(7 + x_offset,8 + y_offset, true);
        grid.setCell(7 + x_offset,9 + y_offset, true);
        grid.setCell(7 + x_offset,10 + y_offset, true);
        grid.setCell(8 + x_offset,7 + y_offset, true);
        grid.setCell(9 + x_offset,7 + y_offset, true);
        grid.setCell(10 + x_offset,7 + y_offset, true);
        grid.setCell(8 + x_offset,12 + y_offset, true);
        grid.setCell(9 + x_offset,12 + y_offset, true);
        grid.setCell(10 + x_offset,12 + y_offset, true);
        grid.setCell(12 + x_offset,8 + y_offset, true);
        grid.setCell(12 + x_offset,9 + y_offset, true);
        grid.setCell(12 + x_offset,10 + y_offset, true);





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