import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdateDropdownFlighBookingTesting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
	       System.setProperty("webdriver.chrome.driver",
	                "E:\\Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  
		driver.manage().window().maximize();  
		
		driver.findElement(By.id("divpaxinfo")).click(); 
		Thread.sleep(2000L); 
		
		int i=1;
		while(i<5) 
		{
			driver.findElement(By.id("hrefincAdt")).click();
			i++;
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}

}
