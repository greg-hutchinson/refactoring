package ca.attractors.soduko;

import java.util.*;

public class Sequence {
    private final List<Position> positions;
    private final SodukoBoard board;

    @Override
    public String toString() {
        return "Sequence{" +
                "positions=" + positions +
                '}';
    }

    public Sequence(List<Position> positions, SodukoBoard board) {
        this.positions = positions;
        this.board = board;
    }

    // Should never happen
    public boolean containsDuplicates() {
        Set<KnownNumber> set = new HashSet<>(getKnownNumbers());
        return set.size() < getKnownNumbers().size();
    }

        public boolean isValid() {
        for (int i=1; i < 10; i++) {
            if (!contains(new KnownNumber(i)))
                return false;
        }
        return true;
    }


    public List<CellContents> toCellContents() {
        List<CellContents> temp = new ArrayList<>(9);
        for (Position position: positions) {
            temp.add(board.getCellContentsAt(position));
        }
        return temp;
    }
    public boolean contains(CellContents content) {
        List<CellContents> contents = toCellContents();
        return contents.contains(content);
    }

    public List<Position> markEmptyCellWithNotNumber(int i) {
        List<Position> emptyPositions = getEmptyPositions();
        for (Position position: emptyPositions) {
            board.putNotNumberAt(i, position);
        }
        return emptyPositions;
    }
    private List<Position> getEmptyPositions() {
        List<Position> emptyPositions = new ArrayList<>();
        CellContents nullContent = NullContent.getInstance();
        for (Position position: positions) {
            if (board.getCellContentsAt(position).equals(nullContent))
                emptyPositions.add(position);
        }
        return emptyPositions;
    }

    public Position getTheOnlyEmptyPosition() {
        List<Position> positions = getEmptyPositions();
        if (positions.size() == 1)
            return positions.get(0);
        return null;
    }

    public List<KnownNumber> getKnownNumbers() {
        ArrayList<KnownNumber> knownNumbers = new ArrayList<>();
        for (Position position: positions) {
            if (board.getCellContentsAt(position).isKnown())
                knownNumbers.add((KnownNumber) board.getCellContentsAt(position));
        }
        return knownNumbers;
    }
}
