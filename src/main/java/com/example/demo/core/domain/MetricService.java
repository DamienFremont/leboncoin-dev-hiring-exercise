package com.example.demo.core.domain;

import com.example.demo.core.application.MetricInboundPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Use Case
 */
@Slf4j
@Component
public class MetricService implements MetricInboundPort {

    private Map<String, Integer> metricMap = new HashMap<String, Integer>();

    public void increaseCount(String request) {
        var count = metricMap.get(request);
        if (count == null) {
            count = 1;
        } else {
            count++;
        }
        metricMap.put(request, count);
    }

    public Map<String, Integer> getFullMetric() {
        return metricMap;
    }

    public Map.Entry<String, Integer> getMostUsedRequest() {
        return metricMap.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .orElse(new AbstractMap.SimpleEntry<String, Integer>("(none)", 0));
    }
}
