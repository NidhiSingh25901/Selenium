import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitImplicitLoginCartAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	    System.setProperty("webdriver.chrome.driver",
                "E:\\Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();  
	
	driver.get("https://rahulshettyacademy.com/loginpagePractise/");
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	
	driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
	driver.findElement(By.id("password")).sendKeys("learning");
	
	driver.findElement(By.xpath("//input[@value='user']")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content"))); 
	
	
	WebElement staticdropdown = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[5]/select"));
	driver.findElement(By.id("okayBtn")).click();
	
	
	Select dropdown = new Select(staticdropdown);
	dropdown.selectByIndex(2); 
	
	driver.findElement(By.id("terms")).click();
	driver.findElement(By.id("signInBtn")).click();
	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  
	
	List<WebElement> productlist = driver.findElements(By.xpath("//button[@class='btn btn-info']")); 
	
	for(int i=0;i<productlist.size();i++) 
	{
		productlist.get(i).click();
	}
	
	driver.findElement(By.xpath("//*[@id=\"navbarResponsive\"]/ul/li/a")).click(); 
	
	driver.quit();
	}

}
