package com.example.demo.helpers;

import com.example.demo.core.domain.FizzbuzzRequest;
import com.example.demo.core.domain.FizzbuzzResponse;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;

/**
 * Helper for tests
 */
public class TestDatas {

    /**
     * Dataset helper
     */
    public static FizzbuzzResponse buildCase1Response() {
        return new FizzbuzzResponse("1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz,16".split(","));
    }

    /**
     * Dataset helper
     */
    public static FizzbuzzRequest buildCase1Request() {
        return new FizzbuzzRequest(3, 5, 16, "fizz", "buzz");
    }

    public static String jwtTokenEncoded() {
        try {
            var file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "token-encoded.txt");
            var content = new String(Files.readAllBytes(file.toPath()));
            return content;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
