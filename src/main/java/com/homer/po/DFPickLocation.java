package com.homer.po;

import org.openqa.selenium.By;

import com.homer.dao.InstanceContainer;

public class DFPickLocation extends PageBase < DFPickLocation > {

	static final By lnkMenu  =By.xpath("//span[contains(text(),'enu')]");
	static final By lnkConfiguration =By.xpath("//a[contains(text(),'Configuration')]");
	static final By lnkPickLocation =By.xpath("//a[contains(text(),'Pick Locations')]");
	static final By inputlocationLookUpId = By.id("dataForm:listView:filterId:locationLookUpId");
	static final By btnApply = By.id("dataForm:listView:filterId:filterIdapply");
	static final By chckBoxPick = By.id("checkAll_c0_dataForm:listView:dataTable");
	static final By btnView = By.id("rmButton_1View1_8319");
	static final By inputBarcde = By.id("dataForm:c11");
	
	String BrCode;
	
	public DFPickLocation(InstanceContainer ic) {
		super(ic);
		
	}
	
	public String DF_PickUpLocation(String Location) throws Throwable {
	    wh.waitForPageLoaded();
	    wh.waitForElementPresent(lnkMenu);
	    expectedResult = wh.isElementPresent(lnkMenu);
	    if (expectedResult) {
	        wh.clickElement(lnkMenu);
	    }
	        wh.waitForPageLoaded();
	        expectedResult = wh.isElementPresent(lnkConfiguration);
	        if (expectedResult) {
	            wh.clickElement(lnkConfiguration);
	        }
	            wh.waitForPageLoaded();
	            expectedResult = wh.isElementPresent(lnkPickLocation);
	            if (expectedResult) {
	                wh.clickElement(lnkPickLocation);
	                wh.waitForPageLoaded();
	            }
	            wh.waitForPageLoaded();
		        expectedResult = wh.isElementPresent(inputlocationLookUpId);
		        if (expectedResult) {
		            wh.sendKeys(inputlocationLookUpId, Location);		            		            
		        }
		        wh.waitForPageLoaded();
		        expectedResult = wh.isElementPresent(btnApply);
		        if (expectedResult) {
		            wh.clickElement(btnApply);
		        }
		        wh.waitForPageLoaded();
		        wh.waitForElementPresent(chckBoxPick);
		        expectedResult = wh.isElementPresent(chckBoxPick);
		        if (expectedResult) {
		            wh.clickElement(chckBoxPick);
		        }
		        wh.waitForPageLoaded();
		        wh.waitForElementPresent(btnView);
		        expectedResult = wh.isElementPresent(btnView);
		        if (expectedResult) {
		            wh.clickElement(btnView);
		        }
		        wh.waitForPageLoaded();
		        BrCode=wh.getAttribute(inputBarcde, "value");	
		        return BrCode;
	}    
	
	  

}
