package ca.attractors.chesscheckers;

public interface Piece {
    PieceColor getColor();
    default Position getPosition() {
        return  getBoard().getPositionOf(this);
    }
    Board getBoard();
}
