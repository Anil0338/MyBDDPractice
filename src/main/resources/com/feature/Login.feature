@tag
Feature: Login Feature Validation

  @smokeTest
  Scenario: Launch the URL 
    Given launch the URL of "https://automationexercise.com/"
    Then Enter the "standard_user" and "secret_sauce "
    Then Validate the Login button background colour
    And click on login button and validated the home page is loaded
    
   @smokeTest
  Scenario Outline: Login with Different Users and validatee the Login access
  	Given launch the URL of "https://automationexercise.com/"
    Then Enter the "<username>" and enter "<password>"
    And click on login button and validated the home page is loaded
      Examples:
      | username  						| password  |
      | locked_out_user     	| secret_sauce   |
      | standard_user     		| secret_sauce   |
     	| problem_user					| secret_sauce	 |
			| performance_glitch_user|secret_sauce	 |
			| error_user						| secret_sauce   |
			| visual_user						| secret_sauce   |
			
		@smokeTest
	Scenario Outline: Login with Different Users and validatee the Login access
  	Given launch the URL of "https://automationexercise.com/"
    Then Enter the "standard_user" and "secret_sauce "
    And click on login button and validated the home page is loaded
    Then wait for Popup and get the popuptext and also accept the popup
    And validate the items Displayed"Sauce Labs Backpack:Sauce Labs Bike Light:Sauce Labs Bolt T-Shirt:Sauce Labs Fleece Jacket:Sauce Labs Onesie:Test.allTheThings() T-Shirt (Red)"
				