package SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager; 

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		String productname ="ZARA COAT 3";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/"); 
		
		driver.findElement(By.id("userEmail")).sendKeys("peacock156mstmst@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Acteam@13");
		driver.findElement(By.id("login")).click(); 
		
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
	 WebElement prod =products.stream().filter(
			 product-> product.findElement(
					 By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
	 
	prod.findElement(By.cssSelector(".card-body button:last-of-type")).click(); 
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-container")));
	
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
	
	driver.findElement(By.cssSelector("[routerlink*='cart']")).click();  
	
	List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartsection h3")); 
	
	boolean match = cartProducts.stream().anyMatch(
			cartProduct -> cartProduct.getText().equalsIgnoreCase(productname)
			);
	Assert.assertTrue(match); 
	driver.findElement(By.cssSelector(".totalRow button")).click(); 
	
	Actions a = new Actions(driver); 
	a.sendKeys(driver.findElement(By.cssSelector("placeholder=['selectcountry']")), "india").build().perform(); 
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	
	driver.findElement(By.xpath("//button[contains(@class, 'ta-item'))[2]]"));
	
	driver.findElement(By.cssSelector(".action__submit")).click(); 
	
	String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
	
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANK YOU FOR THE ORDER")); 
	driver.close();
	}

}
