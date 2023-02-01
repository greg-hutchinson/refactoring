package ca.attractors.soduko;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


// What's wrong with this test?
public class SodukoSolverTest {
    @BeforeEach
    void initialize() {
    }

    @Test
    void solvableWithoutRecursion() {
        SodukoSolver sodukoSolver = getSodukoSolverFor("solvable-given.csv");
        Date start = new Date();
        SodukoBoard board = sodukoSolver.solve(0);
        Date finish = new Date();
        long time = finish.getTime() - start.getTime();
        System.out.println("Time = " + time);
        System.out.println("\n\n" + board);
        System.out.println("\n\n-----");
        assertTrue(board.isValid());
    }

    @Test
    void solvableWithRecursion() {
        SodukoBoard.shouldPrint = false;
        SodukoSolver sodukoSolver = getSodukoSolverFor("part-solvable-given.csv");
        Date start = new Date();
        SodukoBoard board  = sodukoSolver.solve(0);
        Date finish = new Date();
        long time = finish.getTime() - start.getTime();
        System.out.println("Time = " + time);
        assertTrue(board.isValid());
    }

    private static SodukoSolver getSodukoSolverFor(String fileName) {
        File file = new SodukoBoardBuilderTest().getTestFile(fileName);
        SodukoBoardBuilder sodukoBoardBuilder = new SodukoBoardBuilder();
        SodukoBoard board = sodukoBoardBuilder.build(file);
        System.out.println("New board\n\n" + board);
        System.out.println("-----");
        SodukoSolver sodukoSolver = new SodukoSolver(board);
        return sodukoSolver;
    }
    @Test
    void cloningOfBoard() {
        SodukoSolver sodukoSolver = getSodukoSolverFor("part-solvable-given.csv");
        SodukoBoard board = sodukoSolver.getBoard();
        SodukoBoard newBoard = new SodukoBoard(board);
 //       assertEquals(board, newBoard);
    }

}
