package ca.attractors.chess;

import ca.attractors.chesscheckers.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ca.attractors.chesscheckers.PieceColor.White;
import static ca.attractors.chesscheckers.Position.*;
import static org.junit.jupiter.api.Assertions.*;

public class KnightTest {
    private Board chessboard;
    private Knight knight;

    @BeforeEach
    void initialize() {
        chessboard = new Board();
        knight = new Knight(White, chessboard, D4);
    }

    @Test
    void canMoveToUnoccupiedCell() {
        assertTrue(knight.isValidMove(F5));
        assertTrue(knight.isValidMove(F3));
        assertTrue(knight.isValidMove(B5));
        assertTrue(knight.isValidMove(B3));
    }

    @Test
    void canMoveToInvalidCell3StepsAway() {
        assertFalse(knight.isValidMove(D7));
    }
}
