package com.digite.kata.refactoring;

public class RegularMovieRental extends Rental {

    public RegularMovieRental(Movie movie, int daysRented) {
        super(movie, daysRented);
    }

    @Override
    public double getRent() {
        double rent = 2;
        if(this.getDaysRented() > 2){
            rent += (this.getDaysRented() - 2) * 1.5;
        }
        return rent;
    }
}
