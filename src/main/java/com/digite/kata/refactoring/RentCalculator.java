package com.digite.kata.refactoring;

import java.util.Vector;

public class RentCalculator {

    public double calculateTotalRent(Vector<Rental> rentals) {
        return rentals.stream()
                .map(rental -> rental.getRent())
                .reduce(0.0, (subtotal, next) -> subtotal + next);
    }

    public int calculateTotalFrequentRenterPoints(Vector<Rental> rentals) {
        return rentals.stream()
                .map(rental -> rental.getRenterPoints())
                .reduce(0, (subtotal, next) -> subtotal + next);
    }
}
