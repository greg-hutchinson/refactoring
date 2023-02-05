package ca.attractors.soduko;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ca.attractors.soduko.Position.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


// What's wrong with this test?
public class PositionTest {
    @BeforeEach
    void initialize() {
    }

    @Test
    void getBoxPositionsAt() {
        List<Position> positions = Position.getBoxPositionsAt(2, 2);
        assertTrue(positions.contains(P44));
        assertTrue(positions.contains(P66));
        assertTrue(positions.contains(P46));
    }
    @Test

    void getBoxContainingPositions() {
        List<Position> positions = Position.getBoxContainingPosition(P66);
        assertTrue(positions.contains(P44));
        assertTrue(positions.contains(P66));
        assertTrue(positions.contains(P56));

        positions = Position.getBoxContainingPosition(P99);
        assertTrue(positions.contains(Position.P77));
        assertTrue(positions.contains(Position.P99));

        positions = Position.getBoxContainingPosition(P11);
        assertTrue(positions.contains(Position.P11));
        assertTrue(positions.contains(Position.P33));
    }



}
