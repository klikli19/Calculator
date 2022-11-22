package com.skypro.calculator.controller;

import com.skypro.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String getGreeting(){
        return "Добро пожаловать в калькулятор!";
    }
    @GetMapping("/plus")
    public String plus (@RequestParam("num1") int a, @RequestParam("num2") int b){
        return String.format("%d + %d = %d", a, b, this.calculatorService.plus(a, b));
    }
    @GetMapping("/minus")
    public String minus (@RequestParam("num1") int a, @RequestParam("num2") int b){
        return String.format("%d - %d = %d", a, b, this.calculatorService.minus(a, b));
    }
    @GetMapping("/multiply")
    public String multiply (@RequestParam("num1") int a, @RequestParam("num2") int b){
        return String.format("%d * %d = %d", a, b, this.calculatorService.multiply(a, b));
    }

    @GetMapping("/divide")
    public String divide (@RequestParam("num1") int a, @RequestParam("num2") int b){
        return String.format("%d / %d = %d", a, b, this.calculatorService.divide(a, b));
    }
}
