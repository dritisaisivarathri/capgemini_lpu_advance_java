package mokitoprac;

//CLASS TO WRITE BUSINESS LOGIC
public class UserService {
	
	
	UserDao dao; //having null
	
	//takes dao reference
	public UserService(UserDao dao){ 
		this.dao = dao;
	}
	
	//TO FIND WHAT TYPE OF USER
	public String typeOfUser(int id) {
		User user = dao.findById(id);
		
		if(user.getBalance() > 0 && user.getBalance() <= 1000) {
			return "new user";
		} else if(user.getBalance() > 1001 && user.getBalance() <= 2000) {
			return "regular user";
		} else {
			return "premium user"; 
		}
		
	}
	

}
