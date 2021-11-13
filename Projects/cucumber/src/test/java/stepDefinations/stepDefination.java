package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefination {

	@Given("User is on landing page")
	public void user_is_on_landing_page() {
	    System.out.println("Naviageted to URL");
	}

	@When("User login into application with username and password")
	public void user_login_into_application_with_username_and_password() {
		System.out.println("Given details");
	}

	@Then("Home page is populated")
	public void home_page_is_populated() {
		System.out.println("Logged in successfully");
	}

	@Then("Cards are displayed")
	public void cards_are_displayed() {
		System.out.println("CArds are displayed");
	}
}
