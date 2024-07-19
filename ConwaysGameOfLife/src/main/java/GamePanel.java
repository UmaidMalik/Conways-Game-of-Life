import javax.swing.JPanel;
import java.awt.Graphics;

public class GamePanel extends JPanel {

    //private GameOfLife gameOfLife;
    private Grid grid;
    private int cellSizeX;
    private int cellSizeY;

    public GamePanel(Grid grid) {
        this.grid = grid;
        // TODO will delete 2 lines below
        setCellSize(1, 1);
    }

    public void setCellSize(int x, int y){
        cellSizeX = x;
        cellSizeY = y;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < grid.getWidth(); i++) {
            for (int j = 0; j < grid.getHeight(); j++) {
                if (grid.getCell(i, j).isAlive()) {
                    g.fillRect(i, j,  cellSizeX, cellSizeY);
                    //g.drawRect(i,j,1,1);
                }
            }
        }
    }

    public int getCellSizeX(){
        return cellSizeX;
    }

    public int getCellSizeY(){
        return cellSizeY;
    }

}
