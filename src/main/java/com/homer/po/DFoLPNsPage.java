package com.homer.po;

import org.openqa.selenium.By;

import com.homer.dao.InstanceContainer;
import com.homer.enums.EnumClass.StepResult;

public class DFoLPNsPage extends PageBase < DFoLPNsPage > {
	static final By lnkMenuOption = By.id("phMenu");
    static final By lnkMenu = By.xpath("//span[contains(text(),'enu')]");    
    static final By lnkoLPNs = By.linkText("oLPNs");
    static final By inputoLPN = By.id("dataForm:LPNListInOutboundMain_lv:LPNList_Outbound_filterId1:field1value1");
    static final By btnApply = By.id("dataForm:LPNListInOutboundMain_lv:LPNList_Outbound_filterId1:LPNList_Outbound_filterId1apply");
    
    static final By webtableoLPNs = By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr");
    
    
    
	public DFoLPNsPage(InstanceContainer ic) {
		super(ic);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Method to fill payment page details
	 * @return
	 * @throws Exception
	 */
    public void HospitalPacking_oLPNs(String[] iLPNs1, String LPNFacility_Status) throws Throwable {
        wh.waitForPageLoaded();
        wh.waitForElementPresent(lnkMenuOption);
        expectedResult = wh.isElementPresent(lnkMenuOption);
        if (expectedResult) {
            wh.clickElement(lnkMenuOption);
        }
        wh.waitForPageLoaded();
        expectedResult = wh.isElementPresent(lnkoLPNs);
        if (expectedResult) {
            wh.clickElement(lnkoLPNs);
        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(inputoLPN);
        expectedResult = wh.isElementPresent(inputoLPN);
        for(int iLpnitr=0;iLpnitr<=iLPNs1.length-1;iLpnitr++){
        if (expectedResult) {
            wh.sendKeys(inputoLPN, iLPNs1[iLpnitr]);
            wh.clickElement(btnApply);                        
        }
        wh.waitForPageLoaded();
       int row=wh.getSingleRowWithCellData(webtableoLPNs, "//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr", 6, LPNFacility_Status);
       if (row >= 1) {
           report.addReportStep("oLPNs Page",
               "LPN Facility Status is Dispalyed as Packed for HospitalPacking_Station",
               StepResult.PASS);
       } else {
           report.addReportStep("oLPNs Page",
               "LPN Facility Status is Not Dispalyed as Packed for HospitalPacking_Station",
               StepResult.FAIL);
       }
        }
        
    }

}
