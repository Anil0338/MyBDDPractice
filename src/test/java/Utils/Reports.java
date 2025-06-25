package Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import DriveFactory.Driver_Factory;

public class Reports {
	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest logger;
	
	ExtentSparkReporter sparkReporter = new ExtentSparkReporter("ExtentReport.html");
	
	public Reports() {
		this.driver = new Driver_Factory().getDriver();
		this.extent = new ExtentReports();
		this.extent.attachReporter(sparkReporter);
		logger = extent.createTest("Login Test").assignAuthor("QA Tester").assignCategory("Smoke Test")
				.assignDevice("Chrome");
	}

	
	
	

	public void logPass(String msg) {
		logger.pass(msg);
	}

	public void logFali(String msg) {
		logger.fail(msg);
	}

	public void logMsg(String msg) {
		logger.info(msg);
	}

	public void getScreenshot() {
		String failureImageFileName = new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss").format(new GregorianCalendar().getTime()) + ".png";
		String imageFolder = new SimpleDateFormat("MM-dd-yyyy").format(new GregorianCalendar().getTime());
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("Screenshot\\" + imageFolder + "\\" + failureImageFileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void logPasswithScreenshot(String msg) {
		logPass(msg);
		getScreenshot();
	}
}
