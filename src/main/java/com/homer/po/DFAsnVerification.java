package com.homer.po;

import org.openqa.selenium.By;

import com.homer.dao.InstanceContainer;
import com.homer.enums.EnumClass.StepResult;

public class DFAsnVerification extends PageBase<DFAppmntCreationASNShipment> {
	static final By lnkMenu  =By.xpath("//span[contains(text(),'enu')]");
	static final By lnkASNs =By.linkText("ASNs");
	static final By inputASNs = By.id("dataForm:ASNList_entityListView:ASNList_filterId2:field30value1");
	static final By btnApply  =By.id("dataForm:ASNList_entityListView:ASNList_filterId2:ASNList_filterId2apply");
	static final By eleASNStatus = By.id("dataForm:ASNList_entityListView:dataTable:0:ASNStatusValueString");
	static final By chckBoxASNs = By.id("checkAll_c0_dataForm:ASNList_entityListView:dataTable");
	static final By btnView  =By.id("dataForm:ASNList_commandbutton_View");
	static final By eleASNClosed = By.id("dataForm:isClosed");
	static final By eleReceiptVariance = By.id("dataForm:ASNList_entityListView:dataTable:0:OPTxt_ReceiptVariance2");
	static final By btnMore  =By.id("soheaderbuttonsmoreButton");
	static final By lnkVerifyASNShipment  =By.id("CTO_ASNList_VerifyASNShipment_more");
	
	static final By lnkActions  =By.xpath("//span[contains(text(),'ctions')]");
	static final By lnkCreateiLPNs =By.linkText("Create iLPNs");
	
	
	public static String ASNStatusIN;
	public static String ASNclosed;
	public DFAsnVerification(InstanceContainer ic) {
		 super(ic);        	     
	 }

	public  void DF_Open_ASN_Verification() throws Exception {		
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkMenu);
		expectedResult = wh.isElementPresent(lnkMenu);
        if (expectedResult) {
            wh.clickElement(lnkMenu);
        }			
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkASNs);
		expectedResult = wh.isElementPresent(lnkASNs);
        if (expectedResult) {
            wh.clickElement(lnkASNs);
        }			
		wh.waitForPageLoaded();
		wh.sendKeys(inputASNs, ASNID);
		expectedResult = wh.isElementPresent(btnApply);
        if (expectedResult) {
            wh.clickElement(btnApply);
        }
		
		wh.waitForPageLoaded();
		wh.waitForElementPresent(eleASNStatus);
		ASNStatusIN=wh.getText(eleASNStatus);		
		if(ASNStatusIN.contains("InTransit")){	
			 report.addReportStep("ASNs Page, ASNs Status",
						"ASNs Status, enter ASNs Status displayed InTransit", 
						StepResult.PASS);
       	   }
       	   else{
       		report.addReportStep("ASNs Page, ASNs Status",
					"ASNs Status, enter ASNs Status Not displayed InTransit", 
					StepResult.FAIL);
       	}	
		
		expectedResult = wh.isElementPresent(chckBoxASNs);
        if (expectedResult) {
            wh.clickElement(chckBoxASNs);
        }
		
		
		expectedResult = wh.isElementPresent(btnView);
        if (expectedResult) {
            wh.clickElement(btnView);
        }
		wh.waitForPageLoaded();
		wh.waitForElementPresent(eleASNClosed);
		ASNclosed=wh.getText(eleASNClosed);		
		if(ASNclosed.contains("No")){	
			 report.addReportStep("ASNs Page, ASNs Status",
						"ASNs Status, enter ASNs Closed displayed NO", 
						StepResult.PASS);
       	   }
       	   else{
       		report.addReportStep("ASNs Page, ASNs Status",
					"ASNs Status, enter ASNs Closed not displayed NO", 
					StepResult.FAIL);
       	}	
		
	}
	
	public  void DF_ASN_Verification() throws Exception{
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkMenu);		
		expectedResult = wh.isElementPresent(lnkMenu);
        if (expectedResult) {
            wh.clickElement(lnkMenu);
        }			
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkASNs);
		expectedResult = wh.isElementPresent(lnkASNs);
        if (expectedResult) {
            wh.clickElement(lnkASNs);
        }
		
		wh.waitForPageLoaded();
		wh.sendKeys(inputASNs, ASNID);
		wh.clickElement(btnApply);
		wh.waitForPageLoaded();
		wh.waitForElementPresent(eleASNStatus);
		ASNStatusIN=wh.getText(eleASNStatus);		
		if(ASNStatusIN.contains("InTransit")){	
			 report.addReportStep("ASNs Page, ASNs Status",
						"ASNs Status, enter ASNs Status displayed InTransit", 
						StepResult.PASS);
       	   }
       	   else{
       		report.addReportStep("ASNs Page, ASNs Status",
					"ASNs Status, enter ASNs Status Not displayed InTransit", 
					StepResult.FAIL);
       	}
		
		String ReceiptVariance = wh.getText(eleReceiptVariance);		
		if(ReceiptVariance.contains("(24) EA")){	
			 report.addReportStep("ASNs Page, ReceiptVariance",
						"ASNs Page, ReceiptVariance", 
						StepResult.PASS);
       	   }
       	   else{
       		report.addReportStep("ASNs Page, ReceiptVariance",
					"ASNs Page, ReceiptVariance not displayed", 
					StepResult.FAIL);
       	}		
		
		expectedResult = wh.isElementPresent(chckBoxASNs);
        if (expectedResult) {
            wh.clickElement(chckBoxASNs);
        }
		
		expectedResult = wh.isElementPresent(btnMore);
        if (expectedResult) {
            wh.clickElement(btnMore);
        }
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkVerifyASNShipment);
		expectedResult = wh.isElementPresent(lnkVerifyASNShipment);
        if (expectedResult) {
            wh.clickElement(lnkVerifyASNShipment);
        }				
	}
	public  void DF_Close_ASN_Verification() throws Exception {		
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkMenu);
		expectedResult = wh.isElementPresent(lnkMenu);
        if (expectedResult) {
            wh.clickElement(lnkMenu);
        }		
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkASNs);
		expectedResult = wh.isElementPresent(lnkASNs);
        if (expectedResult) {
            wh.clickElement(lnkASNs);
        }		
		wh.waitForPageLoaded();
		wh.sendKeys(inputASNs, ASNID);
		expectedResult = wh.isElementPresent(btnApply);
        if (expectedResult) {
            wh.clickElement(btnApply);
        }		
		wh.waitForPageLoaded();
		wh.waitForElementPresent(eleASNStatus);
		ASNStatusIN=wh.getText(eleASNStatus);		
		if(ASNStatusIN.contains("InTransit")){	
			 report.addReportStep("ASNs Page, ASNs Status",
						"ASNs Status, enter ASNs Status displayed InTransit", 
						StepResult.PASS);
       	   }
       	   else{
       		report.addReportStep("ASNs Page, ASNs Status",
					"ASNs Status, enter ASNs Status Not displayed InTransit", 
					StepResult.FAIL);
       	}			
		expectedResult = wh.isElementPresent(chckBoxASNs);
        if (expectedResult) {
            wh.clickElement(chckBoxASNs);
        }
        expectedResult = wh.isElementPresent(btnView);
        if (expectedResult) {
            wh.clickElement(btnView);
        }			
		wh.waitForPageLoaded();
		wh.waitForElementPresent(eleASNClosed);
		ASNclosed=wh.getText(eleASNClosed);		
		if(ASNclosed.contains("No")){	
			 report.addReportStep("ASNs Page, ASNs Status",
						"ASNs Status, enter ASNs Closed displayed NO", 
						StepResult.PASS);
       	   }
       	   else{
       		report.addReportStep("ASNs Page, ASNs Status",
					"ASNs Status, enter ASNs Closed not displayed NO", 
					StepResult.FAIL);
       	}			
	}	
	
	public  void DF_iLPNs_Creation() throws Exception {	
	    wh.waitForPageLoaded();			
		wh.waitForElementPresent(lnkMenu);
		expectedResult = wh.isElementPresent(lnkMenu);
        if (expectedResult) {
            wh.clickElement(lnkMenu);
        }
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkASNs);
		expectedResult = wh.isElementPresent(lnkASNs);
        if (expectedResult) {
            wh.clickElement(lnkASNs);
        }			
		wh.waitForPageLoaded();	
		wh.waitForElementPresent(inputASNs);
		wh.sendKeys(inputASNs, ASNID);
		wh.waitForElementPresent(btnApply);
		expectedResult = wh.isElementPresent(btnApply);
        if (expectedResult) {
            wh.clickElement(btnApply);
        }		
		wh.waitForPageLoaded();
		wh.waitForElementPresent(eleASNStatus);
		ASNStatusIN=wh.getText(eleASNStatus);		
		if(ASNStatusIN.contains("InTransit")){	
			 report.addReportStep("ASNs Page, ASNs Status",
						"ASNs Status, enter ASNs Status displayed InTransit", 
						StepResult.PASS);
       	   }
       	   else{
       		report.addReportStep("ASNs Page, ASNs Status",
					"ASNs Status, enter ASNs Status Not displayed InTransit", 
					StepResult.FAIL);
       	}	
		    
		    expectedResult = wh.isElementPresent(chckBoxASNs);
	        if (expectedResult) {
	            wh.clickElement(chckBoxASNs);
	        }
		    wh.waitForPageLoaded();
			wh.waitForElementPresent(lnkActions);
			expectedResult = wh.isElementPresent(lnkActions);
	        if (expectedResult) {
	            wh.clickElement(lnkActions);
	        }				
			wh.waitForPageLoaded();
			wh.waitForElementPresent(lnkCreateiLPNs);
			expectedResult = wh.isElementPresent(lnkCreateiLPNs);
	        if (expectedResult) {
	            wh.clickElement(lnkCreateiLPNs);
	        }				     
	}	
}
