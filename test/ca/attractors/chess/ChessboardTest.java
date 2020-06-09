package ca.attractors.chess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static ca.attractors.chess.Position.*;


class ChessboardTest {
    @Test
    void construction() {
        Chessboard chessboard = new Chessboard();
        Pawn pawn1  = (Pawn) chessboard.getPieceAt(A2);
        assertEquals(A2, pawn1.getPosition());
    }
}
