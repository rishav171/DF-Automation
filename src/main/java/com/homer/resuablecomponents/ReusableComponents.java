package com.homer.resuablecomponents;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.w3c.dom.DOMException;

import com.homer.dao.CommonDataColumn;
import com.homer.dao.DataColumn;
import com.homer.enums.EnumClass.StepResult;
import com.homer.helper.DataTable;
import com.homer.helper.HelperClass;
import com.homer.reports.Report;
import com.homer.uistore.CommonElements;
import com.homer.uistore.HomePageUI;
import com.homer.uistore.PLPUI;

import us.monoid.json.JSONException;
import us.monoid.json.JSONObject;
import us.monoid.json.XML;



public class ReusableComponents {

	Report report;
	WebDriver driver;
	WebDriverHelper wh;
	DataTable dataHelper;
	public boolean terminateTestOnElementNotPresent = true;
	public HashMap<String, Object> dataStore = new HashMap<String, Object>();

	public ReusableComponents(WebDriver driver, Report report,
			WebDriverHelper wh, DataTable dataHelper) {

		this.report = report;
		this.driver = driver;
		this.dataHelper = dataHelper;
		this.wh = wh;
	}

	/**
	 * Method to open HomePage
	 * @return
	 * @throws Exception
	 */
	public void openHomeDepotAppln() throws Exception {
		
		String envUrl = dataHelper
				.getCommonData(CommonDataColumn.EnvironmentUrl);

		try {

			driver.manage().deleteAllCookies();
			driver.get(envUrl);
			driver.manage().window().maximize();

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			wh.handleAlert();
		}
		
		if (isConsumerHomePage()) {
			report.addReportStep("Open browser and enter HomeDepot URL",
					"Home page displayed successfully", StepResult.PASS);
		} else {
			report.addReportStep("Open browser and enter HomeDepot URL",
					"Home page was not displayed successfully", StepResult.FAIL);
		}
	}
	
	/**
	 * Method to verify Consumer Home Page
	 * 
	 * @return
	 * @throws Exception
	 */
	private boolean isConsumerHomePage() throws Exception {

		if (wh.isElementPresent(HomePageUI.verifyHomepage, 3) || 
				wh.isElementPresent(HomePageUI.verifyHomepage1, 3)) {

			return true;
		} else {

			return false;
		}
	}

	/**
	 * Method to search keyword
	 * @throws Exception
	 */
	public void searchKeyword() throws Exception {
		
		String keyword = dataHelper.getData(DataColumn.Keyword);

		wh.sendKeys(CommonElements.searchTxtBox, keyword);
		wh.clickElement(CommonElements.searchBtn);

		if (wh.isElementPresent(PLPUI.VerifyPLPPage, 4)
				&& wh.getText(CommonElements.breadCumb).contains(
						keyword)) {

			report.addReportStep("Type '" + keyword
					+ "' in search text box and click on search button",
					"User navigated to search plp page.", StepResult.PASS);
		} else {

			report.addReportStep("Type '" + keyword
					+ "' in search text box and click on search button",
					"User is not navigated to search plp page.",
					StepResult.FAIL);

			terminateTestCase("search plp page");
		}
		
	}
	
		/**
	 * Method to throw custom exception to terminate test case
	 * 
	 * @throws Exception
	 */
	public void throwCustomException() throws Exception {

		throw new Exception("Custom Error");
	}

	/**
	 * Method to terminate test case.
	 * 
	 * @param pageName
	 * @throws Exception
	 */
	public void terminateTestCase(String pageName) throws Exception {

		if (terminateTestOnElementNotPresent) {

			report.addCustomErrorStep("Terminating test case",
					"Terminating test case as " + pageName
							+ " is not displayed");

			throwCustomException();
		}
	}
	
	/**
	 * Method to get analytic value
	 * @param analyticsProperty
	 * @return
	 */
	public String getAnalyticsValue(String analyticsProperty) {          
		   	
	     String analyticsObject= "_hddata";
	     Object propertyValue;
	     String jsProperty = analyticsObject + "."
	              + analyticsProperty + ";";
	
	     JavascriptExecutor js = (JavascriptExecutor) driver;
	     propertyValue = js.executeScript("return " + jsProperty);
	
	    // System.out.println("Property returned is : " + propertyValue);
	     if (propertyValue != null)
	        return propertyValue.toString().trim();
	     else
	        return "null";
	}
	
	/**
	 * Method to check if environment is Prod
	 * 
	 * @return true if Prod Environment else false
	 */
	public boolean isProdEnvironment() {

		if (driver.getCurrentUrl().contains("www.homedepot.com")
				|| dataHelper.getCommonData(CommonDataColumn.EnvironmentUrl)
						.contains("www.homedepot.com")
				|| HelperClass.baseModel.runEnvironment.equals("Prod")) {

			return true;

		} else {

			return false;
		}
	}
	
	public String getXMLResponse(String getEndPointURL){
			
			String strResponse = null;
			try{
				
			    URL obj = new URL(getEndPointURL);
			    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			    
	            con.setRequestMethod("GET");
	            int responseCode = con.getResponseCode();
	
	            System.out.println("RESPONSE CODE : " + responseCode);
	            BufferedReader in;
	            if (responseCode != 200)
	                   in = new BufferedReader(new InputStreamReader(
	                                 con.getErrorStream()));
	            else
	                   in = new BufferedReader(new InputStreamReader(
	                                 con.getInputStream()));
	
	            String inputLine;
	            StringBuffer response = new StringBuffer();
	
	            while ((inputLine = in.readLine()) != null) {
	                   response.append(inputLine);
	            }
	            in.close();
	            System.out.println("RESPONSE: "+response);
	            strResponse = response.toString();
	            System.out.println("Json Response:" +strResponse);
	            
	            String xml = null;
	            try {
	            	JSONObject json = new JSONObject(strResponse);
					xml= XML.toString(json);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
	
	            System.out.println("XML Response: "+xml);
				
			}catch (FileNotFoundException e) {
			    System.out.println(e.getCause());
			    System.out.println("EXCEPTION EXPLANATION:");
			    System.out.println(e.getMessage());
			    e.printStackTrace();
			} catch (MalformedURLException e) {
			    System.out.println(e.getCause());
			    System.out.println("EXCEPTION EXPLANATION:");
			    System.out.println(e.getMessage());
			    e.printStackTrace();
			} catch (ProtocolException e) {
			    System.out.println(e.getCause());
			    System.out.println("EXCEPTION EXPLANATION:");
			    System.out.println(e.getMessage());
			    e.printStackTrace();
			}  catch (DOMException e) {
			    System.out.println(e.getCause());
			    System.out.println("EXCEPTION EXPLANATION:");
			    System.out.println(e.getMessage());
			    e.printStackTrace();
			} catch (IOException e) {
			    System.out.println(e.getCause());
			    System.out.println("EXCEPTION EXPLANATION:");
			    System.out.println(e.getMessage());
			    e.printStackTrace();
			} 
			return strResponse;
		}
}




