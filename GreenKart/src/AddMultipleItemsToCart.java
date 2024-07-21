import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddMultipleItemsToCart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

	    System.setProperty("webdriver.chrome.driver",
	                "E:\\Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  
		driver.manage().window().maximize(); 
		
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");  
		
		Thread.sleep(5000);
		
		String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};
		List<String> itemsNeededList = Arrays.asList(itemsNeeded); 
 
		
		List<WebElement> element= driver.findElements(By.className("product-name")); 
		
		int j =0;
		for(int i=0;i<element.size();i++)
		{
			String[] name = element.get(i).getText().split("-"); 
			String formattedName = name[0].trim();
			//format it to get actual vegetable name , and not Cucumber - 1 Kg
			//check whether name extracted is present in array or not
			//Convert Array into ArrayList for easy search
			
			
			if(itemsNeededList.contains(formattedName))
			{
				j++;
				 // driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click(); 
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==3) {
					break;
				}
			}
			
		}
		driver.quit();
		
	}

}
