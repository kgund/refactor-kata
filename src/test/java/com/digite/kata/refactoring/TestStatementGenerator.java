package com.digite.kata.refactoring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestStatementGenerator {

    StatementGenerator statementGenerator;
    Customer customer;

    @BeforeEach
    public void setup() {
        statementGenerator = new StatementGenerator();
        customer = new Customer("Harry");
    }

    @Test
    public void testStatementForRegularMovie2Days() {
        String statement = statementGenerator.generateStatement(customer);
        String expectedStatement = "Rental Record for " + customer.getName() + "\n" +
                "\tThe Soccerer's Stone\t" +
                "2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points";

        Assertions.assertEquals(expectedStatement, statement);
    }

    @Test
    public void testStatementForRegularMovie4Days() {
        String statement = statementGenerator.generateStatement(customer);
        String expectedStatement = "Rental Record for " + customer.getName() + "\n" +
                "\tThe Soccerer's Stone\t" +
                "5.0\n" +
                "Amount owed is 5.0\n" +
                "You earned 1 frequent renter points";

        Assertions.assertEquals(expectedStatement, statement);
    }

    @Test
    public void testStatementForNewReleasedMovie1Day() {
        String statement = statementGenerator.generateStatement(customer);
        String expectedStatement = "Rental Record for " + customer.getName() + "\n" +
                "\tThe Deathly Hallows\t" +
                "3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";

        Assertions.assertEquals(expectedStatement, statement);
    }

    @Test
    public void testStatementForNewReleasedMovie2Days() {
        String statement = statementGenerator.generateStatement(customer);
        String expectedStatement = "Rental Record for " + customer.getName() + "\n" +
                "\tThe Deathly Hallows\t" +
                "6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter points";

        Assertions.assertEquals(expectedStatement, statement);
    }

    @Test
    public void testStatementForChildrenMovie1Day() {
        String statement = statementGenerator.generateStatement(customer);
        String expectedStatement = "Rental Record for " + customer.getName() + "\n" +
                "\tThe Incredibles\t" +
                "1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points";

        Assertions.assertEquals(expectedStatement, statement);
    }

    @Test
    public void testStatementForChildrenMovie4Days() {
        String statement = statementGenerator.generateStatement(customer);
        String expectedStatement = "Rental Record for " + customer.getName() + "\n" +
                "\tThe Incredibles\t" +
                "3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";

        Assertions.assertEquals(expectedStatement, statement);
    }

    @Test
    public void testAllTypes1Day() {
        String statement = statementGenerator.generateStatement(customer);
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
