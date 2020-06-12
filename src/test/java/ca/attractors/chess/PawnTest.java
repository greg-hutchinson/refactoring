package ca.attractors.chess;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ca.attractors.chess.Position.A2;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {
    private Chessboard chessboard;

    @BeforeEach
    void initialize() {
        chessboard = new Chessboard();
    }

    @Test
    void construction() {
        chessboard.initializeChessBoard();
        Pawn pawn1  = (Pawn) chessboard.getPieceAt(A2);
        assertEquals(A2, pawn1.getPosition());
    }

}
