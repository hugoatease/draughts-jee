package model;

public class Turn {
    private int srcRow;
    private int srcCol;

    private int dstRow;
    private int dstCol;

    public Turn(int srcRow, int srcCol, int dstRow, int dstCol) {
        this.srcRow = srcRow;
        this.srcCol = srcCol;
        this.dstRow = dstRow;
        this.dstCol = dstCol;
    }

    public int getSrcRow() {
        return srcRow;
    }

    public int getSrcCol() {
        return srcCol;
    }

    public int getDstRow() {
        return dstRow;
    }

    public int getDstCol() {
        return dstCol;
    }
}
