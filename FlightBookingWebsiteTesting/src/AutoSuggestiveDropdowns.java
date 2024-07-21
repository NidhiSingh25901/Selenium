import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdowns {

    public static void main(String[] args) {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver",
                "E:\\Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

            driver.findElement(By.id("autosuggest")).sendKeys("India");
            Thread.sleep(3000); // Sleep for 3 seconds

            // Use the correct CSS selector
            List<WebElement> options = driver.findElements(By.cssSelector("li.ui-menu-item a"));

            for (WebElement option : options) {
                if (option.getText().equalsIgnoreCase("India")) {
                    option.click();
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

