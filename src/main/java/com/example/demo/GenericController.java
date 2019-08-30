package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Controller
public class GenericController {

  	// Aggregate root
  	@RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }

    @GetMapping("/genericMessage")
  	String message() {
    return "Esto es un request";
  	}


}
