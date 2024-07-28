import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableSortingValidationInSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	       System.setProperty("webdriver.chrome.driver",
	                "E:\\Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  
		driver.manage().window().maximize(); 
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");  		
		
		// Click on column
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/div/table/thead/tr/th[1]")).click(); 
		
		//Capture all webelements into list
		
		List<WebElement>  elementlist = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/div/table/tbody/tr/td[1]"));
		//capture text of all webelements into new(original) list 
		List<String> originallist = elementlist.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort in the list of step 3 -> sorted list 
		List<String> sortedlist = originallist.stream().sorted().collect(Collectors.toList()); 
		
		//compare original list and sorted list 
		Assert.assertTrue(originallist.equals(sortedlist)); 
		
		List<String> price;
		do {		//Scan the new column with get text, once we encounter the specific product name -> Rice -> print the price of the vegetable
			List<WebElement>  rows = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/div/table/tbody/tr/td[1]"));
			price = rows.stream().filter(s->s.getText().contains("Cheese"))
		.map(s->getPriceVeggie(s)).collect(Collectors.toList());
		
		price.forEach(s->System.out.println(s));
		
		if(price.size()<1)
		{
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
		}
		}while(price.size()<1);
		driver.quit();
	}

	private static String getPriceVeggie(WebElement s ) {
		
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
