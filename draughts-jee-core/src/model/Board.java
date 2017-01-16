package model;

import exceptions.BoardBoundsException;
import exceptions.CellEmptyException;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> board;
    private int ROWS = 10;
    private int COLS = 10;

    public Board() {
        this.board = new ArrayList<>(ROWS);
        for (int rowIndex=0; rowIndex < ROWS; rowIndex++) {
            ArrayList<Cell> row = new ArrayList<>(COLS);
            for (int colIndex = 0; colIndex < COLS; colIndex++) {
                row.add(new Cell(rowIndex, colIndex));
            }
            this.board.add(row);
        }
    }
    private void checkBoundaries(int row, int col) throws BoardBoundsException {
        if (row <= 0 || col <= 0 || row > ROWS || col > COLS) {
            throw new BoardBoundsException();
        }
    }

    public Cell getCell(int row, int col) throws BoardBoundsException {
        checkBoundaries(row, col);
        return this.board.get(row - 1).get(col - 1);
    }

    public void setCell(int row, int col, Cell cell) throws BoardBoundsException {
        checkBoundaries(row, col);
        this.board.get(row - 1).set(col - 1, cell);
    }

    public boolean hasPawn(int row, int col) throws BoardBoundsException {
        return getCell(row, col).hasPawn();
    }

    public Pawn getPawn(int row, int col) throws BoardBoundsException, CellEmptyException {
        return getCell(row, col).getPawn();
    }

    public void setPawn(int row, int col, Pawn pawn) throws BoardBoundsException {
        getCell(row, col).setPawn(pawn);
    }
}
