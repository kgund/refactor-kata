package com.digite.kata.refactoring;

import java.util.Enumeration;
import java.util.stream.Collectors;

public class StatementGenerator {
    public String generateStatement(Customer customer, double totalAmount, int frequentRenterPoints) {
        String result = "Rental Record for " + customer.getName() + "\n";
        result += customer.get_rentals().stream()
                .map(each -> "\t" + each.getMovie().getTitle() + "\t" +
                String.valueOf(each.getRent()) + "\n")
                .collect(Collectors.joining());
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) +
                "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                +
                " frequent renter points";
        return result;
    }
}
