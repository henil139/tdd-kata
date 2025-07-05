package com.incubyte;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {
	
	//add is name of function and emptyString is input and returnsZero is return value
	//which is naming convention used for all test cases

	@Test
	void add_emptyString_returnsZero() {
        Calculator calculator = new Calculator();
        assertEquals(0, calculator.add(""));
    }
	
    @Test
    void add_singleNumber_returnsThatNumber() {
        Calculator calculator = new Calculator();
        assertEquals(1, calculator.add("1"));
    }

    @Test
    void add_twoCommaSeparatedNumbers_returnsTheirSum() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.add("1,5"));
    }

}
