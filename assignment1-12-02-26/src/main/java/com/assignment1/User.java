package com.assignment1;

import java.util.List;

public class User {
	public static void main(String[] args) {
		StudentDuo duo = new StudentDuo();
		
		//insert
//		Student s = new Student();
//		s.setId(2);
//		s.setName("Driti");
//		s.setEmail("driti@email.com");
//		s.setMarks(80);
//
//		System.out.println(duo.insert(s));

		
		
		// FIND
//      Student found = duo.find(1);
//      if (found != null) {
//          System.out.println(
//                  found.getId() + " " +
//                  found.getName() + " " +
//                  found.getEmail() + " " +
//                  found.getMarks() 
//          );
//      }
      
      // FIND ALL
//    List<Student> list = duo.findAll();
//    for (Student p : list) {
//        System.out.println(
//                p.getId() + " " +
//                p.getName() + " " +
//                p.getEmail() + " " +
//                p.getMarks() 
//        );
//    } 
    
 // UPDATE
 //System.out.println(duo.update(1, "Lasya","lasya@email.com", 65));

 
 // DELETE
System.out.println(duo.delete(1));

duo.close();
		
	}

}
