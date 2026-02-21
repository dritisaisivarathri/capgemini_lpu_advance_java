package com.assignment5;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long address_id;
	private String address_city;
	private String address_state;
	private String address_pincode;
	
	@OneToOne(mappedBy="address")
	private Customer customer;
	public long getAddress_id() {
		return address_id;
	}
	public void setAddress_id(long address_id) {
		this.address_id = address_id;
	}
	public String getAddress_city() {
		return address_city;
	}
	public void setAddress_city(String address_city) {
		this.address_city = address_city;
	}
	public String getAddress_state() {
		return address_state;
	}
	public void setAddress_state(String address_state) {
		this.address_state = address_state;
	}
	public String getAddress_pincode() {
		return address_pincode;
	}
	public void setAddress_pincode(String address_pincode) {
		this.address_pincode = address_pincode;
	}
	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", address_city=" + address_city + ", address_state="
				+ address_state + ", address_pincode=" + address_pincode + "]";
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	

}
