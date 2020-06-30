package testing.ExtentReport;

//import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import bsh.ExternalNameSpace;

public class ExtentReportDemo {
	ExtentReports extent;
	@BeforeTest
	public void config() {
	String path = System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter  reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Automation Result");
	reporter.config().setDocumentTitle("Test Result");
	
	 extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "**USER**");
		
	}
	
	@Test
	public void initialDemo() {
		extent.createTest("Initial Demo");
		System.setProperty("webdriver.chrome.driver", "D:\\Testing Projects\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com"); 
		
		extent.flush();
	}

}
