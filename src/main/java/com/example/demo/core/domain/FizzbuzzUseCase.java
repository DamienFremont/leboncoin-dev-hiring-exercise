package com.example.demo.core.domain;

import com.example.demo.core.application.ComputeFizzbuzzInboundPort;
import com.example.demo.core.application.FizzbuzzCalculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Use Case
 */
@Slf4j
@Component
public class FizzbuzzUseCase implements ComputeFizzbuzzInboundPort {

    @Override
    public FizzbuzzResponse writeFizzbuzz(FizzbuzzRequest request) {
        // INIT
        log.debug("init calculator...");
        var calculator = getCalculator(request);
        // COMPUTE
        log.debug("compute...");
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
