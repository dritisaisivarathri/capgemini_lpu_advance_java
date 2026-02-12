package com.prac;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test; 
public class CalculatorTest {
	
	public void addTest() {
		int res = Calculator.add(10,20); 
		
	}
	@Test
	public void reverseTest() {
		String actualres = Calculator.reverseString("Driti");
		//compare expected ---> actual
		//itirD ----> tirD
		
		//we use assertions
		
		assertEquals("itirD",actualres);
		
		
	}
	
//	@Test
//	public void reverseTestNull() { 
//		String actualRes = Calculator.reverseString(null);
//		
//		assertEquals("llun",actualRes);
//	}
	
	@Test
	public void palindromeTest() {
		boolean actualres = Calculator.palindrome("level");
		assertEquals(true,actualres);
	}
	
	@Test
	public void factorialTest() {
		int actualres = Calculator.factorial(5);
		assertEquals(120,actualres);
	}
	
	@Test
	public void testValidAge() {
		Employee e = new Employee(101,"Driti",20,"Mech");
		
		assertTrue(e.isValidAge());
		//assertFalse(e.isValidAge());
	}
	
	@Test
	public void testValidName() {
		Employee e = new Employee(102,"Lasya",20,"CSE");
		assertTrue(e.isValidName());
	}
	
	@Test
	public void testArithmeticException() {
		Calculator c = new Calculator();
		assertThrows(ArithmeticException.class,()->{c.div(10,0);});
		
	}
	

}
