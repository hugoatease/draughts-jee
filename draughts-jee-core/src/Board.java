import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Pawn>> board;
    private int ROWS = 10;
    private int COLS = 10;

    public Board() {
        this.board = new ArrayList<>(ROWS);
        for (int rowIndex=0; rowIndex < ROWS; rowIndex++) {
            ArrayList<Pawn> row = new ArrayList<>(COLS);
            for (int colIndex = 0; colIndex < COLS; colIndex++) {
                row.add(null);
            }
            this.board.add(row);
        }
    }

    public Pawn getSquare(int row, int col) {
        return this.board.get(row).get(col);
    }

    public void setSquare(int row, int col, Pawn pawn) {
        this.board.get(row).set(col, pawn);
    }
}
