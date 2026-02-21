package com.assignment5;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long order_id;
	private String order_date;
	private double order_totalAmount;
	
	@ManyToOne
	@JoinColumn
	private Customer customer;
	
	@ManyToMany
	@JoinTable
	private List <Product> product;
	
	public long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public double getOrder_totalAmount() {
		return order_totalAmount;
	}
	public void setOrder_totalAmount(double order_totalAmount) {
		this.order_totalAmount = order_totalAmount;
	}
	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", order_date=" + order_date + ", order_totalAmount=" + order_totalAmount
				+ "]";
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	

}
