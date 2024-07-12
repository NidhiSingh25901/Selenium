import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelIntroduction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub  
		
		//implicit wait - 5 seconds time out
	       System.setProperty("webdriver.chrome.driver",
	                "E:\\Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); 
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/"); 
		driver.findElement(By.id("inputUsername")).sendKeys("Rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("Rahul@2591");
		driver.findElement(By.className("signInBtn")).click(); 
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText()); 
		
		driver.findElement(By.linkText("Forgot your password?")).click(); 
		
		Thread.sleep(1000); 
		
		driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/form/input[1]")).sendKeys("Rahul");
		driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/form/input[2]")).sendKeys("rahul@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/form/input[3]")).sendKeys("6200156713");
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click(); 
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/form/p")).getText());
		
		driver.findElement(By.xpath("//*[@id=\"container\"]/div[1]/form/div/button[1]")).click(); 
		
		Thread.sleep(1000); 
		
		driver.findElement(By.id("inputUsername")).sendKeys("Rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy"); 
		driver.findElement(By.xpath("//*[@id=\"chkboxTwo\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/form/button")).click(); 
		
	}

}
