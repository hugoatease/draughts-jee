package model;

import exceptions.BoardBoundsException;
import exceptions.CellEmptyException;
import exceptions.IllegalMoveException;
import model.Board;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {
    private Board board;

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

    @Test
    public void isBoardCorrectlyInitialized() throws BoardBoundsException, CellEmptyException {
        Pawn.PawnColor[][] pawns = {
                {Pawn.PawnColor.WHITE, null, Pawn.PawnColor.WHITE, null, Pawn.PawnColor.WHITE, null, Pawn.PawnColor.WHITE, null, Pawn.PawnColor.WHITE, null},
                {null, Pawn.PawnColor.WHITE, null, Pawn.PawnColor.WHITE, null, Pawn.PawnColor.WHITE, null, Pawn.PawnColor.WHITE, null, Pawn.PawnColor.WHITE},
                {Pawn.PawnColor.WHITE, null, Pawn.PawnColor.WHITE, null, Pawn.PawnColor.WHITE, null, Pawn.PawnColor.WHITE, null, Pawn.PawnColor.WHITE, null},
                {null, Pawn.PawnColor.WHITE, null, Pawn.PawnColor.WHITE, null, Pawn.PawnColor.WHITE, null, Pawn.PawnColor.WHITE, null, Pawn.PawnColor.WHITE},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {Pawn.PawnColor.BLACK, null, Pawn.PawnColor.BLACK, null, Pawn.PawnColor.BLACK, null, Pawn.PawnColor.BLACK, null, Pawn.PawnColor.BLACK, null},
                {null, Pawn.PawnColor.BLACK, null, Pawn.PawnColor.BLACK, null, Pawn.PawnColor.BLACK, null, Pawn.PawnColor.BLACK, null, Pawn.PawnColor.BLACK},
                {Pawn.PawnColor.BLACK, null, Pawn.PawnColor.BLACK, null, Pawn.PawnColor.BLACK, null, Pawn.PawnColor.BLACK, null, Pawn.PawnColor.BLACK, null},
                {null, Pawn.PawnColor.BLACK, null, Pawn.PawnColor.BLACK, null, Pawn.PawnColor.BLACK, null, Pawn.PawnColor.BLACK, null, Pawn.PawnColor.BLACK},
        };

        this.board.initialize();

        for (int row=1; row <= 10; row++) {
            for (int col=1; col <= 10; col++) {
                if (pawns[row - 1][col - 1] == null) {
                    assertFalse(this.board.hasPawn(row, col));
                }
                else {
                    assertEquals(this.board.getPawn(row, col).getPawnColor(), pawns[row - 1][col - 1]);
                }
            }
        }
    }

    @Test
    public void checkInitialTurnIsWhite() {
        this.board.initialize();
        assertEquals(this.board.getCurrentTurn(), Pawn.PawnColor.WHITE);
    }

    @Test
    public void checkSecondTurnIsBlack() throws IllegalMoveException {
        this.board.initialize();
        this.board.playTurn(4, 2, 5, 3);
        assertEquals(this.board.getCurrentTurn(), Pawn.PawnColor.BLACK);
    }

    @Test
    public void checkThirdTurnIsWhite() throws IllegalMoveException {
        this.board.initialize();
        this.board.playTurn(4, 2, 5, 3);
        this.board.playTurn(7, 3, 6, 2);
        assertEquals(this.board.getCurrentTurn(), Pawn.PawnColor.WHITE);
    }

    @Test
    public void checkWhitesCountIsCorrect() throws BoardBoundsException {
        this.board.setPawn(1, 2, new Pawn(Pawn.PawnColor.WHITE));
        this.board.setPawn(1, 3, new Pawn(Pawn.PawnColor.BLACK));
        this.board.setPawn(1, 4, new Pawn(Pawn.PawnColor.WHITE));
        this.board.setPawn(1, 5, new Pawn(Pawn.PawnColor.WHITE));
        this.board.setPawn(2, 1, new Pawn(Pawn.PawnColor.BLACK));
        this.board.setPawn(2, 2, new Pawn(Pawn.PawnColor.WHITE));

        assertEquals(this.board.pawnCount(Pawn.PawnColor.WHITE), 4);
    }

    @Test
    public void checkBlacksCountIsCorrect() throws BoardBoundsException {
        this.board.setPawn(8, 1, new Pawn(Pawn.PawnColor.WHITE));
        this.board.setPawn(8, 2, new Pawn(Pawn.PawnColor.BLACK));
        this.board.setPawn(8, 3, new Pawn(Pawn.PawnColor.WHITE));
        this.board.setPawn(8, 4, new Pawn(Pawn.PawnColor.WHITE));
        this.board.setPawn(7, 2, new Pawn(Pawn.PawnColor.BLACK));
        this.board.setPawn(7, 1, new Pawn(Pawn.PawnColor.WHITE));

        assertEquals(this.board.pawnCount(Pawn.PawnColor.BLACK), 2);
    }

    @Test
    public void whitePawnCanMoveLegally() throws CellEmptyException, BoardBoundsException, IllegalMoveException {
        this.board.initialize();
        this.board.getPawn(4, 2);
        this.board.playTurn(4, 2, 5, 3);
        assertEquals(this.board.getPawn(5, 3).getPawnColor(), Pawn.PawnColor.WHITE);
        assertEquals(this.board.getPawn(5, 3).getPawnType(), Pawn.PawnType.PAWN);

        this.board.playTurn(5, 3, 6, 2);
        assertEquals(this.board.getPawn(6, 2).getPawnColor(), Pawn.PawnColor.WHITE);
        assertEquals(this.board.getPawn(6, 2).getPawnType(), Pawn.PawnType.PAWN);
    }

    @Test(expected = IllegalMoveException.class)
    public void whitePawnCannotGoBackwards() throws BoardBoundsException, IllegalMoveException {
        this.board.setPawn(4, 2, new Pawn(Pawn.PawnType.PAWN, Pawn.PawnColor.WHITE));
        this.board.playTurn(4, 2, 3, 3);
    }

    @Test(expected = IllegalMoveException.class)
    public void whitePawnCannotMoveUp() throws BoardBoundsException, IllegalMoveException {
        this.board.setPawn(4, 2, new Pawn(Pawn.PawnType.PAWN, Pawn.PawnColor.WHITE));
        this.board.playTurn(4, 2, 4, 3);
    }

    @Test(expected = IllegalMoveException.class)
    public void whitePawnCannotMoveLeft() throws BoardBoundsException, IllegalMoveException {
        this.board.setPawn(4, 2, new Pawn(Pawn.PawnType.PAWN, Pawn.PawnColor.WHITE));
        this.board.playTurn(4, 2, 3, 2);
    }

    @Test(expected = IllegalMoveException.class)
    public void whitePawnCannotMoveRight() throws BoardBoundsException, IllegalMoveException {
        this.board.setPawn(4, 2, new Pawn(Pawn.PawnType.PAWN, Pawn.PawnColor.WHITE));
        this.board.playTurn(4, 2, 5, 2);
    }

    @Test(expected = IllegalMoveException.class)
    public void whitePawnCannotSuperposeBlackPawn() throws BoardBoundsException, IllegalMoveException {
        this.board.setPawn(4, 2, new Pawn(Pawn.PawnType.PAWN, Pawn.PawnColor.WHITE));
        this.board.setPawn(5, 3, new Pawn(Pawn.PawnType.PAWN, Pawn.PawnColor.BLACK));
        this.board.playTurn(4, 2, 5, 3);
    }
}