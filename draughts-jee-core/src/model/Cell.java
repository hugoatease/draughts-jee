package model;

import exceptions.CellEmptyException;

public class Cell {
    private Pawn pawn;

    public Cell() {}

    public Cell(Cell cell) {
        if (cell.hasPawn()) {
            try {
                setPawn(cell.getPawn());
            } catch (CellEmptyException e) {
                e.printStackTrace();
            }
        }
    }

    public Cell(Pawn pawn) {
        this.pawn = pawn;
    }

    public boolean hasPawn() {
        return this.pawn != null;
    }

    public Pawn getPawn() throws CellEmptyException {
        if (!hasPawn()) {
            throw new CellEmptyException();
        }
        return this.pawn;
    }

    public void setPawn(Pawn pawn) {
        this.pawn = pawn;
    }
}
