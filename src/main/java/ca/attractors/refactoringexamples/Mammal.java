package ca.attractors.refactoringexamples;

public abstract class Mammal  {
    public boolean isWarmBlooded() {
        return true;
    }
    //Refactor  - push down
    public boolean isBornLive() {
        return true;
    }
}

