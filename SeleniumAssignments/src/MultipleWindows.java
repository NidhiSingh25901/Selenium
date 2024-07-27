import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/windows");
		
		driver.findElement(By.xpath("//div[@class='example']/a")).click();
		
		Set<String> windows= driver.getWindowHandles();
		Iterator<String> i= windows.iterator();
		String parentWindow = i.next();
		String childWindow = i.next();		
		
		driver.switchTo().window(childWindow);
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
		
		//switching back to the main window
		driver.switchTo().window(parentWindow);
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());
		
		driver.quit();
	}

}