package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day2 {
 
	@Parameters({"URL","APIKey/username"})
	@Test(groups="Smoke")
	public void ploan(String urlname, String apikeyusername)
	{
		System.out.println("Good"); 
		System.out.println(urlname);
		System.out.println(apikeyusername);
	} 
	
	@BeforeTest
	public void prerequisit()
	{
		System.out.println("This is the prereqisite need to be executed before");
	}
	
	@Test(dataProvider="getData")
	public void mobilesignincarloan(String username, String password) 
	{
		System.out.println("signout");
		System.out.println(username);
		System.out.println(password);
	} 
	
	@DataProvider
	public Object[][] getData() 
	{
		//1st - combination of username and password with good credit history
		//2nd - username password - no credit history
		//3rd - fraud credit history
		
		Object[][] data = new Object[3][2];
		data[0][0] = "Firstusername";
		data[0][1] = "password";
		
		data[1][0] = "secondusername";
		data[1][1] = "secondpassword"; 
		
		data[2][0] = "thirdusername";
		data[2][1] = "thirdpassword"; 
		
		return data;
	}
}
