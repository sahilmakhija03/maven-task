package com.example.automation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();
        assertEquals(10, calculator.add(4, 6), "Addition operation failed!");
    }

    @Test
    public void testSubtraction() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.subtract(8, 6), "Subtraction operation failed!");
    }

    @Test
    public void testMultiplication() {
        Calculator calculator = new Calculator();
        assertEquals(12, calculator.multiply(3, 4), "Multiplication operation failed!");
    }

    @Test
    public void testDivision() {
        Calculator calculator = new Calculator();
        assertEquals(5, calculator.divide(10, 2), "Division operation failed!");
    }

    @Test
    public void testDivisionByZero() {
        Calculator calculator = new Calculator();
        Exception exception = null;
    
        try {
            calculator.divide(10, 0);
        } catch (IllegalArgumentException e) {
            exception = e;
        }
    
        // Assert that the exception is not null and has the expected message
        assertEquals("Division by zero is not allowed.", exception.getMessage(), "Unexpected exception message");
    }

}
