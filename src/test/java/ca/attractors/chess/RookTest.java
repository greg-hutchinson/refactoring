package ca.attractors.chess;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ca.attractors.chess.Position.*;

import static org.junit.jupiter.api.Assertions.*;

public class RookTest {
    private Chessboard chessboard;
    private Rook rook;

    @BeforeEach
    void initialize() {
        chessboard = new Chessboard();
        rook  = new Rook(chessboard);
        chessboard.putPieceAt(rook, D4);
    }

    @Test
    void getPosition() {
        assertSame(D4, rook.getPosition());
    }

    @Test
    void moveToNonHorizontalOrVerticalSpot() {
        assertFalse(rook.moveTo(B2));
    }

    @Test
    void moveVerticallyWithUnoccupiedCells() {
        assertTrue(rook.moveTo(D8));
        assertSame(rook.getPosition(), D8);
    }

    //FIXME, GH, Uncomment this test - Change Constructor signature

/*
    @Test
    void moveVerticallyWithBlockedPath() {
        Rook rook1 = new Rook(chessboard, Black);
        chessboard.putPieceAt(rook, D6);
        assertFalse(rook.moveTo(D8));
    }
*/
}
