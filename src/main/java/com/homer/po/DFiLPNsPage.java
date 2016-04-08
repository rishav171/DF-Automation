package com.homer.po;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.homer.dao.And;
import com.homer.dao.InstanceContainer;
import com.homer.enums.EnumClass.StepResult;

  public class DFiLPNsPage extends PageBase<DFiLPNsPage> {
	static final By lnkMenu  =By.xpath("//span[contains(text(),'enu')]");
	static final By lnkiLPNs =By.linkText("iLPNs");
	static final By inputLPN = By.id("dataForm:LPNListInOutboundMain_lv:LPNList_Inbound_filterId1:field1value1");
		
	static final By btnApply  =By.id("dataForm:LPNListInOutboundMain_lv:LPNList_Inbound_filterId1:LPNList_Inbound_filterId1apply");
	static final By WebElemntLPN = By.id("dataForm:LPNListInOutboundMain_lv:dataTable:0:LPNList_Outbound_Link_NameText_param_out");
	static final By WebElemntpallet = By.id("dataForm:LPNListInOutboundMain_lv:dataTable:0:LPNListTPM_parentLPNLink_NameText_param_out");
	static final By WebElemntSlotNum = By.id("dataForm:LPNListInOutboundMain_lv:dataTable:0:LPNList_Inbound_WorkOrderNbr_param_out");	
	static final By ImgArrow = By.id("LPNList_Inbound_filterId1_fltrExpCol");	
	static final By inputASN = By.id("dataForm:LPNListInOutboundMain_lv:LPNList_Inbound_filterId1:field6value1");
	static final By webtableIlpn=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr");
	
	static final By webtableLPN=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr[1]/td[2]");
	static final By webtableLPNFacStatus=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr[1]/td[3]");
	static final By webtablepallet_no=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr[1]/td[4]");
	static final By webtableCurLoc=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr[1]/td[8]");
	
	static final By webtableLPNQty=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr[1]/td[6]");
	static final By webtableLock=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr[1]/td[7]");
	static final By webtableCurlocation=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr[1]/td[8]");
	static final By webtableDestlocation=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr[1]/td[9]");
		
	public DFiLPNsPage(InstanceContainer ic) {
		 super(ic);        	     
	 }
	
	public void Multiple_iLPN_Verification_Checkin(String iLPNs1,String iLPNsStatus1,String CurrentLocation1,String iLPNs2,String iLPNsStatus2,String CurrentLocation2,String iLPNs3,String iLPNsStatus3,String CurrentLocation3,String iLPNs4,String iLPNsStatus4,String CurrentLocation4) throws Throwable { 
	    wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkMenu);
		wh.clickElement(lnkMenu);	
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkiLPNs);
		wh.clickElement(lnkiLPNs);	
		wh.waitForPageLoaded();
		wh.waitForElementPresent(inputLPN);
		wh.clickElement(ImgArrow);	
		wh.waitForPageLoaded();
		wh.waitForElementPresent(inputASN);
		wh.sendKeys(inputASN, ASNID);				
		wh.clickElement(btnApply);
		wh.waitForPageLoaded();		
		int rows=wh.getElementsCount(webtableIlpn);                       
        for(int rnum=1;rnum<=rows;rnum++){
        	final By webtableCombineXpathRow=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[2]");
        	final By webtableCombineXpathStatus=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[3]");
        	final By webtableCombineXpathCurLoc=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[8]");        	
        	List<WebElement> rowcells=wh.getElements(webtableCombineXpathRow); 
        	List<WebElement> rowstatusCells=wh.getElements(webtableCombineXpathStatus); 
        	List<WebElement> Colcells=wh.getElements(webtableCombineXpathCurLoc);         	 
        	int blnFlag = 0;
			for(int cNum=0;cNum<rowcells.size();cNum++){
				String text1=rowcells.get(cNum).getText();				
					if(text1.equals(iLPNs1)){
						 if(rowstatusCells.get(cNum).getText().equals(iLPNsStatus1) & Colcells.get(cNum).getText().equals(CurrentLocation1)){ 	        		  		    			  
		    			  report.addReportStep("Generated LPN1 is ,LPN Number"+iLPNs1 ,
		  						"Generated LPN1 status is , LPN_Status"+iLPNsStatus1+","+"CurrentLocation"+CurrentLocation1, 
		  						StepResult.PASS);
		    			  blnFlag=1;
		    			  break;
		         	   }
		         	   else{
		         		  report.addReportStep("Generated LPN1 is ,LPN Number"+iLPNs1 ,
			  						"Generated LPN1 status is , LPN_Status"+iLPNsStatus1+","+"CurrentLocation"+CurrentLocation1, 
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
        
        for(int rnum=1;rnum<=rows;rnum++){
		        	final By webtableCombineXpathRow=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[2]");
		        	final By webtableCombineXpathStatus=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[3]");
		        	final By webtableCombineXpathCurLoc=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[8]");        	
		        	List<WebElement> rowcells=wh.getElements(webtableCombineXpathRow); 
		        	List<WebElement> rowstatusCells=wh.getElements(webtableCombineXpathStatus); 
		        	List<WebElement> Colcells=wh.getElements(webtableCombineXpathCurLoc);         	 
		        	int blnFlag = 0;
					for(int cNum=0;cNum<rowcells.size();cNum++){
						String text1=rowcells.get(cNum).getText();				
							if(text1.equals(iLPNs2)){
								 if(rowstatusCells.get(cNum).getText().equals(iLPNsStatus2) & Colcells.get(cNum).getText().equals(CurrentLocation2)){ 	        		  		    			  
				    			  report.addReportStep("Generated LPN2 is ,LPN Number"+iLPNs2 ,
				  						"Generated LPN2 status is , LPN_Status"+iLPNsStatus2+","+"CurrentLocation"+CurrentLocation2, 
				  						StepResult.PASS);
				    			  blnFlag=1;
				    			  break;
				         	   }
				         	   else{
				         		  report.addReportStep("Generated LPN2 is ,LPN Number"+iLPNs2 ,
					  						"Generated LPN2 status is , LPN_Status"+iLPNsStatus2+","+"CurrentLocation"+CurrentLocation2, 
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
        
        for(int rnum=1;rnum<=rows;rnum++){
        	final By webtableCombineXpathRow=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[2]");
        	final By webtableCombineXpathStatus=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[3]");
        	final By webtableCombineXpathCurLoc=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[8]");        	
        	List<WebElement> rowcells=wh.getElements(webtableCombineXpathRow); 
        	List<WebElement> rowstatusCells=wh.getElements(webtableCombineXpathStatus); 
        	List<WebElement> Colcells=wh.getElements(webtableCombineXpathCurLoc);         	 
        	int blnFlag = 0;
			for(int cNum=0;cNum<rowcells.size();cNum++){
				String text1=rowcells.get(cNum).getText();				
					if(text1.equals(iLPNs3)){
						 if(rowstatusCells.get(cNum).getText().equals(iLPNsStatus3) & Colcells.get(cNum).getText().equals(CurrentLocation3)){ 	        		  		    			  
		    			  report.addReportStep("Generated LPN3 is ,LPN Number"+iLPNs3 ,
		  						"Generated LPN3 status is , LPN_Status"+iLPNsStatus3+","+"CurrentLocation"+CurrentLocation3, 
		  						StepResult.PASS);
		    			  blnFlag=1;
		    			  break;
		         	   }
		         	   else{
		         		  report.addReportStep("Generated LPN3 is ,LPN Number"+iLPNs3 ,
			  						"Generated LPN3 status is , LPN_Status"+iLPNsStatus3+","+"CurrentLocation"+CurrentLocation3, 
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
        
        
        for(int rnum=1;rnum<=rows;rnum++){
        	final By webtableCombineXpathRow=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[2]");
        	final By webtableCombineXpathStatus=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[3]");
        	final By webtableCombineXpathCurLoc=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[8]");        	
        	List<WebElement> rowcells=wh.getElements(webtableCombineXpathRow); 
        	List<WebElement> rowstatusCells=wh.getElements(webtableCombineXpathStatus); 
        	List<WebElement> Colcells=wh.getElements(webtableCombineXpathCurLoc);         	 
        	int blnFlag = 0;
			for(int cNum=0;cNum<rowcells.size();cNum++){
				String text1=rowcells.get(cNum).getText();				
					if(text1.equals(iLPNs4)){
						 if(rowstatusCells.get(cNum).getText().equals(iLPNsStatus4) & Colcells.get(cNum).getText().equals(CurrentLocation4)){ 	        		  		    			  
		    			  report.addReportStep("Generated LPN4 is ,LPN Number"+iLPNs4 ,
		  						"Generated LPN4 status is , LPN_Status"+iLPNsStatus4+","+"CurrentLocation"+CurrentLocation4, 
		  						StepResult.PASS);
		    			  blnFlag=1;
		    			  break;
		         	   }
		         	   else{
		         		  report.addReportStep("Generated LPN2 is ,LPN Number"+iLPNs4 ,
			  						"Generated LPN4 status is , LPN_Status"+iLPNsStatus4+","+"CurrentLocation"+CurrentLocation4, 
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


	public void Multiple_iLPN_SLOT_Verification_Checkin(String iLPNs1,String CurrentLocation1,String iLPNs2,String CurrentLocation2) throws Throwable { 
	    wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkMenu);
		wh.clickElement(lnkMenu);	
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkiLPNs);
		wh.clickElement(lnkiLPNs);	
		wh.waitForPageLoaded();
		wh.waitForElementPresent(inputLPN);
		wh.clickElement(ImgArrow);	
		wh.waitForPageLoaded();
		wh.waitForElementPresent(inputASN);
		wh.sendKeys(inputASN, ASNID);								
		wh.clickElement(btnApply);
		wh.waitForPageLoaded();		
		int rows=wh.getElementsCount(webtableIlpn);                       
        for(int rnum=1;rnum<=rows;rnum++){
        	final By webtableCombineXpathRow=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[2]");        	
        	final By webtableCombineXpathCurLoc=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[14]");        	
        	List<WebElement> rowcells=wh.getElements(webtableCombineXpathRow);         	
        	List<WebElement> Colcells=wh.getElements(webtableCombineXpathCurLoc);         	 
        	int blnFlag = 0;
			for(int cNum=0;cNum<rowcells.size();cNum++){
				String text1=rowcells.get(cNum).getText();				
					if(text1.equals(iLPNs1)){
						 if(Colcells.get(cNum).getText().equals(CurrentLocation1)){ 	        		  		    			  
		    			  report.addReportStep("Generated LPN1 Current Slot is ,LPN Number"+iLPNs1 ,
		  						"Generated LPN1 Current Slot is,Generated LPN1 Current Slot is "+CurrentLocation1, 
		  						StepResult.PASS);
		    			  blnFlag=1;
		    			  break;
		         	   }
		         	   else{
		         		  report.addReportStep("Generated LPN1 Current Slot is ,LPN Number"+iLPNs1 ,
			  						"Generated LPN1 Current Slot is,Generated LPN1 Current Slot is "+CurrentLocation1, 
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
        
        for(int rnum=1;rnum<=rows;rnum++){
        	final By webtableCombineXpathRow=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[2]");        	
        	final By webtableCombineXpathCurLoc=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[14]");        	
        	List<WebElement> rowcells=wh.getElements(webtableCombineXpathRow);         	
        	List<WebElement> Colcells=wh.getElements(webtableCombineXpathCurLoc);         	 
        	int blnFlag = 0;
			for(int cNum=0;cNum<rowcells.size();cNum++){
				String text1=rowcells.get(cNum).getText();				
					if(text1.equals(iLPNs2)){
						 if(Colcells.get(cNum).getText().equals(CurrentLocation2)){ 	        		  		    			  
		    			  report.addReportStep("Generated LPN1 Current Slot is ,LPN Number"+iLPNs2 ,
		  						"Generated LPN1 Current Slot is,Generated LPN1 Current Slot is "+CurrentLocation2, 
		  						StepResult.PASS);
		    			  blnFlag=1;
		    			  break;
		         	   }
		         	   else{
		         		  report.addReportStep("Generated LPN1 Current Slot is ,LPN Number"+iLPNs2 ,
			  						"Generated LPN1 Current Slot is,Generated LPN1 Current Slot is "+CurrentLocation2, 
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
	
	
	
  public  void LPNStatus_Verification(String LpnNumber,String Pallet,String SlotNumb) throws Exception {	
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkMenu);
		wh.clickElement(lnkMenu);	
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkiLPNs);
		wh.clickElement(lnkiLPNs);	
		wh.waitForPageLoaded();
		wh.waitForElementPresent(inputLPN);
		wh.sendKeys(inputLPN, LpnNumber);
		wh.clickElement(btnApply);
		wh.waitForPageLoaded();
		wh.waitForElementPresent(WebElemntLPN);
		String LpnNum = wh.getText(WebElemntLPN);
		String PalletNumber = wh.getText(WebElemntpallet);
		String SlotNumber = wh.getText(WebElemntSlotNum);		
		if(LpnNum.equals(LpnNumber) & PalletNumber.equals(Pallet) & SlotNumber.equals(SlotNumb)){	
			 report.addReportStep("iLpns Page, LPN Number"+LpnNumber ,
						"iLpns Page, PalletNumber"+Pallet, 
						StepResult.PASS);
       	   }
       	   else{
       		report.addReportStep("iLpns Page, LPN Number"+LpnNumber ,
						"iLpns Page, PalletNumber"+Pallet, 
						StepResult.FAIL);
         	}					
         }
  
  
  public void verification_of_Multiple_iLPNs(String iLPNs1,String iLPNsStatus1,String CurrentLocation1,String DestinationLocation1,String PreviousLocation1,String iLPNs2,String iLPNsStatus2,String CurrentLocation2,String DestinationLocation2,String PreviousLocation2,String iLPNs3,String iLPNsStatus3,String CurrentLocation3,String DestinationLocation3,String PreviousLocation3) throws Throwable { 
	    wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkMenu);
		wh.clickElement(lnkMenu);	
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkiLPNs);
		wh.clickElement(lnkiLPNs);	
		wh.waitForPageLoaded();
		wh.waitForElementPresent(inputLPN);
		wh.clickElement(ImgArrow);	
		wh.waitForPageLoaded();
		wh.waitForElementPresent(inputASN);		
		wh.sendKeys(inputASN, ASNID);										
		wh.clickElement(btnApply);
		wh.waitForPageLoaded();		
		int rows=wh.getElementsCount(webtableIlpn);        
        System.out.println(rows);     
        String data="10000151419";
        for(int rnum=1;rnum<=rows;rnum++){
        	final By webtableCombineXpathRow=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[2]");
        	final By webtableCombineXpathStatus=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[3]");
        	final By webtableCombineXpathCurLoc=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[8]");
        	final By webtableCombineXpathDestLoc=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[9]");
        	final By webtableCombineXpathPrevLoc=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[10]");        	
        	List<WebElement> rowcells=wh.getElements(webtableCombineXpathRow); 
        	List<WebElement> rowstatusCells=wh.getElements(webtableCombineXpathStatus); 
        	List<WebElement> Colcells=wh.getElements(webtableCombineXpathCurLoc); 
        	List<WebElement> Colcells1=wh.getElements(webtableCombineXpathDestLoc); 
        	List<WebElement> Colcells2=wh.getElements(webtableCombineXpathPrevLoc); 
        	int blnFlag = 0;
			for(int cNum=0;cNum<rowcells.size();cNum++){
				String text1=rowcells.get(cNum).getText();				
					if(text1.equals(iLPNs1)){
						 if(rowstatusCells.get(cNum).getText().equals(iLPNsStatus1) & Colcells.get(cNum).getText().equals(CurrentLocation1) &  Colcells1.get(cNum).getText().equals(DestinationLocation1) & Colcells2.get(cNum).getText().equals(PreviousLocation1)){ 	        		  		    			  
		    			  report.addReportStep("Generated LPN1 is ,LPN Number"+iLPNs1 ,
		  						"Generated LPN1 status is , LPN_Status"+iLPNsStatus1+","+"CurrentLocation"+CurrentLocation1+","+"DestinationLocation"+DestinationLocation1+","+"PreviousLocation"+PreviousLocation1, 
		  						StepResult.PASS);
		    			  blnFlag=1;
		    			  break;
		         	   }
		         	   else{
		         		  report.addReportStep("Generated LPN1 is ,LPN Number"+iLPNs1 ,
			  						"Generated LPN1 status is , LPN_Status"+iLPNsStatus1+","+"CurrentLocation"+CurrentLocation1+","+"DestinationLocation"+DestinationLocation1+","+"PreviousLocation"+PreviousLocation1, 
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
        for(int rnum=1;rnum<=rows;rnum++){
        	final By webtableCombineXpathRow=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[2]");
        	final By webtableCombineXpathStatus=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[3]");
        	final By webtableCombineXpathCurLoc=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[8]");
        	final By webtableCombineXpathDestLoc=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[9]");
        	final By webtableCombineXpathPrevLoc=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[10]");        	
        	List<WebElement> rowcells=wh.getElements(webtableCombineXpathRow); 
        	List<WebElement> rowstatusCells=wh.getElements(webtableCombineXpathStatus); 
        	List<WebElement> Colcells=wh.getElements(webtableCombineXpathCurLoc); 
        	List<WebElement> Colcells1=wh.getElements(webtableCombineXpathDestLoc); 
        	List<WebElement> Colcells2=wh.getElements(webtableCombineXpathPrevLoc); 
		        int blnFlag1 = 0;
				for(int cNum=0;cNum<rowcells.size();cNum++){
					String text1=rowcells.get(cNum).getText();				
						if(text1.equals(iLPNs2)){
							 if(rowstatusCells.get(cNum).getText().equals(iLPNsStatus2) & Colcells.get(cNum).getText().equals(CurrentLocation2) &  Colcells1.get(cNum).getText().equals(DestinationLocation2) & Colcells2.get(cNum).getText().equals(PreviousLocation2)){ 	        		  		    			  
			    			  report.addReportStep("Generated LPN1 is ,LPN Number"+iLPNs2 ,
			  						"Generated LPN2 status is , LPN_Status"+iLPNsStatus2+","+"CurrentLocation"+CurrentLocation2+","+"DestinationLocation"+DestinationLocation2+","+"PreviousLocation"+PreviousLocation2, 
			  						StepResult.PASS);
			    			  blnFlag1=1;
			    			  break;
			         	   }
			         	   else{
			         		  report.addReportStep("Generated LPN1 is ,LPN Number"+iLPNs2 ,
				  						"Generated LPN2 status is , LPN_Status"+iLPNsStatus2+","+"CurrentLocation"+CurrentLocation2+","+"DestinationLocation"+DestinationLocation2+","+"PreviousLocation"+PreviousLocation2, 
				  						StepResult.FAIL);
			         		  blnFlag1=1;
			    			  break;
							 }
		        		}        		  
		          }
					if(blnFlag1==1){						 
		           	 break;
		             }
		    		
    	        } 
           
  
		  for(int rnum=1;rnum<=rows;rnum++){
		  	final By webtableCombineXpathRow=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[2]");
		  	final By webtableCombineXpathStatus=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[3]");
		  	final By webtableCombineXpathCurLoc=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[8]");
		  	final By webtableCombineXpathDestLoc=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[9]");
		  	final By webtableCombineXpathPrevLoc=By.xpath("//table[@id='dataForm:LPNListInOutboundMain_lv:dataTable_body']/tbody/tr["+rnum+"]/td[10]");        	
		  	List<WebElement> rowcells=wh.getElements(webtableCombineXpathRow); 
		  	List<WebElement> rowstatusCells=wh.getElements(webtableCombineXpathStatus); 
		  	List<WebElement> Colcells=wh.getElements(webtableCombineXpathCurLoc); 
		  	List<WebElement> Colcells1=wh.getElements(webtableCombineXpathDestLoc); 
		  	List<WebElement> Colcells2=wh.getElements(webtableCombineXpathPrevLoc); 
			        int blnFlag1 = 0;
					for(int cNum=0;cNum<rowcells.size();cNum++){
						String text1=rowcells.get(cNum).getText();				
							if(text1.equals(iLPNs3)){
								 if(rowstatusCells.get(cNum).getText().equals(iLPNsStatus3) & Colcells.get(cNum).getText().equals(CurrentLocation3) &  Colcells1.get(cNum).getText().equals(DestinationLocation3) & Colcells2.get(cNum).getText().equals(PreviousLocation2)){ 	        		  		    			  
				    			  report.addReportStep("Generated LPN3 is ,LPN Number"+iLPNs3 ,
				  						"Generated LPN3 status is , LPN_Status"+iLPNsStatus3+","+"CurrentLocation"+CurrentLocation3+","+"DestinationLocation"+DestinationLocation3+","+"PreviousLocation"+PreviousLocation3, 
				  						StepResult.PASS);
				    			  blnFlag1=1;
				    			  break;
				         	   }
				         	   else{
				         		  report.addReportStep("Generated LPN1 is ,LPN Number"+iLPNs3 ,
					  						"Generated LPN3 status is , LPN_Status"+iLPNsStatus3+","+"CurrentLocation"+CurrentLocation3+","+"DestinationLocation"+DestinationLocation3+","+"PreviousLocation"+PreviousLocation3, 
					  						StepResult.FAIL);
				         		  blnFlag1=1;
				    			  break;
								 }
			        		}        		  
			          }
						if(blnFlag1==1){						 
			           	 break;
			             }
			    		
			        } 
		     }
  
  public void Navigate_to_iLPN_Res_loc(String Generate_LPN1,String LPN_Status,String LPN_QTY,String CurrentLocation,String DestinationLocation,String LockCode) throws Throwable { 
	    wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkMenu);
		wh.clickElement(lnkMenu);	
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkiLPNs);
		wh.clickElement(lnkiLPNs);	
		wh.waitForPageLoaded();
		wh.waitForElementPresent(inputLPN);
		wh.sendKeys(inputLPN, Generate_LPN1);
		wh.clickElement(btnApply);
		wh.waitForPageLoaded();
		wh.waitForElementPresent(webtableLPN);
		if (wh.getText(webtableLPN).equals(Generate_LPN1) && wh.getText(webtableLPNFacStatus).equals(LPN_Status)&& wh.getText(webtableLPNQty).equals(LPN_QTY)&& wh.getText(webtableCurlocation).equals(CurrentLocation)&& wh.getText(webtableDestlocation).equals(DestinationLocation)&& wh.getText(webtableDestlocation).equals(DestinationLocation)&& wh.getText(webtableLock).equals(LockCode)){
			 report.addReportStep("iLpns Page, LPN Number"+Generate_LPN1 ,
						"iLpns Page, LPN_Status"+LPN_Status, 
						StepResult.PASS);
    	   }
    	   else{
    		   report.addReportStep("iLpns Page, LPN Number"+Generate_LPN1 ,
						"iLpns Page, LPN_Status"+LPN_Status, 
						StepResult.FAIL);
    	   }		
      }  
  
  public void RF_Multiple_iLPN_Verification(String LPN_Number,String Pallet_Number,String LPN_Number_1,String Pallet_Number_1) throws Throwable { 
	    wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkMenu);
		wh.clickElement(lnkMenu);	
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkiLPNs);
		wh.clickElement(lnkiLPNs);	
		wh.waitForPageLoaded();
		wh.waitForElementPresent(inputLPN);
		wh.sendKeys(inputLPN, LPN_Number);
		wh.clickElement(btnApply);
		wh.waitForPageLoaded();
		wh.waitForElementPresent(webtableLPN);
		if (wh.getText(webtableLPN).equals(LPN_Number) && wh.getText(webtablepallet_no).equals(Pallet_Number)){
			 report.addReportStep("Generated Lpns Page, LPN Number"+LPN_Number ,
						"Generated PALLET, Generated PALLET"+Pallet_Number, 
						StepResult.PASS);
  	   }
  	   else{
  		 report.addReportStep("Generated Lpns Page, LPN Number"+LPN_Number ,
					"Generated PALLET, Generated PALLET"+Pallet_Number, 
					StepResult.FAIL);
  	   }
		
		wh.waitForElementPresent(inputLPN);
		wh.sendKeys(inputLPN, LPN_Number_1);
		wh.clickElement(btnApply);
		wh.waitForPageLoaded();
		wh.waitForElementPresent(webtableLPN);
		if (wh.getText(webtableLPN).equals(LPN_Number_1) && wh.getText(webtablepallet_no).equals(Pallet_Number_1)){
			 report.addReportStep("Generated Lpns Page, LPN Number"+LPN_Number_1 ,
						"Generated PALLET, Generated PALLET"+Pallet_Number_1, 
						StepResult.PASS);
  	   }
  	   else{
  		 report.addReportStep("Generated Lpns Page, LPN Number"+LPN_Number_1 ,
					"Generated PALLET, Generated PALLET"+Pallet_Number_1, 
					StepResult.FAIL);
  	   }
    }  
  
  public void RF_Multiple_iLPN_Verification_Loc(String LPN_Number,String Pallet_Number,String Current_Loc) throws Throwable { 
	    wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkMenu);
		wh.clickElement(lnkMenu);	
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkiLPNs);
		wh.clickElement(lnkiLPNs);	
		wh.waitForPageLoaded();
		wh.waitForElementPresent(inputLPN);
		wh.sendKeys(inputLPN, LPN_Number);
		wh.clickElement(btnApply);
		wh.waitForPageLoaded();
		wh.waitForElementPresent(webtableLPN);
		if (wh.getText(webtableLPN).equals(LPN_Number) && wh.getText(webtablepallet_no).equals(Pallet_Number)&& wh.getText(webtableCurLoc).equals(Current_Loc)){
			 report.addReportStep("Generated Lpns Page, LPN Number"+LPN_Number ,
						"Generated PALLET, Generated PALLET"+Pallet_Number+"CurrentLocation, Location"+Current_Loc, 
						StepResult.PASS);
	   }
	   else{
		   report.addReportStep("Generated Lpns Page, LPN Number"+LPN_Number ,
					"Generated PALLET, Generated PALLET"+Pallet_Number+"CurrentLocation, Location"+Current_Loc, 
					StepResult.FAIL);
	   }			
  }  
  
 }
  
  
