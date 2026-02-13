package com.assignment1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.assignment1.Student;
import com.assignment1.Student;
import com.assignment1.StudentDuo;
import com.assignment1.Student;

public class StudentTest {
	 static EntityManagerFactory emf;
	    EntityManager em;
	    

	    @BeforeAll
	    public static void initEmf() {
	        System.out.println("Init EMF");
	        emf = Persistence.createEntityManagerFactory("postgres");
	    }
	    
	    @BeforeEach
	    public void initEm() {
	        em = emf.createEntityManager();
	    }
	    
	    // ---------------- INSERT SUCCESS ----------------
	   @Test
	    public void insertPersonTest() {
	        StudentDuo duo = new StudentDuo();

	        Student student = new Student();
	        student.setId(1);
	        student.setName("lasya");
	        student.setEmail("lasya@gmail.com");
	        student.setMarks(96); 
	        

	        String result = duo.insert(student);
	        assertEquals("Student inserted", result);
	    }
	   
	   
	    
	 // ---------------- FIND BY ID ----------------
	   // @Test
	    public void findStudentTest() {
	        StudentDuo duo = new StudentDuo();

	        Student student = duo.find(1);
	        assertNotNull(student);
	    }
	    
	 // ---------------- UPDATE STUDENT ----------------
	    @Test
	    public void updateTest() {
	        StudentDuo duo = new StudentDuo();

	        String result = duo.update(1, "Lasya", "lasya@gmail.com",560001);
	        assertEquals("Person updated", result);
	    }
	    
	    //-----------------------DELETE------------------
	    @Test
	    public void deleteTest() {
	    	StudentDuo duo = new StudentDuo();
	    	assertEquals("Student deleted",duo.delete(1));
	    }
	    
	    //----------STUDENT COUNT------------
	    @Test
	    public void testStudentCount() {
	    	StudentDuo duo = new StudentDuo();
	    	long count = duo.getStudentCount();
	    	assertTrue(count >= 0);
	    }
	    
	    


}
