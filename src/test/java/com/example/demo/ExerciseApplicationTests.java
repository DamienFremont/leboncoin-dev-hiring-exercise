package com.example.demo;

import com.example.demo.core.domain.FizzbuzzRequest;
import com.example.demo.core.domain.FizzbuzzResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.util.Collections;

import static com.example.demo.helpers.TestDatas.*;
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
        var request = buildCase1Request();
        var headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Bearer " + jwtTokenEncoded());
        var entity = new HttpEntity<FizzbuzzRequest>(request, headers);
        // WHEN
        var body = restTemplate.exchange("/api/v1/fizzbuzz", HttpMethod.POST, entity, FizzbuzzResponse.class);
        // THEN
        assertEquals(HttpStatus.OK, body.getStatusCode());
        assertArrayEquals(expected.getList(), body.getBody().getList());
    }

    @Test
    public void test_health() {
        // GIVEN
        var expected = "UP";
        // WHEN
        var body = restTemplate.getForEntity("/health", String.class);
        // THEN
        assertEquals(HttpStatus.OK, body.getStatusCode());
        assertEquals(expected, body.getBody());
    }

    @Test
    public void test_security() {
        // GIVEN
        var request = buildCase1Request();
        // WHEN
        var body = restTemplate.postForEntity("/api/v1/fizzbuzz", request, FizzbuzzResponse.class);
        // THEN
        assertEquals(HttpStatus.FORBIDDEN, body.getStatusCode());
    }
}
