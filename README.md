# Unit Testing with Different Coverage Criteria

This project demonstrates unit testing with different coverage criteria for various Java classes.

## Palindrome Class Tests

### Bug Fix
The original Palindrome class had a bug in the index manipulation:
```java
// Original (buggy)
j++;
i--;

// Fixed
j--;
i++;
```

### Test Coverage Explanation

1. Line Coverage Tests
- Covers all executable lines of code
- Tests null input, empty string, single character, valid palindromes, and non-palindromes
- Ensures all string manipulation operations are tested

2. Branch Coverage Tests
- Covers all decision points in the code
- Tests both true and false branches of all conditions
- Includes edge cases like empty strings and single characters

3. Condition Coverage Tests
- Tests each boolean condition for both true and false outcomes
- Covers various string lengths and character combinations
- Ensures all comparison paths are tested

### Test Organization
Tests are organized in three packages:
- `LineCoverageTest`: Focuses on executing each line of code
- `BranchCoverageTest`: Focuses on executing each branch
- `ConditionCoverageTest`: Focuses on testing each condition

## Running Tests
To run the tests with coverage:
1. Use Maven: `mvn clean test`
2. Use IDE: Right-click on test class and select "Run with Coverage"

## Coverage Reports
Coverage reports are generated using JaCoCo and can be found in:
`target/site/jacoco/index.html` 