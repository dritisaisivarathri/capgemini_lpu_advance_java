package com.manyToManyMapping;

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
		
		//creating for student
		Student s = new Student();
		s.setStu_name("driti");
		s.setStu_gender("female");
		s.setStu_branch("cse");
		
		Student so = new Student();
		so.setStu_name("lasya");
		so.setStu_gender("female");
		so.setStu_branch("ece");
		
		
		//creating for subject
		Subject s1 = new Subject();
		s1.setSub_id(101);
		s1.setSub_name("maths");
		s1.setSub_no_of_days(30);
		
		
		Subject s2 = new Subject();
		s2.setSub_id(102);
		s2.setSub_name("science");
		s2.setSub_no_of_days(50);
		
		Subject s3 = new Subject();
		s3.setSub_id(103);
		s3.setSub_name("social");
		s3.setSub_no_of_days(60);
		
		List<Subject> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		s.setSubject(list);
		so.setSubject(list);
		
		et.begin();
		em.persist(s);
		em.persist(so);
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		et.commit();
	}

}
