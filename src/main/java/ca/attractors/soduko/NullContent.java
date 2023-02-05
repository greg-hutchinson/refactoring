package ca.attractors.soduko;

public class NullContent extends  CellContents {
    private static final NullContent singleton = new NullContent();

    private NullContent() {
    }

    public static NullContent getInstance() {
        return singleton;
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    public boolean equals(Object obj) {
        return (obj == singleton);
    }

    @Override
    public String toString() {
        return "    ";
    }

}
