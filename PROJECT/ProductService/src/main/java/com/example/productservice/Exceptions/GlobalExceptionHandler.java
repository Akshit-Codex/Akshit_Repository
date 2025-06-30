package com.example.productservice.Exceptions;

import com.example.productservice.DTOs.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
//Jaha bhi yeh error hoga waha yeh niche wale Exception ko call karega
public class GlobalExceptionHandler extends Exception
{
    @ExceptionHandler(NullPointerException.class)
    // This explicitly tells the spring that this method handles the exception
    public ErrorDTO handleNullPointerExceptions()
    {
        ErrorDTO errorDTO=new ErrorDTO();
        errorDTO.setStatus("Failure");
        errorDTO.setMessage("BHAI YEH ID HAI HI NHI");
        return errorDTO;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDTO> ProductNotFoundException(Exception e)
    {
        ErrorDTO errorDTO=new ErrorDTO();
        errorDTO.setStatus("Failure");
        errorDTO.setMessage(e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.NOT_FOUND);
    }
}
