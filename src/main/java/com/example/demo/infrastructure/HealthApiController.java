package com.example.demo.infrastructure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Target: Supervision API, API Gateway
 */
@Slf4j
@RestController
@RequestMapping("/health")
public class HealthApiController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String status() {
        return "UP";
    }
}
