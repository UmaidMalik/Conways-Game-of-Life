public class GameOfLife {
    //TODO: Add observer for getting the generation count
    private Grid grid;
    private int generation;
    private static GameOfLife gameOfLife;

    private GameOfLife(int width, int height) {
        grid = new Grid(width, height);
        generation = 0;
    }

    public static GameOfLife getInstanceOfGameOfLife(int width, int height) {
        if (gameOfLife == null) {
            gameOfLife = new GameOfLife(width, height);
        }
        return gameOfLife;
    }

    public void nextGeneration() {
        grid.update();
        generation++;
    }

    public Grid getGrid() {
        return grid;
    }

    public int getGeneration() {
        return generation;
    }




}
