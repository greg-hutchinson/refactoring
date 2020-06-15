package ca.attractors.chess;

import org.junit.jupiter.api.Test;

import static ca.attractors.chess.Position.*;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;


public class ChessboardTest {
    @Test
    void movePieceTo() {
        Chessboard chessboard = new Chessboard();
        Rook rook = new Rook(chessboard, PieceColor.White);
        chessboard.putPieceAt(rook, A1);
        chessboard.movePieceTo(rook, A5);
        assertSame(rook, chessboard.getPieceAt(A5));
        assertNull(chessboard.getPieceAt(A1));
    }
}
