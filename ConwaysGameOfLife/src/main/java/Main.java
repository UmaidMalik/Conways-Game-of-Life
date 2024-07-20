import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Handler;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        JFrame frame = new JFrame("Conway's Game of Life");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.pack();
        frame.setVisible(true);

        Grid grid = new Grid(400, 300);
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
        frame.add(gamePanel);


        while (true) {
            grid.printGrid();
            grid.update();
            gamePanel.paintComponent(frame.getGraphics());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
