package com.assignment5;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TicketService {
	
	public static void raiseSupportTicket(long order_id, String issue, String ticket_status) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Order order = em.find(Order.class,order_id);
		SupportTicket ticket = new SupportTicket();
		ticket.setOrder(order);
		ticket.setIssue(issue);
		ticket.setTicket_status(ticket_status);
		
		et.begin();
		em.persist(ticket);
		et.commit();
		
		System.out.println("Ticket raised");
	}

}
