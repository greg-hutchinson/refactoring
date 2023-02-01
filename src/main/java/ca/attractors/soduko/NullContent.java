package ca.attractors.soduko;

public class NullContent extends  CellContents {
    private static NullContent singleton = new NullContent();

    private NullContent() {
    }

    public static NullContent getInstance() {
        return singleton;
    }

    public boolean equals(Object obj) {
        return (obj == singleton);
    }

    @Override
    public String toString() {
        return "    ";
    }

}
