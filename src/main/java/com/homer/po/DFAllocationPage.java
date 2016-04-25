package com.homer.po;

import org.openqa.selenium.By;

import com.homer.dao.InstanceContainer;

public class DFAllocationPage  extends PageBase < DFAllocationPage >  {
	
	
	static final By lnkMenuOption = By.id("phMenu");
    static final By lnkMenu = By.xpath("//span[contains(text(),'enu')]");
    static final By lnkWaves = By.linkText("Waves");
    static final By inputWaveNumber = By.id("dataForm:listView:filterId:field0value1");
    static final By btnApply = By.id("dataForm:listView:filterId:filterIdapply");
    static final By chckBoxWave = By.id("checkAll_c0_dataForm:listView:dataTable");
    static final By btnMore1 = By.id("rmbuttons_1moreButton");
    static final By lnkAllocationDetails = By.id("rmButton_2AllocationDetails1_150105000");
    static final By webtableLocation = By.xpath("//table[@id='dataForm:listView:dataTable_body']/tbody/tr[1]/td[4]");
    
    
    String Location;
   
	public DFAllocationPage(InstanceContainer ic) {
		super(ic);		
	}
	
	public String AllocationDetails(String Wave_Number) throws Throwable {	
		wh.waitForPageLoaded();
        wh.waitForElementPresent(lnkMenuOption);
        expectedResult = wh.isElementPresent(lnkMenuOption);
        if (expectedResult) {
            wh.clickElement(lnkMenuOption);
        }

        wh.waitForPageLoaded();
        expectedResult = wh.isElementPresent(lnkWaves);
        if (expectedResult) {
            wh.clickElement(lnkWaves);
        }
        wh.waitForPageLoaded();
        
        wh.waitForElementPresent(inputWaveNumber);
        expectedResult = wh.isElementPresent(inputWaveNumber);
        if (expectedResult) {
            wh.sendKeys(inputWaveNumber, Wave_Number);
            wh.clickElement(btnApply);           
        }
        
        wh.waitForPageLoaded();
        wh.waitForElementPresent(chckBoxWave);
        expectedResult = wh.isElementPresent(chckBoxWave);
        if (expectedResult) {
            wh.clickElement(chckBoxWave);
        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(btnMore1);
        expectedResult = wh.isElementPresent(btnMore1);
        if (expectedResult) {
            wh.clickElement(btnMore1);
        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(lnkAllocationDetails);
        expectedResult = wh.isElementPresent(lnkAllocationDetails);
        if (expectedResult) {
            wh.clickElement(lnkAllocationDetails);
        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(webtableLocation);                
        expectedResult = wh.isElementPresent(webtableLocation);
        if (expectedResult) {
        	Location=driver.findElement(webtableLocation).getText();
        }
        return Location;       		
	}	
	
	
}
