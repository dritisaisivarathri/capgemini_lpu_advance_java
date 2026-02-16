package com.manyToOneMapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		//insert data for department
		Department d1 = new Department();
		//d1.setDeptId(101);
		d1.setDeptName("Sales");
		d1.setManagerName("Ramuu");
		d1.setNumOfEmp(10);
		
		//insert data for employee
		Employee e1 = new Employee();
		//e1.setEmpId(1); //because we created generatedvalue for employee id if not used write manually
		e1.setEmpName("driti");
		e1.setEmpSalary(5000);
		e1.setEmpDesignation("software manager");
		
		Employee e2 = new Employee();
		//e2.setEmpId(2);
		e2.setEmpName("lasya");
		e2.setEmpSalary(9000);
		e2.setEmpDesignation("electric manager");
		
		
		
		e1.setDepartment(d1);
		e2.setDepartment(d1);
		
		et.begin();
		em.persist(d1);
		em.persist(e1);
		em.persist(e2);
		et.commit();
		
	}

}
