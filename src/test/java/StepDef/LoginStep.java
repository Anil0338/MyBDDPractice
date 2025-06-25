package StepDef;

import com.aventstack.extentreports.model.ReportStats;
import com.pages.Login;

import Utils.Reports;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginStep {
	Login ln=new Login();
	Reports logger=new Reports();

	@Given("launch the URL of {string}")
	public void launch_the_url_of(String string) {
	   ln.LaunchTheURL();
	   logger.logPass("URl launched");
}
	@Then("Enter the username and password")
	public void enter_the_username_and_password() {
		ln.enter_UserName();
		ln.enter_Password();
		logger.logFali("URl launched");
	}

	@Then("Validate the Login button background colour")
	public void validate_the_login_button_background_colour() {
		 ln.vaidateElementcolour();
		 logger.logPasswithScreenshot("Validation is sucessful");
	}

	@Then("click on login button and validated the home page is loaded")
	public void click_on_login_button_and_validated_the_home_page_is_loaded() {
		   ln.clickOnLogin();
		   logger.logPass("Test");
	}}
