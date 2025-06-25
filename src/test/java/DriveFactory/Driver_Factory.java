package DriveFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver_Factory {
	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	  public static void initializeDriver() {
	        // You can use WebDriverManager or set system property manually
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
	        WebDriverManager.chromedriver().setup();
	        driver.set(new ChromeDriver());  
	    }

	    public static WebDriver getDriver() {
	        return driver.get();
	    }

	    public static void quitDriver() {
	        if (driver.get() != null) {
	            driver.get().quit();
	            driver.remove();
	        }
	    }
}
