package com.example.stream18spring.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    CalculatorService service = new CalculatorService();

    @Test
    void testPlus() {
        assertEquals(3, service.plus(1, 2));
        assertEquals(-3, service.plus(-1, -2));
        assertEquals(1, service.plus(-1, 2));
        assertEquals(-1, service.plus(1, -2));
        assertEquals(1, service.plus(1, 0));
        assertEquals(1, service.plus(0, 1));
    }

    @Test
    void testMinus() {
        var result = service.minus(1, 2);
        assertEquals(-1, result);

        var result2 = service.minus(-5, -6);
        assertEquals(1, result2);

        var result3 = service.minus(-5, 6);
        assertEquals(-11, result3);

        var result4 = service.minus(5, -6);
        assertEquals(11, result4);

        var result5 = service.minus(0, 0);
        assertEquals(0, result5);
    }

    @Test
    void testMultiply() {
        var result = service.multiply(1, 2);
        assertEquals(2, result);

        var result2 = service.multiply(-5, -6);
        assertEquals(30, result2);

        var result3 = service.multiply(-5, 6);
        assertEquals(-30, result3);

        var result4 = service.multiply(5, -6);
        assertEquals(-30, result4);

        var result5 = service.multiply(0, 0);
        assertEquals(0, result5);
    }

    @Test
    void testDivide() {
        var result = service.divide(1, 2);
        assertEquals(0, result);

        var result2 = service.divide(-6, -6);
        assertEquals(1, result2);

        var result3 = service.divide(-12, 6);
        assertEquals(-2, result3);

        var result4 = service.divide(12, -6);
        assertEquals(-2, result4);

        assertThrows(ArithmeticException.class, () -> service.divide(12, 0));

        try {
            service.divide(12, 0);
            fail();
        } catch (ArithmeticException ignored) {
        }
    }
}