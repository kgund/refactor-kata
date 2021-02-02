package com.digite.kata.refactoring;

public class RegularMovie extends Movie {
    public RegularMovie(String title, int code) {
        super(title, code);

    }

    @Override
    public double calculateRent(int days) {
        double rent = 2;
        if(days > 2){
            rent += (days-2) * 1.5;
        }
        return rent;
    }
}
