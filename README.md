## JUnit Automation Exercises

### Project Overview

This project provides a collection of automated JUnit test cases designed to exercise various programming concepts and algorithms.


### Getting Started

Before you begin, ensure you have the following installed:
- **[Java Development Kit (JDK) 22](https://www.oracle.com/java/technologies/javase/jdk22-archive-downloads.html)** or later: Make sure it's properly configured in your environment.
- **[Gradle](https://gradle.org/)** *(recommended)*: The project uses the Gradle build system. While you don't need to install it globally (thanks to the included Gradle Wrapper), it’s good practice.

1. **Clone the Repository**:

```bash
git clone https://github.com/mdziegielewska/Automation-JUnit.git
cd Automation-JUnit
```

2. **Import into your IDE**
* In IntelliJ IDEA or Eclipse, choose “Import Project”, then select the `build.gradle` file.
* Let the IDE download dependencies and set up the classpath.


## Running Tests

Once set up, you have two main options:

* **IDE Test Runner**: Right-click on the `src/test/java` folder or individual test class → Run  
* **Command Line**:  
  ```bash
  ./gradlew test
  ```
Test reports will be available under `build/reports/tests/test/index.html`.


### Technologies Used

* [Java 22](https://www.oracle.com/java/technologies/javase/jdk22-archive-downloads.html)
* [JUnit 5](https://junit.org/junit5/)
* [Git](https://git-scm.com/)
* [Gradle](https://gradle.org/)


### Chosen algoritms

* **Palindromes**: Validates strings for palindromic properties.
* **Fibonacci Numbers**: Tests the calculation and verification of the Fibonacci sequence.
* **Array Calculations**: _in progress_

  
### Test Coverages

The project provides extensive test coverage for the following areas:

* **Correctness**: Verifies that the implemented algorithms and functions produce accurate results.
* **Edge Cases**: Tests various edge cases, such as empty strings, null values, and special characters.
* **Error Handling**: Ensures that the code handles exceptions and errors gracefully.


### Future work

* Add more test cases to cover additional scenarios and edge cases.
* Evaluate the performance of algorithms, especially for time-sensitive operations.
* Experiment with other testing frameworks like TestNG or Spock for comparison
