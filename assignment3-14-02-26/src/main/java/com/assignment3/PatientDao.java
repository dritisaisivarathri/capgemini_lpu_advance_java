package com.assignment3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class PatientDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();
    
 // ---------------- INSERT PATIENT DATA ----------------
    public String insert(Patient patient) {

        if (patient == null) {
            return "Illegal Argument";
        }

        et.begin();
        em.persist(patient);
        et.commit();
        return "Patient Data saved";
    }

    
    //FIND PATIENT BY ID
    public Patient find(int patientId) {
        return em.find(Patient.class, patientId); 
    } 
    
  //---------------- FIND ALL PATIENTS ----------------
    public List<Patient> findAll() {
        TypedQuery<Patient> query =
                em.createQuery("SELECT p FROM Patient p", Patient.class);
        return query.getResultList();
    }

    public void close() { 
        em.close();
        emf.close();
    }
    
 // ---------------- UPDATE ----------------
    public String update(int patientId, String patientName, int patientAge, String patientContact) {

        Patient p = em.find(Patient.class, patientId);

        if (p == null) {
            return "Patient not found";
        }

        et.begin();
        p.setPatientName(patientName);
        p.setPatientAge(patientAge);
        p.setPatientContact(patientContact);
        em.merge(p);
        et.commit();

        return "Patient updated";
    }
    
    // ---------------- DELETE ----------------
    public String delete(int id) {

        Patient p = em.find(Patient.class, id);

        if (p == null) {
            return "Patient not found";
        }

        et.begin();
        em.remove(p);
        et.commit();

        return "Patient deleted";
    }

}
