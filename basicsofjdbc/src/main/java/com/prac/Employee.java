package com.prac;

public class Employee {
	private int id;
	private String name;
	private int age;
	private String dept;
	
	public Employee(int id, String name, int age, String dept) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.dept = dept;
	}
	
	public boolean isValidAge() {
		
		if(age > 17) {
			return true;
			
		} else {
			return false;
		}
		
	}
	
	public boolean isValidName() {
		for(int i = 0 ; i <= name.length()-1;i++) {
			if(Character.isDigit(name.charAt(i))) {
				return false;
			} else if(!(Character.isLetter(name.charAt(i)))){
				return false; 
			}
		}
		return true;
	}
	

}
