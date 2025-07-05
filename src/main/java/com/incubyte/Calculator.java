package com.incubyte;

import java.util.*;
import java.util.regex.Pattern;

public class Calculator {

    public int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = "[,\n]"; // default delimiters
        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);
            if (parts.length < 2) {
                throw new RuntimeException("Invalid input format for custom delimiter.");
            }
            delimiter = Pattern.quote(parts[0].substring(2)); // safely escape delimiter
            input = parts[1];
        }

        String[] numbers = input.split(delimiter);
        List<Integer> negatives = new ArrayList<>();
        int sum = 0;

        for (String numberStr : numbers) {
            if (numberStr.trim().isEmpty()) continue;

            int num = Integer.parseInt(numberStr.trim());

            if (num < 0) {
                negatives.add(num);
            } else {
                sum += num;
            }
        }

        if (!negatives.isEmpty()) {
            String message = "negative numbers not allowed: " +
                             String.join(", ", negatives.stream()
                                                        .map(String::valueOf)
                                                        .toArray(String[]::new));
            throw new RuntimeException(message);
        }

        return sum;
    }
}
