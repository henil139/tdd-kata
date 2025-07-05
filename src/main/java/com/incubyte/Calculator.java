package com.incubyte;

import java.util.regex.Pattern;

public class Calculator {
	public int add(String input) {
		if (input == null || input.isEmpty()) {
	        return 0;
	    }

	    String delimiter = "[,\n]"; // default delimiter is comma or newline

	    // Check for custom delimiter format
	    if (input.startsWith("//")) {
	        String[] parts = input.split("\n", 2);
	        String delimiterPart = parts[0].substring(2); // after "//"
	        delimiter = Pattern.quote(delimiterPart);     // escape special characters
	        input = parts[1]; // the remaining numbers
	    }

	    String[] numbers = input.split(delimiter);

	    int sum = 0;
	    for (String number : numbers) {
	        sum += Integer.parseInt(number.trim());
	    }

	    return sum;
	}
}
