package test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass; 

public class day1 {

	@BeforeClass
	public void beforeclass() 
	{
		System.out.println("Before executing any method in the class ");
	} 
	
	@AfterClass
	public void afterclass()
	{
		System.out.println("After executing any method in the class");
	}
	@AfterTest
	public void AfterTest() 
	{
		System.out.println("I will run at last");
	} 
	
	@BeforeMethod
	public void beforemethod()
	{
		System.out.println("This is before method");
	} 
	@AfterMethod
	public void aftermethod()
	{
		System.out.println("This is after method");
	}
	@Test
	public void demo()
	{
		System.out.println("Hello");
	} 
	
	@Test
	public void secondtest()
	{
		System.out.println("Hello Nidhi");
	} 
	@BeforeTest
	public void prerequisitetest()
	{
		System.out.println("I will run first");
	}
}
