public class Pawn {
    public enum PawnType {
        PAWN,
        QUEEN
    }

    public enum PawnColor {
        BLACK,
        WHITE
    }

    private PawnType pawnType = PawnType.PAWN;
    private PawnColor pawnColor;

    public Pawn(PawnType pawnType, PawnColor pawnColor) {
        this.pawnType = pawnType;
        this.pawnColor = pawnColor;
    }

    public Pawn(PawnColor pawnColor) {
        this.pawnColor = pawnColor;
    }

    public Pawn(Pawn pawn) {
        setPawnType(pawn.getPawnType());
        setPawnColor(pawn.getPawnColor());
    }

    public PawnType getPawnType() {
        return pawnType;
    }

    public void setPawnType(PawnType pawnType) {
        this.pawnType = pawnType;
    }

    public PawnColor getPawnColor() {
        return pawnColor;
    }

    public void setPawnColor(PawnColor pawnColor) {
        this.pawnColor = pawnColor;
    }
}
