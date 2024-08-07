package PageObjectModel.MavenSeleniumFrameworkPart3TestComponent.TestComponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import MavenSeleniumFrameworkPart3TestComponent.MavenFrameworkDesignPageObjectModel.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static  WebDriver initializeDriver() throws IOException
	{
		Properties prop = new Properties(); 
		FileInputStream fls = new FileInputStream(System.getProperty("user.dir")+"E:\\Eclipse_Workspace\\MavenSeleniumFrameworkPart3TestComponent\\src\\main\\java\\MavenSeleniumFrameworkPart3TestComponent\\resources\\GlobalData.properties");
		prop.load(fls);
		String browserName = prop.getProperty("browser"); 
		System.out.println(browserName); 
		
		
		if(browserName.equalsIgnoreCase("Chrome")) {
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize(); 
		} 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize(); 
		return driver;
	} 
	
	public static  LandingPage launchApplication() throws IOException
	{
		try {
			driver = initializeDriver();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		LandingPage landingpage = new LandingPage(driver); 
		landingpage.GoTo();
		return landingpage;
	}
	
}
