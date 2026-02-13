package mokitoprac;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;


public class UserServiceTest {
	
	@Test 
	public void testGetTypeOfCustomer() {
		UserDao userdao = new UserDao();
		UserService userService = new UserService(userdao);
		String actualRes = userService.typeOfUser(1);
		assertEquals("regular user",actualRes);
		
	}
	
	@Test
	public void testDoubleAddition() {
		//mock an object
		//STEP 1: CREATE FAKE OBJECT
		Calculator calmock = mock(Calculator.class);
		
		//STEP 2: WHAT MOCK OBJECT SHOULD RETURN
		when(calmock.add(5,5)).thenReturn(20);
		
		//STEP 3: GIVE THE FAKE OBJECT REFERENCE
		//INJECT THE MOCK REFERENCE
		MathService service = new MathService(calmock);
		int res = service.doubleAddition(5, 5);
		
		assertEquals(-1,res);
	}

}
