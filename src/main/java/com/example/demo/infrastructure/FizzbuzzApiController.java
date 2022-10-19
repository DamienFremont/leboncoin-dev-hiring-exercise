package com.example.demo.infrastructure;

import com.example.demo.core.application.ComputeFizzbuzzInboundPort;
import com.example.demo.core.application.MetricInboundPort;
import com.example.demo.core.application.WriteFizzbuzzInboundPort;
import com.example.demo.core.domain.FizzbuzzRequest;
import com.example.demo.core.domain.FizzbuzzResponse;
import com.example.demo.core.domain.MetricService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Map;

import static java.lang.String.format;

/**
 * Web Adapter
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/fizzbuzz")
public class FizzbuzzApiController implements WriteFizzbuzzInboundPort {

    @Autowired
    private ComputeFizzbuzzInboundPort fizzbuzzUseCase;
    @Autowired
    private MetricInboundPort metricService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Override
    public FizzbuzzResponse writeFizzbuzz(@Valid @RequestBody FizzbuzzRequest request) {
        log.info(format("writeFizzbuzz() request=%s", request.toString()));
        metricService.increaseCount("/fizzbuzz:" + request.toString());
        return fizzbuzzUseCase.writeFizzbuzz(request);
    }


}
