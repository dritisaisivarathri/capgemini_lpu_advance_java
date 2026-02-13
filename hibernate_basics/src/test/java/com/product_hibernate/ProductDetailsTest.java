package com.practice;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.*;

public class ProductDetailsTest {

    static EntityManagerFactory emf;
    EntityManager em;
    ProductDao dao;

    @BeforeAll
    public static void initEmf() {
        emf = Persistence.createEntityManagerFactory("postgres");
    }

    @BeforeEach
    public void initEm() {
        em = emf.createEntityManager();
        dao = new ProductDao(em);
    }

    @Test
    public void insertProductTest() {
        Product product = new Product();
        product.setId(4);
        product.setName("Pen");
        product.setPrice(10);
        product.setQuantity(5);

        String actualRes = dao.insertProduct(product);
        assertEquals("Product inserted", actualRes);
    }

    @Test
    public void insertProductTestNull() {
        String actualRes = dao.insertProduct(null);
        assertEquals("Illegal Argument", actualRes);
    }

    @Test
    public void findProductTest() {
        Product product = dao.findProduct(4);
        assertNotNull(product);
    }

    @Test
    public void deleteProductTest() {
        String result = dao.deleteProduct(4);
        assertEquals("Product deleted", result);
    }

    @AfterEach
    public void destroyEm() {
        em.close();
    }

    @AfterAll
    public static void destroyEmf() {
        emf.close();
    }
}
