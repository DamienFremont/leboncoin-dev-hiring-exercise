package com.example.demo.infrastructure;

import com.example.demo.core.application.MetricInboundPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Web Adapter
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/metric")
public class MetricApiController {

    @Autowired
    private MetricInboundPort metricService;

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Map getMetric() {
        return metricService.getFullMetric();
    }

    @GetMapping(value = "/most-used-request")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Map.Entry<String, Integer> getMetricMostUsedRequest() {
        return metricService.getMostUsedRequest();
    }
}
