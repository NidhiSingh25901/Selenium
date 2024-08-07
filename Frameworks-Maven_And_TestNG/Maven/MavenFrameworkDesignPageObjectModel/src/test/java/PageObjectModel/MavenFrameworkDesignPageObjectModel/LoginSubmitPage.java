package PageObjectModel.MavenFrameworkDesignPageObjectModel;

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

public class LoginSubmitPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		String productname ="ZARA COAT 3";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		
		LandingPage landingPage = new LandingPage(driver); 
		landingPage.GoTo();
		landingPage.loginApplication("peacock156mstmst@gmail.com", "Acteam@13"); 
		
		ProductCataloguePage productcatalogue = new ProductCataloguePage(driver);
		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.addProductToCart(productname);
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
	driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

	
	List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartsection h3")); 
	
	boolean match = cartProducts.stream().anyMatch(
			cartProduct -> cartProduct.getText().equalsIgnoreCase(productname)
			);
	Assert.assertTrue(true); 
	driver.findElement(By.cssSelector(".totalRow button")).click(); 
	
	
	driver.findElement(By.cssSelector(".action__submit")).click(); 
	
	String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
	
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANK YOU FOR THE ORDER")); 
	driver.close();
	}

}
