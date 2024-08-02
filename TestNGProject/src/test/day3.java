package test;

import org.testng.annotations.Test;

public class day3 {

	@Test(timeOut=400)
	public void mobilelogincarloan()
	{
		//Appium 
		System.out.println("Mobile login Car");
	} 
	@Test(enabled=true)    // while executing script will not run this code if enabled is false
	public void weblogincarloan() 
	{
		//Selenium
		System.out.println("Web Login Car");
	} 
	
	@Test(dependsOnMethods= {"mobilelogincarloan", "weblogincarloan"})   //code will execute only if the "mobilelogincarloan" is executed
	public void loginapicarloan() 
	{
		//REST API Testing
		System.out.println("REST API Login Car");
	}
}
