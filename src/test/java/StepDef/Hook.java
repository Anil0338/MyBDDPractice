package StepDef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Report;
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
	public static Reports log;
	
	@Before
	public void setUp(Scenario scenario) throws InterruptedException {
	    
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("Reports\\ExtentReport.html");
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		logger=extent.createTest(scenario.getName());
		log=new Reports();
		System.out.println("Starting scenario: " + scenario.getName());
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
