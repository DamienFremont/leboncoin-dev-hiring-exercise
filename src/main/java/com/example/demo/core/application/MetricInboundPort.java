package com.example.demo.core.application;

import java.util.Map;

/**
 * Inbound Port
 */
public interface MetricInboundPort {

    void increaseCount(String request);

    Map<String, Integer> getFullMetric();

    Map.Entry<String, Integer> getMostUsedRequest();
}
