
import model.Grid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridTest {


    private Grid grid;
    private int state;


    @BeforeEach
    public void setup() {
        grid = new Grid(10, 10);
        state = 1;

    }

    @Test
    public void testCountAliveNeighbors() {
        grid.setCell(2, 4, state);       //     0  1  2  3  4  5  6  7  8  9
        grid.setCell(4, 1, state);       //  0  x  x  x  x  x  x  x  x  x  x
        grid.setCell(5, 2, state);       //  1  x  x  x  x  x  x  x  x  x  x
        grid.setCell(5, 3, state);       //  2  x  x  x  x  O  x  x  x  x  x
        grid.setCell(7, 3, state);       //  3  x  x  x  x  x  x  x  x  x  x
        grid.setCell(7, 5, state);       //  4  x  O  x  x  x  x  x  x  x  x
        grid.setCell(6, 6, state);       //  5  x  x  0  0  x  x  x  x  x  x
        grid.setCell(7, 6, state);       //  6  x  x  x  x  x  x  0  0  0  x
        grid.setCell(8, 6, state);       //  7  x  x  x  0  x  0  0  x  0  x
        grid.setCell(6, 7, state);       //  8  x  x  x  x  x  x  0  0  0  x
        grid.setCell(6, 8, state);       //  9  x  x  x  x  x  x  x  x  x  x
        grid.setCell(8, 7, state);       //
        grid.setCell(8, 8, state);       //
        grid.setCell(7, 8, state);       //

        //assertEquals(5, grid.countAliveNeighbors(7, 6));
        //assertEquals(8, grid.countAliveNeighbors(7, 7));
        //assertEquals(3, grid.countAliveNeighbors(6, 3));
        //assertEquals(2, grid.countAliveNeighbors(5, 1));
        //assertEquals(3, grid.countAliveNeighbors(9, 7));
        //assertEquals(1, grid.countAliveNeighbors(9, 9));
    }
}
