package com.example.demo.core.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzUseCaseTest {

    FizzBuzzUseCase classToTest;

    @BeforeEach
    void setUp() {
        classToTest = new FizzBuzzUseCase();
    }

    @Test
    void writeFizzBuzz() {
        // GIVEN
        var expected = Arrays.asList("1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz,16".split(","));
        var param = new FizzBuzzRequest(3, 5, 16, "fizz", "buzz");
        // WHEN
        var actual = classToTest.writeFizzBuzz(param);
        // THEN
        Assertions.assertArrayEquals(expected.toArray(new String[0]), actual.toArray(new String[0]));
    }
}