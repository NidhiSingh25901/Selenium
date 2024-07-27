import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class WebDriverScopeAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1. Select any checkbox
		 * 2. Grab the text of the selected checkbox
		 * 3. Select the option form the dropdown, having same value as the selected checkbox
		 * 4. Enter the text in the text box and hit alert
		 * 5. Check the name displayed in the alert is same as the grabbed text
		 */
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qaclickacademy.com/practice.php");
		
		//selecting option2 and grabing the text
		driver.findElement(By.id("checkBoxOption2")).click();
		String text = driver.findElement(By.xpath("//label[@for= 'benz']")).getText();
		//System.out.println(text);
		
		//selecting the same option from the dropdown
		driver.findElement(By.id("dropdown-class-example")).click();
		WebElement dropdownList = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select dropdownSelector= new Select(dropdownList);
		dropdownSelector.selectByVisibleText(text);
		
		//entering the same text in the textbox
		driver.findElement(By.id("name")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();
		
		//checking name displayed in the alert is same as the grabbed text
		String alert= driver.switchTo().alert().getText();
		alert= alert.split(",")[0].split(" ")[1].trim();
		Assert.assertEquals(text,alert);
		driver.switchTo().alert().accept();
		
		driver.quit();

	}

}