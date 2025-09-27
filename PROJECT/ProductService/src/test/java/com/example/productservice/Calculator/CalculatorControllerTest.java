package com.example.productservice.Calculator;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class CalculatorControllerTest
{
    CalculatorService calculatorService = Mockito.mock(CalculatorService.class);
    // Added Mockito to tell that we are going to
    // mock add function in CalculatorService

    CalculatorController calculatorController = new CalculatorController(calculatorService);

    @Test // you need to annotate test in order to tell Spring that we are going to test this function
    public void testSumAcceptsTwoIntegersReturnsSumAsInteger()
    {
        when(calculatorService.add(5,10)).thenReturn(15);
        when(calculatorService.add(6,10)).thenReturn(16);

        //Arrange
        int a = 6;
        int b = 10;
        int expectedResult = 16;

        //Act
        int actualResult=calculatorController.sum(a,b);

        //Assert
        assertEquals(expectedResult,actualResult);
    }

    @Test // Below function is little similar to previous one, but previously we were not training it properly
    // So here instead of numbers we are going to use anyInt().
    // Previously we were using default values below we are using anyInt().
    public void testSumAcceptsAnyTwoIntegersReturnsSumAsInteger()
    {
        when(calculatorService.add(5,10)).thenReturn(15);
        when(calculatorService.add(anyInt(),anyInt())).thenReturn(100);

        //Arrange
        int a = 23294;
        int b = 54352;
        int expectedResult = 100;

        //Act
        int actualResult=calculatorController.sum(a,b);

        //Assert
        assertEquals(expectedResult,actualResult);
    }

}