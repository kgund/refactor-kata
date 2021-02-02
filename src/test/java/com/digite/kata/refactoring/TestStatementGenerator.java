package com.digite.kata.refactoring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestStatementGenerator {

    StatementGenerator statementGenerator;
    Customer customer;
    RentCalculator rentCalculator;

    @BeforeEach
    public void setup() {
        statementGenerator = new StatementGenerator();
        customer = new Customer("Harry");
        rentCalculator = new RentCalculator();
    }

    @Test
    public void testStatementForRegularMovie2Days() {
        Movie movie = new Movie("The Soccerer's Stone");
        Rental rental = new RegularMovieRental(movie, 2);
        customer.addRental(rental);

        double totalAmt = rentCalculator.calculateTotalRent(customer.get_rentals());
        int frequentTenterPoints = rentCalculator.calculateTotalFrequentRenterPoints(customer.get_rentals());
        String statement = statementGenerator.generateStatement(customer, totalAmt, frequentTenterPoints);

        String expectedStatement = "Rental Record for " + customer.getName() + "\n" +
                "\tThe Soccerer's Stone\t" +
                "2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points";

        Assertions.assertEquals(expectedStatement, statement);
    }

    @Test
    public void testStatementForRegularMovie4Days() {
        Movie movie = new Movie("The Soccerer's Stone");
        Rental rental = new RegularMovieRental(movie, 4);
        customer.addRental(rental);

        double totalAmt = rentCalculator.calculateTotalRent(customer.get_rentals());
        int frequentTenterPoints = rentCalculator.calculateTotalFrequentRenterPoints(customer.get_rentals());
        String statement = statementGenerator.generateStatement(customer, totalAmt, frequentTenterPoints);

        String expectedStatement = "Rental Record for " + customer.getName() + "\n" +
                "\tThe Soccerer's Stone\t" +
                "5.0\n" +
                "Amount owed is 5.0\n" +
                "You earned 1 frequent renter points";

        Assertions.assertEquals(expectedStatement, statement);
    }

    @Test
    public void testStatementForNewReleasedMovie1Day() {
        Movie movie = new Movie("The Deathly Hallows");
        Rental rental = new NewReleasedMovieRental(movie, 1);
        customer.addRental(rental);

        double totalAmt = rentCalculator.calculateTotalRent(customer.get_rentals());
        int frequentTenterPoints = rentCalculator.calculateTotalFrequentRenterPoints(customer.get_rentals());
        String statement = statementGenerator.generateStatement(customer, totalAmt, frequentTenterPoints);

        String expectedStatement = "Rental Record for " + customer.getName() + "\n" +
                "\tThe Deathly Hallows\t" +
                "3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";

        Assertions.assertEquals(expectedStatement, statement);
    }

    @Test
    public void testStatementForNewReleasedMovie2Days() {
        Movie movie = new Movie("The Deathly Hallows");
        Rental rental = new NewReleasedMovieRental(movie, 2);
        customer.addRental(rental);
        double totalAmt = rentCalculator.calculateTotalRent(customer.get_rentals());
        int frequentTenterPoints = rentCalculator.calculateTotalFrequentRenterPoints(customer.get_rentals());
        String statement = statementGenerator.generateStatement(customer, totalAmt, frequentTenterPoints);

        String expectedStatement = "Rental Record for " + customer.getName() + "\n" +
                "\tThe Deathly Hallows\t" +
                "6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter points";

        Assertions.assertEquals(expectedStatement, statement);
    }

    @Test
    public void testStatementForChildrenMovie1Day() {
        Movie movie = new Movie("The Incredibles");
        Rental rental = new ChildrenMovieRental(movie, 1);
        customer.addRental(rental);

        double totalAmt = rentCalculator.calculateTotalRent(customer.get_rentals());
        int frequentTenterPoints = rentCalculator.calculateTotalFrequentRenterPoints(customer.get_rentals());
        String statement = statementGenerator.generateStatement(customer, totalAmt, frequentTenterPoints);

        String expectedStatement = "Rental Record for " + customer.getName() + "\n" +
                "\tThe Incredibles\t" +
                "1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points";

        Assertions.assertEquals(expectedStatement, statement);
    }

    @Test
    public void testStatementForChildrenMovie4Days() {
        Movie movie = new Movie("The Incredibles");
        Rental rental = new ChildrenMovieRental(movie, 4);
        customer.addRental(rental);

        double totalAmt = rentCalculator.calculateTotalRent(customer.get_rentals());
        int frequentTenterPoints = rentCalculator.calculateTotalFrequentRenterPoints(customer.get_rentals());
        String statement = statementGenerator.generateStatement(customer, totalAmt, frequentTenterPoints);

        String expectedStatement = "Rental Record for " + customer.getName() + "\n" +
                "\tThe Incredibles\t" +
                "3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";

        Assertions.assertEquals(expectedStatement, statement);
    }

    @Test
    public void testAllTypes1Day() {
        Movie movie1 = new Movie("The Soccerer's Stone");
        Rental rental1 = new RegularMovieRental(movie1, 1);
        customer.addRental(rental1);
        Movie movie2 = new Movie("The Deathly Hallows");
        Rental rental2 = new NewReleasedMovieRental(movie2, 1);
        customer.addRental(rental2);
        Movie movie3 = new Movie("The Incredibles");
        Rental rental3 = new ChildrenMovieRental(movie3, 1);
        customer.addRental(rental3);

        double totalAmt = rentCalculator.calculateTotalRent(customer.get_rentals());
        int frequentTenterPoints = rentCalculator.calculateTotalFrequentRenterPoints(customer.get_rentals());
        String statement = statementGenerator.generateStatement(customer, totalAmt, frequentTenterPoints);

        String expectedStatement = "Rental Record for " + customer.getName() + "\n" +
                "\tThe Soccerer's Stone\t" +
                "2.0\n" +
                "\tThe Deathly Hallows\t" +
                "3.0\n" +
                "\tThe Incredibles\t" +
                "1.5\n" +
                "Amount owed is 6.5\n" +
                "You earned 3 frequent renter points";

        Assertions.assertEquals(expectedStatement, statement);
    }
}
