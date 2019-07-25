package stepdef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverFactory;
import driver.SharedDriver;
import driver.Wrappers;
import org.json.JSONException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageobject.GoogleHomePO;
import pageobject.GoogleSearchPO;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class StepDefinition1 {

	private GoogleHomePO ghPO;
	private GoogleSearchPO gsPO;

	public StepDefinition1(SharedDriver driver, GoogleHomePO ghPO, GoogleSearchPO gsPO) {
		this.ghPO = ghPO;
		this.gsPO = gsPO;
	}

	
	@When("Enter search \"([^\"]*)\"")
	public void when(String search) {
		gsPO = ghPO.performSearch(search);
		new WebDriverWait(DriverFactory.getDriver(), 15).until(ExpectedConditions.visibilityOfAllElements(gsPO.searchResult));
		System.out.format("\nCount results for %s search is %d.\n", search, gsPO.searchResultCount());
	}

	@Then("^Verify error message for From User Email field when below values are entered$")
	public void errorValidationUserEmail(List<String> valueToEnter) throws JSONException, IOException {
		gsPO.enterValidationUserEmail(valueToEnter);
	}

	@When("^User clicks on FromSubmit button$")
	public void clickOnAddressSubmit() throws InterruptedException {
		gsPO.fromSubmit();
	}

	@Then("^Verify Element isDisplayed$")
	public void Verify_Element_is_displayed(List<String> classPath) throws InterruptedException, IOException {
			gsPO.verifyElement(classPath);
	}

	@And("^Verify whether active element in screen is matched to expected element:\"([^\"]*)\" using attribute:\"([^\"]*)\"$")
	public void verifyActiveElement(String elementToVerifyClassPath, String attribute)
			throws IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
			gsPO.verifyActiveEleme(elementToVerifyClassPath,attribute);
	}
}
