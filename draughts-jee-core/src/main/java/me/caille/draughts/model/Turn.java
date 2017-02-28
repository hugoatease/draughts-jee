package me.caille.draughts.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Turn {
    @Column(name = "src_row")
    private int srcRow;
    @Column(name = "src_col")
    private int srcCol;

    @Column(name = "dst_row")
    private int dstRow;

    @Column(name = "dst_col")
    private int dstCol;

    public Turn() {

    }

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
