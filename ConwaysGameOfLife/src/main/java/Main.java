import controller.*;
import model.*;
import view.*;


import javax.swing.*;
import java.awt.*;
import java.util.Timer;

public class Main {

    public static void main(String[] args) {

        //GameOfLifeApp.launch();

        JFrame frame = new JFrame("Conway's Game of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        //frame.pack();

        Grid grid = new Grid(80, 60);
        grid.setCell(2, 4, true);
        grid.setCell(4, 1, true);
        grid.setCell(5, 2, true);
        grid.setCell(5, 3, true);
        grid.setCell(5, 4, true);
        grid.setCell(5, 5, true);
        grid.setCell(4, 5, true);
        grid.setCell(3, 5, true);
        grid.setCell(2, 4, true);
        GamePanel gamePanel = new GamePanel(grid);
        //gamePanel.paintComponent(frame.getGraphics());
        GameOfLife gameOfLife = GameOfLife.getInstance();
        gameOfLife.setGrid(grid);

        // Set layout and add panels

        frame.setLayout(new BorderLayout());


        // Make the frame visible
        frame.setVisible(true);

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


    }


}
