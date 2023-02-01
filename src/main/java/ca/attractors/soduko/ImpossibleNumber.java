package ca.attractors.soduko;

import java.util.Objects;

public class ImpossibleNumber extends  CellContents {
    int number;

    public ImpossibleNumber(int number) {
        this.number = number;
    }

    public boolean isImpossibleNumber() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImpossibleNumber impossibleNumber = (ImpossibleNumber) o;
        return number == impossibleNumber.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return " -" + number +" ";
    }

}
