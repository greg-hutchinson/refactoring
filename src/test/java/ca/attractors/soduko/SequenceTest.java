package ca.attractors.soduko;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import java.util.List;

import static ca.attractors.chesscheckers.PieceColor.White;
import static ca.attractors.chesscheckers.Position.A1;
import static ca.attractors.chesscheckers.Position.D4;
import static org.junit.jupiter.api.Assertions.*;


// What's wrong with this test?
public class SequenceTest {
    @BeforeEach
    void initialize() {
    }

    @Test
    void isValid() {
        SodukoBoard board = new SodukoBoard();
        List<Position> positions = Position.getBoxPositionsAt(1, 1);
        int i = 1;
        for (Position position: positions)
        {
            board.putKnownNumberAt(i++, position);
        }
        Sequence sequence = new Sequence(positions, board);
        assertTrue(sequence.isValid());
        Position anyPosition = positions.get(0);
        board.putNotNumberAt(1, anyPosition);
        sequence = new Sequence(positions, board);
        assertFalse(sequence.isValid());
    }

}
