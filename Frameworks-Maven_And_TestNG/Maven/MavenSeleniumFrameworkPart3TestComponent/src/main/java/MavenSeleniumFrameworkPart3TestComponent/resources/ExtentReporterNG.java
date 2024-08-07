package MavenSeleniumFrameworkPart3TestComponent.resources;

import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	public static ExtentReports getReportObject() 
	{
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path); 
		reporter.config().setReportName("Web Automation Results"); 
		reporter.config().setDocumentTitle("Test Results");
		
		ExtentReports extent = new ExtentReports(); 
		extent.attachReporter(reporter); 
		extent.setSystemInfo("Tester", "RahulShetty"); 
		
        // Add system info
        Properties systemInfo = SystemInfoUtil.getSystemInfo();
        for (String key : systemInfo.stringPropertyNames()) {
            extent.setSystemInfo(key, systemInfo.getProperty(key));
        }
        
        return extent;

	}
}
