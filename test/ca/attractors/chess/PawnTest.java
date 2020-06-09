package ca.attractors.chess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PawnTest {
    @Test
    void construction() {
        Chessboard chessboard = new Chessboard();
        Pawn pawn1  = new Pawn(chessboard,1,1);
        assertEquals(1, pawn1.getX());
        assertEquals(chessboard.getPieceAt(1,1), pawn1);
    }
}
