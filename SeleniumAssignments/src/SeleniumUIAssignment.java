import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumUIAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	       System.setProperty("webdriver.chrome.driver",
	                "E:\\Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  
		driver.manage().window().maximize(); 
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");  
		
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("Nidhi"); 
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("peacock156mst@gmail.com");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Peacock@25535"); 
		driver.findElement(By.cssSelector("input[type='checkbox']")).click(); 
		driver.findElement(By.xpath("//*[@id=\"exampleFormControlSelect1\"]/option[2]")).click(); 
		driver.findElement(By.cssSelector("input[value='option1']")).click();
		driver.findElement(By.name("bday")).sendKeys("02/02/1992");; 
		driver.findElement(By.cssSelector("input[type='submit']")).click();  
        String message = driver.findElement(By.cssSelector("div.alert.alert-success")).getText();
		System.out.println(message);
		driver.quit();

	}

}
