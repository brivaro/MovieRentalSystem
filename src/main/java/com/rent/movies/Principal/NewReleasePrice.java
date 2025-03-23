package com.rent.movies.Principal;

public class NewReleasePrice implements PriceStrategy {
    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }
}
