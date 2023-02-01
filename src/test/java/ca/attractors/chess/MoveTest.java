package ca.attractors.chess;


import ca.attractors.chesscheckers.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ca.attractors.chesscheckers.PieceColor.White;
import static ca.attractors.chesscheckers.Position.*;
import static org.junit.jupiter.api.Assertions.*;

public class MoveTest {
    private Board chessboard;
    private Move move;

    @BeforeEach
    void initialize() {
        chessboard = new Board();
    }

    @Test
    void isPathBlocked() {
        Rook rook1 = new Rook(White, chessboard, A1);
        move = new Move(rook1, A6);
        assertFalse(move.isPathBlocked());

        Rook rook2 = new Rook(White, chessboard, A2);
        assertTrue(move.isPathBlocked());
    }
}
