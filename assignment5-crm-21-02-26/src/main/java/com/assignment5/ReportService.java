package com.assignment5;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ReportService {


    // 1. Employee Performance Report
    public static void getEmployeePerformance(long employeeId) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        // count leads handled by employee
        Query query = em.createNativeQuery(
                "SELECT COUNT(*) FROM lead WHERE salesEmployee_emp_id=?1");

        query.setParameter(1, employeeId);

        et.begin();
        Object result = query.getSingleResult();
        et.commit();

        System.out.println("Total Leads handled = " + result);

        em.close();
        emf.close();
    }


    // 2. Total Orders Placed By Customer
    
    public static void getCustomerOrderCount(long customerId) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Query query = em.createNativeQuery(
                "SELECT COUNT(*) FROM orders WHERE customer_customer_id=?1");

        query.setParameter(1, customerId);

        et.begin();
        Object result = query.getSingleResult();
        et.commit();

        System.out.println("Total Orders = " + result);

        em.close();
        emf.close();
    }

    
    // 3. Total Revenue Generated
  
    public static void getTotalRevenue() {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Query query =
                em.createNativeQuery("SELECT SUM(order_totalAmount) FROM orders");

        et.begin();
        Object result = query.getSingleResult();
        et.commit();

        System.out.println("Total Revenue = " + result);

        em.close();
        emf.close();
    }

   
    // 4. View All Support Tickets
   
    public static void viewAllTickets() {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Query query = em.createNativeQuery("SELECT * FROM support_ticket");

        et.begin();
        List<Object[]> tickets = query.getResultList();
        et.commit();

        for (Object[] t : tickets) {
            System.out.println(
                    "TicketID: " + t[0] +
                    " | Issue: " + t[1] +
                    " | Status: " + t[2]);
        }

        em.close();
        emf.close();
    }
}