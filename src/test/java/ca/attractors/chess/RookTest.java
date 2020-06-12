package ca.attractors.chess;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ca.attractors.chess.Position.*;
import static org.junit.jupiter.api.Assertions.*;

public class RookTest {
    private Chessboard chessboard;

    @BeforeEach
    void initialize() {
        chessboard = new Chessboard();
    }

    @Test
    void move() {
        Rook rook  = new Rook(chessboard);
        chessboard.putPieceAt(rook, A1);
        assertFalse(rook.moveTo(B2));
        assertTrue(rook.moveTo(A3));
        assertTrue(rook.getPosition()== A3);
        assertTrue(rook.moveTo(A1));

        Pawn pawn  = new Pawn(chessboard);
        chessboard.putPieceAt(pawn, A1);


    }


}
