package me.caille.draughts.model;

import me.caille.draughts.exceptions.CellEmptyException;

public class Cell {
    private Pawn pawn;
    private int row;
    private int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Cell(int row, int col, Pawn pawn) {
        this(row, col);
        this.pawn = pawn;
    }

    public Cell(Cell cell) {
        setRow(cell.getRow());
        setCol(cell.getCol());

        if (cell.hasPawn()) {
            try {
                setPawn(cell.getPawn());
            } catch (CellEmptyException e) {
                e.printStackTrace();
            }
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
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
