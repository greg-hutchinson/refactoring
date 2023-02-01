package ca.attractors.chess;


import ca.attractors.chesscheckers.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ca.attractors.chesscheckers.PieceColor.*;
import static ca.attractors.chesscheckers.Position.*;
import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {
    private Board chessboard;
    private Pawn pawn;

    @BeforeEach
    void initialize() {
        chessboard = new Board();
    }

    @Test
    void moveOneCellForward() {
        pawn = new Pawn(White, chessboard, A2 );
        assertTrue(pawn.moveTo(A3));
    }
    @Test
    void moveTwoCellsForward() {
        pawn = new Pawn(White, chessboard, A2 );
        assertTrue(pawn.moveTo(A4));
    }

    @Test
    void moveTwoCellsForwardAfterFirstMove() {
        pawn = new Pawn(White, chessboard, A2 );
        assertTrue(pawn.moveTo(A4));
 //       assertFalse(pawn.moveTo(A6));
    }

}
