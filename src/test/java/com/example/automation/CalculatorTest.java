package com.example.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3), "Addition test failed");
        assertEquals(-1, calculator.add(2, -3), "Addition with negative numbers failed");
    }

    @Test
    public void testSubtract() {
        assertEquals(-1, calculator.subtract(2, 3), "Subtraction test failed");
        assertEquals(5, calculator.subtract(2, -3), "Subtraction with negative numbers failed");
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3), "Multiplication test failed");
        assertEquals(-6, calculator.multiply(2, -3), "Multiplication with negative numbers failed");
    }

    @Test
    public void testDivide() {
        assertEquals(2.0, calculator.divide(6, 3), 0.01, "Division test failed");
        assertEquals(-2.0, calculator.divide(6, -3), 0.01, "Division with negative numbers failed");

        // Test division by zero
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.divide(6, 0));
        assertEquals("Division by zero is not allowed.", exception.getMessage(), "Division by zero exception failed");
    }
}

