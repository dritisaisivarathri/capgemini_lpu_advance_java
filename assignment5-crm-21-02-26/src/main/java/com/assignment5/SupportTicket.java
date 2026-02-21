package com.assignment5;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class SupportTicket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long ticket_id;
	private String issue;
	private String ticket_status;
	
	@OneToOne
	@JoinColumn
	private Order order;
	public long getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(long ticket_id) {
		this.ticket_id = ticket_id;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getTicket_status() {
		return ticket_status;
	}
	public void setTicket_status(String ticket_status) {
		this.ticket_status = ticket_status;
	}
	@Override
	public String toString() {
		return "SupportTicket [ticket_id=" + ticket_id + ", issue=" + issue + ", ticket_status=" + ticket_status + "]";
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	

}
