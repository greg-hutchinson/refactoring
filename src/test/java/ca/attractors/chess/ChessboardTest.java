package ca.attractors.chess;

import org.junit.jupiter.api.Test;

import static ca.attractors.chess.Position.A2;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ChessboardTest {
    @Test
    void construction() {
        Chessboard chessboard = new Chessboard();
        chessboard.initializeChessBoard();
        Pawn pawn1  = (Pawn) chessboard.getPieceAt(A2);
        assertEquals(A2, pawn1.getPosition());
    }
}
