package com.example.demo.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetricListResponse {
    private MetricItemResponse[] metrics;
}
