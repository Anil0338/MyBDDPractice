package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import DriveFactory.Driver_Factory;
import Utils.Genaric;

public class Login {
	public Genaric utils=new Genaric();
	public WebDriver driver = new Driver_Factory().getDriver();

			
	private By userName=By.xpath("//input[@id='user-name']");
	private By Password=By.xpath("//input[@id='password']");
	private By login_Button=By.xpath("//input[@id='login-button']");
	private By pic=By.xpath("//img[@class='bot_column']");
	private By swagLabLogo=By.xpath("//div[@class='login_logo']");
	
	public void LaunchTheURL() {
		driver.get("https://www.saucedemo.com/v1/");
		}
	
	public void enter_UserName() {
		try{
			utils.enterText(userName, "standard_user");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enter_Password() {
		try{
			utils.enterText(Password, "secret_sauce");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickOnLogin() {
		try {
			utils.clickElement(login_Button);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void vaidateElementcolour() {
		try {
			utils.elementColourValidation(login_Button,"background-color", "rgba(226, 35, 26)");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
