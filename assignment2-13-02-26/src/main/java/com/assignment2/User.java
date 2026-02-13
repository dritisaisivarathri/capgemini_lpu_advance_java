package com.assignment2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.assignment2.Student; 



public class User {
public static void main(String[] args) {
	//insertStudentAadharAndHostel();
	//findByStudentId();
	deleteAadharById();
	
}


//INSERTING DATA
public static void insertStudentAadharAndHostel() {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();
    
    Student s = new Student();
    s.setStuId(1);
    s.setStuName("driti");
    s.setStuEmail("driti@gmail.com");
    s.setStuBranch("cse");
	
	AadharCard a = new AadharCard();
	a.setAadharId(101);
	a.setAadharNumber(123456);
	a.setAddress("nellore");
	a.setIssueDate("12-03-25");
	
	
	
	HostelRoom h = new HostelRoom();
	h.setRoomId(201);
	h.setRoomNo(1);
	h.setBlockName("a block");
	h.setFloorNumber(3);
	
	s.setAadharCard(a);
	s.setHostelRoom(h);
	
	
	
	et.begin();
	em.persist(a);
	em.persist(h);
	em.persist(s);
	et.commit();
	
	

}

//FETCHING STUDENT DETAILS
public static void findByStudentId() {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();
    
    Student s = em.find(Student.class,1);
    System.out.println(s);
    System.out.println(s.getAadharCard());
    System.out.println(s.getHostelRoom());
	
}

//DELETING AADHARCARD BUT HOSTEL ROOM SHOULD BE THERE
public static void deleteAadharById() {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();
    
   Query updateQuery =  em.createNativeQuery("Update student set aadharcard_aadharid = null where aadharcard_aadharid=?1");
   updateQuery.setParameter(1, 101);
   
   Query deleteQuery = em.createNativeQuery("Delete from aadharcard where aadharid=?1");
   deleteQuery.setParameter(1, 101);
   
   et.begin();
   updateQuery.executeUpdate();
   deleteQuery.executeUpdate();
   et.commit();
}
}


