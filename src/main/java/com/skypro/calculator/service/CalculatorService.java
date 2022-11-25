package com.skypro.calculator.service;


import com.skypro.calculator.exception.CanNotDividedByZeroException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;


@Service
@SessionScope
public class CalculatorService {

    public Integer plus (Integer a, Integer b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Вы ввели только одно число, а надо два!");
        }
        return a + b;
    }

    public Integer minus(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Вы ввели только одно число, а надо два!");
        }
        return a - b;
    }

    public Integer multiply(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Вы ввели только одно число, а надо два!");
        }
        return a * b;
    }

    public Integer divide(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Вы ввели только одно число, а надо два!");
        }
        if (b == 0) {
            throw new CanNotDividedByZeroException( "Делить на ноль нельзя");
        }
        return a / b;
    }

}
