package com.oneToOneBidirectionalMapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();
	    
	    Passport passport = new Passport();
	    passport.setPassport_id(1);
	    passport.setPassport_name("domestic");
	    passport.setPassport_dob("12-feb-2004");
	    
	  
	    
	    Person person = new Person();
	    person.setPerson_id(101);
	    person.setPerson_name("driti");
	    person.setPerson_phno("9704490499");
	    person.setPerson_email("driti@mail.com");
	    
	    person.setPassport(passport);
	    passport.setPerson(person);
	    
	    et.begin();
	    em.persist(person);
	    //em.persist(passport); //because we are using cascading near one to onr no need to persist child class
	    et.commit();

	}

}
