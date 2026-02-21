package com.assignment5;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CustomerService {
	
	public static void registerCustomer(String customer_name, String customer_email, String customer_phone) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	Customer customer = new Customer();
	customer.setCustomer_name("Driti sai");
	customer.setCustomer_email("dritisai@gmail.com");
	customer.setCustomer_phone("9704490499");
	
	et.begin();
	em.persist(customer);
	et.commit();
	System.out.println("Registered Successfully");
	

}
	public static void addAddress(long customer_id, String address_city, String address_state, String address_pincode) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Customer customer = em.find(Customer.class, customer_id);
		Address address = new Address();
		address.setAddress_city(address_city);
		address.setAddress_state(address_state);
		address.setAddress_pincode(address_pincode);
		
		et.begin();
		address.setCustomer(customer);	
		customer.setAddress(address);
		em.persist(address);
		et.commit();
		
		System.out.println("Address updated successfully");
		
	}
}
