package ca.attractors.chess;

import ca.attractors.chesscheckers.Board;

public class ChessGame {

    private Board chessboard;
    public ChessGame (Board chessboard) {
        this.chessboard = chessboard;
    }
    public ChessGame newDefaultGame() {
        chessboard = new ChessBoardBuilder().build();
        return new ChessGame(chessboard);
    }


}
