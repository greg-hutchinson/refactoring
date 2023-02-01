package ca.attractors.chesscheckers;

import ca.attractors.chess.ChessBoardBuilder;
import ca.attractors.chess.Rook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ca.attractors.chesscheckers.PieceColor.White;
import static ca.attractors.chesscheckers.Position.*;
import static org.junit.jupiter.api.Assertions.*;


// What's wrong with this test?
public class BoardTest {
    private Board chessboard;
    private Rook rook;

    @BeforeEach
    void initialize() {
        chessboard = new Board();
        rook  = new Rook(White, chessboard, D4);
    }

    @Test
    void getPieceAt() {
        assertSame(rook, chessboard.getPieceAt(D4));
    }

    @Test
    void movePieceTo() {
        chessboard.movePieceTo(rook, A1);
        assertNull(chessboard.getPieceAt(D4));
        assertSame(rook, chessboard.getPieceAt(A1));
    }

    @Test
    void getPositionOf() {
        assertSame(D4, chessboard.getPositionOf(rook));
    }

    @Test
    void testToString() {
        chessboard = new ChessBoardBuilder().build();
        String chessboardString = chessboard.toString();
        System.out.println(chessboardString);
    }

}
