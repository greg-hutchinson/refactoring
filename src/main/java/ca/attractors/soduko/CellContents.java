package ca.attractors.soduko;

public abstract class CellContents {
    public static CellContents newInstance(CellContents cellContents) {
        if (cellContents.isKnown())
            return new KnownNumber(((KnownNumber) cellContents).number);
        if (cellContents.isImpossibleNumber())
            return new ImpossibleNumber(((ImpossibleNumber) cellContents).number);
        return NullContent.getInstance();
    }

    public boolean isKnown() {
        return false;
    }
    public boolean isImpossibleNumber() {
        return false;
    }
}
