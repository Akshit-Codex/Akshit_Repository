package com.example.productservice.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDTO // We are creating this DTO for Exception Handling
{
    private String status;
    private String message;
}
