package driver;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

import static java.lang.Class.forName;


@SuppressWarnings("deprecation")
public class Wrappers extends Property{


	
	/**
	 * Method to Enter Value in a field
	 * 
	 * @param element, value
	 * @throws InterruptedException 
	 * @throws IOException 
	 */

    public static void enterValue(WebElement element, String value) throws InterruptedException, IOException {
    	new WebDriverWait(DriverFactory.getDriver(), 15).until(ExpectedConditions.visibilityOf(element));
    		if(element.isDisplayed()){
    			BackSpace(element);
    			element.sendKeys(value);
    			Thread.sleep(1000);
    		}
	}

    
/*    public static void closeKeyboard(MobileWebDriver driver) {
        driver.device().closeKeyboard();
        }*/

    public static String getEmailValidationError(String jsonParent, String keyValue) throws JSONException, IOException {
        String errorMsg = null;
        try {
            if (jsonParent.contains(".")) {
                String[] jsonTag = jsonParent.split("\\.");
                errorMsg = getJsonDatalocale("en").getJSONObject(jsonTag[0]).getJSONObject(jsonTag[1]).getString(keyValue);
            } else {
                errorMsg = getJsonDatalocale("en").getJSONObject(jsonParent).getString(keyValue);
            }

        }catch (Exception e){
            Assert.fail();
        }
        return errorMsg;
    }
	
	/**
	 * Method to clear data from a field
	 * 
	 * @param element
	 */
    
    public static void BackSpace(WebElement element){
        String i=element.getAttribute("value").toString();
        int length=i.length();
        while(length!=0)
        {
            element.sendKeys(Keys.BACK_SPACE);
            length--;
        }
    }
    
    
	/**
	 * Method to Click on a Element
	 * 
	 * @param element
     */
    
    public static void clickOnElement(WebElement element) throws InterruptedException {
        waitForElement(element);
        Thread.sleep(3000);
          if (element.isDisplayed()) {
                element.click();
            } 
        else {
        	Assert.fail();
        	}
    }


    /**
     * Method to Click on LoginDropDown Element
     *
     * @param element
     */

    public static void clickOnElementLoginDropDown(WebElement element) {
        element.click();
    }
    
    
	/**
	 * Method to Click on a Element using javascriptexecutor
	 * 
	 * @param element
	 */
    
    public static void clickOnElementJS(WebElement element) {
    	new WebDriverWait(DriverFactory.getDriver(), 15).until(ExpectedConditions.visibilityOf(element));
        if (element.isDisplayed()) {
            ((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].click();", element);
        } else {
            Assert.fail();
        }
    }
    
    
    /**
	 * Method to Select a value from drop down using Value
	 * 
	 * @param element
     * @throws InterruptedException 
	 */
    
    public static void selectValuebyValue(WebElement element, String valueToSelect) throws InterruptedException {
    //	scrollToElement(driver, element);
        Thread.sleep(2000);
            waitforSelectValue(element);
            if (element.isDisplayed()) {
                Select select = new Select(element);
                select.selectByValue(valueToSelect);
                Thread.sleep(2000);
            }
        /*catch(Exception e)
        {
            e.printStackTrace();
        }*/

        else {
				Assert.fail();
			}
    }
       
    
/*    *//**
	 * Method to Select a value from drop down using Value
	 * 
	 * @param element
     * @throws InterruptedException 
	 *//*
    
    public static void selectbyValueMobile(MobileWebDriver driver, String Method, String element, String valueToSelect){
    	WebElement elem = driver.findElement(By.id(element));
    	new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOf(elem));
    	driver.client.hybridSelect("", 0, Method, element, valueToSelect);
    }*/


    /**
     * Method to Select a value from drop down using Index
     *
     * @param element
     * @throws InterruptedException
     */

    public static void selectByIndex(WebElement element, String valueToSelect){

        if (element.isDisplayed()) {
            Select select = new Select(element);
            for (int i = 0; i < select.getOptions().size(); i++) {
                String SelectorValue=select.getOptions().get(i).getText().trim();
                if (valueToSelect.equalsIgnoreCase(SelectorValue)){
                    select.selectByIndex(i);
                    break;
                }
            }
        } else {
            Assert.fail();
        }
    }
    
    
    
    /**
	 * Method to get value from a field
	 * 
	 * @param element
	 */
    
    public static String getText(WebElement element) {
        String getText = null;
      //  new WebDriverWait(DriverFactoryUpdated.getDriver(), 15).until(ExpectedConditions.visibilityOf(element));
        if (element.isDisplayed() || element.isEnabled()) {
        	getText = element.getAttribute("value");
        } else {
            Assert.fail();
        }
        return getText;
    }


    public static String getTextInSelectElement(WebElement element) {
        waitForElement(element);
        String text = new Select(element).getFirstSelectedOption().getText();
        return text;
    }
    
    
    /**
	 * Method to get value from a field
	 * 
	 * @param element
	 */
    
    public static String getInnerText(WebElement element) {
        String getText = null;
     //   new WebDriverWait(DriverFactoryUpdated.getDriver(), 15).until(ExpectedConditions.visibilityOf(element));
        if (element.isDisplayed() || element.isEnabled()) {
        	getText = element.getText();
        } else {
            Assert.fail();
        }
        return getText;
    }
/*
    public static String getInnerTextMobile(MobileWebDriver driver, String element) {
        String getText = null;
        getText = driver.client.elementGetText("WEB", "id="+element, 0); 
        return getText;
    }
    */
   
    /**
	 * Method to compare a value with a given value
	 * 
	 * @param textToCompare
	 */
    
    public static void compareTextValue(String textToCompare, String compareWith) {
        if (textToCompare != null && textToCompare.length() > 0) {
            if (compareWith.contains(textToCompare) || textToCompare.equals(compareWith)
                    || textToCompare.equalsIgnoreCase(compareWith) || textToCompare.matches(compareWith)) {
                System.out.println("Text Comparison Passed");
            } else {
            	System.out.println("Text doesn't match with the Expected");
            	Assert.fail();
            }
        } else {
            Assert.fail();
        }
    }
    
    
    
    public static void getTextFromAndCompareTextWith(WebElement element, String compareWith) throws InterruptedException {
        Thread.sleep(1000);
      //  waitForElement(element);
    	if (element.isDisplayed() || element.isEnabled()) {
            String textToCompare = getText(element).trim();
            System.out.println(textToCompare+" "+compareWith);
            compareTextValue(textToCompare, compareWith);
        } else {
            System.out.println("Element is not available");
            Assert.fail();
        }
    }

    public static void tabOut(WebElement element){
        element.sendKeys(Keys.TAB);
    }
    public static void clickOnTab(String attribute) {
        try {
            WebElement element = DriverFactory.getDriver().switchTo().activeElement();
            element.sendKeys(Keys.TAB);

        } catch (Exception e) {
            Assert.fail();
        }
    }
    
    
    public static void getTextFromAndCompareTextWithUI(WebElement element, String compareWith) throws Exception{
        Thread.sleep(2000);
        if (element.isDisplayed() || element.isEnabled()) {
            String textToCompare = getInnerText(element).trim();
            System.out.println("hello" + textToCompare+","+"jsondata"+compareWith);
            compareTextValue(textToCompare, compareWith);
        } else {
            System.out.println("Element is not available");
            Assert.fail();
        }
    }
    
/*    public static void getTextFromAndCompareTextWithUIMobile(MobileWebDriver driver, String element, String compareWith) {
    	WebElement elem = driver.findElement(By.id(element));
    	if (elem.isDisplayed() || elem.isEnabled()) {
            String textToCompare = getInnerTextMobile(driver, element).trim();
            compareTextValue(textToCompare, compareWith);
        } else {
            System.out.println("Element is not available");
            Assert.fail();
        }
    }*/


    public static String getLabelText(WebElement element) {
        try {
            return ((JavascriptExecutor) DriverFactory.getDriver()).executeScript("return arguments[0].nextElementSibling.innerHTML;", element).toString();
        }catch (JavascriptException js) {
         //   waitForElement(element);
            return element.getText();
        }
    }


    public static void getLabelTextAndCompare(WebElement element, String compareWith) {
        if (element.isDisplayed()) {
            String textToCompare = getLabelText(element).trim();
            compareTextValue(textToCompare, compareWith);
        } else {
            System.out.println("Element is not displayed");
            Assert.fail();
        }
    }


    public static void scrollToElement(WebElement element){
    	((JavascriptExecutor) DriverFactory.getDriver()).executeScript(String.format("window.scroll(0, %s)", element.getLocation().getY() - 300));
    }
    
   /* public static void scrollToElementMobile(MobileWebDriver driver, String pixel){
    	driver.device().runJavascript("window.scrollBy(0,"+ pixel +")");
    }*/
    
 /*   public static void scrollToElementMobile1(WebDriver driver, String pixel){
        ((MobileWebDriver)driver).device().runJavascript("window.scrollBy(0,"+ pixel +")");
    }*/
    
    public static void waitforSelectValue(WebElement element) throws InterruptedException{
    	Select select = new Select(element);
    	for(int i=0;i<15;i++)
    	{
    		if(select.getOptions().size()>1){
    			break;
    		}else {
    			Thread.sleep(1000);
    			i++;
    		}
    	}
    }
    
    public static void waitForElement(WebElement element){
    	new WebDriverWait(DriverFactory.getDriver(), 15).until(ExpectedConditions.visibilityOf(element));
    }
    
    public static void verifyElementIsDisplayed(WebElement element){
    	new WebDriverWait(DriverFactory.getDriver(), 15).until(ExpectedConditions.visibilityOf(element));
    	try{	
	    	if(element.isDisplayed()){
	    		System.out.println("Element is displayed");
	    	}else{
	    		System.out.println("Element is not displayed");
	    		Assert.fail();
	    	}
    	}catch (NoSuchElementException e){
    	Assert.fail();
    	}
    }


    /**
     * Method to get WebElement with the provided classpath
     *
     * @param classPath
     */

    public static WebElement getWebElementByClassPath(String classPath) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        WebElement element;
        classPath = "com.fedex.test.shipping.ObjectsRepository." + classPath;
        int packagePath = classPath.lastIndexOf(".");
        String pageObjectName = classPath.substring(0, packagePath);
        String elementName = classPath.substring(packagePath + 1);
        Class pageObjectClass = forName(pageObjectName);
        Field webElementName;
        webElementName = pageObjectClass.getDeclaredField(elementName);
        webElementName.setAccessible(true);
        element = (WebElement) webElementName.get(pageObjectClass);
        return element;
    }


    /**
     * Method to get select options from drop down
     *
     * @param element
     */

    public static ArrayList<String> getAllAvailableOptionsInSelect(WebElement element) {
        ArrayList<String> options = new ArrayList<String>();
        for (WebElement option : new Select(element).getOptions()) {
            if (option.getAttribute("value") != "") {
                options.add(option.getAttribute("value"));
            }
        }
        return options;
    }


    /**
     * Method to get WebElement with the provided classpath
     *
     * @param classPath
     */

    public static String getStringElementByClassPath(String classPath) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        classPath = "test.java.shipping.mobilePageObjectsAndSteps.M_" + classPath;
        int packagePath = classPath.lastIndexOf(".");
        String pageObjectName = classPath.substring(0, packagePath);
        String elementName = classPath.substring(packagePath + 1);
        Class classObject = Class.forName(pageObjectName);
        Field fl = classObject.getDeclaredField(elementName);
        return fl.get(classObject).toString();
    }


    public static boolean elementisDisplayedAndEnabled(WebElement element) {
        boolean displayed = false;
        try {
            if (element.isDisplayed() && element.isEnabled()) {
                displayed = true;
            }
        } catch (Exception e) {
            displayed = false;
        }
        return displayed;
    }
    
    
    public static void selectRadioButton(WebElement element){
    	new WebDriverWait(DriverFactory.getDriver(), 15).until(ExpectedConditions.visibilityOf(element));
    	try{
    		if(Property.getProp("platform").toString().equalsIgnoreCase("mobile")){
    			element.click();
    			System.out.println("Option is now selected");
    		}else{
    		if(element.isSelected()){
    			System.out.println("Option is selected");
    		}else{
    			element.click();
    			System.out.println("Option is now selected");
    		}
    	}
    		
    	}catch(Exception e){
    		Assert.fail();
    	}
    }
    
    public static void getAndCompareSelectedValueInGivenElement(WebElement element, String valueToVerify) {
        String selectedOption = null;
        try {
            if (element.isDisplayed()) {
                selectedOption = getTextInUserInputElement(element);
                if (selectedOption.equals(valueToVerify)) {
                } else {
                    Assert.fail();
                }
            } else {
                Assert.fail();
            }
        } catch (Exception e) {
            Assert.fail();
        }
    }
    
    public static String getTextInUserInputElement(WebElement element) {
        String getText = null;
        if (element.isDisplayed()) {
            getText = ((JavascriptExecutor) DriverFactory.getDriver()).executeScript("return arguments[0].value", element).toString();
        } else {
            Assert.fail();
        }
        return getText;
    }
    
    
/************************************JSON PARSER : START*********************************************/
    
    public static JSONObject getUserAddressDetailsJson(String userReference) throws IOException {
        JSONObject userAddressDetails = Wrappers.getJsonData("userData");
        JSONArray users = userAddressDetails.getJSONArray("userData");
        JSONObject getUserAddressDetails = null;
        if (userReference.length() < 2) {
        	userReference = "Markus Wainman";
        }
        for (int i = 0; i < users.length(); ) {
            if (((JSONObject) users.get(i)).get("Name").toString().equalsIgnoreCase(userReference)) {
                getUserAddressDetails = ((JSONObject) users.get(i));
                break;
            } else {
                i++;
            }
        }
        return getUserAddressDetails;
    }
    
    
    public static JSONObject getJsonData(String fileName) throws IOException {
    	String filepath = (Property.prop.getProperty("jsonData") + fileName + ".json");
    	File file = new File(filepath);
    	String JSONdata = FileUtils.readFileToString(file, "utf-8");
        return new JSONObject(JSONdata);
    }
    
    
    public static JSONObject getJsonDatalocale(String fileName) throws IOException {
    	String filepath = (Property.prop.getProperty("localeJson") + fileName + ".json");
    	File file = new File(filepath);
    	String JSONdata = FileUtils.readFileToString(file, "utf-8");
        return new JSONObject(JSONdata);
    }
    
    
    public static JSONObject getUserCredentials(String userReference) throws IOException{
            return Wrappers.getJsonData("USER_PROFILE").getJSONObject(userReference);
    }

    public static String getShipmentErrorMessages(String errorDesc) throws IOException {
        return Wrappers.getJsonDatalocale("en").getJSONObject("customsSection").getJSONObject("customsDocumentSection").get(errorDesc).toString();
    }
    
/************************************JSON PARSER : END*********************************************/
/* new objects*/
      public static boolean elementExists(WebElement element) {
       boolean displayed = false;
        try {
        if (element.isDisplayed() && element.isEnabled()) {
            displayed = true;
        }
     } catch (Exception e) {
        displayed = false;
    }
      return displayed;
}
    public static String getTextInElement(WebElement element) {
          String getText = null;
        if (element.isDisplayed() || element.isEnabled()) {
             System.out.println("Element is displayed");
           // report.pass("Element is displayed");
            getText = element.getText();
            //report.pass("Text from WebElement ID " + element.getAttribute("id") + " is - " + getText);
        } else {
            System.out.println("Element isn't displayed");
           // report.fail("Element isn't displayed");
            Assert.fail();
        }
        return getText;
    }


    public static void waitUntilSelectValueOccurs(WebElement element) {
       // ExtentTest report = D_Steps.scenarioTest.createNode("Wait for Select Field to have values");
        try {
            waitForElement(element);
            scrollToElement(element);
            Select select = new Select(element);
            for (int i = 0; i < 20; ) {
                if (select.getOptions().size() > 1) {
                    break;
                } else {
                    Thread.sleep(1000);
                    i++;
                }
            }
        } catch (Exception e) {
            //addScreenShotToExtentReport(report, "Select wait for value Exception");
            Assert.fail();
        }
    }

}
