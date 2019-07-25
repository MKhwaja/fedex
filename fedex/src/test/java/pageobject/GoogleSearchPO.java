package pageobject;

import java.util.ArrayList;
import java.util.List;

import driver.Wrappers;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;

import driver.DriverFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GoogleSearchPO extends LoadableComponent<GoogleSearchPO>{
	
	@FindBy(css = "div[class='srg'] a > h3[class='LC20lb']")
	public List<WebElement> searchResult;

	/*********From fields****************/
	public final static String fromHeader = "fromHeading";
	public static final String fromEdit = "summaryFromEdit";
	public static final String fromName = "//*[@id='userNameFROM']";
	public static final String fromCountry = "userCountryFROM";
	public final static String fromUserNameError = "userNameFROMerror";
	public static final String fromAddressline1 = "userAddressFROM";
	public static final String fromAddressline2 = "userAptSuiteFROM";
	public final static String fromUserPostalError = "userPostalFROMerror";
	public static final String fromPostal = "userPostalFROM";
	public static final String fromPostallabel = "userPostalFROMLabel";
	public static final String fromState = "userStateFROM";
	public static final String fromCity = "userCityFROM";
	public static final String fromPhoneNumber = "userPhoneNumberFROM";
	public static final String fromEmail = "userEmailFROM";
	public static final String fromCompany = "userCompanyFROM";
	public static final String fromUpdate = "updateFROM";
	public final static String userStateLabelFROM = "userStateFROMLabel";
	//public final static String fromUserNameError = "userNameFROMerror";
	public final static String userNameFROM = "userNameFROM";
	public final static String fromUserCountryError = "userCountryFROMError";
	public final static String fromUserAddressError = "userAddressFROMerror";
	public final static String userEmailFROM = "userEmailFROM";
	public final static String fromuserEmailError = "userEmailFROMerror";
	public final static String summaryFromEdit = "summaryFromEdit";
	public final static String userNoteFROM = "(//span[contains(text(),' Your contacts will appear once you start typing below.')])[1]";
	public final static String fromUserStateError = "userStateFROMError";
	public final static String fromUserCityError = "userCityFROMerror";
	public final static String userCityDropDownListFrom = "//*[@id='userCityFROMDropdown']/li[1]";
	public final static String userNameDropFromDownList = "//*[@id='userNameFROMDropdown']/li[1]";
	public final static String fromUserPhonenumberError = "userPhoneNumberFROMerror";
	public final static String userFromAltPickupEdit = "summaryFromAltEdit";
	public final static String fromUserAddressLine2Error = "userAptSuiteFROMerror";
	/*********TO fields***************/
	public final static String toHeader = "fx-mags-address-form-to>h3";
	public static final String toName = "//*[@id='field_contact_personName_firstName']";
	public final static String toCompany = "field_contact_companyName";
	public final static String toCountry = "field_address_countryCode";
	public final static String toAddressline1 = "field_address_streetLine1";
	public final static String toAddressline2 = "field_address_streetLine2";
	public final static String toCity = "field_address_city";
	public final static String toState = "field_address_stateOrProvinceCode";
	public final static String toPostal = "field_address_postalCode";
	public final static String toPhoneNumber = "field_contact_phoneNumber";
	public final static String toEmail = "field_notification_0_email";
	public final static String toUpdate = "fx-mags-address-form+div .fdx-c-button--primary";
	public static final String toUserError = "toUserNameError";
	public static final String globalLoginDropDown = "HeaderLogin";
	public final static String toUserPostalError = "errors_address_postalCode";
	public final static String userPostalTO = "field_address_postalCode";
	public final static String userEmailTO= "field_notification_0_email";
	public final static String userCityTO = "field_address_city";
	public final static String userStateTO = "field_address_stateOrProvinceCode";
	public final static String userPhoneNumberTO = "field_contact_phoneNumber";
	public final static String userCountryTO = "field_address_countryCode";
	public final static String addressSubmitTO = "fx-mags-address-form+div button";
	public final static String userCompanyTO = "field_contact_companyName";
	public final static String userNameTO = "field_contact_personName_firstName";
	public final static String userAddressBookTO= "[fxmagsmodal=addressBook]";
	public final static String userAddressBookCloseTO= "#e2e-addressBook-close > svg";
	public final static String userAddressBookSearchQueryTO= "field_address_book_search_query";






	public final static String alternativePickupAdressLine2 = "alternativePickupAptSuite";
	public final static String userCompanyError = "userCompanyFROMerror";
	public final static String alternativePickupPostal = "alternativePickupPostal";
	public final static String alternativePickupAdressLine2Error = "alternativePickupAptSuiteerror";

	@FindBy(id = fromHeader)
	public WebElement fromfieldHeader;

	@FindBy(id = fromEdit)
	public WebElement fromfieldEdit;

	@FindBy(id = summaryFromEdit)
	public WebElement summaryFromedit;

	@FindBy(id = globalLoginDropDown)
	public WebElement globalLoginDropDowns;

	@FindBy(id =userEmailFROM)
	public WebElement userEmailfROM;

	@FindBy(id = fromUserNameError)
	public WebElement fromUserNameerror;

	@FindBy(id = fromuserEmailError)
	public WebElement fromuserEmailerror;

	@FindBy(xpath = fromName)
	public WebElement fromfieldName;

	@FindBy(id = fromCountry)
	public WebElement fromfieldCountry;

	@FindBy(id = fromAddressline1)
	public WebElement fromfieldAddress1;

	@FindBy(id = fromAddressline2)
	public WebElement fromfieldAddress2;

	@FindBy(id = fromPostal)
	public WebElement fromfieldPostal;

	@FindBy(id = fromPostallabel)
	public WebElement fromfieldPostalLabel;

	@FindBy(id = fromState)
	public WebElement fromfieldState;

	@FindBy(id = fromCity)
	public WebElement fromfieldCity;

	@FindBy(id = fromPhoneNumber)
	public WebElement fromfieldPhnNum;

	@FindBy(id = fromEmail)
	public WebElement fromfieldEmail;

	@FindBy(id = fromCompany)
	public WebElement fromfieldCompany;

	@FindBy(id = fromUpdate)
	public WebElement fromfieldUpdate;

	@FindBy(xpath = toUserError)
	public WebElement toErrorMsg;

	@FindBy(css = toHeader)
	public WebElement tofieldHeader;

	@FindBy(xpath = toName)
	public WebElement tofieldName;

	@FindBy(id = toCompany)
	public WebElement tofieldCompany;

	@FindBy(id = toCountry)
	public WebElement tofieldCountry;

	@FindBy(id = toAddressline1)
	public WebElement tofieldAddress1;

	@FindBy(id = toAddressline2)
	public WebElement tofieldAddress2;

	@FindBy(id = toPostal)
	public WebElement tofieldPostal;

	@FindBy(id = toState)
	public WebElement tofieldState;

	@FindBy(id = toCity)
	public WebElement tofieldCity;

	@FindBy(id = toPhoneNumber)
	public WebElement tofieldPhnNum;

	@FindBy(id = toEmail)
	public WebElement tofieldEmail;

	@FindBy(css = toUpdate)
	public WebElement tofieldUpdate;

	@FindBy(xpath = userNoteFROM)
	public WebElement userNotefROM;

	@FindBy(id = toUserPostalError)
	public WebElement toUserPostalerror;


	@FindBy(id = userNameFROM)
	public WebElement userNamefROM;

	@FindBy(id = fromUserCountryError)
	public WebElement fromUserCountryerror;

	@FindBy(id = fromUserAddressError)
	public WebElement fromUserAddresserror;

	@FindBy(id = fromUserPostalError)
	public WebElement fromUserPostalerror;

	@FindBy(id =userStateLabelFROM)
	public WebElement userStateLabelfROM;

	@FindBy(id = fromUserStateError)
	public WebElement fromUserStateerror;

	@FindBy(id = fromUserCityError)
	public WebElement fromUserCityerror;

	@FindBy(xpath = userCityDropDownListFrom)
	public List<WebElement> userCityDropDownListfrom;

	@FindBy(xpath = userNameDropFromDownList)
	public List<WebElement> userNameDropFromDownlist;

	@FindBy(id = fromUserPhonenumberError)
	public WebElement fromUserPhonenumbererror;

	@FindBy(id = userFromAltPickupEdit)
	public WebElement userFromAltPickupedit;

	@FindBy(id =alternativePickupAdressLine2)
	public WebElement alternativePickupAdressline2;

	@FindBy(id = fromUserAddressLine2Error)
	public WebElement fromUserAddressLine2error;

	@FindBy(id = userCompanyError)
	public WebElement userCompanyerror;

	@FindBy(id = alternativePickupPostal)
	public WebElement alternativePickuppostal;

	@FindBy(id = alternativePickupAdressLine2Error)
	public WebElement alternativePickupAdressLine2error;

	@FindBy(id = userPostalTO)
	public WebElement userPostaltO;

	@FindBy(id =userCityTO)
	public WebElement userCitytO;

	@FindBy(id =userStateTO)
	public WebElement userStatetO;

	@FindBy(id = userPhoneNumberTO)
	public WebElement userPhoneNumbertO;

	@FindBy(id = userEmailTO)
	public WebElement userEmailtO;

	@FindBy(id = userCountryTO)
	public WebElement userCountrytO;

	@FindBy(css = addressSubmitTO)
	public WebElement addressSubmittO;

	@FindBy(id = userCompanyTO)
	public WebElement userCompanytO;

	@FindBy(id = userNameTO)
	public WebElement userNametO;

	@FindBy(css= userAddressBookTO)
	public WebElement userAddressBooktO;

	@FindBy(css= userAddressBookCloseTO)
	public WebElement userAddressBookClosetO;

	@FindBy(id= userAddressBookSearchQueryTO)
	public WebElement userAddressBookSearchQuerytO;
	
	public GoogleSearchPO() {
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}
	
	public int searchResultCount() {

		return searchResult.size() + 1;
	}

	public void clickOnFromEdit() throws InterruptedException {
		Wrappers.waitForElement(fromfieldEdit);
		Wrappers.scrollToElement(fromfieldEdit);
		Wrappers.clickOnElement(fromfieldEdit);
		Thread.sleep(3000);
	}

	public void verifyFromSection(){

		try{
			Thread.sleep(5000);
			JSONObject users = Wrappers.getUserAddressDetailsJson("Bindu  TM");
			Wrappers.getTextFromAndCompareTextWith(userNamefROM,users.get("Name").toString());
			Wrappers.getTextFromAndCompareTextWith(fromfieldCountry,users.get("country").toString());
			Wrappers.getTextFromAndCompareTextWith(fromfieldAddress1,users.get("address").toString());
			//Wrappers.getTextFromAndCompareTextWith(driver,gsPO.fromfieldAddress2,users.get("aptsuite").toString());
			Wrappers.getTextFromAndCompareTextWith(fromfieldPostal,users.get("postal").toString());
			Wrappers.getTextFromAndCompareTextWith(fromfieldState,users.get("state").toString());
			Wrappers.getTextFromAndCompareTextWith(fromfieldCity,users.get("city").toString());
			Wrappers.getTextFromAndCompareTextWith(fromfieldPhnNum,users.get("phonenumber").toString());
			Wrappers.getTextFromAndCompareTextWith(fromfieldEmail,users.get("email").toString());

		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
	}

	public void enterValidationUserEmail(List<String> valueToEnter){
		ArrayList<String> values = new ArrayList<>(valueToEnter);
		for (String val : values) {
			try {
				//   waitForElement(inputElement);
				userEmailfROM.clear();
				Wrappers.enterValue(userEmailfROM, val);
				Wrappers.tabOut(userEmailfROM);
				Wrappers.getTextFromAndCompareTextWithUI(fromuserEmailerror, Wrappers.getEmailValidationError("validationErrorSection.email", "pattern"));
			} catch (Exception e) {
				Assert.fail();
			}

		}
	}

	public void fromSubmit() throws InterruptedException {
		Wrappers.clickOnElement(fromfieldUpdate);
	}

	public void verifyElement(List<String> classPath){
		try {
			for (String s : classPath) {
				WebElement element = Wrappers.getWebElementByClassPath(s);
				//     waitForElement(element);
				if (element.isDisplayed()) {
					System.out.println("Element is displayed");
				} else{
					Assert.fail();
					System.out.println("Element is not displayed");
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
	}

	public void verifyActiveEleme(String elementToVerifyClassPath, String attribute){
		boolean matched = false;
		try {
			WebElement activeElement = DriverFactory.getDriver().switchTo().activeElement();
			String activeElementAttribute = activeElement.getAttribute(attribute);
			String expectedElementAttribute = Wrappers.getWebElementByClassPath(elementToVerifyClassPath).getAttribute(attribute);
			if (activeElementAttribute.equals(expectedElementAttribute)) {
				matched = true;
				System.out.println(matched);
			} else {
				Assert.fail();
			}
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Override
	protected void load() {
	}

	@Override
	protected void isLoaded() throws Error {
		
	}
}
