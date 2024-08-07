package PageObjectModel.MavenFrameworkDesignPageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class ProductCataloguePage extends AbstractComponent{
 
	WebDriver driver;
	public ProductCataloguePage(WebDriver driver)
	{
	    
	    super(driver);
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3")); 
	
	//Above code can be written as shown below using PageFactory 
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	By productBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector(".toast-container"); 
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productBy);
		return products;
	}
	public WebElement getProductByName(String productName)
	{
		 WebElement prod =products.stream().filter(
				 product-> product.findElement(
						 By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		 return prod;
	}


	public void addProductToCart(String productName)
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisappear(spinner); 
	}
	

}
