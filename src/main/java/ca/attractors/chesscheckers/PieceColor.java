package ca.attractors.chesscheckers;

public enum PieceColor {
    Black, White;

    public String toSimpleString() {
        return toString().substring(0, 1);
    }
}
