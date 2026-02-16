package com.manyToOneMapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main1 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		//delete department
		//make connection that is dept id as null and delete department table
		
		String sql1 = "update employee set department_deptid = null where department_deptid=?1";
		String sql2 = "delete from department where deptid = ?1";
		
		Query updateQuery = em.createNativeQuery(sql1);
		updateQuery.setParameter(1, 101);
		
		Query deleteQuery = em.createNativeQuery(sql2);
		deleteQuery.setParameter(1, 101);
		
		et.begin();
		updateQuery.executeUpdate();
		deleteQuery.executeUpdate();
		et.commit();
		em.close();
		
}
}