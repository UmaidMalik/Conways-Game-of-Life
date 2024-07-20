import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel {

    private Grid grid;
    private int cellSize;

    public GamePanel(Grid grid) {
        this.grid = grid;
        setCellSize(10);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < grid.getWidth(); i++) {
            for (int j = 0; j < grid.getHeight(); j++) {
                if (grid.getCell(i, j).isAlive()) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
            }
        }

        //drawGridLines();
    }


    protected void drawGridLines() {
        Graphics g = getGraphics();
        g.setColor(Color.GRAY);
        for (int i = 0; i <= grid.getWidth(); i++) {
            g.drawLine(i * cellSize, 0, i * cellSize, grid.getHeight() * cellSize);
        }
        for (int i = 0; i <= grid.getHeight(); i++) {
            g.drawLine(0, i * cellSize, grid.getWidth() * cellSize, i * cellSize);
        }
    }

    public int getCellSize() {
        return cellSize;
    }

    public void setCellSize(int size){
        cellSize = size;
    }

}
