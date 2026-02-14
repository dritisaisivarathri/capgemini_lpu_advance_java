package com.assignment3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AppointmentDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();
    
 // ---------------- INSERT PATIENT DATA ----------------
    public String insert(Appointment appointment) {

        if (appointment == null) {
            return "Illegal Argument";
        }

        et.begin();
        em.persist(appointment);
        et.commit();
        return "Appointment Data saved";
    }

 
    public Appointment findById(int id) {
        return em.find(Appointment.class, id);
    }

    public void updateAppointment(Appointment appointment) {
        et.begin();
        em.merge(appointment);
        et.commit();
    }


	public String updateFee(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}


}
