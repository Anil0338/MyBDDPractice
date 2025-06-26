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
		   logger.logPass("Launched URL");
	}
		@Then("Enter the {string} and {string}")
		public void enter_the_username_and_password(String username,String passweord) {
			ln.enter_UserName(username);
			ln.enter_Password(passweord);
			  logger.logPass("Enter User Name and password");
		}

		@Then("Validate the Login button background colour")
		public void validate_the_login_button_background_colour() {
			 ln.vaidateElementcolour();
			  logger.logPass("Validated login button");
		}

		@Then("click on login button and validated the home page is loaded")
		public void click_on_login_button_and_validated_the_home_page_is_loaded() {
			   ln.clickOnLogin();
			   logger.logPass("Clicked on login button");
		}
		@Then("Enter the {string} and enter {string}")
		public void enter_the_and_enter(String username, String passweord) {
			ln.enter_UserName(username);
			ln.enter_Password(passweord);
			 logger.logPass("Enter User Name and password");
					
		}
		@Then("wait for Popup and get the popuptext and also accept the popup")
		public void wait_for_popup_and_get_the_popuptext_and_also_accept_the_popup() {
			ln.acceptPopup();
		
		}

		@Then("validate the items Displayed\"Sauce Labs Backpack:Sauce Labs Bike Light:Sauce Labs Bolt T-Shirt:Sauce Labs Fleece Jacket:Sauce Labs Onesie:Test.allTheThings\\() T-Shirt \\(Red)\"")
		public void validate_the_items_displayed_sauce_labs_backpack_sauce_labs_bike_light_sauce_labs_bolt_t_shirt_sauce_labs_fleece_jacket_sauce_labs_onesie_test_all_the_things_t_shirt_red() {
		
		}

}
