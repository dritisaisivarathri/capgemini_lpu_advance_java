package com.manyToManyMapping;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subject {
	@Id
	private int sub_id;
	private String sub_name;
	private int sub_no_of_days;
	public int getSub_id() {
		return sub_id;
	}
	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}
	public String getSub_name() {
		return sub_name;
	}
	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}
	public int getSub_no_of_days() {
		return sub_no_of_days;
	}
	public void setSub_no_of_days(int sub_no_of_days) {
		this.sub_no_of_days = sub_no_of_days;
	}
	@Override
	public String toString() {
		return "Subject [sub_id=" + sub_id + ", sub_name=" + sub_name + ", sub_no_of_days=" + sub_no_of_days + "]";
	}
	
	
	

}
