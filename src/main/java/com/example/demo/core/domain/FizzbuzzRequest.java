package com.example.demo.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.*;

/**
 * Model
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FizzbuzzRequest {

    @NotNull(message = "Please provide a int1")
    private Integer int1;
    @NotNull(message = "Please provide a int2")
    private Integer int2;
    @NotNull(message = "Please provide a limit")
    private Integer limit;
    @NotBlank(message = "Please provide a str1")
    private String str1;
    @NotBlank(message = "Please provide a str2")
    private String str2;
}
