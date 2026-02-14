package com.oneToManyMapping;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main1 {
	public static void main(String[] args) {
		deleteStudentById();
	}
		
        //update student table 
	public static void insertCollegeAndStudent() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		College c = em.find(College.class, 1);
		
		List<Student> list = c.getStudent();
		
		Student s = new Student();
		s.setSid(105);
		s.setSname("harsha");
		s.setBranch("Mech");
		
		list.add(s);
		
		c.setStudent(list);
		et.begin();
		em.persist(s);
		et.commit();
	}
	
	//delete student by id
	public static void deleteStudentById() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();
	    
	    //first delete from connected table 
	   Query deleteQuery1 =  em.createNativeQuery("Delete from college_student where student_sid=?1");
	   deleteQuery1.setParameter(1, 101);
	   
	   //delete from student table
	   Query deleteQuery2 = em.createNativeQuery("Delete from Student where sid=?1");
	   deleteQuery2.setParameter(1, 101);
	   
	   et.begin();
	   deleteQuery1.executeUpdate();
	   deleteQuery2.executeUpdate(); 
	   et.commit();

}
}
