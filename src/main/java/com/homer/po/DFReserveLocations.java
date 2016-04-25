package com.homer.po;

import org.openqa.selenium.By;

import com.homer.dao.InstanceContainer;

public class DFReserveLocations  extends PageBase < DFReserveLocations > {
	static final By lnkMenu  =By.xpath("//span[contains(text(),'enu')]");
	static final By lnkConfiguration =By.xpath("//a[contains(text(),'Configuration')]");
	static final By lnkReserveLocation =By.xpath("//a[contains(text(),'Reserve Locations')]");
	static final By inputlocationLookUpId = By.id("dataForm:listView:filterId:locationLookUpId");
	static final By btnApply = By.id("dataForm:listView:filterId:filterIdapply");
	static final By chckBoxReserve = By.id("checkAll_c0_dataForm:listView:dataTable");
	static final By btnView = By.id("rmButton_1View1_8341");	
	static final By inputBarcde = By.id("dataForm:b10");
	
	String BrCode;
	
	public DFReserveLocations(InstanceContainer ic) {
		super(ic);
		
	}
      
	
	public String DF_ReserveLocation(String BrCode) throws Throwable {
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
	            expectedResult = wh.isElementPresent(lnkReserveLocation);
	            if (expectedResult) {
	                wh.clickElement(lnkReserveLocation);
	                wh.waitForPageLoaded();
	            }
	            wh.waitForPageLoaded();
		        expectedResult = wh.isElementPresent(inputlocationLookUpId);
		        if (expectedResult) {
		            wh.sendKeys(inputlocationLookUpId, BrCode);		            		            
		        }
		        wh.waitForPageLoaded();
		        expectedResult = wh.isElementPresent(btnApply);
		        if (expectedResult) {
		            wh.clickElement(btnApply);
		        }
		        
		        wh.waitForPageLoaded();
		        wh.waitForElementPresent(chckBoxReserve);
		        expectedResult = wh.isElementPresent(chckBoxReserve);
		        if (expectedResult) {
		            wh.clickElement(chckBoxReserve);
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
