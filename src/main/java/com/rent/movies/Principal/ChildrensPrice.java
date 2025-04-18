package com.rent.movies.Principal;

public class ChildrensPrice implements PriceStrategy {
    @Override
    public double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3) {
            result = (daysRented - 3) * 1.5;
        }
        return result;
    }
}
