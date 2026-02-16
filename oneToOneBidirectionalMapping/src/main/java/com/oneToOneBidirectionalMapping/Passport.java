package com.oneToOneBidirectionalMapping;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {
	@Id
	private int passport_id;
	private String passport_name;
	private String passport_dob;
	
	@OneToOne(mappedBy = "passport")
	private Person person;
	public int getPassport_id() {
		return passport_id;
	}
	public void setPassport_id(int passport_id) {
		this.passport_id = passport_id;
	}
	public String getPassport_name() {
		return passport_name;
	}
	public void setPassport_name(String passport_name) {
		this.passport_name = passport_name;
	}
	public String getPassport_dob() {
		return passport_dob;
	}
	public void setPassport_dob(String passport_dob) {
		this.passport_dob = passport_dob;
	}
	@Override
	public String toString() {
		return "Passport [passport_id=" + passport_id + ", passport_name=" + passport_name + ", passport_dob="
				+ passport_dob + "]";
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	

}
