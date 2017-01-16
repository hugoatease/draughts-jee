package model;

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
                row.add(null);
            }
            this.board.add(row);
        }
    }


}
