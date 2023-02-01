package ca.attractors.soduko;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.abs;

public enum Position {
    P11(1, 1),P12(1, 2),  P13(1, 3),P14(1, 4),P15(1, 5),  P16(1, 6), P17(1, 7), P18(1, 8),P19(1, 9),
    P21(2, 1),P22(2, 2),  P23(2, 3),P24(2, 4),P25(2, 5),  P26(2, 6), P27(2, 7), P28(2, 8),P29(2, 9),
    P31(3, 1),P32(3, 2),  P33(3, 3),P34(3, 4),P35(3, 5),  P36(3, 6), P37(3, 7), P38(3, 8),P39(3, 9),
    P41(4, 1),P42(4, 2),  P43(4, 3),P44(4, 4),P45(4, 5),  P46(4, 6), P47(4, 7), P48(4, 8),P49(4, 9),
    P51(5, 1),P52(5, 2),  P53(5, 3),P54(5, 4),P55(5, 5),  P56(5, 6), P57(5, 7), P58(5, 8),P59(5, 9),
    P61(6, 1),P62(6, 2),  P63(6, 3),P64(6, 4),P65(6, 5),  P66(6, 6), P67(6, 7), P68(6, 8),P69(6, 9),
    P71(7, 1),P72(7, 2),  P73(7, 3),P74(7, 4),P75(7, 5),  P76(7, 6), P77(7, 7), P78(7, 8),P79(7, 9),
    P81(8, 1),P82(8, 2),  P83(8, 3),P84(8, 4),P85(8, 5),  P86(8, 6), P87(8, 7), P88(8, 8),P89(8, 9),
    P91(9, 1),P92(9, 2),  P93(9, 3),P94(9, 4),P95(9, 5),  P96(9, 6), P97(9, 7), P98(9, 8),P99(9, 9);


    final int row;
    final int column;

    Position(int x, int y) {
        this.row = x;
        this.column = y;
    }

    public static List<List<Position>> getAllSequences() {
        List<List<Position>> rows = new ArrayList<List<ca.attractors.soduko.Position>>(27);
        rows.addAll(getAllRows());
        rows.addAll(getAllColumns());
        rows.addAll(getAllBoxes());
        return rows;
    }

    public static List<List<Position>> getAllRows() {
        List<List<Position>> rows = new ArrayList<List<Position>>(9);
        for (int i = 1; i <= 9; i++) {
            rows.add(getRowPositionsAt(i));
        }
        return rows;
    }
    public static List<List<Position>> getAllColumns() {
        List<List<Position>> columns = new ArrayList<List<Position>>(9);
        for (int i = 1; i <= 9; i++) {
            columns.add(getColumnPositionsAt(i));
        }
        return columns;
    }
    public static List<List<Position>> getAllBoxes() {
        List<List<Position>> columns = new ArrayList<List<Position>>(9);
        for (int row = 1; row <= 3; row++) {
            for (int col = 1; col <= 3; col++)
            columns.add(getBoxPositionsAt(row,col));
        }
        return columns;
    }

    int getXOffset() {
        return row - 1;
    }
    int getYOffset() {
        return column - 1;
    }

/**
    static List<Position> getTopLeftToBottomRightPositions () {
        return Arrays.stream(values()).toList();
    }
*/
    public static List<Position> getRowContainingPosition(Position position) {
        return getRowPositionsAt(position.row);
    }
    public static List<Position> getColumnContainingPosition(Position position) {
        return getColumnPositionsAt(position.column);
    }

    private static Map<Position, List<Position>> boxMap = new HashMap<>();

    public static List<Position> getBoxContainingPosition(Position position) {
        if (boxMap.containsKey(position))
            return boxMap.get(position);
        int startRow = (position.row - 1) / 3 + 1;
        int startCol = (position.column -1) / 3 + 1;
        List<Position> positions = getBoxPositionsAt(startRow, startCol);
        boxMap.put(position, positions);
        return positions;
    }
    public static List<Position> getBoxPositionsAt(int boxRow, int boxColumn) {
        int startRow = (boxRow - 1) * 3 + 1;
        int startCol = (boxColumn - 1) * 3 + 1;

        List<Position> boxPositions = new ArrayList<>();
        for (int row = startRow; row < startRow + 3; row++) {
            for (int column = startCol; column < startCol + 3; column++) {
                boxPositions.add(getPositionFor(row, column));
            }
        }
        return boxPositions;
    }

    public static List<Position> getRowPositionsAt(int rowNumber) {
        List<Position> rowPositions = new ArrayList<>();
        for (int column = 1; column <=9; column++) {
            rowPositions.add(getPositionFor(rowNumber,column));
        }
        return rowPositions;
    }
    public static List<Position> getColumnPositionsAt(int columnNumber) {
        List<Position> columnPositions = new ArrayList<>();
        for (int row = 1; row <=9; row++) {
            columnPositions.add(getPositionFor(row, columnNumber));
        }
        return columnPositions;
    }

    static Position getPositionFor (int row, int column) {
        for (Position position: Position.values()) {
            if (position.getXOffset() == row - 1 ) {
                if (position.getYOffset() == column - 1)
                    return position;
            }
        }
        throw new IllegalArgumentException("There is no position with these offsets " + row + ":" + column);
    }

}
