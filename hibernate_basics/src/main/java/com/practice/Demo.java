package com.practice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demo {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		
		//creating entity manager
		//give us method to perform crud operations
		
		EntityManager em = emf.createEntityManager();
		
		//Entity Transaction
		//converting object to query type
		//with the help of entity manager reference
		EntityTransaction et = em.getTransaction();
		
		Student s = new Student();
		s.setId(2);
		s.setName("rohit");
		s.setPercentage(80);
		
		et.begin();
		em.persist(s);
		et.commit();
		
		emf.close();
	}

}
