public class GameOfLife {
    //TODO: Add observer for getting the generation count
    private Grid grid;
    private int generation;
    private static GameOfLife gameOfLife;

    private GameOfLife() {
        generation = 0;
    }

    public static GameOfLife getInstance() {
        if (gameOfLife == null) {
            gameOfLife = new GameOfLife();
        }
        return gameOfLife;
    }

    public void nextGeneration() {
        grid.update();
        generation++;
    }

    public void createGrid(int width, int height) {
        grid = new Grid(width, height);
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public int getGeneration() {
        return generation;
    }




}
