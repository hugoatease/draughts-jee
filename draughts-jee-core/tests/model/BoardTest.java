package model;

import exceptions.BoardBoundsException;
import exceptions.CellEmptyException;
import model.Board;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    private Board board;
    private int rows;
    private int cols;

    @Before
    public void setUp() throws Exception {
        this.board = new Board();
    }

    @Test(expected = BoardBoundsException.class)
    public void cannotGetCellAtLowerBoundaries() throws BoardBoundsException {
        this.board.getCell(0, 0);
    }

    @Test(expected = BoardBoundsException.class)
    public void cannotSetCellAtLowerBoundaries() throws BoardBoundsException {
        Cell cell = new Cell(0, 0);
        this.board.setCell(0, 0, cell);
    }

    @Test(expected = BoardBoundsException.class)
    public void cannotGetCellAtUpperBoundaries() throws BoardBoundsException {
        this.board.getCell(11, 11);
    }

    @Test(expected = BoardBoundsException.class)
    public void cannotSetCellAtUpperBoundaries() throws BoardBoundsException {
        Cell cell = new Cell(0, 0);
        this.board.setCell(11, 11, cell);
    }

    @Test
    public void canGetCellInBounds() throws BoardBoundsException {
        for (int row=1; row <= 10; row++) {
            for (int col=1; col <= 10; col++) {
                this.board.getCell(row, col);
            }
        }
    }

    @Test
    public void canSetCellInBounds() throws BoardBoundsException {
        for (int row=1; row <= 10; row++) {
            for (int col=1; col <= 10; col++) {
                Cell cell = new Cell(row, col);
                this.board.setCell(row, col, cell);
            }
        }
    }

    @Test
    public void emptyBoardHasNoPawns() throws BoardBoundsException {
        for (int row=1; row <= 10; row++) {
            for (int col = 1; col <= 10; col++) {
                assertFalse(this.board.hasPawn(row, col));
            }
        }
    }

    @Test
    public void canSetAndGetPawn() throws BoardBoundsException, CellEmptyException {
        Pawn pawn = new Pawn(Pawn.PawnType.QUEEN, Pawn.PawnColor.BLACK);
        this.board.setPawn(5, 9, pawn);
        assertEquals(this.board.getPawn(5, 9), pawn);
    }
}