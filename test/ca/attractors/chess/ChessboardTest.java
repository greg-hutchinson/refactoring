package ca.attractors.chess;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessboardTest {
    @Test
    void construction() {
        Chessboard chessboard = new Chessboard();
        Pawn pawn1  = (Pawn) chessboard.getPieceAt(0, 0);
        assertEquals(0, pawn1.getX());
    }
}
