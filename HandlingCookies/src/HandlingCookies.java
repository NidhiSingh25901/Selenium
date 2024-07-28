import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCookies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        System.setProperty("webdriver.chrome.driver", "E:\\\\Driver\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();   
        
        driver.manage().window().maximize(); 
        
        driver.manage().deleteAllCookies(); 
        driver.manage().deleteCookieNamed("sessionkey"); 
 
        driver.get("https://www.google.com");  
        
        
	}

}
