package com.homer.po;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.homer.dao.InstanceContainer;
import com.homer.enums.EnumClass.StepResult;

public class DFPixTransactionsPage extends PageBase<DFPixTransactionsPage>  {
	static final By lnkMenu  =By.xpath("//span[contains(text(),'enu')]");
	static final By lnkConfiguration =By.linkText("Configuration");
	static final By lnkReserveLoc =By.linkText("Reserve Locations");
	static final By inputLoc = By.id("dataForm:listView:filterId:locationLookUpId");
	static final By btnApply  =By.id("dataForm:listView:filterId:filterIdapply");
	static final By chckBoxLocation = By.id("checkAll_c0_dataForm:listView:dataTable");
	static final By btnView  =By.id("rmButton_1View1_8341");
	static final By elementLocation=By.id("dataForm:listView:dataTable:0:dspId");
	static final By elementCurrentquantity=By.id("dataForm:b22Hid");
	static final By elementCurrentvolume  =By.id("dataForm:b28Hid");
	static final By elementCurrentweight  =By.id("dataForm:b25Hid");
	static final By lnkPIXTransactions =By.linkText("PIX Transactions");
	static final By listTransactionsType =By.linkText("dataForm:lview:filterId:field0value1");
	static final By btnPixApply  =By.id("dataForm:lview:filterId:filterId_quickFilterGroupButton_mainButton");
	static final By webtablePix=By.xpath("//table[@id='dataForm:lview:dataTable_body']/tbody/tr");
	
	
	

	public DFPixTransactionsPage(InstanceContainer ic) {
		super(ic);
		
	}
	
	public void PIX_TransactionUpdated(String TransType,String Stype,String Scode,String SAcode,String Inumber,String LpNum) throws Throwable {
		int blnFlag = 0;
	    wh.waitForPageLoaded();
	    expectedResult = wh.isElementPresent(lnkMenu);
        if (expectedResult) {
            wh.clickElement(lnkMenu);
        }
		wh.waitForPageLoaded();		
		wh.waitForElementPresent(lnkPIXTransactions);
		expectedResult = wh.isElementPresent(lnkPIXTransactions);
        if (expectedResult) {
            wh.clickElement(lnkPIXTransactions);
        }
		
		wh.waitForPageLoaded();
		wh.waitForElementPresent(listTransactionsType);
		expectedResult = wh.isElementPresent(listTransactionsType);
        if (expectedResult) {
        	wh.selectValue(lnkPIXTransactions, TransType);
    		wh.clickElement(btnPixApply);			    		
        }
		wh.waitForPageLoaded();		
		int rows=wh.getElementsCount(webtablePix);                       
        for(int rnum=1;rnum<=rows;rnum++){
        	final By webtableStrTType=By.xpath("//table[@id='dataForm:lview:dataTable_body']/tbody/tr["+rnum+"]/td[4]");
        	final By webtableStrTCode=By.xpath("//table[@id='dataForm:lview:dataTable_body']/tbody/tr["+rnum+"]/td[5]");
        	final By webtableStrACode=By.xpath("//table[@id='dataForm:lview:dataTable_body']/tbody/tr["+rnum+"]/td[6]");  
        	final By webtableItemNumb=By.xpath("//table[@id='dataForm:lview:dataTable_body']/tbody/tr["+rnum+"]/td[9]"); 
        	final By webtableLPNNUmber=By.xpath("//table[@id='dataForm:lview:dataTable_body']/tbody/tr["+rnum+"]/td[10]"); 
        	List<WebElement> StrTType=wh.getElements(webtableStrTType); 
        	List<WebElement> StrTCode=wh.getElements(webtableStrTCode); 
        	List<WebElement> StrACode=wh.getElements(webtableStrACode);        
        	List<WebElement> ItemNumb=wh.getElements(webtableItemNumb); 
        	List<WebElement> LPNNUmber=wh.getElements(webtableLPNNUmber);         	         	        	
			for(int cNum=0;cNum<LPNNUmber.size();cNum++){												
				 if(StrTType.get(cNum).getText().equals(Stype) & StrTCode.get(cNum).getText().equals(Scode) & StrACode.get(cNum).getText().equals(SAcode) & ItemNumb.get(cNum).getText().equals(Inumber)& LPNNUmber.get(cNum).getText().equals(LpNum)){ 	        		  		    			  		    			 
	         		  blnFlag=1;
	    			  break;
					 }	        		        		  
              }
				if(blnFlag==1){						
		    		blnFlag=1;
		    		break;
	             }				        		
        } 	
        if(blnFlag==1){	
			report.addReportStep("PIX Transaction Page is ,TransType"+TransType ,
						"PIX Transaction Page is  is , TransCode"+Scode+"PIX Transaction Page is  is , ItemNumber"+Inumber, 
						StepResult.PASS);	    			  	    			  
     	   }
     	   else{
     		  report.addReportStep("PIX Transaction Page is ,TransType"+TransType ,
  						"PIX Transaction Page is  is , TransCode"+Scode+"PIX Transaction Page is  is , ItemNumber"+Inumber, 
  						StepResult.FAIL);					  		    		
         }
	}
	
	public void verification_of_DF_Reserve_Locations_PIX(String ReserveLocation,String CurrentWeight,String CurrentQuantity,String CurrentVolume,String gReserveLoc) throws Throwable { 
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
		wh.waitForElementPresent(lnkReserveLoc);
		expectedResult = wh.isElementPresent(lnkReserveLoc);
		if (expectedResult) {
            wh.clickElement(lnkReserveLoc);
        }
		wh.waitForPageLoaded();		
		wh.waitForElementPresent(inputLoc);
		expectedResult = wh.isElementPresent(inputLoc);
		if (expectedResult) {
			wh.sendKeys(inputLoc, AppointmentID);
			wh.clickElement(btnApply);			
        }		
		wh.waitForPageLoaded();
		wh.waitForElementPresent(chckBoxLocation);			
		String ReserveLocationTxt=wh.getAttribute(elementLocation,"value");
		if(ReserveLocationTxt.equals(ReserveLocation)){				
			 report.addReportStep("Reserve Locations, Reserve Locations Displayed" ,
						"Reserve Locations, Reserve Locations Displayed"+ReserveLocation, 
						StepResult.PASS);
      	   }
      	   else{
      		 report.addReportStep("Reserve Locations, Reserve Locations Displayed" ,
						"Reserve Locations, Reserve Locations Displayed"+ReserveLocation, 
						StepResult.FAIL);
      	}
		wh.clickElement(chckBoxLocation);
		wh.waitForElementPresent(btnView);		
		wh.clickElement(btnView);
		wh.waitForPageLoaded();		
		String CurrentQuantityTxt = wh.getText(elementCurrentquantity);
		String CurrentVolumeTxt = wh.getText(elementCurrentvolume);
		String CurrentWeightTxt = wh.getText(elementCurrentweight);				
		if(CurrentWeightTxt.equals(CurrentWeight) & CurrentQuantityTxt.equals(CurrentQuantity) & CurrentVolumeTxt.equals(CurrentVolume)){				
			 report.addReportStep("Extracting Current Weight, Current Volume and Current Quantity  values" ,
						"Extracting Current Weight, Current Volume and Current Quantity  values"+CurrentWeight+CurrentQuantity+CurrentVolume, 
						StepResult.PASS);
       	   }
       	   else{
       		report.addReportStep("Extracting Current Weight, Current Volume and Current Quantity  values" ,
					"Extracting Current Weight, Current Volume and Current Quantity  values"+CurrentWeight+CurrentQuantity+CurrentVolume, 
					StepResult.FAIL);
       	}	
		
	}
}
