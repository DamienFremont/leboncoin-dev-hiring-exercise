package com.example.demo.core.domain;

import com.example.demo.core.application.ComputeFizzbuzzInboundPort;
import com.example.demo.infrastructure.FizzbuzzCalculator;
import org.springframework.stereotype.Component;

/**
 * Use Case
 */
@Component
public class FizzbuzzUseCase implements ComputeFizzbuzzInboundPort {

    @Override
    public FizzbuzzResponse writefizzbuzz(FizzbuzzRequest request) {
        // INIT
        var calculator = getCalculator(request);
        // COMPUTE
        var arg = request.getLimit();
        var res = calculator.fizzBuzz(arg);
        return new FizzbuzzResponse(res);
    }

    private FizzbuzzCalculator getCalculator(FizzbuzzRequest request) {
        return new FizzbuzzCalculator(
                request.getInt1(), request.getInt2(),
                request.getStr1(), request.getStr2());
    }
}
