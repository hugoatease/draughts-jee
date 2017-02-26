package me.caille.draughts.model;

import exceptions.CellEmptyException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {
    private Cell cell;
    private Pawn pawn;

    @Before
    public void setUp() throws Exception {
        this.pawn = new Pawn(Pawn.PawnType.QUEEN, Pawn.PawnColor.BLACK);
    }

    @Test
    public void emptyCellHasNoPawn() {
        this.cell = new Cell(1, 1);
        assertFalse(this.cell.hasPawn());
    }

    @Test
    public void filledCellHasPawn() {
        this.cell = new Cell(1, 1, this.pawn);
        assertTrue(this.cell.hasPawn());
    }

    @Test
    public void canGetPawnInCell() {
        this.cell = new Cell(1, 1, this.pawn);
        try {
            assertEquals(this.cell.getPawn(), this.pawn);
        } catch (CellEmptyException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void canSetPawnInCell() {
        this.cell = new Cell(1, 1);
        this.cell.setPawn(this.pawn);
        try {
            assertEquals(this.cell.getPawn(), this.pawn);
        } catch (CellEmptyException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = CellEmptyException.class)
    public void getEmptyCellThrowsException() throws CellEmptyException {
        this.cell = new Cell(1, 1);
        this.cell.getPawn();
    }
}