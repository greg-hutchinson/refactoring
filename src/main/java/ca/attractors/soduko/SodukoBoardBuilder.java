package ca.attractors.soduko;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ca.attractors.soduko.Position.*;
public class SodukoBoardBuilder {
    public static void main(String[] args) {
        SodukoBoard sodukoBoard = new SodukoBoard();
        sodukoBoard.putKnownNumberAt(1,P11);
        sodukoBoard.putKnownNumberAt(9,P24);
        sodukoBoard.putNotNumberAt(1 ,P99);
        System.out.println(sodukoBoard);
    }

    public SodukoBoard build(File file) {
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        CellContents[][] contents = new CellContents[9][9];
        for (int i = 0; i < 9; i++) {
            List<String> row = records.get(i);
            int column = 0;
            for (String value: row) {
                int number = 0;
                try {
                    number = Integer.parseInt(value);
                }
                catch (RuntimeException e) {

                }
                CellContents content =  NullContent.getInstance();
                if (number != 0)
                    content = new KnownNumber(number);
                contents[i][column++] = content;
            }

        }
        return new SodukoBoard(contents);
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

}
