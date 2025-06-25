package StepDef;

import java.io.File;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import DriveFactory.Driver_Factory;
import Utils.Reports;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {
	public static WebDriver driver;
	public static ExtentTest logger;
	public static ExtentReports extent;
	
	@Before
	public void setUp(Scenario scenario) throws InterruptedException {
	    
		/*
		 * String reportPath = Paths.get(System.getProperty("user.dir"), "Reports",
		 * "ExtentReport.html").toString(); ExtentSparkReporter sparkReporter = new
		 * ExtentSparkReporter(reportPath);
		 * sparkReporter.config().setDocumentTitle("My Automation Report");
		 * sparkReporter.config().setReportName("Test Results");
		 * 
		 * // Attach the reporter to ExtentReports extent = new ExtentReports();
		 * extent.attachReporter(sparkReporter);
		 * 
		 */		System.out.println("Starting scenario: " + scenario.getName());
		Driver_Factory.initializeDriver();
		driver = Driver_Factory.getDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized"); // Open browser maximized
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver.manage().window().maximize();
        
	}

	@After
	public void tearDown(Scenario scenario) {
		System.out.println("Finished scenario: " + scenario.getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Driver_Factory.quitDriver();
		
		  extent.flush();
	}
}
