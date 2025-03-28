<div align="center">
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/junit/junit-original.svg" height="80" alt="junit logo" />
<img src="https://raw.githubusercontent.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/master/Emojis/Objects/Camera%20with%20Flash.png" alt="Camera with Flash" width="100" height="100" />

<h1>🎬 Movie Rental System in JAVA using JUnit & Mockito for Testing</h1>
</div>

---

Welcome to the **Movie Rental System** project – a sleek and flexible application to manage movie rentals using various pricing strategies. This project is built in Java and leverages design patterns to handle different movie types (Regular, New Release, and Children's movies), along with a comprehensive test suite powered by **JUnit**.

---

## 🚀 Overview

The system implements a movie rental service where:
- **Movies** are priced based on a strategy pattern.  
  - **Regular movies** calculate charges with a base fee plus a per-day increment after two days.  
  - **New releases** charge a fixed rate per day and offer bonus frequent renter points.  
  - **Children's movies** apply a simplified pricing model.
- **Customers** can rent movies, accumulate rental charges, and earn frequent renter points.
- The **Rental** class ties together a movie and the rental duration, computing charges and frequent renter points.
- The **Customer** class aggregates rentals and generates a detailed statement of all rentals.

---

## 🔧 Key Components

- **PriceStrategy Interface**  
  Defines a contract for calculating rental charges (see [PriceStrategy.java]).

- **RegularPrice, NewReleasePrice, ChildrensPrice**  
  Concrete implementations of the pricing strategy for different movie types (see [RegularPrice.java], [NewReleasePrice.java], and [ChildrensPrice.java]).

- **Movie**  
  Encapsulates movie details and delegates charge computation to its associated pricing strategy (see [Movie.java]).

- **Rental**  
  Associates a movie with its rental duration, calculating both the charge and the frequent renter points (see [Rental.java]).

- **Customer**  
  Manages a collection of rentals and produces a final rental statement, summarizing charges and points earned (see [Customer.java]).

- **RentalTest**  
  A comprehensive JUnit test class that validates:
  - Movie titles and charge calculations.
  - Customer rental aggregation.
  - Correct computation of frequent renter points.
  - Statement generation matching expected output (see [RentalTest.java]).

---

## 🛠️ Technologies Used

- **Java** – Core programming language.
- **JUnit 5** – For unit testing.
- **Maven** – Dependency management and build automation.
- **Design Patterns** – Strategy pattern for dynamic pricing.

---

## 📖 Getting Started

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/brivaro/MovieRentalSystem.git

2. **Build the Project:** Navigate to the project directory and run:
   ```bash
   mvn clean install

3. **Run Tests:** Execute the test suite using Maven or VS plugins:
   ```bash
   mvn test
