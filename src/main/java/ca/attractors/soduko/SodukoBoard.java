package ca.attractors.soduko;

import java.util.ArrayList;
import java.util.List;

public class SodukoBoard {
    final String FRAME =  "++----+----+----++----+----+----++----+----+----++\n";
    private CellContents[][] cells = new CellContents[9][9];
    public  static boolean shouldPrint = false;

    public SodukoBoard() {
        for (int y = 8; y >= 0; y--) {
            for (int x = 0; x < 9; x++) {
                cells[y][x] = NullContent.getInstance();
            }
        }
    }

    public SodukoBoard(CellContents[][] cells) {
        this.cells = cells;
    }

    @SuppressWarnings("CopyConstructorMissesField")
    public SodukoBoard(SodukoBoard board) {
        this();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                this.cells[i][j] = CellContents.newInstance(board.cells[i][j]);
        }
    }

    public void print(String message) {
        if (!shouldPrint)
            return;
//        System.out.println(message + "\n\n"  + this);
//        System.out.println("\n\n-----");
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(FRAME);
        for (int row = 0; row <= 8; row++) {
            int count = 0;
            for (int column = 0; column < 9; column++) {
                builder.append("|");
                if (count++ % 3 == 0)
                    builder.append("|");
                builder.append(cells[row][column].toString());
            }
            builder.append("||\n" + FRAME);
            if ((row+1) % 3 == 0)
                builder.append(FRAME);

        }
        return builder.toString();
    }

    public void putCellContentsAt(CellContents contents, Position position) {
//        CellContents old = cells[position.getXOffset()][position.getYOffset()];
        cells[position.getXOffset()][position.getYOffset()] = contents;
        /*
        Sequence sequence1 = this.checkAllSequences();
        if (sequence1 != null) {
            System.out.println("Something went wrong in sequence " + sequence1);
            System.out.println("Something went wrong old value " + old);
            System.out.println("\n\n" + this);
            System.out.println("\n\n-----");
        }
         */
    }

    public void putNullNumberAt(Position position) {
        putCellContentsAt(NullContent.getInstance(), position);
    }

    public void putNotNumberAt(int number, Position position)  {
        putCellContentsAt(new ImpossibleNumber(number), position);
    }

    public void putKnownNumberAt(int number, Position position) {
//        this.print("Currently setting " + position + " with " + number + "\n");
        putCellContentsAt(new KnownNumber(number), position);
    }


    public Sequence checkAllSequences() {
        for (Sequence sequence:getAllSequences()) {
            if (sequence.containsDuplicates())
                return sequence;
        }
        return null;
    }
    private List<Sequence> getAllSequences() {
        List<Sequence> sequences = new ArrayList<>();
        for (List<Position> positions: Position.getAllSequences()) {
            sequences.add(new Sequence(positions,this));
        }
        return sequences;
    }


    public CellContents getCellContentsAt(Position position)  {
        return cells[position.getXOffset()][position.getYOffset()];
    }

    public boolean isValid() {
        for (List<Position> positions: Position.getAllRows()) {
            Sequence sequence = new Sequence(positions, this);
            if (!sequence.isValid())
                return false;
        }
        for (List<Position> positions: Position.getAllColumns()) {
            Sequence sequence = new Sequence(positions, this);
            if (!sequence.isValid())
                return false;
        }
        List<List<Position>> allBoxes = Position.getAllBoxes();
        for (List<Position> positions: allBoxes) {
            Sequence sequence = new Sequence(positions, this);
            if (!sequence.isValid())
                return false;
        }
        return true;
    }

}
