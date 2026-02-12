package com.prac;

public class Calculator {
	public static void main(String[] args) {
		//execute that method
		System.out.println(Calculator.add(20,30));
		System.out.println(Calculator.reverseString("Driti"));
		System.out.println(Calculator.factorial(5));
		System.out.println(Calculator.palindrome("level"));
		
	}
	public static int add(int a, int b) {
		return a+b;
	}
	
	public static int factorial(int c) {
		int res = 1,i;
		for(i = 2;i<=c;i++) {
			res *= i;
		}
		return res;
	}
	
	public static boolean palindrome(String h) {
		h = h.toLowerCase();
		String rev = "";
		for(int i = h.length()-1;i>=0;i--) {
			rev = rev +h.charAt(i);
		}
		return h.equals(rev); 
		
	}
	public static String reverseString(String data) {
		String rev = "";
		for(int i = data.length()-1;i>=0;i--) {
			rev = rev+data.charAt(i);
		} 
		return rev;
		
	}
	
	public static int div(int a, int b) {
		return a/b;
	}
	
	//JUNIT
	//UNIT TESTING FRAMEWORK

}
