package ca.attractors.chess;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessboardTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void move() {
        Rook rook = new Rook();
        Chessboard chessboard = new Chessboard();
        chessboard.move(rook, 'a',1);
        Piece piece  = chessboard.getPieceAt('a', 1);
        assertEquals(piece, rook);

    }
}