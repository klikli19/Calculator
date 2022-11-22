package com.skypro.calculator.service;


import com.skypro.calculator.exception.CanNotDividedByZeroException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.server.ResponseStatusException;

@Service
@SessionScope
public class CalculatorService {

    public Integer plus (int a, int b) {
        return a + b;
    }

    public Integer minus(int a, int b) {
        return a - b;
    }

    public Integer multiply(int a, int b) {
        return a * b;
    }

    public Integer divide(int a, int b) {
        if (b == 0) {
            throw new CanNotDividedByZeroException( "Делить на ноль нельзя");
        }
        return a / b;
    }

}
