import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginLogout {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub 
		
	       System.setProperty("webdriver.chrome.driver",
	                "E:\\Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");  
		
		String name = "Rahul";
		String password = getPassword(driver);  
		
		driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/form/div/button[1]")).click(); // To get Back to login page
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));   
		
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();  
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  
		
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/p")).getText()); // getting text "you are successfully logged in"
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/p")).getText(),"You are successfully logged in.");
		
		
		
		//extracting name value
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/h2")).getText(), "Hello "+name+","); 
		
		//Clicking on Logout option:
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/button")).click();  
		
		driver.close();
	}

	private static String getPassword(WebDriver driver) throws InterruptedException { 
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");   
		driver.findElement(By.linkText("Forgot your password?")).click(); 
		
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click(); 
		String passwordText = driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/form/p")).getText(); 
		String[] passwordCmt = passwordText.split("'"); 
		String password = passwordCmt[1].split("'")[0];

		return password;
		// TODO Auto-generated method stub
		
	}
}
