package Utils;

import javax.swing.JScrollBar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriveFactory.Driver_Factory;

public class Genaric {

	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static 	JavascriptExecutor js;
	public Genaric() {
		this.driver=(WebDriver) new Driver_Factory().getDriver();
		this.js=(JavascriptExecutor) this.driver;
	}
	
	public void enterText(By text,String Input) {
		try {
			driver.findElement(text).clear();
			Thread.sleep(1);
			driver.findElement(text).sendKeys(Input);	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void clickElement(By webElement) {
		try {
			driver.findElement(webElement).click();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void elementColourValidation(By wb ,String acctribute ,String Expectedcolour) {
		try {
			String backgroundcolour=driver.findElement(wb).getCssValue(acctribute);
			if(backgroundcolour.equals(Expectedcolour)) {
				System.out.println("Background colour is matching");
			}else{
				System.out.println("Background colour is not matching");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
