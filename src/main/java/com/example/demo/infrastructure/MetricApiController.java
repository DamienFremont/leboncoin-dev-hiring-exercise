package com.example.demo.infrastructure;

import com.example.demo.core.application.MetricInboundPort;
import com.example.demo.core.domain.MetricItemResponse;
import com.example.demo.core.domain.MetricListResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

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
    public MetricListResponse getMetric() {
        return new MetricListResponse(
                metricService.getFullMetric()
                        .entrySet()
                        .stream()
                        .map(e -> new MetricItemResponse(e.getKey(), e.getValue()))
                        .collect(Collectors.toList()).toArray(new MetricItemResponse[0]));
    }

    @GetMapping(value = "/most-used-request")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public MetricItemResponse getMetricMostUsedRequest() {
        var res = metricService.getMostUsedRequest();
        return new MetricItemResponse(res.getKey(), res.getValue());
    }
}
