package com.example.demo.core.application;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

/**
 * Service
 * <p>
 * fizzBuzz.
 * see https://en.wikipedia.org/wiki/Fizz_buzz
 * <p>
 * Approach: String Concatenation
 */
@Slf4j
@AllArgsConstructor
public class FizzbuzzCalculator {

    private Integer int1;
    private Integer int2;
    private String str1;
    private String str2;

    /**
     * @param limit: number list size.
     * @return new list of numbers and strings
     */
    public String[] fizzBuzz(int limit) {
        var answer = new ArrayList<String>();

        // loop on every number
        for (var number = 1; number <= limit; number++) {

            var numSB = new StringBuilder();

            if (isDivisibleBy(number, int1)) {
                log.debug("Divides by int1, add str1");
                numSB.append(str1);
            }

            if (isDivisibleBy(number, int2)) {
                log.debug("Divides by int2, add str2");
                numSB.append(str2);
            }

            if (numSB.length() == 0) {
                log.debug("Not divisible by int1 or int2, add the current number");
                numSB.append(number);
            }

            // Append the current answer str to the ans list
            answer.add(numSB.toString());
        }
        return answer.toArray(new String[0]);
    }

    private boolean isDivisibleBy(int nbr, int div) {
        return nbr % div == 0;
    }
}
