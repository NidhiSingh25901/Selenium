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

public class HandlingAmazonCaptchaOCR {

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
        
        // Print the final URL
        String finalURL = driver.getCurrentUrl();
        System.out.println("Final URL after refresh: " + finalURL);

        // Assuming you want to capture an image from the refreshed page
        List<WebElement> paginationElements = driver.findElements(By.xpath("//yourImageXPath")); // Replace with the correct XPath
        
        int pageCount = paginationElements.size();
        if (pageCount > 0) {
            String imageUrl = paginationElements.get(pageCount - 1).getAttribute("src");
            BufferedImage image = ImageIO.read(new URL(imageUrl));
            File imageFile = new File("captured_image.png");
            ImageIO.write(image, "png", imageFile);

            ITesseract tess = new Tesseract();
            tess.setDatapath("E:/Software_Testing/OCR/Software_Technology/tessdata"); // Path to the tessdata folder
            tess.setLanguage("eng"); // Set language if needed

            // Extract text from the image
            String extractedText = tess.doOCR(imageFile);
            System.out.println("Extracted Text: " + extractedText);
            
        }

    }
}
