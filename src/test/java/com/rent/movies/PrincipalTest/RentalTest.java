package com.rent.movies.PrincipalTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rent.movies.Principal.ChildrensPrice;
import com.rent.movies.Principal.Customer;
import com.rent.movies.Principal.Movie;
import com.rent.movies.Principal.NewReleasePrice;
import com.rent.movies.Principal.RegularPrice;
import com.rent.movies.Principal.Rental;

public class RentalTest {
    private Movie regularMovie;
    private Movie newReleaseMovie;
    private Movie childrensMovie;
    private Rental regularRental;
    private Rental newReleaseRental;
    private Rental childrensRental;
    private Customer customer;

    @BeforeEach
    public void setUp() {
         regularMovie = new Movie("Regular Movie", new RegularPrice());
         newReleaseMovie = new Movie("New Release Movie", new NewReleasePrice());
         childrensMovie = new Movie("Childrens Movie", new ChildrensPrice());

         // Para una película Regular: 2 + (días - 2) * 1.5. Con 3 días → 2 + 1.5 = 3.5
         regularRental = new Rental(regularMovie, 3);
         // Para una película NewRelease: días * 3. Con 2 días → 6.0
         newReleaseRental = new Rental(newReleaseMovie, 2);
         // Para una película Childrens: según el código, con 4 días → 1.5 (ya que se sobreescribe)
         childrensRental = new Rental(childrensMovie, 4);

         customer = new Customer("John Doe");
    }

    @Test
    public void testMovies() {
         assertEquals("Regular Movie", regularMovie.getTitle());
         assertEquals(3.5, regularMovie.getCharge(3), 0.001);
         assertEquals("New Release Movie", newReleaseMovie.getTitle());
         assertEquals(6.0, newReleaseMovie.getCharge(2), 0.001);
         assertEquals("Childrens Movie", childrensMovie.getTitle());
         assertEquals(1.5, childrensMovie.getCharge(4), 0.001);
    }

    @Test
    public void testCustomers() {
         assertEquals("John Doe", customer.getName());
    }

    @Test
    public void testRentals() {
         assertEquals(regularMovie, regularRental.getMovie());
         assertEquals(3, regularRental.getDaysRented());
    }

    @Test
    public void testGetCharge() {
         // Comprobamos los cálculos:
         assertEquals(3.5, regularRental.getCharge(), 0.001); // el 0.001 es el margen de error (delta)
         assertEquals(6.0, newReleaseRental.getCharge(), 0.001); // se pone porque los decimales no son exactos
         assertEquals(1.5, childrensRental.getCharge(), 0.001); // y puede haber errores de redondeo en memoria
    }

    @Test
    public void testGetFrequentRenterPoint() {
         // Para películas que no sean NewRelease, se devuelve 1 punto.
         assertEquals(1, regularRental.getFrequentRenterPoint());
         assertEquals(1, childrensRental.getFrequentRenterPoint());
         // Para NewRelease con más de 1 día, se devuelve 2 puntos.
         assertEquals(2, newReleaseRental.getFrequentRenterPoint());
    }

    @Test
    public void testStatement() {
         // Añadimos los alquileres al cliente
         customer.addRental(regularRental);
         customer.addRental(newReleaseRental);
         customer.addRental(childrensRental);
         
         String expected = "Rental record for John Doe\n";
         expected += "\tRegular Movie\t3.5\n";
         expected += "\tNew Release Movie\t6.0\n";
         expected += "\tChildrens Movie\t1.5\n";
         expected += "Amount owed is 11.0\n";
         expected += "You earned 4 frequent renter points.";
         
         assertEquals(expected, customer.statement());
    }
}
