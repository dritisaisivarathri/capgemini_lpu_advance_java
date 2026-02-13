package com.assignment1;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

//import com.student.Student;

public class StudentDuo {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();
    
 // ---------------- INSERT ----------------
    public String insert(Student student) {

        if (student == null) {
            return "Illegal Argument";
        }

        et.begin();
        em.persist(student);
        et.commit();
        return "Student inserted";
    }

    
    //FIND STUDENT BY ID
    public Student find(int id) {
        return em.find(Student.class, id); 
    } 
    
  //---------------- FIND ALL STUDENTS ----------------
    public List<Student> findAll() {
        TypedQuery<Student> query =
                em.createQuery("SELECT s FROM Student s", Student.class);
        return query.getResultList();
    }

    public void close() { 
        em.close();
        emf.close();
    }
    
 // ---------------- UPDATE ----------------
    public String update(int id, String name, String email,int marks) {

        Student p = em.find(Student.class, id);

        if (p == null) {
            return "Student not found";
        }

        et.begin();
        p.setName(name);
        p.setEmail(email);
        p.setMarks(marks);;
        em.merge(p);
        et.commit();

        return "Student updated";
    }
    
    // ---------------- DELETE ----------------
    public String delete(int id) {

        Student p = em.find(Student.class, id);

        if (p == null) {
            return "Student not found";
        }

        et.begin();
        em.remove(p);
        et.commit();

        return "Student deleted";
    }
    
    //-------------------COUNT----------------
    public long getStudentCount() {
    	return em.createQuery("Select count(p) from Student p",Long.class)
    			.getSingleResult();
    }
}



