package ca.attractors.leapyear;

public class Year {
    private int year;

    public Year(int year) {
        this.year = year;
    }
    public boolean isLeapYear() {
        if (year % 400 == 0)
            return true;
        if (year % 100 == 0)
            return false;
        if (year % 4 == 0)
            return true;
        return false;
    }
}
