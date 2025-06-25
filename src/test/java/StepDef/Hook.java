package StepDef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import DriveFactory.Driver_Factory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {
	public static WebDriver driver;

	@Before
	public void setUp(Scenario scenario) throws InterruptedException {
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
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Driver_Factory.quitDriver();
	}
}
