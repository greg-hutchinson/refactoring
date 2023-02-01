package ca.attractors.refactoringexamples;

import org.testng.annotations.Test;

public class DogTest {
    @Test
    void refactor() {
        Dog dog = new Dog();
        int lifeExpectancy = dog.getLifeExpectancy();


    }

}
