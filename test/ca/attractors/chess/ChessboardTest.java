package ca.attractors.chess;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessboardTest {
    @Test
    void move() {
        Chessboard chessboard = new Chessboard();
        Pawn pawn1  = (Pawn) chessboard.getPieceAt('a', 1);
        assertNotNull(pawn1);

        chessboard.move(pawn1, 'a',3);
        assertNull (chessboard.getPieceAt('a', 1));

        Pawn pawn2  = (Pawn) chessboard.getPieceAt('a', 3);
        assertEquals(pawn1, pawn2);
    }
}