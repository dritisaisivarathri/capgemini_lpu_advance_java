package com.product_hibernate;

import com.practice.Calculator;

@Test
public class CalculatorTest {
	public void divideTest() {
		Calculator c = new Calculator();
		int actualRes = c.divide(10,2);
		assertEquals(5,actualRes);
		
	}

	public void divideTestZero() {
		Calculator c = new Calculator();
		int actualRes = c.divide(10,0);
		assertEquals(0,actualRes);
		
	}
}
