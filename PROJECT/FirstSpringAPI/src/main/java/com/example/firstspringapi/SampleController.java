package com.example.firstspringapi;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// This controller will contain HTTPs APIs
@RestController
//localhost:8080/Sample
@RequestMapping
public class SampleController
{
    @GetMapping("/sayHello")
    public String sayHello()
    {
        return "Hello Everyone";
    }
}
