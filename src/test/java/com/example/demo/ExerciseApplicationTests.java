package com.example.demo;

import com.example.demo.core.domain.FizzbuzzResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

import static com.example.demo.helpers.TestDatas.buildCase1Request;
import static com.example.demo.helpers.TestDatas.buildCase1Response;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, args = "--spring.main.banner-mode=off")
public class ExerciseApplicationTests {

    @Test
    public void contextLoads() {
        assertDoesNotThrow(() -> {
        });
    }

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void test_writeFizzBuzz_exerciceUseCase() {
        // GIVEN
        var expected = buildCase1Response();
        var request = buildCase1Request() ;
        // WHEN
        var body = restTemplate.postForEntity("/api/v1/fizzbuzz", request, FizzbuzzResponse.class);
        // THEN
        assertEquals(HttpStatus.OK, body.getStatusCode());
        assertArrayEquals(expected.getList(), body.getBody().getList());
    }
}
