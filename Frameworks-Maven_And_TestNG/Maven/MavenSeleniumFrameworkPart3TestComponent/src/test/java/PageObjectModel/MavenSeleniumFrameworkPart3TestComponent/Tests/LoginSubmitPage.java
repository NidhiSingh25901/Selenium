package PageObjectModel.MavenSeleniumFrameworkPart3TestComponent.Tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import MavenSeleniumFrameworkPart3TestComponent.MavenFrameworkDesignPageObjectModel.LandingPage;
import MavenSeleniumFrameworkPart3TestComponent.MavenFrameworkDesignPageObjectModel.ProductCataloguePage;
import PageObjectModel.MavenSeleniumFrameworkPart3TestComponent.TestComponent.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class LoginSubmitPage extends BaseTest {

    private WebDriver driver;
    private Properties prop;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Load the properties file
        prop = new Properties();
        FileInputStream fis = new FileInputStream("E:\\Eclipse_Workspace\\MavenSeleniumFrameworkPart3TestComponent\\src\\main\\java\\MavenSeleniumFrameworkPart3TestComponent\\resources\\GlobalData.properties");
        prop.load(fis);
    }

    public void loginsubmitpage() throws InterruptedException {
        String productname = "ZARA COAT 3";

        // Launch the application
        LandingPage landingPage = new LandingPage(driver);
        landingPage.GoTo();
        landingPage.loginApplication("peacock156mstmst@gmail.com", "Acteam@13");

        // Continue with the test steps
        ProductCataloguePage productcatalogue = new ProductCataloguePage(driver);
        List<WebElement> products = productcatalogue.getProductList();
        productcatalogue.addProductToCart(productname);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartsection h3"));
        boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productname));
        Assert.assertTrue(match);

        driver.findElement(By.cssSelector(".totalRow button")).click();
        driver.findElement(By.cssSelector(".action__submit")).click();

        String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANK YOU FOR THE ORDER"));

        driver.close();
    }
}

