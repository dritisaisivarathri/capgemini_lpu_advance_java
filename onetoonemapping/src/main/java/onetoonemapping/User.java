package onetoonemapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class User {
	
	public static void main(String[] args) {
		//findByCarId();
		deleteEngineById(); 
		
	}
	public static void findByCarId() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();
	    
	    Car c = em.find(Car.class,1);
	    System.out.println(c);
	    System.out.println(c.getEngine());
		
	}
	
	//delete only engine by id
	//remove connection b/w two tables
	//then only we can delete
	//we did null-> 100 now do 100-> null so do update first then delete
	//update car set e.id = null where e.id = ?1;
	//delete from engine where id=?2;
	public static void deleteEngineById() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();
	    
	   Query updateQuery =  em.createNativeQuery("Update car set engine_id = null where engine_id=?1");
	   updateQuery.setParameter(1, 100);
	   
	   Query deleteQuery = em.createNativeQuery("Delete from engine where id=?1");
	   deleteQuery.setParameter(1, 100);
	   
	   et.begin();
	   updateQuery.executeUpdate();
	   deleteQuery.executeUpdate();
	   et.commit();
	    
	   // Engine e = em.find(Engine.class, 100);
	    //et.begin();
	   // em.remove(e);
	    //et.commit();
	    
//	    String sql1 = "update Car set e.id = null where e.id = ?1";
//	    Query query1 = em.createQuery(sql1);
//	    
//	    String sql2 = "delete from Engine e where e.id = ?1";
//	    Query query2 = em.createQuery(sql2); 
//	    
//	    et.begin();
//	    query1.executeUpdate();
//	    query2.executeUpdate();
//	    query1.setParameter(1, 100);
//	    query2.setParameter(1, 100);
//	    et.commit();
//	    
		
	}
	
		
		
		//Persistence.createEntityManagerFactory("postgres");
	public static void insertCarAndEngine() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();
		
		Engine e = new Engine();
		e.setId(100);
		e.setType("V8");
		e.setFuelType("Petrol");
		e.setMileage("12");
		e.setCc("3000");
		
		Car c = new Car();
		c.setId(1);
		c.setModel("Polo Gt10");
		c.setBrand("volkswagen");
		c.setModelYear("2019");
		c.setPrice(10000.0);
		
		c.setEngine(e);
		
		et.begin();
		em.persist(e);
		em.persist(c);
		et.commit();
		
		
	
	}
}


