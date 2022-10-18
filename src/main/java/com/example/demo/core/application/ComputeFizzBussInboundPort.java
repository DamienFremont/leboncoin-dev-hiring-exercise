package com.example.demo.core.application;

import com.example.demo.core.domain.FizzBuzzRequest;

import java.util.List;

public interface ComputeFizzBussInboundPort {
    
    List<String> writeFizzBuzz(FizzBuzzRequest request);
}
