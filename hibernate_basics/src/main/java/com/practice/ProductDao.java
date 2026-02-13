package com.practice;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ProductDao {

    private EntityManager em;

    public ProductDao(EntityManager em) {
        this.em = em;
    }

    public String insertProduct(Product p) {
        if (p == null) {
            return "Illegal Argument";
        }

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(p);
        et.commit();

        return "Product inserted";
    }

    public Product findProduct(int id) {
        return em.find(Product.class, id);
    }

    public String deleteProduct(int id) {
        Product p = findProduct(id);

        if (p == null) {
            return "Product not found";
        }

        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(p);
        et.commit();

        return "Product deleted";
    }
}
