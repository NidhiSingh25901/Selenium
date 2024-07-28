import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub 
		
	       System.setProperty("webdriver.chrome.driver",
	                "E:\\Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com"); 
		
		//https://commons.apache.org/proper/commons-io/download_io.cgi - site for downloading FileUtil jar
		// If importing jar file is not working, we can add dependancy in pom.xml
        //<dependency>
        //<groupId>commons-io</groupId>
        //<artifactId>commons-io</artifactId>
        //<version>2.11.0</version> <!-- Use the latest version -->
        //</dependency>
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(screenshot, new File("E://Eclipse_Workspace//WindowScreenshot//OutputScreenshotStrorage//screenshot.png"));
		driver.quit();
	}

}
