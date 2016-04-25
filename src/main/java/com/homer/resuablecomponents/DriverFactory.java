package com.homer.resuablecomponents;

import java.net.URL;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.homer.enums.EnumClass.Browser;
import com.homer.helper.HelperClass;
import com.homer.logger.HomerLogger;

public class DriverFactory {
	
	public WebDriver getLocalWebDriver(Browser browser) throws Exception {
		
		System.out.println("getLocalWebDriver called from Homer");
		
		WebDriver driver = null;
		
		switch (browser) {		
		
		case FireFox:
			driver = getFireFoxDriver();
			break;
		case Chrome:
			driver = getChromeDriver();
			break;
		case IE:
			driver = getIEDriver();
			break;
		case Safari:
			driver = getSafariDriver();
			break;
		case HtmlUnit:
			driver = getHTMLUnitDriver();
			break;	
		default:
			break;
		}
		return driver;
	}
	
	public WebDriver getSauceLabDriver(String testCaseName) throws Exception {
		
		System.out.println("getSauceLabDriver called from Homer");
		
		WebDriver driver = null;		
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		
		desiredCapabilities.setCapability("name",testCaseName);
		
		setCapabilitiesUsingSaucelabCap(desiredCapabilities);
		
	    URL hubUrl = null;  			
  		hubUrl = new URL(HelperClass.baseModel.sauceLabsUrl);
	   
  		//throw new Exception("Driver exception from sauce lab");
  		
        driver = new RemoteWebDriver(hubUrl,desiredCapabilities);
	
       
       return (WebDriver)driver;
	}
	
	private void setCapabilitiesUsingSaucelabCap(
			DesiredCapabilities desiredCapabilities) {
		
		for (Entry<String, String> entry : HelperClass.baseModel.sauceLabCapabilities.entrySet()) {
			
			desiredCapabilities.setCapability(entry.getKey(), entry.getValue());
        }
		
		/*Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", "Google Nexus 5");
		Map<String, Object> chromeOptions = new HashMap<String, Object>();
		chromeOptions.put("mobileEmulation", mobileEmulation);*/
		//desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		
	}	
	
	private WebDriver getFireFoxDriver() throws Exception{

		WebDriver driver = null;
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

		return driver;
	}

	private WebDriver getChromeDriver() throws Exception {

		WebDriver driver=null;
		String chromeDriverPath = null;
		
		chromeDriverPath = HelperClass.baseModel.driversPath + "/chromedriver.exe";
		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,chromeDriverPath);
		/*
		if (HelperClass.baseModel.chromeEmulation){

			Map<String, String> mobileEmulation = new HashMap<String, String>();
			mobileEmulation.put("deviceName", HelperClass.baseModel.chromeEmulationDevice);

			Map<String, Object> chromeOptions = new HashMap<String, Object>();
			chromeOptions.put("mobileEmulation", mobileEmulation);
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability("platform", HelperClass.baseModel.platForm);
			capabilities.setCapability("autoAcceptAlerts", "ACCEPT");
		
			capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			 driver = new ChromeDriver(capabilities);
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else {			 
			
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}*/
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}
	
	private WebDriver getIEDriver() throws Exception {

		WebDriver driver = null;			
		String ieDriverPath = HelperClass.baseModel.driversPath
				+ "/IEDriverServer.exe";
		System.setProperty(
				InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY,
				ieDriverPath);

		DesiredCapabilities capabilities = DesiredCapabilities
				.internetExplorer();
		capabilities
				.setCapability(
						InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
		capabilities.setCapability(
				CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION,
				true);		
		
		System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer\\IEDriverServer.exe");     
		//System.setProperty("webdriver.ie.driver", "C:\\WMS\\Homer_Release3.2\\Homer\\Drivers\\IEDriverServer.exe");
        DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
        caps.setCapability(
            InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
            true);
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);     
        capabilities.setCapability("requireWindowFocus", true);
        capabilities.setCapability("enablePersistentHover", false);
		driver = new InternetExplorerDriver(capabilities);
		driver.manage().deleteAllCookies();
		Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 2");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		return driver;
	}
	
	private WebDriver getSafariDriver() throws Exception{

		WebDriver driver = null;			
		driver = new SafariDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;
	}

	private WebDriver getHTMLUnitDriver() throws Exception {

		HtmlUnitDriver driver = new HtmlUnitDriver();
		driver.setJavascriptEnabled(true);		
		Logger.getLogger("").setLevel(Level.OFF); 
				
		return driver;		
	}	
}
