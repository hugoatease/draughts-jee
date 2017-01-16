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
        this.cell = new Cell();
        assertFalse(this.cell.hasPawn());
    }

    @Test
    public void filledCellHasPawn() {
        this.cell = new Cell(this.pawn);
        assertTrue(this.cell.hasPawn());
    }

    @Test
    public void canGetPawnInCell() {
        this.cell = new Cell(this.pawn);
        assertEquals(this.cell.getPawn(), this.pawn);
    }

    @Test
    public void canSetPawnInCell() {
        this.cell = new Cell();
        this.cell.setPawn(this.pawn);
        assertEquals(this.cell.getPawn(), this.pawn);
    }
}