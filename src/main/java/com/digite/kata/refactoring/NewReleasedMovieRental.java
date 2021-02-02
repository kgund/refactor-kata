package com.digite.kata.refactoring;

public class NewReleasedMovieRental extends Rental {


    public NewReleasedMovieRental(Movie movie, int daysRented) {
        super(movie, daysRented);
    }

    public double getRent() {
        return this.getDaysRented() * 3;
    }

    @Override
    public int getRenterPoints() {
        if(this.getDaysRented() > 1)
            return super.getRenterPoints() + 1;
        return super.getRenterPoints();
    }
}
