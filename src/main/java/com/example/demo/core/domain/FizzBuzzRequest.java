package com.example.demo.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FizzBuzzRequest {

    private Integer int1;
    private Integer int2;
    private Integer limit;
    private String str1;
    private String str2;
}
