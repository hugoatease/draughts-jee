import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    private Board board;

    @Before
    public void doBefore() {
        board = new Board();
    }

    @Test
    public void canGetEmptySquare() {
        assertNull(board.getSquare(1,4));
    }
}