import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WindowScrolling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	       System.setProperty("webdriver.chrome.driver",
	                "E:\\Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/"); 
		
		//specific for windows scrolling
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("window.scrollBy(0,500)"); 
		
		Thread.sleep(5000);

		//specific for table scrolling
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000"); 
		
		List<WebElement> elementlist= driver.findElements(By.xpath("//table[@id='product']/tbody/tr/td[4]"));
		int sum =0;
		int num=0; 
		for(int i=0;i< elementlist.size();i++) 
		{
		    num = Integer.parseInt(elementlist.get(i).getText()); 
			sum+=num;
		}
		System.out.println("Sum of all values listed in the table:- "+sum);  
		
		String value =  driver.findElement(By.xpath("/html/body/div[3]/div[2]/fieldset[2]/div[2]")).getText();
		String actualval = value.split(":")[1].trim(); 
	    int actualnum = Integer.parseInt(actualval); 
	    
	  //  Assert.assertEquals(sum,actualnum); 
	    
		if(sum==actualnum)
		{
			System.out.println("Sum is correct");
		} else 
		{
			System.out.println("Sum is not correct");
		}
		driver.quit();
	}

}
