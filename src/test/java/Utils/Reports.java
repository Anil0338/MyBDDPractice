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
import StepDef.Hook;

public class Reports {
	public WebDriver driver;
	AppConfiguration properties = new AppConfiguration();
	Hook h1=new Hook();
	
	public Reports() {
		this.driver = new Driver_Factory().getDriver();
		
	}
	
		

	public void logPass(String msg) {
		h1.logger.pass(msg);
	}

	public void logFali(String msg) {
		h1.logger.fail(msg);
	}

	public void logMsg(String msg) {
		h1.logger.info(msg);
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
	
	public String htmlReportPath() {
		String reportPath = null;
		String fileName =  new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss aa").format(new GregorianCalendar().getTime());
		String folderName =  new SimpleDateFormat("MM-dd-yyyy").format(new GregorianCalendar().getTime());
		//SubFolder Creation with Respect to Batch Execution
		String subFolderName =  new SimpleDateFormat("MM-dd-yyyy_HHmmssaa").format(new GregorianCalendar().getTime());
		String subFolder;
		try {
			subFolder = properties.getPropValues("reportPath")+ folderName + "\\" + subFolderName;
			properties.putPropValues("subFolderName", subFolder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String reportPath1 = properties.getPropValues("reportPath")+folderName+"\\"+subFolderName+"\\"+fileName+".html";
			reportPath = reportPath1.replaceAll("\\s+", "");
			properties.putPropValues("EmailResultPath", reportPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reportPath;
	}
}
