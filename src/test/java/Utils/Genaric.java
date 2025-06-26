package Utils;

import java.awt.Robot;

import javax.swing.JScrollBar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriveFactory.Driver_Factory;

public class Genaric {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static JavascriptExecutor js;
	public static Actions action;
	public static Select select;
	public static Robot robot;

	public Genaric() {
		this.driver = (WebDriver) new Driver_Factory().getDriver();
		this.js = (JavascriptExecutor) this.driver;
		this.action = new Actions(this.driver);

	}

	public void enterText(By text, String Input) {
		try {
			driver.findElement(text).clear();
			Thread.sleep(1);
			driver.findElement(text).sendKeys(Input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickElement(By webElement) {
		try {
			driver.findElement(webElement).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void elementColourValidation(By wb, String acctribute, String Expectedcolour) {
		try {
			String backgroundcolour = driver.findElement(wb).getCssValue(acctribute);
			if (backgroundcolour.equals(Expectedcolour)) {
				System.out.println("Background colour is matching");
			} else {
				System.out.println("Background colour is not matching");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mouseOverAction(WebElement webElement) {
		try {
			action.moveToElement(webElement).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickUsingMouseOverAction(WebElement webElement) {
		try {
			action.moveToElement(webElement).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendKeysUsingMouseOverAction(WebElement webElement, String input) {
		try {
			action.moveToElement(webElement).sendKeys(input).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickAndHold(WebElement webElement) {
		try {
			action.clickAndHold(webElement).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void rightClickOperation(WebElement webElement) {
		try {
			action.contextClick(webElement).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doubleClickUsingMouse(WebElement webElement) {
		try {
			action.doubleClick(webElement).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void  dragAndDropOfAnElement(WebElement ScrElement, WebElement destinationElement) {
		try {
			action.dragAndDrop(ScrElement, destinationElement).build().perform();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void elementIsDisplayed(By Webelement) {
		try {
			driver.findElement(Webelement).isDisplayed();
		}catch(Exception e) {
			
		}
	}
	
	public void elementIsEnabled(By Webelement) {
		try {
			driver.findElement(Webelement).isEnabled();
		}catch(Exception e) {
			
		}
	}
	
	public void elementIsSelected(By Webelement) {
		try {
			driver.findElement(Webelement).isSelected();
		}catch(Exception e) {
			
		}
	}
	
}
