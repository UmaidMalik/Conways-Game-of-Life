public class Grid {

    private Cell[][] cells;
    private int width, height;
    private Cell[][] nextGeneration;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        initializeGrid();
    }

    public void initializeGrid() {
        cells = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                cells[i][j] = new Cell(false);
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }

    public void setCell(int x, int y, boolean isAlive) {
        cells[x][y].setAlive(isAlive);
    }

    public void update() {
        createCopyOfGrid();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int aliveNeighbours = countAliveNeighbors(i, j);
                applyGameOfLifeRule(i, j, aliveNeighbours);
            }
        }
        cells = nextGeneration;
    }

    public int countAliveNeighbors(int i, int j) {
        int aliveNeighbors = 0;
        for (int x = i - 1; x <= i + 1; x++) {
            for (int y = j - 1; y <= j + 1; y++) {
                if (x >= 0 && x < width && y >= 0 && y < height && !(x == i && y == j) && cells[x][y].isAlive()) {
                    aliveNeighbors++;
                }
            }
        }
        return aliveNeighbors;
    }

    private void applyGameOfLifeRule(int i, int j, int aliveNeighbours) {
        if (cells[i][j].isAlive()) {
            if (aliveNeighbours < 2 || aliveNeighbours > 3) {
                nextGeneration[i][j].setAlive(false);
            }
        } else {
            if (aliveNeighbours == 3) {
                nextGeneration[i][j].setAlive(true);
            }
        }
    }

    private void createCopyOfGrid() {
        nextGeneration = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                nextGeneration[i][j] = new Cell(cells[i][j].isAlive());
            }
        }
    }

    public void printGrid() {
        for (int i = 0; i < width; i++) {
            System.out.print("|");
            for (int j = 0; j < height; j++) {

                System.out.print(cells[i][j].isAlive() ? "X " : "  ");
            }
            System.out.print("|");
            System.out.println();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                sb.append(cells[i][j].isAlive() ? "X " : "  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
