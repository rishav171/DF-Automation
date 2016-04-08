package com.homer.po;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.homer.dao.InstanceContainer;
import com.homer.enums.EnumClass.StepResult;

public class DFActivityTrackingPage extends PageBase<DFActivityTrackingPage> {
	static final By lnkMenu  =By.xpath("//span[contains(text(),'enu')]");
	static final By lnkConfiguration =By.linkText("Configuration");
	static final By lnkActivityTracking =By.linkText("Activity Tracking");
	static final By listTransType = By.id("dataForm:lv1:filterId:field1value1");
	static final By inputItem = By.id("dataForm:lv1:filterId:itemLookUpId");
	static final By btnApply  =By.id("dataForm:lv1:filterId:filterIdapply");
	static final By webtableActivityTracking=By.xpath("//table[@id='dataForm:lv1:dataTable_body']/tbody/tr");
	static final By btnView =By.id("rmButton_2View1_8109000");	
	
	static final By ElementTransTyp = By.id("dataForm:tranTyp");
	static final By ElementTransCD = By.id("dataForm:tranCd");
	static final By ElementStatusCd = By.id("dataForm:stCd");
	static final By ElementASNNumber = By.id("dataForm:rfFld1");
	static final By ElementPONumber = By.id("dataForm:rfFld2");
	
	
	public DFActivityTrackingPage(InstanceContainer ic) {
		super(ic);
		// TODO Auto-generated constructor stub
	}

	
	public void Activity_TrackingPage(String LPNNumber,String Transaction_Type,String ItemBar,String From_LOCATION,String To_LOCATION) throws Throwable {
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkMenu);
		expectedResult = wh.isElementPresent(lnkMenu);
        if (expectedResult) {
            wh.clickElement(lnkMenu);
        }		
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkConfiguration);
		expectedResult = wh.isElementPresent(lnkConfiguration);
        if (expectedResult) {
            wh.clickElement(lnkConfiguration);
        }
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkActivityTracking);
		expectedResult = wh.isElementPresent(lnkActivityTracking);
        if (expectedResult) {
            wh.clickElement(lnkActivityTracking);
        }
		wh.waitForPageLoaded();		
		wh.waitForElementPresent(listTransType);
		expectedResult = wh.isElementPresent(listTransType);
        if (expectedResult) {
        	wh.selectValue(listTransType, Transaction_Type);
        }
					
		wh.waitForPageLoaded();		
		wh.waitForElementPresent(inputItem);
		expectedResult = wh.isElementPresent(inputItem);
        if (expectedResult) {
        	wh.sendKeys(inputItem, ItemBar);		
    		wh.clickElement(btnApply);    		
        }
		wh.waitForPageLoaded();
		wh.waitForElementPresent(webtableActivityTracking);					
		int rows=wh.getElementsCount(webtableActivityTracking);                       
        for(int rnum=1;rnum<=rows;rnum++){
        	final By webtableCombineLPNXpathRow=By.xpath("//table[@id='dataForm:lv1:dataTable_body']/tbody/tr["+rnum+"]/td[7]");
        	final By webtableCombineItemXpathRow=By.xpath("//table[@id='dataForm:lv1:dataTable_body']/tbody/tr["+rnum+"]/td[8]");
        	final By webtableCombineFromLocXpathStatus=By.xpath("//table[@id='dataForm:lv1:dataTable_body']/tbody/tr["+rnum+"]/td[9]");
        	final By webtableCombineXpathToCurLoc=By.xpath("//table[@id='dataForm:lv1:dataTable_body']/tbody/tr["+rnum+"]/td[10]");        	
        	List<WebElement> LPNrowcells=wh.getElements(webtableCombineLPNXpathRow); 
        	List<WebElement> Itemrowcells=wh.getElements(webtableCombineItemXpathRow); 
        	List<WebElement> FromLocrowCells=wh.getElements(webtableCombineFromLocXpathStatus); 
        	List<WebElement> ToLocColcells=wh.getElements(webtableCombineXpathToCurLoc);         	 
        	int blnFlag = 0;
			for(int cNum=0;cNum<LPNrowcells.size();cNum++){
				String text1=LPNrowcells.get(cNum).getText();				
					if(text1.equals(LPNNumber)){
						 if(Itemrowcells.get(cNum).getText().equals(ItemBar) && FromLocrowCells.get(cNum).getText().equals(From_LOCATION) && ToLocColcells.get(cNum).getText().equals(To_LOCATION)){ 	        		  		    			  
		    			  report.addReportStep("Activity Tracking Page,From location Dispalys"+From_LOCATION ,
		  						"Activity Tracking Page,To location Dispalys"+To_LOCATION, 
		  						StepResult.PASS);
		    			  blnFlag=1;
		    			  break;
		         	   }
		         	   else{
		         		  report.addReportStep("Activity Tracking Page,From location Dispalys"+From_LOCATION ,
			  						"Activity Tracking Page,To location Dispalys"+To_LOCATION, 
			  						StepResult.FAIL);
		         		  blnFlag=1;
		    			  break;
						 }
	        		}        		  
              }
				if(blnFlag==1){						 
	           	 break;
	             }        		
        	 }         
	}
	
	public void Activity_Tracking_Reserve(String LPNNumber,String Transaction_Type,String ItemBar,String Transaction_Code,String ASN_Number,String PO_Number,String Status) throws Throwable {
		 wh.waitForPageLoaded();
		 wh.waitForElementPresent(lnkMenu);
		 expectedResult = wh.isElementPresent(lnkMenu);
	        if (expectedResult) {
	            wh.clickElement(lnkMenu);
	        }		
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkConfiguration);				 
		 expectedResult = wh.isElementPresent(lnkConfiguration);
	        if (expectedResult) {
	            wh.clickElement(lnkConfiguration);
	        }		
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkActivityTracking);					 
		 expectedResult = wh.isElementPresent(lnkActivityTracking);
	        if (expectedResult) {
	            wh.clickElement(lnkActivityTracking);
	        }					
		wh.waitForPageLoaded();		
		wh.waitForElementPresent(listTransType);
		 expectedResult = wh.isElementPresent(listTransType);
	        if (expectedResult) {
	        	wh.selectValue(listTransType, Transaction_Type);
	        }		
		wh.waitForPageLoaded();		
		wh.waitForElementPresent(webtableActivityTracking);					
		int rows=wh.getElementsCount(webtableActivityTracking);                       
        for(int rnum=1;rnum<=rows;rnum++){
        	final By webtableCombineTransTypeRow=By.xpath("//table[@id='dataForm:lv1:dataTable_body']/tbody/tr["+rnum+"]/td[4]");
        	final By webtableCombineTransCodeRow=By.xpath("//table[@id='dataForm:lv1:dataTable_body']/tbody/tr["+rnum+"]/td[5]");
        	final By webtableCombineLPNXpathRow=By.xpath("//table[@id='dataForm:lv1:dataTable_body']/tbody/tr["+rnum+"]/td[7]");
        	final By webtableCombineItemXpathRow=By.xpath("//table[@id='dataForm:lv1:dataTable_body']/tbody/tr["+rnum+"]/td[8]");
        	   
        	List<WebElement> TransTyperowcells=wh.getElements(webtableCombineTransTypeRow); 
        	List<WebElement> TransCoderowcells=wh.getElements(webtableCombineTransCodeRow); 
        	List<WebElement> LPNrowcells=wh.getElements(webtableCombineLPNXpathRow); 
        	List<WebElement> Itemrowcells=wh.getElements(webtableCombineItemXpathRow);         	        	 
        	int blnFlag = 0;
			for(int cNum=0;cNum<TransTyperowcells.size();cNum++){												
			   if(TransTyperowcells.get(cNum).getText().equals(Transaction_Type) && LPNrowcells.get(cNum).getText().equals(LPNNumber) && Itemrowcells.get(cNum).getText().equals(ItemBar)){				   
    			 final By webtableCombineXpathCheckBox=By.id("checkAll_c"+cNum+"_dataForm:lv1:dataTable");
        			wh.clickElement(webtableCombineXpathCheckBox);
        			blnFlag=1;
        			break;
         	     }		         	   							        		       		  
             }
				if(blnFlag==1){						 
	           	 break;
	             }        		
        	 } 	
		        wh.waitForPageLoaded();
				wh.waitForElementPresent(btnView);
				wh.clickElement(btnView);				
				wh.waitForPageLoaded();	
				wh.waitForElementPresent(ElementTransTyp);
				
				if (wh.getText(ElementTransTyp).equals(Transaction_Type) && wh.getText(ElementTransCD).equals(Transaction_Code) && wh.getText(ElementStatusCd).equals(Status) && wh.getText(ElementASNNumber).equals(ASN_Number)  && wh.getText(ElementPONumber).equals(PO_Number)){
					 report.addReportStep("Activity Tracking Page, Transaction type is:"+Transaction_Type ,
								"Activity Tracking Page, Transaction Code is:"+Transaction_Code+"Status Code"+ElementStatusCd, 
								StepResult.PASS);
			   }
			   else{
				   report.addReportStep("Activity Tracking Page, Transaction type is:"+Transaction_Type ,
							"Activity Tracking Page, Transaction Code is:"+Transaction_Code+"Status Code"+ElementStatusCd, 
							StepResult.FAIL);
			   }
				
	}

}
	