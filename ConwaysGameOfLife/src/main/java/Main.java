import controller.*;
import model.*;
import view.*;


import javax.swing.*;
import java.awt.*;
import java.util.Timer;

public class Main {

    public static void main(String[] args) {

        GameOfLifeApp.launch();
        /*
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

        grid.setCell(2, 24, true);
        grid.setCell(4, 21, true);
        grid.setCell(5, 22, true);
        grid.setCell(5, 23, true);
        grid.setCell(5, 24, true);
        grid.setCell(5, 25, true);
        grid.setCell(4, 25, true);
        grid.setCell(3, 25, true);
        grid.setCell(2, 24, true);

        grid.setCell(32, 4, true);
        grid.setCell(34, 1, true);
        grid.setCell(35, 2, true);
        grid.setCell(35, 3, true);
        grid.setCell(35, 4, true);
        grid.setCell(35, 5, true);
        grid.setCell(34, 5, true);
        grid.setCell(33, 5, true);
        grid.setCell(32, 4, true);

        grid.setCell(52, 24, true);
        grid.setCell(54, 21, true);
        grid.setCell(55, 22, true);
        grid.setCell(55, 23, true);
        grid.setCell(55, 24, true);
        grid.setCell(55, 25, true);
        grid.setCell(54, 25, true);
        grid.setCell(53, 25, true);
        grid.setCell(52, 24, true);
        GameOfLife gameOfLife = GameOfLife.getInstance();
        gameOfLife.setGrid(grid);
        GamePanel gamePanel = new GamePanel(gameOfLife);



        // Set layout and add panels

        frame.setLayout(new BorderLayout());


        // Make the frame visible
        frame.setVisible(true);

        while (true) {
            //grid.printGrid();
            //grid.update();

            //gamePanel.paintComponent(frame.getGraphics());
            gameOfLife.nextGeneration();
            gamePanel.repaint();


            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

         */



    }


}
