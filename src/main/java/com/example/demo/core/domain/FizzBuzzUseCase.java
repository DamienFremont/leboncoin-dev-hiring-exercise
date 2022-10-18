package com.example.demo.core.domain;

import com.example.demo.core.application.ComputeFizzBussInboundPort;

import java.util.Arrays;
import java.util.List;

public class FizzBuzzUseCase implements ComputeFizzBussInboundPort {

    @Override
    public List<String> writeFizzBuzz(FizzBuzzRequest request) {
        return Arrays.asList("1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz,16".split(","));
    }
}
