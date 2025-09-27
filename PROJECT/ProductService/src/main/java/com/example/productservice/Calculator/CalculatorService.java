package com.example.productservice.Calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService
{
    public int add(int a, int b)
    {
        System.out.println("Service: Logic before addition");
        int result =  a + b;
        System.out.println("Service: Logic after addition");

        return result;
    }
}
