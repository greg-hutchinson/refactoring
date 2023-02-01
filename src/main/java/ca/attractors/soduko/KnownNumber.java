package ca.attractors.soduko;

import java.util.Objects;

public class KnownNumber extends CellContents {
    int number;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KnownNumber that = (KnownNumber) o;
        return number == that.number;
    }
    public boolean isKnown() {
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public KnownNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "  " + number +" ";
    }
}
