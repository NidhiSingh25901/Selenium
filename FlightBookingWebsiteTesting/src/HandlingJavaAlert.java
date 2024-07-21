import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingJavaAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	       System.setProperty("webdriver.chrome.driver",
	                "E:\\Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  
		driver.manage().window().maximize(); 
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");  
		
		driver.findElement(By.id("name")).sendKeys("Nidhi"); 
		driver.findElement(By.id("alertbtn")).click();
		
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept(); 
		
		driver.findElement(By.id("confirmbtn")).click();
		driver.switchTo().alert().accept();
		
		driver.quit();
		
		
	}

}
