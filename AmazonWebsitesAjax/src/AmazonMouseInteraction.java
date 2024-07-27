import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonMouseInteraction {

    public static void main(String[] args) throws MalformedURLException, IOException, TesseractException {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "E:\\\\Driver\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();   
        
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        
        WebDriverWait driverwait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
        
        

        // Refresh the page using JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("location.reload();");
        
        // Wait for the page to load completely
      //  driverwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//yourElementXPath"))); // Replace with an actual element that confirms the page is loaded

        // Print the final URL
        String finalURL = driver.getCurrentUrl();
        System.out.println("Final URL after refresh: " + finalURL);

		Actions action = new Actions(driver);
		
		//hovering on a particular element
		action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		
		//inserting text in CAPS using keyboard SHIFT
		action.moveToElement(driver.findElement(By.className("nav-search-field"))).click().keyDown(Keys.SHIFT).sendKeys("watch").keyDown(Keys.ENTER).build().perform();
		
		//inserting text in CAPS using keyboard SHIFT and selecting the complete text
	    //action.moveToElement(driver.findElement(By.className("nav-search-field"))).click().keyDown(Keys.SHIFT).sendKeys("watch").doubleClick().build().perform();

		//right clicking on the website
		action.contextClick().build().perform();

    }
}
