package com.masum.company.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
    @GetMapping("health-check")
    public String healthcheck(){
        return "Everything is Ok";
    }
}
