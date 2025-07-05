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
    
    @Test
    void add_multipleCommaSeparatedNumbers_returnsTheirSum() {
        Calculator calculator = new Calculator();
        assertEquals(15, calculator.add("2,4,3,6"));
    }
    
    @Test
    void add_numbersWithNewlines_returnsTheirSum() {
        Calculator calculator = new Calculator();
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    void add_customSemicolonDelimiter_returnsSum() {
        Calculator calculator = new Calculator();
        assertEquals(3, calculator.add("//;\n1;2"));
    }
    @Test
    void add_negativeNumbers_throwsExceptionWithAllNegatives() {
        Calculator calculator = new Calculator();
        Exception exception = assertThrows(RuntimeException.class, () -> {
            calculator.add("2,-4,3,-5");
        });

        assertEquals("negative numbers not allowed: -4, -5", exception.getMessage());
    }

}
