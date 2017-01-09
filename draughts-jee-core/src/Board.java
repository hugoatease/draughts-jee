import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Pawn>> board;
    private int ROWS = 10;
    private int COLS = 10;

    public Board() {
        this.board = new ArrayList<>(this.ROWS);
        for (int i=0; i < this.COLS; i++) {
            this.board.set(i, new ArrayList<>(this.COLS));
        }
    }

    private Pawn getSquare(int row, int col) {
        return this.board.get(row).get(col);
    }

    private void setSquare(int row, int col, Pawn pawn) {
        this.board.get(row).set(col, pawn);
    }
}
