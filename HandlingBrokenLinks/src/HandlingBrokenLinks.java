import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandlingBrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub 
		
		//Broken Link is Broken URL -> URL that is not working 
		//Step 1- IS to get all URL tied up to the links using selenium
		// Java methods that will get the URL and its status code
		//If status code is > 400 then that URL is not working -> link which is tied up with the URL is broken
		
	       System.setProperty("webdriver.chrome.driver",
	                "E:\\Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");  
		
		//To Find Status Code for a particular link - SoapUI in footer section
		String url = driver.findElement(By.xpath("//*[@id=\"gf-BIG\"]/table/tbody/tr/td[1]/ul/li[3]/a")).getAttribute("href"); 
		
		HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int code = conn.getResponseCode(); 
		System.out.println(code); 
			
		//To check for broken links in the site
		List<WebElement> elementlist = driver.findElements(By.cssSelector("li[class='gf-li'] a")); 
		
		for(WebElement webelementlist : elementlist)
		{
			String webelementurl = webelementlist.getAttribute("href");
			HttpURLConnection urlconn = (HttpURLConnection)new URL(webelementurl).openConnection(); 
			urlconn.setRequestMethod("HEAD");
			urlconn.connect();
			int rescode = urlconn.getResponseCode();
			if(rescode == 404) 
			{
				System.out.println("Link is broken with code of 404"); 
				Assert.assertTrue(false);
			} else {
				System.out.println("Link is not broken and it is working fine");
			}
		} 
		
		driver.quit();
		
	}

}
