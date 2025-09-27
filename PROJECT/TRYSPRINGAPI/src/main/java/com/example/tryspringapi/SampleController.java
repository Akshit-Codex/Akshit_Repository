package com.example.tryspringapi;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//This controller will contain HTTP APIs
@RestController
//localhost:8080/Sample
@RequestMapping("/Sample")
public class SampleController
{

    @GetMapping("/sayHello")
    public String sayHello()
    {
        return "HELLO MAVEN!!!!";
    }
}
