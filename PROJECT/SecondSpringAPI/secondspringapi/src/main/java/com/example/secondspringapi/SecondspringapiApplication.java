package com.example.secondspringapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

// This controller will contain HTTPs APIs
@RestController
//localhost:8080/SecondspringapiApplication
@RequestMapping("/SecondspringapiApplication")
public class SecondspringapiApplication 
{
	public static void main(String[] args) 
	{
        SpringApplication.run(SecondspringapiApplication.class, args);
    }
	@GetMapping("/sayHello"/*{name}*/)
	public String sayHello(@PathVariable("name") String name)
	{
		return "Hello Everyone" + name;
	}
	@GetMapping("/sayBye")
	public String sayBye()
	{
		return "Bye Everyone";
	}
	@GetMapping("/sayHi")
	public String sayHi()
	{
		return "Hi, Welcome to Spring Boot,connection to maven is successful";
	}
}
