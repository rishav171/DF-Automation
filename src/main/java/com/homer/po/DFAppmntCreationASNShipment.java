package com.homer.po;

import org.openqa.selenium.By;

import com.homer.dao.InstanceContainer;
import com.homer.enums.EnumClass.StepResult;

public class DFAppmntCreationASNShipment extends PageBase<DFAppmntCreationASNShipment> {
	
	static final By lnkMenu  =By.xpath("//span[contains(text(),'enu')]");
	static final By lnkCreateAppointments =By.linkText("Appointments");
	static final By btnAdd  =By.id("dataForm:listView:apptList_btn_1");
	static final By inputEquipCode = By.id("dataForm:equipment_det");
	static final By inputApptdate = By.id("dataForm:startTime_det");
	static final By listApptype = By.id("dataForm:cd10");
	static final By inputASN = By.id("dataForm:apptObjTable:0:asnId2");
	static final By chckBoxAddApp = By.id("checkAll_c0_dataForm:apptObjTable");
	static final By btnSave  =By.id("apptList_btn_12");
	static final By eleAppointmentID = By.id("dataForm:appointmentId_d");
	
	
	public DFAppmntCreationASNShipment(InstanceContainer ic) {
		 super(ic);        	     
	 }
	
	
	public  void Appointment_Creation() throws Exception {		
			wh.waitForPageLoaded();
			expectedResult = wh.isElementPresent(lnkMenu);
	        if (expectedResult) {
	            wh.clickElement(lnkMenu);
	        }			
			wh.waitForPageLoaded();
			wh.waitForElementPresent(lnkCreateAppointments);
			report.addReportStep("Appointment Page, Appointment Page Displayed",
					"Appointment Page, Appointment Page Displayed", 
					StepResult.DONE);
			expectedResult = wh.isElementPresent(lnkCreateAppointments);
	        if (expectedResult) {
	            wh.clickElement(lnkCreateAppointments);
	        }						
			wh.waitForPageLoaded();
			wh.waitForElementPresent(btnAdd);
			expectedResult = wh.isElementPresent(btnAdd);
	        if (expectedResult) {
	            wh.clickElement(btnAdd);
	        }
							
			wh.waitForPageLoaded();
			wh.waitForElementPresent(inputEquipCode);
			expectedResult = wh.isElementPresent(inputEquipCode);
	        if (expectedResult) {
	        	wh.sendKeys(inputEquipCode, "28");
	        }
					
			wh.sendKeydateVal(inputApptdate);
			wh.selectValue(listApptype, "Live Unload");
			wh.sendKeys(inputASN, ASNID);
			wh.clickElement(chckBoxAddApp);	
			report.addReportStep("Appointment Page, Appointment Details",
					"Appointment Page, Appointment Details Entered", 
					StepResult.DONE);
			wh.clickElement(btnSave);
			wh.waitForPageLoaded();
			wh.waitForElementPresent(eleAppointmentID);
			AppointmentID=wh.getText(eleAppointmentID);		
			if(!AppointmentID.equals("")){	
				 report.addReportStep("Appointment Page, AppointmentID",
							"Appointment Page, AppointmentID dispalyed", 
							StepResult.PASS);
	      	   }
	      	   else{
	      		 report.addReportStep("Appointment Page, AppointmentID",
							"Appointment Page, AppointmentID Not dispalyed", 
							StepResult.FAIL);
	      	}	
		}

}
