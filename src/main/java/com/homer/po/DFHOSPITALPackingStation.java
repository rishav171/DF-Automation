package com.homer.po;

import java.util.Arrays;

import org.openqa.selenium.By;

import com.homer.dao.InstanceContainer;

public class DFHOSPITALPackingStation  extends PageBase < DFHOSPITALPackingStation > {
	static final By lnkMenuOption = By.id("phMenu");
    static final By lnkMenu = By.xpath("//span[contains(text(),'enu')]");    
	static final By lnkHosPackingStation = By.linkText("HOSPITAL Packing Station");
	static final By inputPackStatnNbr = By.id("dataForm:PutPack_INP_PackStatnNbr_input");	
	static final By inputoLPNNbr = By.id("dataForm:PutPack_INP_oLPNNbr");	
	static final By btnYes = By.id("dataForm:softCheckYesButton");	
	static final By webtableHosPackingStation = By.xpath("//table[@id='dataForm:dataTable_body']/tbody/tr");
	static final By inputoItmBarCode = By.id("dataForm:PutWallPackStation_Input_VerifyItemBarcode");
	static final By btnShippingLabel = By.id("dataForm:PutWallPackStation_PrintShippingLabel_button");
	static final By btnsubmitButton = By.id("dataForm:submitButton");
	
	
	public DFHOSPITALPackingStation(InstanceContainer ic) {
		super(ic);
		// TODO Auto-generated constructor stub
	}
	
	public void Clicks_on_HospitalPackingStation_Link(String PackStationNum) throws Throwable {	        
        wh.waitForPageLoaded();
        wh.waitForElementPresent(lnkMenuOption);
        expectedResult = wh.isElementPresent(lnkMenuOption);
        if (expectedResult) {
            wh.clickElement(lnkMenuOption);
        }

        wh.waitForPageLoaded();
        expectedResult = wh.isElementPresent(lnkHosPackingStation);
        if (expectedResult) {
            wh.clickElement(lnkHosPackingStation);
        }
        wh.waitForPageLoaded();
        expectedResult = wh.isElementPresent(inputPackStatnNbr);
        if (expectedResult) {
            wh.sendKeys(inputPackStatnNbr, PackStationNum);
            wh.waitForPageLoaded();
            wh.moveKeyBoardEnter();
        }
        wh.waitForPageLoaded();
        expectedResult = wh.isElementPresent(btnsubmitButton);
        if (expectedResult) {
            wh.clickElement(btnsubmitButton);
        }
        
	}
	
	public void HospitalPack_Station(String[] iLPNs) throws Throwable {	  
		
        for(int iLpnitr=0;iLpnitr<=iLPNs.length-1;iLpnitr++){
            wh.waitForPageLoaded();
            expectedResult = wh.isElementPresent(inputoLPNNbr);
            if (expectedResult) {
                wh.sendKeys(inputoLPNNbr, iLPNs[iLpnitr]);
                wh.waitForPageLoaded();
                wh.moveKeyBoardEnter();
            }	            
            wh.waitForPageLoaded();
            expectedResult = wh.isElementPresent(btnYes);
            if (expectedResult) {
            	wh.clickElement(btnYes);               
            }
            
            expectedResult = wh.isElementPresent(inputoItmBarCode);
            if (expectedResult) {            		            	     	
            	wh.verifyItemNameRowsHospitalinPackingSystem(webtableHosPackingStation,inputoItmBarCode,"//table[@id='dataForm:dataTable_body']/tbody/tr",btnYes);
            }	            
            wh.waitForPageLoaded();
            expectedResult = wh.isElementPresent(btnShippingLabel);
            if (expectedResult) {
                wh.clickElement(btnShippingLabel);
                wh.waitForPageLoaded();
            }
          }	        
     }	
}
