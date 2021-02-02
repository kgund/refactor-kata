package com.digite.kata.refactoring;

public class NewReleasedMovie extends Movie {
    public NewReleasedMovie(String title, int code) {
        super(title, code);
    }

    public double calculateRent(int days) {
        return days * 3;
    }
}
