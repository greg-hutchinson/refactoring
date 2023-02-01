package ca.attractors.chess;


import ca.attractors.chesscheckers.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ca.attractors.chesscheckers.Position.*;
import static ca.attractors.chesscheckers.PieceColor.*;

import static org.junit.jupiter.api.Assertions.*;

public class RookTest {
    private Board chessboard;
    private Rook rook;

    @BeforeEach
    void initialize() {
        chessboard = new Board();
        rook  = new Rook(White, chessboard, D4);
    }

    @Test
    void moveToNonHorizontalOrVerticalSpot() {

        assertFalse(rook.moveTo(B2));
    }
    @Test
    void moveToOccupiedCellOfSameColor() {
        Rook rook2 = new Rook(White, chessboard, D3);
        Runnable ignore = () -> {};
        rook2.moveTo(D3, ignore);
        assertFalse(rook.moveTo(D3));
    }

    @Test
    void moveToOccupiedCellOfDifferentColor() {
        Rook rook2 = new Rook(Black, chessboard,D1);
        assertTrue(rook.moveTo(D1));
        assertSame(rook.getPosition(), D1);
        assertNull (chessboard.getPieceAt(D4));
    }

    @Test
    void moveVerticallyWithUnoccupiedCells() {
        assertTrue(rook.moveTo(D8));
        assertSame(rook.getPosition(), D8);
    }
    @Test
    void moveVerticallyToCellWithOccupiedCellsInBetween() {
        Rook rook2 = new Rook(Black, chessboard, D7);
        assertFalse(rook.moveTo(D8));
    }

    @Test
    void moveHorizontallyWithUnoccupiedCells() {
        assertTrue(rook.moveTo(A4));
        assertSame(rook.getPosition(), A4);
    }

    @Test
    void moveHorizontallyToCellWithOccupiedCellsInBetween() {
        Rook rook2 = new Rook(Black, chessboard, C4 );
        assertFalse(rook.moveTo(A4));
    }

}
