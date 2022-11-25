package com.skypro.calculator.controller;

import com.skypro.calculator.exception.CanNotDividedByZeroException;
import com.skypro.calculator.service.CalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @ExceptionHandler(value = CanNotDividedByZeroException.class)
    public ResponseEntity<String> canNotDividedByZeroException(CanNotDividedByZeroException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    @GetMapping
    public String getGreeting(){
        return "Привет человек! Добро пожаловать в наш калькулятор!";
    }
    @GetMapping("/plus")
    public String plus (@RequestParam("num1") Integer a, @RequestParam("num2") Integer b) {
        return String.format("%d + %d = %d", a, b, this.calculatorService.plus(a, b));
    }
    @GetMapping("/minus")
    public String minus (@RequestParam("num1") Integer a, @RequestParam("num2") Integer b) {
        return String.format("%d - %d = %d", a, b, this.calculatorService.minus(a, b));
    }
    @GetMapping("/multiply")
    public String multiply (@RequestParam("num1") Integer a, @RequestParam("num2") Integer b)  {
        return String.format("%d * %d = %d", a, b, this.calculatorService.multiply(a, b));
    }

    @GetMapping("/divide")
    public String divide (@RequestParam("num1") Integer a, @RequestParam("num2") Integer b){
        return String.format("%d / %d = %d", a, b, this.calculatorService.divide(a, b));
    }
}
