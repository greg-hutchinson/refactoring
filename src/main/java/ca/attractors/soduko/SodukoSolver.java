package ca.attractors.soduko;

import java.util.*;

public class SodukoSolver {

    public SodukoBoard getBoard() {
        return board;
    }

    private final Map<Position, List<Sequence>> sequenceMap = new HashMap<>();

    private SodukoBoard board;

    public SodukoSolver(SodukoBoard board) {
        this.board = board;
    }

    public SodukoBoard solve(int depth) {
        boolean somethingChanged = true;
        while (somethingChanged) {
            somethingChanged = false;
            for (int i = 1; i <= 9; i++) {
                somethingChanged = somethingChanged | resolveNumberIfPossible(i);
            }
        }
        if (board.isValid())
            return board;
        return recurseSolve(board, depth);
    }

    private SodukoBoard recurseSolve(SodukoBoard board, int depth) {
        for (Position position: getEmptyPositions()) {
            List<KnownNumber> possibleNumbers = getPossibleNumbersFor (position);
            for (KnownNumber number: possibleNumbers) {
                SodukoBoard newBoard = new SodukoBoard(board);
//                newBoard.print("** CHOICE  Number: " + number + "depth: " + depth + " position: " + position);
                newBoard.putKnownNumberAt(number.number, position);
                newBoard = new SodukoSolver(newBoard).solve(depth + 1);
                if (newBoard.isValid()) {
                    return newBoard;
                }
            }
        }
//        board.print("Returning from Recursion depth:" + depth);
        return board;
    }

    private List<KnownNumber> getPossibleNumbersFor(Position position) {
        List<KnownNumber> all = getAllPossibleNumbers();
        Set<KnownNumber> currentKnownNumbers = getCurrentKnownsFor(position);
        for (KnownNumber number: currentKnownNumbers) {
            if (all.contains(number))
               all.remove(number);
        }

        return all;
    }

    private Set<KnownNumber> getCurrentKnownsFor(Position position) {
        List<Sequence> sequences = getAllSequencesForPosition(position);
        Set<KnownNumber> currentKnown = new HashSet<>();
        for (Sequence sequence: sequences) {
            currentKnown.addAll(sequence.getKnownNumbers());
        }
        return currentKnown;
    }

    private static List<KnownNumber> getAllPossibleNumbers() {
        List<KnownNumber> all = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            KnownNumber knownNumber = new KnownNumber(i);
            all.add(knownNumber);
        }
        return all;
    }

    private boolean resolveNumberIfPossible(int i) {
        markImpossiblePositionsFor(i);
        boolean somethingChanged = false;
        somethingChanged = markGuaranteedPositionsFor(i);
        resetImpossibleMarks();
        return somethingChanged;
    }

    private boolean markGuaranteedPositionsFor(int i) {
        boolean somethingChanged = false;
        for (Position position: getEmptyPositions()) {
            somethingChanged = somethingChanged | tryEmptyPositionWithNumber(i, position);
        }
        return somethingChanged;
    }

    private void markImpossiblePositionsFor(int i) {
        List<Position> givenPositions = getAllKnownPositionsFor(i);
        for (Position position: givenPositions) {
            List<Sequence> sequences = getAllSequencesForPosition(position);
            for (Sequence sequence: sequences) {
                sequence.markEmptyCellWithNotNumber(i);
            }
        }
    }

    private boolean tryEmptyPositionWithNumber(int i,Position position) {
        if ((position.equals(new ImpossibleNumber(i))))
            return false;
        boolean somethingChanged = false;
        List<Sequence> sequences = getAllSequencesForPosition(position);
        for (Sequence sequence: sequences) {
            Position theOnlyEmptyPosition = sequence.getTheOnlyEmptyPosition();
            if (position.equals(theOnlyEmptyPosition)) {
                CellContents old = board.getCellContentsAt(position);
                board.putKnownNumberAt(i, position);
                markAllEmptyPositionInSequencesToNotNumber(sequences, i);
                somethingChanged = true;
            }
        }
        return somethingChanged;
    }


    private void markAllEmptyPositionInSequencesToNotNumber(List<Sequence> sequences, int i) {
        for (Sequence sequence: sequences) {
            sequence.markEmptyCellWithNotNumber(i);
        }
    }

    private boolean isPositionInAllSequencesTheSame(Position position) {
        for (Sequence sequence : getAllSequencesForPosition(position)) {
            Position theOnlyEmptyPosition = sequence.getTheOnlyEmptyPosition();
            if (theOnlyEmptyPosition == null)
                return false;
            if (!(theOnlyEmptyPosition.equals(position)))
                return false;
        }
        return true;
    }

    private void resetImpossibleMarks() {
        for (Position position: Position.values()) {
            if (board.getCellContentsAt(position) instanceof ImpossibleNumber)
                board.putNullNumberAt(position);
        }
    }



    private List<Sequence> getAllSequencesForPosition(Position position) {
        if (sequenceMap.containsKey(position))
            return sequenceMap.get(position);
        List<Sequence> sequences = new ArrayList<>();
        sequences.add(new Sequence(Position.getBoxContainingPosition(position),board));
        sequences.add(new Sequence(Position.getRowContainingPosition(position),board));
        sequences.add(new Sequence(Position.getColumnContainingPosition(position),board));
        sequenceMap.put(position, sequences);
        return sequences;
    }

    private List<Position> getAllKnownPositionsFor(int i) {
        List<Position> allPositions = new ArrayList<>();
        for (Position position : Position.values()) {
            if (board.getCellContentsAt(position).equals(new KnownNumber(i)))
                allPositions.add(position);
        }
        return allPositions;
    }

        private void addPositionsTo(List<Sequence> sequences, List<List<Position>> columns) {
        for (List<Position> positions : columns) {
            sequences.add(new Sequence(positions, board));
        }
    }

    private Sequence doRowForPosition(Position position, int i) {
        Sequence sequence = getRowSequenceForPosition(position);
        doPositionInSequence(position, sequence, i);
        return sequence;
    }

    private Sequence doColumnForPosition(Position position, int i) {
        Sequence sequence = getColumnSequenceForPosition(position);
        doPositionInSequence(position, sequence, i);
        return sequence;
    }

    private Sequence doBoxForPosition(Position position, int i) {
        Sequence sequence = getBoxSequenceForPosition(position);
        doPositionInSequence(position, sequence, i);
        return sequence;
    }

    private boolean doPositionInSequence(Position position, Sequence sequence, int i) {
        if (sequence.contains(new KnownNumber(i))) {
            sequence.markEmptyCellWithNotNumber(i);
            return true;
        }
        return false;
    }


    private Sequence getRowSequenceForPosition(Position position) {
        return new Sequence(Position.getRowPositionsAt(position.row), board);
    }
    private Sequence getColumnSequenceForPosition(Position position) {
        return new Sequence(Position.getColumnPositionsAt(position.column), board);
    }
    private Sequence getBoxSequenceForPosition(Position position) {
        return new Sequence(Position.getBoxContainingPosition(position), board);
    }

    private List<Position> getEmptyPositions() {
        List<Position> emptyPositions = new ArrayList<Position>();
        for (int row = 1; row <= 9 ; row++) {
            List<Position> positions = Position.getRowPositionsAt(row);
            CellContents nullContent = NullContent.getInstance();
            for (Position position: positions) {
                if (board.getCellContentsAt(position).equals(nullContent))
                    emptyPositions.add(position);
            }

        }
        return emptyPositions;
    }
}
