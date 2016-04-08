package com.homer.po;

import org.openqa.selenium.By;

import com.homer.dao.InstanceContainer;
import com.homer.enums.EnumClass.StepResult;

public class DFReleaseDockDoor extends PageBase<DFAppmntCreationASNShipment>  {
	static final By lnkMenu  =By.xpath("//span[contains(text(),'enu')]");
	static final By lnkDockDoor =By.linkText("Dock Door");
	static final By inputdockDoor = By.id("dataForm:listView:filterId:dockDoorLookUpFilterId");
	static final By btnApply  =By.id("dataForm:listView:filterId:filterIdapply");	
	static final By eledockstatus = By.id("dataForm:listView:dataTable:1:out5");
	public static String dockDoorStatus;
	
	public DFReleaseDockDoor(InstanceContainer ic) {
		 super(ic);        	     
	 }
	
	public  void DF_Open_ASN_Verification(String DockDoor) throws Exception {		
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkMenu);
		wh.clickElement(lnkMenu);	
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkDockDoor);
		wh.clickElement(lnkDockDoor);	
		wh.waitForPageLoaded();
		wh.waitForElementPresent(inputdockDoor);
		wh.sendKeys(inputdockDoor, DockDoor);
		wh.clickElement(btnApply);
		wh.waitForPageLoaded();
		wh.waitForElementPresent(eledockstatus);
		dockDoorStatus=wh.getText(eledockstatus);		
		if(dockDoorStatus.contains("In Use (Full)")){	
			 report.addReportStep("Dock door list Page, dockDoor Status",
						"dockDoor Status, enter dockDoor Status displayed as In Use (Full)", 
						StepResult.PASS);
       	   }
       	   else{
       		report.addReportStep("Dock door list Page, dockDoor Status",
					"dockDoor Status, enter dockDoor Status not displayed as In Use (Full)", 
					StepResult.FAIL);
       	}	
		
		
		
	}
}
