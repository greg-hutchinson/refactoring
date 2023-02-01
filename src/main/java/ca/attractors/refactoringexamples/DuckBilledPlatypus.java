package ca.attractors.refactoringexamples;

public class DuckBilledPlatypus extends Mammal {

    public MyPlatypus getMyPlatypus() {
        return new MyPlatypus();
    }

    // Poor Example - needs work.
    class MyPlatypus extends Reptile {
        public boolean isSomething() {
            return isBornLive() && isUgly();
        }

    }
}
