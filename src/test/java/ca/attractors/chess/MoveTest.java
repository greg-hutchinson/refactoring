package ca.attractors.chess;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ca.attractors.chess.PieceColor.White;
import static ca.attractors.chess.Position.*;
import static org.junit.jupiter.api.Assertions.*;

public class MoveTest {
    private Chessboard chessboard;
    private Move move;

    @BeforeEach
    void initialize() {
        chessboard = new Chessboard();
    }

    @Test
    void isDiagonal() {
        Move move = new Move(A1, C3, chessboard);
        assertTrue(move.isDiagonal());
    }
    @Test
    void isNotDiagonal() {
        Move move = new Move(A1, C4, chessboard);
        assertFalse(move.isDiagonal());
    }

    @Test
    void isHorizontal() {
        Move move = new Move(A1, F1, chessboard);
        assertTrue(move.isHorizontal());
    }

    @Test
    void isNotHorizontal() {
        Move move = new Move(A1, A6, chessboard);
        assertFalse(move.isHorizontal());
    }
    @Test
    void isVertical() {
        Move move = new Move(A1, A6, chessboard);
        assertFalse(move.isHorizontal());
    }
    @Test
    void isNotVertical() {
        Move move = new Move(A1, F3, chessboard);
        assertFalse(move.isVertical());
    }

    @Test
    void isLine() {
        Move move = new Move(A1, A6, chessboard);
        assertTrue(move.isLine());
        move = new Move(A1, F1, chessboard);
        assertTrue(move.isLine());
        move = new Move(A1, E5, chessboard);
        assertTrue(move.isLine());
        move = new Move(A1, C5, chessboard);
        assertFalse(move.isLine());
    }

    @Test
    void isPathBlocked() {
        Rook rook1 = new Rook(chessboard, White);
        chessboard.putPieceAt(rook1, A2);
        Move move = new Move(A1, A6, chessboard);
        assertTrue(move.isPathBlocked());
    }
}
