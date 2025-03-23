//Movie.java

package com.rent.movies.Principal;

public class Movie {
    private final String title;
    private final PriceStrategy priceStrategy;

    public Movie(String title, PriceStrategy priceStrategy) {
        this.title = title;
        this.priceStrategy = priceStrategy;
    }

    public String getTitle() {
        return title;
    }

    public double getCharge(int daysRented) {
        return priceStrategy.getCharge(daysRented);
    }

    public int getFrequentRenterPoint(int daysRented) {
        if (priceStrategy instanceof NewReleasePrice && daysRented > 1)
            return 2;
        return 1;
    }
    
}

