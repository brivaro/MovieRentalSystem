//Customer.java

package com.rent.movies.Principal;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
    private final String name;
    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public double getTotalCharge() {
        double total = 0;
        for (Rental rental : rentals) {
            total += rental.getCharge();
        }
        return total;
    }
    
    public int getTotalFrequentRenterPoints() {
        int total = 0;
        for (Rental rental : rentals) {
            total += rental.getFrequentRenterPoint();
        }
        return total;
    }
    
    public String statement() {
        StringBuilder result = new StringBuilder("Rental record for " + name + "\n");
        for (Rental rental : rentals) {
            result.append("\t")
                  .append(rental.getMovie().getTitle())
                  .append("\t")
                  .append(rental.getCharge())
                  .append("\n");
        }
        result.append("Amount owed is ").append(getTotalCharge()).append("\n");
        result.append("You earned ").append(getTotalFrequentRenterPoints()).append(" frequent renter points.");
        return result.toString();
    }

}
