package com.digite.kata.refactoring;

public class ChildrenMovieRental extends Rental {


    public ChildrenMovieRental(Movie movie, int daysRented) {
        super(movie, daysRented);
    }

    @Override
    public double getRent() {
        double rent = 1.5;
        if (this.getDaysRented() > 3)
            rent += (this.getDaysRented() - 3) * 1.5;
        return rent;
    }
}
