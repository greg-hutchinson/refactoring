package ca.attractors.chess;

import ca.attractors.chess.ChessBoardBuilder;
import ca.attractors.chess.Rook;
import ca.attractors.chesscheckers.Board;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;


// What's wrong with this test?
public class BoardBuilderTest {
    private Board chessboard;
    private Rook rook;

    @BeforeEach
    void initialize() {
        chessboard = new ChessBoardBuilder().build();
    }

}
