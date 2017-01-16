import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PawnTest {
    private Pawn whitePawn;
    private Pawn blackPawn;
    private Pawn whiteQueen;
    private Pawn blackQueen;

    @Before
    public void setUp() throws Exception {
        this.whitePawn = new Pawn(Pawn.PawnType.PAWN, Pawn.PawnColor.WHITE);
        this.blackPawn = new Pawn(Pawn.PawnType.PAWN, Pawn.PawnColor.BLACK);
        this.whiteQueen = new Pawn(Pawn.PawnType.QUEEN, Pawn.PawnColor.WHITE);
        this.blackQueen = new Pawn(Pawn.PawnType.QUEEN, Pawn.PawnColor.BLACK);
    }

    @Test
    public void getPawnType() throws Exception {
        assertEquals(this.whitePawn.getPawnType(), Pawn.PawnType.PAWN);
        assertEquals(this.blackPawn.getPawnType(), Pawn.PawnType.PAWN);
        assertEquals(this.whiteQueen.getPawnType(), Pawn.PawnType.QUEEN);
        assertEquals(this.blackQueen.getPawnType(), Pawn.PawnType.QUEEN);
    }

    @Test
    public void setPawnType() throws Exception {
        this.whitePawn.setPawnType(Pawn.PawnType.QUEEN);
        assertEquals(this.whitePawn.getPawnType(), Pawn.PawnType.QUEEN);

        this.blackPawn.setPawnType(Pawn.PawnType.QUEEN);
        assertEquals(this.blackPawn.getPawnType(), Pawn.PawnType.QUEEN);

        this.whiteQueen.setPawnType(Pawn.PawnType.PAWN);
        assertEquals(this.whiteQueen.getPawnType(), Pawn.PawnType.PAWN);

        this.blackQueen.setPawnType(Pawn.PawnType.PAWN);
        assertEquals(this.blackQueen.getPawnType(), Pawn.PawnType.PAWN);
    }

    @Test
    public void getPawnColor() throws Exception {
        assertEquals(this.whitePawn.getPawnColor(), Pawn.PawnColor.WHITE);
        assertEquals(this.blackPawn.getPawnColor(), Pawn.PawnColor.BLACK);
        assertEquals(this.whiteQueen.getPawnColor(), Pawn.PawnColor.WHITE);
        assertEquals(this.blackQueen.getPawnColor(), Pawn.PawnColor.BLACK);
    }

    @Test
    public void setPawnColor() throws Exception {
        this.whitePawn.setPawnColor(Pawn.PawnColor.BLACK);
        assertEquals(this.whitePawn.getPawnColor(), Pawn.PawnColor.BLACK);

        this.whiteQueen.setPawnColor(Pawn.PawnColor.BLACK);
        assertEquals(this.whiteQueen.getPawnColor(), Pawn.PawnColor.BLACK);

        this.blackPawn.setPawnColor(Pawn.PawnColor.WHITE);
        assertEquals(this.blackPawn.getPawnColor(), Pawn.PawnColor.WHITE);

        this.blackQueen.setPawnColor(Pawn.PawnColor.WHITE);
        assertEquals(this.blackQueen.getPawnColor(), Pawn.PawnColor.WHITE);
    }

}