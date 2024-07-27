import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandleConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	       System.setProperty("webdriver.chrome.driver",
	                "E:\\Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  
		driver.manage().window().maximize(); 
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/"); 
		driver.findElement(By.className("blinkingText")).click(); 
		Set<String> windows = driver.getWindowHandles(); 
		Iterator<String> it = windows.iterator();
		String parentId = it.next(); 
		String childId = it.next(); 
		
		driver.switchTo().window(childId);
		
		String email = driver.findElement(By.xpath("//*[@id=\"interview-material-container\"]/div/div[2]/p[2]/strong/a")).getText(); 
		
		driver.switchTo().window(parentId); 
		
		driver.findElement(By.id("username")).sendKeys(email); 
		driver.findElement(By.id("password")).sendKeys("learning"); 
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/div/label[2]/span[2]")).click();
		
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
