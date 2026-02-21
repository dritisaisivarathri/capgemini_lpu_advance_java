package com.assignment5;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class LeadService {
	public static void createLead(String lead_source, String lead_name, String contactInfo) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Lead lead = new Lead();
		lead.setLead_source(lead_source);
		lead.setLead_status("NEW");
		lead.setLead_name(lead_name);
		lead.setContactInfo(contactInfo);
		
		et.begin();
		em.persist(lead);
		et.commit();
		
		System.out.println("Lead created sccessfully");
	}
	
	public static void assignLead(long lead_id, long emp_id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Lead lead = em.find(Lead.class, lead_id);
		SalesEmployee emp = em.find(SalesEmployee.class, emp_id);
		et.begin();
		lead.setSalesEmployee(emp);
		et.commit();
		
		System.out.println("lead assiged succesfully");
	}
	


}
