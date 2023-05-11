package mavenprojects.newtestng;

import org.testng.annotations.Test;

public class TestNGDemo {
	
	@Test(priority=1)// TestNG follows alphabetical order for multiple tc's and prints...if we give priority it follows priority than alphabetical order
	public void userlogin()
	{
		System.out.println("Login successful");

	}
	
	@Test(priority=2)
	public void adminlogout()
	{
		System.out.println("Logout successful");

	}

}
