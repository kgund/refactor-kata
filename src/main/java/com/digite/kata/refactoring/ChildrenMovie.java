package com.digite.kata.refactoring;

public class ChildrenMovie extends Movie {
    public ChildrenMovie(String title, int code) {
        super(title, code);
    }

    @Override
    public double calculateRent(int days) {
        double rent = 1.5;
        if (days > 3)
            rent += (days - 3) * 1.5;
        return rent;
    }


}
