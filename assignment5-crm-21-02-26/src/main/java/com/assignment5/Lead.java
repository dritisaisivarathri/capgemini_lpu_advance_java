package com.assignment5;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Lead {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long lead_id;
	private String lead_source;
	private String lead_status;
	private String lead_name;
	private String contactInfo;
	
	@ManyToOne
	@JoinColumn
	private SalesEmployee salesEmployee;
	
	@OneToOne
	@JoinColumn
	private Customer customer;
	public long getLead_id() {
		return lead_id;
	}
	public void setLead_id(long lead_id) {
		this.lead_id = lead_id;
	}
	public String getLead_source() {
		return lead_source;
	}
	public void setLead_source(String lead_source) {
		this.lead_source = lead_source;
	}
	public String getLead_status() {
		return lead_status;
	}
	public void setLead_status(String lead_status) {
		this.lead_status = lead_status;
	}
	
	public String getLead_name() {
		return lead_name;
	}
	public void setLead_name(String lead_name) {
		this.lead_name = lead_name;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	@Override
	public String toString() {
		return "Lead [lead_id=" + lead_id + ", lead_source=" + lead_source + ", lead_status=" + lead_status + "]";
	}
	public SalesEmployee getSalesEmployee() {
		return salesEmployee;
	}
	public void setSalesEmployee(SalesEmployee salesEmployee) {
		this.salesEmployee = salesEmployee;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	

}
