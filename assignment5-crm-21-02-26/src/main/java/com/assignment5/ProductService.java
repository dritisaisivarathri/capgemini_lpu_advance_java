package com.assignment5;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProductService {
	
	public static void addProduct(String product_name, double product_price) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Product product = new Product();
		product.setProduct_name(product_name);
		product.setProduct_price(product_price);
		
		et.begin();
		em.persist(product); 
		et.commit();
		
		System.out.println("prodct added");
	}

}
