package com.example.demo.infrastructure;

import com.example.demo.core.application.ComputeFizzbuzzOutboundPort;
import lombok.AllArgsConstructor;

import java.util.ArrayList;

/**
 * Service Adapter
 *
 * Approach: String Concatenation
 */
@AllArgsConstructor
public class FizzbuzzCalculator implements ComputeFizzbuzzOutboundPort {

    private Integer int1;
    private Integer int2;
    private String str1;
    private String str2;

    public String[] fizzBuzz(int limit) {
        var answer = new ArrayList<String>();

        // loop on every number
        for (var number = 1; number <= limit; number++) {

            var numAnsStr = "";

            var isDivisibleByInt1 = isDivisibleBy(number, int1);
            var isDivisibleByInt2 = isDivisibleBy(number, int2);

            // Divides by int1, add str1
            if (isDivisibleBy(number, int1)) {
                numAnsStr += str1;
            }

            // Divides by int2, add str2
            if (isDivisibleBy(number, int2)) {
                numAnsStr += str2;
            }

            // Not divisible by int1 or int2, add the current number
            if ("".equals(numAnsStr)) {
                numAnsStr += number;
            }

            // Append the current answer str to the ans list
            answer.add(numAnsStr);
        }
        return answer.toArray(new String[0]);
    }

    private boolean isDivisibleBy(int nbr, int div) {
        return nbr % div == 0;
    }
}
