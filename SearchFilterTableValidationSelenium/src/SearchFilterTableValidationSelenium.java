import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SearchFilterTableValidationSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	       System.setProperty("webdriver.chrome.driver",
	                "E:\\Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  
		driver.manage().window().maximize(); 
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");  
		
		driver.findElement(By.id("search-field")).sendKeys("Rice"); 
		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<WebElement> veggiesList = veggies.stream()
			    .filter(veggie -> veggie.getText().contains("Rice"))
			    .collect(Collectors.toList());

		Assert.assertEquals(veggies.size(), veggiesList.size());
	}

}
