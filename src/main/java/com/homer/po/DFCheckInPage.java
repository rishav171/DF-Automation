package com.homer.po;

import java.util.Random;

import org.openqa.selenium.By;

import com.homer.dao.DataClass;
import com.homer.dao.InstanceContainer;
import com.homer.enums.EnumClass.StepResult;

public class DFCheckInPage  extends PageBase<DFCheckInPage>   {
	static final By lnkMenu  =By.xpath("//span[contains(text(),'enu')]");
	static final By lnkCheckIn =By.linkText("Check-In");
	static final By inputApptmtId = By.id("dataForm:listView:filterId:field1value1");
	static final By btnApply  =By.id("dataForm:listView:filterId:filterIdapply");	
	static final By chckBoxCheckIn = By.id("checkAll_c0_dataForm:listView:dataTable");
	static final By btnCheckIn  =By.id("rmButton_1CheckIn1_167271203");	
	static final By btnDriverName  =By.id("dataForm:loc3LookupDriver");	
	static final By inputFname = By.id("dataForm:driverNameNew1");
	static final By inputLname = By.id("dataForm:driverLastNameNew1");
	static final By inputLICNo = By.id("dataForm:driverLicNoNew1");
	static final By inputCarrier = By.id("dataForm:driverCRCode1");
	static final By listLicenseState = By.id("dataForm:State_List");
	static final By btnCreate = By.id("dataForm:driver_locgetlist23");
	static final By chckBoxAppmntList = By.id("checkAll_c0_dataForm:listView:apptListTable");	
	static final By inputtrailerV = By.id("dataForm:listViewTrailer:dataTableTrailer:0:trailerV");
	static final By inputCurrLocation = By.id("dataForm:listViewTrailer:dataTableTrailer:0:currentLocationV");
	static final By listtrailerCondition = By.id("dataForm:listViewTrailer:dataTableTrailer:0:trailerConditionV");
	static final By chckBoxTrailerList = By.id("checkAll_c0_dataForm:listViewTrailer:dataTableTrailer");	
	static final By btnSave = By.id("rmButton_1Save1_167271199");
	
	
	
	
	
   public DFCheckInPage(InstanceContainer ic) {
		 super(ic);        	     
	 }
	
   public  void DFCheckInNavigation() throws Exception {		
			wh.waitForPageLoaded();
			wh.waitForElementPresent(lnkMenu);			
			expectedResult = wh.isElementPresent(lnkMenu);
	        if (expectedResult) {
	            wh.clickElement(lnkMenu);
	        }
			wh.waitForPageLoaded();
			wh.waitForElementPresent(lnkCheckIn);
			expectedResult = wh.isElementPresent(lnkCheckIn);
	        if (expectedResult) {
	            wh.clickElement(lnkCheckIn);
	        }			
			wh.waitForPageLoaded();
			wh.waitForElementPresent(inputApptmtId);
			wh.sendKeys(inputApptmtId, AppointmentID);
			expectedResult = wh.isElementPresent(btnApply);
	        if (expectedResult) {
	            wh.clickElement(btnApply);
	        }			
			wh.waitForPageLoaded();
			report.addReportStep("Appointment Page, AppointmentID Details",
					"Appointment Page, AppointmentID Details", 
					StepResult.DONE);
				}

   public  void DF_CheckIn_Fill_Details(String Fname,String Lname,String LicenseNumber,String Carrier,String Statelist,String DockDoor) throws Exception {	
			wh.waitForElementPresent(chckBoxCheckIn);
			expectedResult = wh.isElementPresent(chckBoxCheckIn);
	        if (expectedResult) {
	            wh.clickElement(chckBoxCheckIn);
	        }
	        wh.waitForElementPresent(btnCheckIn);
			expectedResult = wh.isElementPresent(btnCheckIn);
	        if (expectedResult) {
	            wh.clickElement(btnCheckIn);
	        }						
			wh.waitForPageLoaded();
			wh.waitForElementPresent(btnDriverName);
			expectedResult = wh.isElementPresent(btnDriverName);
	        if (expectedResult) {
	            wh.clickElement(btnDriverName);
	        }			
			wh.waitForPageLoaded();
			wh.waitForElementPresent(inputFname);		
			wh.sendKeys(inputFname, Fname);
			wh.sendKeys(inputLname, Lname);
			wh.sendKeys(inputLICNo, LicenseNumber);
			wh.sendKeys(inputCarrier, Carrier);
			wh.selectValue(listLicenseState, Statelist);
			report.addReportStep("Appointment Page, Driver Details",
					"Appointment Page, Driver Details", 
					StepResult.DONE);
			
			expectedResult = wh.isElementPresent(btnCreate);
	        if (expectedResult) {
	        	wh.clickElement(btnCreate);
	        }
			wh.waitForPageLoaded();
			wh.waitForElementPresent(chckBoxAppmntList);	
			expectedResult = wh.isElementPresent(chckBoxAppmntList);
	        if (expectedResult) {
	        	wh.clickElement(chckBoxAppmntList);
	        }			
			wh.waitForPageLoaded();
			wh.waitForElementPresent(inputtrailerV);		
			Random rand = new Random();
			int trailer = rand.nextInt(1000000);
			String strtrailer = Integer.toString(trailer);
			wh.sendKeys(inputtrailerV, strtrailer);
			wh.clearElement(inputCurrLocation);
			wh.waitForElementPresent(inputCurrLocation);
			wh.sendKeys(inputCurrLocation, DockDoor);
			wh.selectValue(listtrailerCondition, "Good");
			wh.waitForPageLoaded();
			wh.waitForElementPresent(chckBoxTrailerList);					
			expectedResult = wh.isElementPresent(chckBoxTrailerList);
	        if (expectedResult) {
	        	wh.clickElement(chckBoxTrailerList);
	        }
			report.addReportStep("Appointment Page, Trailer Details",
					"Appointment Page, Trailer Details", 
					StepResult.DONE);
			wh.clickElement(btnSave);
			String AppmtSucessFullLbl = wh.getSource();	
			if(AppmtSucessFullLbl.contains("Driver should proceed to location [GR1]DD323")){
				 report.addReportStep("Check-in confirmation Page, AppointmentID Sucessfully Created",
							"Check-in confirmation Page, AppointmentID Sucessfully Created", 
							StepResult.PASS);
			   }
			   else{
				 report.addReportStep("Check-in confirmation Page, AppointmentID NOT Sucessfully Created",
							"Check-in confirmation Page, AppointmentID NOT Sucessfully Created", 
							StepResult.FAIL);
			}				
}
	
}
