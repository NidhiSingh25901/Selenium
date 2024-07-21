import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SynchronnizationAddItemsToCart {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

	    System.setProperty("webdriver.chrome.driver",
                "E:\\Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();  
	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
	
	
	driver.manage().window().maximize(); 
	
	String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"}; 
	
	driver.get("https://rahulshettyacademy.com/seleniumPractise/");  
	Thread.sleep(5000); 
	addItems(driver, itemsNeeded); 
	
	driver.findElement(By.cssSelector("img[alt='Cart']")).click(); 
	driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click(); 
	driver.findElement(By.cssSelector("input.promocode")).sendKeys("rahulshettyacademy"); 
	driver.findElement(By.cssSelector("button.promobtn")).click();
	System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	
	
	} 
	
	public static void addItems(WebDriver driver, String[] itemsNeeded) 
	{
			
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

	}

}
