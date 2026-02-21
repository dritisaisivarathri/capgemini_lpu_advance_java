package com.assignment5;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class SalesEmployee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long emp_id;
	private String emp_name;
	private String emp_department;
	
	@OneToMany(mappedBy="salesEmployee")
	private List <Lead> lead;
	public long getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(long emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_department() {
		return emp_department;
	}
	public void setEmp_department(String emp_department) {
		this.emp_department = emp_department;
	}
	@Override
	public String toString() {
		return "SalesEmployee [emp_id=" + emp_id + ", emp_name=" + emp_name + ", emp_department=" + emp_department
				+ "]";
	}
	public List<Lead> getLead() {
		return lead;
	}
	public void setLead(List<Lead> lead) {
		this.lead = lead;
	}
	
	

}
