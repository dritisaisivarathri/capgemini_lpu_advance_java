package comm.manyToManyBidirectionalMapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		//creating for student
		Student stu1 = new Student();
		stu1.setStu_name("driti");
		stu1.setStu_gender("female");
		stu1.setStu_branch("cse");
		
		Student stu2 = new Student();
		stu2.setStu_name("lasya");
		stu2.setStu_gender("female");
		stu2.setStu_branch("ece");
		
		
		//creating for subject
		Subject sub1 = new Subject();
		sub1.setSub_id(101);
		sub1.setSub_name("maths");
		sub1.setSub_no_of_days(30);
		
		
		Subject sub2 = new Subject();
		sub2.setSub_id(102);
		sub2.setSub_name("science");
		sub2.setSub_no_of_days(50);
		
		Subject sub3 = new Subject();
		sub3.setSub_id(103);
		sub3.setSub_name("social");
		sub3.setSub_no_of_days(60);
		
		//immutable wa of creating list
//		List<Student> stu = List.of(stu1,stu2);
//		List<Subject> sub = List.of(sub1,sub2,sub3);
		
		List<Subject> list = new ArrayList<>();
		list.add(sub1);
		list.add(sub2);
		list.add(sub3);
		stu1.setSubject(list);
		stu2.setSubject(list);
		
	    List<Student> list1 = new ArrayList<>();
	    list1.add(stu1);
	    list1.add(stu2);
	    sub1.setStudent(list1);
	    sub2.setStudent(list1);
	    sub3.setStudent(list1);
	    
		et.begin();
		em.persist(stu1);
		em.persist(stu2);
		em.persist(sub1);
		em.persist(sub2); 
		em.persist(sub3); 
		et.commit();
	}

}
