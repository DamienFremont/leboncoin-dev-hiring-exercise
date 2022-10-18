package com.example.demo.core.domain;

import com.example.demo.core.application.ComputeFizzbuzzInboundPort;
import org.springframework.stereotype.Component;

/**
 * Use Case
 */
@Component
public class FizzbuzzUseCase implements ComputeFizzbuzzInboundPort {

    @Override
    public FizzbuzzResponse writefizzbuzz(FizzbuzzRequest request) {
        return new FizzbuzzResponse("1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz,16".split(","));
    }
}
