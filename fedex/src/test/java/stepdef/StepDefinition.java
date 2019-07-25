package stepdef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.SharedDriver;
import driver.Wrappers;
import org.json.JSONObject;
import org.testng.Assert;
import pageobject.GoogleHomePO;
import pageobject.GoogleSearchPO;

import java.awt.*;
import java.io.IOException;

public class StepDefinition {
	
	public GoogleHomePO ghPO;
	public GoogleSearchPO gsPO;
	
	public StepDefinition(SharedDriver driver, GoogleHomePO ghPO, GoogleSearchPO gsPO) {
		this.ghPO = ghPO;
		this.gsPO = gsPO;
	}

	@Given("Go to google page")
	public void given() {
		ghPO.get();
	}

	@Given("^User:\"([^\"]*)\" logs in to Shipping application$")
	public void login_to_Shipping_Application(String reference) throws IOException, AWTException, InterruptedException {
		ghPO.login(reference);
	}

	@Then("^User clicks on start shipping button$")
	public void clickOnSimpleShipping() throws IOException, InterruptedException ,Exception{
		ghPO.clickOnShipping();
	}


	@When("^User clicks on FROM EDIT$")
	public void click_on_FROM_EDIT() throws InterruptedException {
		gsPO.clickOnFromEdit();
	}


	@Then("Verify the from section address fields")
	public void verify_the_from_section_address_fields() throws IOException, AWTException {
		gsPO.verifyFromSection();
	}

}
