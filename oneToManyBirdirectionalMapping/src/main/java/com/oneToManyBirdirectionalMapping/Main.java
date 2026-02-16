package com.oneToManyBirdirectionalMapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
	
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		//inserting data for student
		Student s1 = new Student();
		s1.setSid(103);
		s1.setBranch("CSE");
		s1.setSname("Driti");
		
		Student s2 = new Student();
		s2.setSid(104);
		s2.setBranch("ECE");
		s2.setSname("Lasya"); 
		
		//inserting data in college table
		College c = new College();
		c.setId(2);
		c.setName("Kendriya vidhyalaya");
		c.setLocation("Jalandhar");
		c.setPincode("524004");
		
		
		
		//we need to set data of student in college for updating 3 table
		//we will create list for that and add that to setStudent() method
		List<Student> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		c.setStudent(list);
		
		et.begin();
		em.persist(c);
		em.persist(s1);
		em.persist(s2);
		et.commit();
	}

}
