package com.assignment5;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class OrderService {
	
	public static void placeOrder(
	        long customerId,
	        List<Long> productIds,
	        String date) {

	    EntityManagerFactory emf =
	            Persistence.createEntityManagerFactory("postgres");
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();

	    Customer customer = em.find(Customer.class, customerId);

	    List<Product> products = new ArrayList<>();
	    double total = 0;

	    // ✅ fetch each product separately
	    for(Long id : productIds) {

	        Product product = em.find(Product.class, id);

	        if(product != null) {
	            products.add(product);
	            total += product.getProduct_price();
	        }
	    }

	    Order order = new Order();
	    order.setCustomer(customer);
	    order.setProduct(products);
	    order.setOrder_date(date);
	    order.setOrder_totalAmount(total);

	    et.begin();
	    em.persist(order);
	    et.commit();

	    em.close();
	}
}