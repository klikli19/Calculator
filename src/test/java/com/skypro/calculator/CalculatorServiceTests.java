package com.skypro.calculator;

import com.skypro.calculator.exception.CanNotDividedByZeroException;
import com.skypro.calculator.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorServiceTests {
    public final CalculatorService calculatorService = new CalculatorService();

    public static Stream<Arguments> forPlusTest() {
        return Stream.of(
                Arguments.of(2,4,6),
                Arguments.of(3,3,6));
    }

    public static Stream<Arguments> forMinusTest() {
        return Stream.of(
                Arguments.of(7, 2, 5),
                Arguments.of(10, 5, 5));
    }

    public static Stream<Arguments> forMultiplyTest() {
        return Stream.of(
                Arguments.of(4,4,16),
                Arguments.of(-6, 3, -18));
    }

    public static Stream<Arguments> forDivideTest() {
        return Stream.of(
                Arguments.of(21, -7, -3),
                Arguments.of(30, 15, 2));
    }

    @ParameterizedTest
    @MethodSource("forPlusTest")
    public void plusTest(Integer a, Integer b, Integer result) {
        Assertions.assertEquals(result, calculatorService.plus(a,b));
    }

    @ParameterizedTest
    @MethodSource("forMinusTest")
    public void minusTest(Integer a, Integer b, Integer result) {
        Assertions.assertEquals(result, calculatorService.minus(a, b));
    }

    @ParameterizedTest
    @MethodSource("forMultiplyTest")
    public void multiplyTest(Integer a, Integer b, Integer result) {
        Assertions.assertEquals(result, calculatorService.multiply(a, b));
    }

    @ParameterizedTest
    @MethodSource("forDivideTest")
    public void divideTest(Integer a, Integer b, Integer result) {
        Assertions.assertEquals(result, calculatorService.divide(a, b));
    }

    @Test
    public void divideByZeroException() {
        Assertions.assertThrows(CanNotDividedByZeroException.class,() -> {
        calculatorService.divide(1, 0);
    });
    }

    @Test
    public void plusWithFistNumNullException() {
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            calculatorService.plus(null,4);
        });
    }

    @Test
    public void minusWithFistNumNullException() {
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            calculatorService.minus(null,2);
        });
    }

    @Test
    public void multiplyWithFistNumNullException() {
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            calculatorService.multiply(null,8);
        });
    }

    @Test
    public void divideWithFistNumNullException() {
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            calculatorService.divide(null,1);
        });
    }

    @Test
    public void plusWithSecondNumNullException() {
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            calculatorService.plus(3,null);
        });
    }

    @Test
    public void minusWithSecondNumNullException() {
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            calculatorService.minus(5,null);
        });
    }

    @Test
    public void multiplyWithSecondNumNullException() {
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            calculatorService.multiply(4,null);
        });
    }

    @Test
    public void divideWithSecondNumNullException() {
        Assertions.assertThrows(IllegalArgumentException.class,() -> {
            calculatorService.divide(10,null);
        });
    }
}
