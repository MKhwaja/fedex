package driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is used for defining the configuration properties used in this project.
 */
public class Property {
	
	 public static Properties prop = new Properties();
	
	
	/*
	 * configuration Properties for Selenium and TestNG.
	 */
	public static int implicitWait=15;
	public static int pageLoadTimeout=160;
	public static int scriptTimeout=15;
	public static String ieDriverPath="Drivers/IEDriverServer.exe";
	public static String chromeDriverPath="Drivers/chromedriverV75.exe";
	public static String geckoDriverPath="Drivers/geckodriver.exe";
	public static String firefoxBinaryPath="C:\\Program Files\\Mozilla Firefox\\Firefox.exe";
	public static String ipAddress="172.26.59.88";
	public static String portNumber="4444";

	
	public static  String getAppURL() throws IOException {
		   FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//application.properties");
		   prop.load(fis);
	        String appURL = prop.getProperty(prop.getProperty("level"));
	        return appURL;
	}
	
	public static  Properties LoadProps() throws IOException {
		   FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//application.properties");
		   prop.load(fis);
		   return prop;
	}
	
	public static String getProp(String key) throws IOException{
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//application.properties");
			prop.load(fis);
			String value = prop.getProperty(key);
			return value;
	}
}
