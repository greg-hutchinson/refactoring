package ca.attractors.leapyear;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class YearTest {
    @Test
    void testIsLeapYear() {
        Year year;
        year = new Year(1992);
        assertTrue(year.isLeapYear());

        year = new Year(1993);
        assertFalse(year.isLeapYear());

        year = new Year(2300);
        assertFalse(year.isLeapYear());

        year = new Year(2000);
        assertTrue(year.isLeapYear());
    }

}
