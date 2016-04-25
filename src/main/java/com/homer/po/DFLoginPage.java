package com.homer.po;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.By;

import com.homer.dao.CommonDataColumn;
import com.homer.dao.InstanceContainer;
import com.homer.enums.EnumClass.StepResult;



public class DFLoginPage extends PageBase<DFLoginPage>  {
	
	static final By username = By.name("j_username");
	static final By password = By.name("j_password");
	static final By btnEnter = By.name("btnEnter");
	static final By imgHome  = By.name("home");
	static final By lnkMenu  =By.id("phMenu");
	static final By overlink  =By.id("overridelink");
	static final By lnkSignOut = By.linkText("Sign Out");
	static final By btnSignOutOk = By.name("SignoutOK");
	
	
	public DFLoginPage(InstanceContainer ic) {
		 super(ic);        	     
	 }
	 
	 /**
	  * Method to open Home Page
	 * @throws Exception 
	  * @throws Exception
	  */
	

	
	 public void open() throws Exception {
		 	
		 String envUrl = dataTable.getCommonData(CommonDataColumn.EnvironmentUrl);
		   
			try {								
		        driver.manage().window().maximize();   
		        driver.get(envUrl);									
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				wh.handleAlert();
			}

	 }		
	 
	 
	 public  void SigninPage() throws Exception {			
			wh.waitForElementPresent(overlink);
			wh.clickElement(overlink);					 
		 	wh.sendKeys(username, dataTable.getCommonData(CommonDataColumn.SignInUser));
			wh.sendKeys(password, dataTable.getCommonData(CommonDataColumn.SignInPassword));
			wh.clickElement(btnEnter);			
			wh.waitForElementPresent(imgHome); 
			wh.clickElement(imgHome);
			wh.waitForElementPresent(overlink);
	        wh.clickElement(overlink);	        	             
	        wh.waitForPageLoaded();
			wh.waitForElementPresent(lnkMenu);			
			 if(wh.isElementPresent(lnkMenu)){	
				 report.addReportStep("Login into userID, enter Password and click on Enter",
							"entered user, enter Password and clicked on Enter", 
							StepResult.PASS);
            	   }
            	   else{
            		   report.addReportStep("Login into userID, enter Password and click on Enter",
           					"entered user, enter Password and clicked on Enter", 
           					StepResult.FAIL);
            	}	
		
	      }
	 
	 public  void SignOutLink() throws Exception {
		    wh.waitForPageLoaded();
	        wh.waitForElementPresent(lnkSignOut);
	        expectedResult = wh.isElementPresent(lnkSignOut);
	        if (expectedResult) {
	            wh.clickElement(lnkSignOut);
		 
	         }
	        /*
	        wh.waitForPageLoaded();
	        wh.waitForElementPresent(btnSignOutOk);
	        expectedResult = wh.isElementPresent(btnSignOutOk);
	        if (expectedResult) {
	            wh.clickElement(btnSignOutOk);
		 
	         }
	         */
	 }

}
