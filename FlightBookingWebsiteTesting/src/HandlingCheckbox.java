import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandlingCheckbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        System.setProperty("webdriver.chrome.driver",
                "E:\\Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
    	driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); 
    	
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()); 
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click(); 
        System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());    
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        System.out.println("Total Number of checkboxes:-- "+ driver.findElements(By.cssSelector("input[type='checkbox']")).size());   
        
        System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date1")).isEnabled()); 
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click(); 
        
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
        {
        	System.out.println("its enabled"); 
        	Assert.assertTrue(true); 
        }
        else {
        	Assert.assertFalse(false);
        }
       
        
        driver.quit();
        
	}

}
