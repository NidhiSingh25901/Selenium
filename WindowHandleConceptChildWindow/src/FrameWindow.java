
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		
		//switching to frame
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement sourceOfDrag= driver.findElement(By.id("draggable"));
		WebElement destinationOfDrop= driver.findElement(By.id("droppable"));
		
		Actions a= new Actions(driver);
		a.dragAndDrop(sourceOfDrag, destinationOfDrop).build().perform();
		
		//switching back to normal HTML content
		driver.switchTo().defaultContent();
		
		driver.quit();
		
	}

}