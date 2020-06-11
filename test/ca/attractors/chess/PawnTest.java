package ca.attractors.chess;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static ca.attractors.chess.Position.*;

class PawnTest {
    Chessboard chessboard;

    @BeforeAll
    void initialize() {
        Chessboard chessboard = new Chessboard();
    }

    @Test
    void construction() {
        Pawn pawn1  = (Pawn) chessboard.getPieceAt(A2);
        assertEquals(A2, pawn1.getPosition());
    }


}
