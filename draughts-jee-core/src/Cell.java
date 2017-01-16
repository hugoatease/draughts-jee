public class Cell {
    private Pawn pawn;

    public Cell() {}

    public Cell(Cell cell) {
        setPawn(cell.getPawn());
    }

    public Cell(Pawn pawn) {
        this.pawn = pawn;
    }

    public boolean hasPawn() {
        return this.pawn != null;
    }

    public Pawn getPawn() {
        return this.pawn;
    }

    public void setPawn(Pawn pawn) {
        this.pawn = pawn;
    }
}
