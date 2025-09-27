package com.example.productservice.Exceptions;

public class ProductNotFoundException extends Exception /*Never extend Runtime Exception*/
{
    public ProductNotFoundException(String message)
    {
        super(message);
    }
}
