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
        GameOfLife gameOfLife = GameOfLife.getInstance();
        ControlPanel controlPanel = new ControlPanel();
        gameOfLife.setGrid(grid);
        GamePanel gamePanel = new GamePanel(gameOfLife.getGrid());
        GameController gameController = new GameController(gameOfLife, gamePanel, controlPanel);
        // Set layout and add panels

        frame.setLayout(new BorderLayout());
        frame.add(gamePanel, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);

        // Make the frame visible
        frame.setVisible(true);

        gamePanel.paintComponent(frame.getGraphics());
        gameController.start();
    }
}
