package com.example.demo.core.application;

import com.example.demo.core.domain.FizzbuzzRequest;
import com.example.demo.core.domain.FizzbuzzResponse;

/**
 * Inbound Port
 */
public interface ComputeFizzbuzzInboundPort {

    FizzbuzzResponse writefizzbuzz(FizzbuzzRequest request);
}
