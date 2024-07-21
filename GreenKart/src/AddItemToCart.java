import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddItemToCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	       System.setProperty("webdriver.chrome.driver",
	                "E:\\Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  
		driver.manage().window().maximize(); 
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");  
		
		List<WebElement> element= driver.findElements(By.cssSelector("h4.product-name"));
	
		for(int i=0;i<element.size();i++) 
		{
			String name = element.get(i).getText();
			if(name.contains("Cucumber"))
			{
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				break;
			}
		} 
		System.out.println("Product is Added to Cart");
		driver.quit();
		
	}

}
