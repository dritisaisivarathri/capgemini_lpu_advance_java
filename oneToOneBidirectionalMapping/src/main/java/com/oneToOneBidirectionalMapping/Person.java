package com.oneToOneBidirectionalMapping;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	private int person_id;
	private String person_name;
	private String person_phno;
	private String person_email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Passport passport;
	
	public int getPerson_id() {
		return person_id;
	}
	public void setPerson_id(int person_id) {
		this.person_id = person_id;
	}
	public String getPerson_name() {
		return person_name;
	}
	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}
	public String getPerson_phno() {
		return person_phno;
	}
	public void setPerson_phno(String person_phno) {
		this.person_phno = person_phno;
	}
	public String getPerson_email() {
		return person_email;
	}
	public void setPerson_email(String person_email) {
		this.person_email = person_email;
	}
	@Override
	public String toString() {
		return "Person [person_id=" + person_id + ", person_name=" + person_name + ", person_phno=" + person_phno
				+ ", person_email=" + person_email + "]";
	}
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	
	
	

}
