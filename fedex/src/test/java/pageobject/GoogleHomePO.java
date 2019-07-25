package pageobject;

import driver.Property;
import driver.Wrappers;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;

import driver.DriverFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class GoogleHomePO extends LoadableComponent<GoogleHomePO>{

	@FindBy(css = "input[name='q']")
	private WebElement searchTextBox;

	@FindBy(css="div[class='FPdoLc VlcLAe'] input[name='btnK']")
	private WebElement searchButton;

	@FindBy(css="img[alt='Google']")
	private WebElement googleImage;

	public static final String SimpleShipmentButton = "//*[@id='welcomePageSimpleShippingButton']";
	public static final String AppBar ="fxg-app-bar";
	public static final String globalLoginLink = "#global-login-wrapper";
	public static final String loginId = "NavLoginUserId";
	public static final String loginPassword = "NavLoginPassword";
	public static final String loginbutton = "//*[text()='Log In']";
	public static final String headerLogin = "HeaderLogin";
	public static final String logout = "//*[contains(text(),'SIGN OUT')]";
	public final static String alertMsgOnHeader = ".fxg-alert__close-btn";
	public final static String feedbackpopup = "//span[@id='closeQualtricsButton']/img";
	public final static String noSurvey = "//*[@style='position: absolute; top: 0px; left: 0px; width: 87px; height: 22px; overflow: hidden; display: block;']";
	// public final static String onBoardingclose = "e2e-onboarding-close";
	public final static String onBoardingStartshipping = "e2e-onboarding-startShipping";
	public final static String onBoardingWhatsnew = "e2e-onboarding-whatsNew";
	public final static String onBoardingcontent = "fdx-u-align--center fdx-u-pt--8 fdx-u-pr--8-medium";
	public final static String onBoardingnext = "e2e-onboarding-next";
	public final static String onBoardingback = "e2e-onboarding-back";
	public final static String onBoardingContentWhatsnewInMAGS = "fdx-u-pt--8";
	public final static String onBoardingreturntoOldVersion = "e2e-onboarding-returnToOldVersion";
	public final static String onBoardingYouHavebeenUpgraded = "fdx-c-notification__title fdx-u-align--center";
	public final static String onBoardingWelcometextMessage = "fdx-u-font-size--small fdx-u-mt--6 fdx-u-mb--6";
	public final static String pleaseLoginMessageafterLogout = "fdx-u-align--center fdx-u-pt--8";
	public final static String onBoardingClose = "e2e-onboarding-close";
	public final static String onBoardingStartShipping = "e2e-onboarding-startShipping";


	@FindBy(xpath = SimpleShipmentButton)
	public WebElement simpleShippingButton;

	@FindBy(id = AppBar)
	public WebElement Appbar;

	@FindBy(css = globalLoginLink)
	public WebElement logindrpdown;

	@FindBy(id = headerLogin)
	public WebElement headerLoginEnabled;

	@FindBy(id = loginId)
	public WebElement userId;

	@FindBy(id = loginPassword)
	public WebElement userPassword;

	@FindBy(xpath = loginbutton)
	public WebElement login;

	@FindBy(xpath = logout)
	public WebElement logsout;

	@FindBy(css = alertMsgOnHeader)
	public WebElement alertMessageHeader;

	@FindBy(xpath = feedbackpopup)
	public WebElement feedbackPopup;

	@FindBy(id = onBoardingClose)
	public WebElement onBoardingclose;

	@FindBy(xpath = feedbackpopup)
	public WebElement feedBackpopup;

	@FindBy(id = onBoardingStartShipping)
	public WebElement onBoardingStartShippings;


	@FindBy(id = onBoardingWhatsnew)
	public WebElement onBoardingWhatsNew;

	@FindBy(id = onBoardingreturntoOldVersion)
	public WebElement onBoardingreturnToOldVersion;

	@FindBy(className = onBoardingcontent)
	public WebElement onBoardingContent;

	@FindBy(id = onBoardingnext)
	public WebElement onBoardingNext;

	@FindBy(id = onBoardingback)
	public WebElement onBoardingBack;

	@FindBy(className = onBoardingContentWhatsnewInMAGS)
	public WebElement onBoardingContentWhatsNewInMAGS;

	@FindBy(className = onBoardingWelcometextMessage)
	public WebElement onBoardingWelcomeTextMessage;

	@FindBy(className = onBoardingYouHavebeenUpgraded)
	public WebElement onBoardingYouHaveBeenUpgraded;

	@FindBy(className = pleaseLoginMessageafterLogout)
	public WebElement pleaseLoginMessageAfterLogout;
	
	public GoogleHomePO() throws IOException {
		DriverFactory.getDriver().navigate().to(Property.getAppURL());
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	public GoogleSearchPO performSearch(String search) {
		//new WebDriverWait(DriverFactory.getDriver(), 15).until(ExpectedConditions.visibilityOf(searchTextBox));
		searchTextBox.sendKeys(search);
		//Intermittent error - To get rid of suggestion dropdown so search button can be found.
		googleImage.click();
		searchButton.click();
		return new GoogleSearchPO();
	}

	public void login(String reference) throws InterruptedException, IOException {
		Thread.sleep(2000);
		JSONObject user = Wrappers.getUserCredentials(reference);
		if((headerLoginEnabled).isDisplayed()){
			Wrappers.enterValue(userId, user.get("ID").toString());
			Wrappers.enterValue(userPassword, user.get("PASSWORD").toString());
			Wrappers.clickOnElement(login);
		}else {
			Wrappers.clickOnElementLoginDropDown(logindrpdown);
			Wrappers.enterValue(userId, user.get("ID").toString());
			Wrappers.enterValue(userPassword, user.get("PASSWORD").toString());
			Wrappers.clickOnElement(login);
		}
	}

	public void clickOnShipping() throws InterruptedException {
		Wrappers.waitForElement(onBoardingStartShippings);
		if (Wrappers.elementisDisplayedAndEnabled(onBoardingclose)
				||Wrappers.elementisDisplayedAndEnabled(onBoardingStartShippings)
		)
		{
			Wrappers.waitForElement(onBoardingStartShippings);
			Wrappers.clickOnElement(onBoardingStartShippings);
		//	Wrappers.waitForElement(fromfieldEdit);
		}
	}



	@Override
	protected void load() {
	}

	@Override
	protected void isLoaded() throws Error {
		
	}
}
