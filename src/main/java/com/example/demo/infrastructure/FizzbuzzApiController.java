package com.example.demo.infrastructure;

import com.example.demo.core.application.ComputeFizzbuzzInboundPort;
import com.example.demo.core.application.WriteFizzbuzzInboundPort;
import com.example.demo.core.domain.FizzbuzzRequest;
import com.example.demo.core.domain.FizzbuzzResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Web Adapter
 */
@RestController
@RequestMapping("/api/v1")
public class FizzbuzzApiController implements WriteFizzbuzzInboundPort {

    @Autowired
    private ComputeFizzbuzzInboundPort fizzbuzzUseCase;

    @PostMapping("/fizzbuzz")
    @ResponseStatus(HttpStatus.OK)
    @Override
    public FizzbuzzResponse writefizzbuzz(@Valid @RequestBody FizzbuzzRequest request) {
        return fizzbuzzUseCase.writefizzbuzz(request);
    }
}
