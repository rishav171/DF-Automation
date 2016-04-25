package com.homer.po;

import org.openqa.selenium.By;

import com.homer.dao.InstanceContainer;
import com.homer.enums.EnumClass.StepResult;

public class DFMULTISPackingStation extends PageBase < DFMULTISPackingStation >  {
	static final By lnkMenuOption = By.id("phMenu");
    static final By lnkMenu = By.xpath("//span[contains(text(),'enu')]");
    static final By lnkDistribution = By.linkText("Distribution Orders");
    static final By lnkDistributionTab = By.linkText("Distribution");
    static final By inputDistributionOrderID = By.id("dataForm:DOList_entityListView:DistributionOrderlist1:field6value1");
    static final By btnApply = By.id("dataForm:DOList_entityListView:DistributionOrderlist1:DistributionOrderlist1apply");
    static final By chckBoxDistOrder = By.id("checkAll_c0_dataForm:DOList_entityListView:DOList_MainListTable");    
    static final By lnkSinglePackStation = By.linkText("SINGLES Packing Station");
    static final By inputPackStatnNbr = By.id("dataForm:PutPack_INP_PackStatnNbr_input");
    static final By btnsubmitButton = By.id("dataForm:submitButton");
    static final By inputToteNbr = By.id("dataForm:SinglePack_INP_ToteNbr");
    static final By inputItemNbr = By.id("dataForm:SinglePack_INP_ItemNbrS11");
    static final By btnShortTote = By.id("dataForm:submitButtonShortTote1");
    static final By btnView = By.id("dataForm:DO_List_View_button");
    static final By lnkLPNs = By.id("DODetailsMainHeader_LPNs_lnk");
    static final By btnShippingLabel = By.id("dataForm:PutWallPackStation_PrintShippingLabel_button");    
    static final By lnkMobilePackStation = By.linkText("MOBILE Packing Station");
    static final By inputoLPNNbr = By.id("dataForm:PutPack_INP_oLPNNbr");    
    static final By inputoItmBarCode = By.id("dataForm:PutWallPackStation_Input_VerifyItemBarcode");    
    static final By lnkMULTISPackingStation = By.linkText("MULTIS Packing Station (Supervisor)");
    static final By chckBoxSec02 = By.id("dataForm:PutPack_ChckBox_Sec02");
    static final By inputoLPNNbr1 = By.id("dataForm:PutPack_INP_oLPNNbr1");       
    static final By webtableMultiPackingStation = By.xpath("//table[@id='dataForm:dataTable_body']/tbody/tr");
    static final By webtableDistOrder = By.xpath("//table[@id='dataForm:DODetailsLpnList_lv:LPNListTable_body']/tbody/tr");
    
	
		
	 public DFMULTISPackingStation(InstanceContainer ic) {
		super(ic);
	
	}

	 public void Clicks_on_MULTIPackingStation_Link(String PackStationNum) throws Throwable {	        
	        wh.waitForPageLoaded();
	        wh.waitForElementPresent(lnkMenuOption);
	        expectedResult = wh.isElementPresent(lnkMenuOption);
	        if (expectedResult) {
	            wh.clickElement(lnkMenuOption);
	        }

	        wh.waitForPageLoaded();
	        expectedResult = wh.isElementPresent(lnkMULTISPackingStation);
	        if (expectedResult) {
	            wh.clickElement(lnkMULTISPackingStation);
	        }
	        wh.waitForPageLoaded();
	        expectedResult = wh.isElementPresent(inputPackStatnNbr);
	        if (expectedResult) {
	            wh.sendKeys(inputPackStatnNbr, PackStationNum);
	            wh.waitForPageLoaded();
	            wh.moveKeyBoardEnter();
	        }
	        wh.waitForPageLoaded();
	        expectedResult = wh.isElementPresent(chckBoxSec02);
	        if (expectedResult) {
	            wh.clickElement(chckBoxSec02);
	        }
	        
	        wh.waitForPageLoaded();
	        expectedResult = wh.isElementPresent(btnsubmitButton);
	        if (expectedResult) {
	            wh.clickElement(btnsubmitButton);
	        }
	        
	 }
	 
	 
	public void MULTISPacking_Station(String[] iLPNs1) throws Throwable {	       	        
	        for(int iLpnitr=0;iLpnitr<=iLPNs1.length-1;iLpnitr++){
	            wh.waitForPageLoaded();
	            expectedResult = wh.isElementPresent(inputoLPNNbr1);
	            if (expectedResult) {
	                wh.sendKeys(inputoLPNNbr1, iLPNs1[iLpnitr]);
	                wh.waitForPageLoaded();
	                wh.moveKeyBoardEnter();
	            }	            
	            wh.waitForPageLoaded();
	            expectedResult = wh.isElementPresent(inputoItmBarCode);
	            if (expectedResult) {	            		            	     	
	              wh.verifyItemNameRowsinPackingSystem(webtableMultiPackingStation,inputoItmBarCode,"//table[@id='dataForm:dataTable_body']/tbody/tr");
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
