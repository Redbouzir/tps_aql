# Integration Testing Project

This project demonstrates different types of integration testing scenarios using JUnit 5 and Mockito.

## Project Structure

The project is organized into three main exercises:

### Exercise 1: Simple Module Interaction
- `UserService`: Service class that retrieves user data
- `UserRepository`: Interface for user data access
- Tests verify the interaction between `UserService` and `UserRepository`

### Exercise 2: Database Interaction with Mocks
- `OrderController`: Controller class for order creation
- `OrderService`: Service class for order processing
- `OrderDao`: Interface for order data persistence
- Tests verify the interaction between all three layers

### Exercise 3: API Integration with Mocking
- `ProductService`: Service class for product retrieval
- `ProductApiClient`: Interface for external API communication
- Tests verify different API interaction scenarios (success, failure, invalid data)

## Running the Tests

To run the tests, use the following Maven command:

```bash
mvn test
```

## Dependencies

- Java 8 or higher
- JUnit 5
- Mockito
- Maven

## Test Coverage

The tests cover:
1. Successful data retrieval
2. Error handling
3. Data validation
4. Layer interaction verification
5. Mock object behavior verification 