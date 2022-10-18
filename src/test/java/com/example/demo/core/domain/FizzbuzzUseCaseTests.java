package com.example.demo.core.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.example.demo.helpers.TestDatas.buildCase1Request;
import static com.example.demo.helpers.TestDatas.buildCase1Response;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FizzbuzzUseCaseTests {

    FizzbuzzUseCase classToTest;

    @BeforeEach
    void setUp() {
        classToTest = new FizzbuzzUseCase();
    }

    @Test
    void test_writeFizzBuzz_exerciceUseCase() {
        // GIVEN
        var expected = buildCase1Response();
        var request = buildCase1Request() ;
        // WHEN
        var actual = classToTest.writefizzbuzz(request);
        // THEN
        assertArrayEquals(expected.getList(), actual.getList());
    }
}