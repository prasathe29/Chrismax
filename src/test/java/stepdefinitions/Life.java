package stepdefinitions;

import java.util.Date;

import org.new1.Baseclass1;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Life extends Baseclass1 {

	@Given("I want to write a step with precondition")
	public void i_want_to_write_a_step_with_precondition() {
		Date d = new Date();
		System.out.println(d);
	}

	@Given("some other precondition")
	public void some_other_precondition() {
browserLaunch("chrome");
url("https://facebook.com");
	}
	
	@When("click logine button")
	public void click_logine_button() {
		xpathClick("//button[@name='login']");
	}

@When("check more outcomes with date")
public void check_more_outcomes_with_date() {
	closeBrowser(); 
}}