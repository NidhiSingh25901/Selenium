package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
	}


	@FindBy(css="[routerlink*='Cart']")
	WebElement CartHeader;
	
	public void waitForElementToAppear(By FindBy) 
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
	wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	} 
	
	public void waitForElementToDisappear(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); 
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	
}
