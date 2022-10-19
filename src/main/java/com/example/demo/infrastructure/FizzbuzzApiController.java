package com.example.demo.infrastructure;

import com.example.demo.core.application.ComputeFizzbuzzInboundPort;
import com.example.demo.core.application.WriteFizzbuzzInboundPort;
import com.example.demo.core.domain.FizzbuzzRequest;
import com.example.demo.core.domain.FizzbuzzResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static java.lang.String.format;

/**
 * Web Adapter
 */
@Slf4j
@RestController
@RequestMapping("/api/v1")
public class FizzbuzzApiController implements WriteFizzbuzzInboundPort {

    @Autowired
    private ComputeFizzbuzzInboundPort fizzbuzzUseCase;

    @PostMapping("/fizzbuzz")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public FizzbuzzResponse writefizzbuzz(@Valid @RequestBody FizzbuzzRequest request) {
        log.info(format("writefizzbuzz() request=%s", request.toString()));
        return fizzbuzzUseCase.writefizzbuzz(request);
    }
}
