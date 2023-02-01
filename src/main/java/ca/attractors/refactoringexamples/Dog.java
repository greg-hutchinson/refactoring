package ca.attractors.refactoringexamples;

public class Dog extends Mammal {
    //Refactor  - pull up
    public int getNumberOfLegs() {
        return 4;
    }

    //Refactor  - extract variable (v) and inline (n)
    //Refactor  - introduce Parameter - Look at DogTest
    public int getLifeExpectancy() {
        return getNumberOfLegs() * getNumberOfLegs() - 4;
    }

}
