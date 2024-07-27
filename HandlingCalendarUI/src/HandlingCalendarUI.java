import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCalendarUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    System.setProperty("webdriver.chrome.driver",
                "E:\\Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();  
	driver.manage().window().maximize(); 
	
	
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");  
	
	String month = "6"; 
	String date = "15";
	String year = "2027"; 
	
	driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click(); 
	driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
	driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
	driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click(); 
	driver.findElement(By.xpath("//button[text()='"+year+"'")).click();
	driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(year)-1).click();
	driver.findElement(By.xpath("//abbr[text()='"+date+"'")).click();
	}

}
