package com.product_hibernate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import com.practice.Product;
import com.practice.ProductDao;

public class ProductDaoTest {
	static EntityManagerFactory emf;
	EntityManager em;
	
	@BeforeAll
	public static void initEmf() {
		System.out.println("init emf");
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	}
	
	@BeforeEach
	public void initEm() {
		em = emf.createEntityManager();
}
}
	
	
	//@Test
	public void insertProductTest() {
		System.out.println("product inserted");
		ProductDao dao = new ProductDao();
		Product product = new Product();
		product.setId(2);
		product.setName("Pencil");
		product.setPrice(50);
		dao.insertProduct(product);
		
	}
	@Test
	public void findById() {
		System.out.println("product find");
		ProductDao dao = new ProductDao();
		Product p = dao.findById(1);
		assertNotNull(p);
		
	}
	

}
