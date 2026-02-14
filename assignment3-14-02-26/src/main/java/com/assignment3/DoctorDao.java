package com.assignment3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DoctorDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();
    
 // ---------------- INSERT PATIENT DATA ----------------
    public String insert(Doctor doctor) {

        if (doctor == null) {
            return "Illegal Argument";
        }

        et.begin();
        em.persist(doctor);
        et.commit();
        return "Doctor Data saved";
    }

    
    //FIND Doctor BY ID
    public Doctor find(int doctorId) {
        return em.find(Doctor.class, doctorId);  
    } 

}
