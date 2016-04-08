package com.homer.po;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.homer.dao.CommonDataColumn;
import com.homer.dao.InstanceContainer;
import com.homer.enums.EnumClass.StepResult;

public class DFAsnCreation extends PageBase<DFAsnCreation>  {
	
	static final By lnkMenu  =By.id("phMenu");
	static final By lnkCreateASNMenu =By.linkText("Create ASN From PO");
	static final By btnAdd  =By.id("dataForm:cbaddasn");
	static final By inputAsn = By.id("dataForm:asnidh1");
	static final By btnGenAsn = By.id("dataForm:gena");
	static final By inputShippedDate = By.id("dataForm:sdqtyhcc");
	static final By btnOK  =By.id("dataForm:sv");
	static final By inputAsnTxtbox = By.id("dataForm:filterId2:field1value1");
	static final By btnPoApply  =By.id("dataForm:filterId:filterIdapply");	
	static final By btnApply  =By.id("dataForm:filterId2:filterId2apply");
	static final By inputPOTxtbox = By.id("dataForm:filterId:field1value1");
	static final By btnPlusView = By.id("dataForm:treeTable:0:treeB:adaptor:0::tn1:handle:img:collapsed");
	static final By chckBoxPo = By.id("dataForm:treeTable:0:treeB:adaptor:0:pdadaptor2:0::pdselectId2");
	static final By btnAsnPlusView = By.id("dataForm:atreeTable:0:atreeB:aadaptor:0::j_id138:handle:img:collapsed");
	static final By chckBoxAsn = By.id("dataForm:atreeTable:0:atreeB:aadaptor:0::aselectId");
	static final By btnArrow  =By.id("dataForm:cb5");
	static final By QtyTxtbox1 = By.id("dataForm:atreeTable:0:atreeB:aadaptor:0:apdadaptor2:0::j_id166");
	static final By QtyTxtbox2 = By.id("dataForm:atreeTable:0:atreeB:aadaptor:0:apdadaptor2:1::j_id166");
	
	static final By chckBoxAssign = By.id("dataForm:atreeTable:0:atreeB:aadaptor:0:apdadaptor2:0::apdselectId2");
	static final By btnSave  =By.id("dataForm:cbdelasns");
	static final By webtablePo=By.xpath("//table[@id='tablee2']/tbody/tr");
	static final By webtablePoRow=By.xpath("//table[@id='tablee2']/tbody/tr[");
	static final By webtablePoCol=By.xpath("]/td[3]");
	
	//static String ASNID;
	
	public DFAsnCreation(InstanceContainer ic) {
		 super(ic);        	     
	 }
	
	public  void AsnCreation() throws Exception {
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkMenu);
		wh.clickElement(lnkMenu);	
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkCreateASNMenu);
		wh.clickElement(lnkCreateASNMenu);			
		wh.waitForPageLoaded();						
		wh.waitForElementPresent(btnAdd);
		wh.clickElement(btnAdd);
		wh.waitForPageLoaded();
		wh.waitForElementPresent(inputAsn);
		wh.clickElement(btnGenAsn);
		ASNID=wh.getAttribute(inputAsn,"value");		
		wh.sendKeydateVal(inputShippedDate);
		report.addReportStep("Create ASN from PO, DF ASN Creation",
				 "Create ASN from PO, DF ASN Creation", 
				  StepResult.DONE);
		wh.clickElement(btnOK);
		wh.waitForPageLoaded();	
	}
	
	public  void DF_Assign_ASN_to_PO_Single_Item(String PoNumber,String ItemNumber1) throws Exception {
		wh.waitForPageLoaded();		
		wh.sendKeys(inputAsnTxtbox, ASNID);		
		wh.clickElement(btnApply);	
		wh.waitForPageLoaded();		
		wh.waitForElementPresent(inputPOTxtbox);
		wh.sendKeys(inputPOTxtbox, PoNumber);		
		wh.clickElement(btnPoApply);
		wh.waitForPageLoaded();		
		wh.waitForElementPresent(btnPlusView);
		wh.clickElement(btnPlusView);				
		wh.waitForElementPresent(chckBoxPo);
		int rows=wh.getElementsCount(webtablePo);		                
        for(int rnum=1;rnum<=rows;rnum++){        	
        	final By webtableCombineXpathRow=By.xpath("//table[@id='tablee2']/tbody/tr["+rnum+"]/td[3]");
        	List<WebElement> rowcells=wh.getElements(webtableCombineXpathRow);        			      	
        	int blnFlag = 0;
			for(int cNum=0;cNum<rowcells.size();cNum++){
        		  String text=rowcells.get(cNum).getText();        		  
        		if(text.equals(ItemNumber1)){
        			final By webtableCombineXpathCheckBox=By.id("dataForm:treeTable:0:treeB:adaptor:0:pdadaptor2:"+cNum+"::pdselectId2");
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
		wh.waitForElementPresent(btnAsnPlusView);
		wh.clickElement(btnAsnPlusView);	
		wh.waitForElementPresent(chckBoxAsn);
		wh.clickElement(chckBoxAsn);	
		wh.waitForPageLoaded();		            
		wh.waitForElementPresent(btnArrow);
		wh.clickElement(btnArrow);				
		wh.waitForPageLoaded();		
		wh.waitForElementPresent(QtyTxtbox1);
		wh.sendKeys(QtyTxtbox1, "1");		
		//wh.waitForElementPresent(chckBoxAssign);
		//wh.clickElement(chckBoxAssign);	
		wh.waitForPageLoaded();	
		report.addReportStep("Create ASN from PO, Assign ASN to PO Single Item",
				 "Create ASN from PO, Assign ASN to PO Single Item", 
				  StepResult.DONE);
		wh.clickElement(btnSave);	
		wh.waitForPageLoaded();			
		
	}
	
	public  void Assign_ASN_to_PO_Multiple_Items(String PoNumber, String ItemNumber1, String ItemNumber2) throws Exception {
		wh.waitForPageLoaded();		
		wh.sendKeys(inputAsnTxtbox, ASNID);		
		wh.clickElement(btnApply);	
		wh.waitForPageLoaded();		
		wh.waitForElementPresent(inputPOTxtbox);
		wh.sendKeys(inputPOTxtbox, PoNumber);		
		wh.clickElement(btnPoApply);
		wh.waitForPageLoaded();		
		wh.waitForElementPresent(btnPlusView);
		wh.clickElement(btnPlusView);
							
		wh.waitForElementPresent(chckBoxAsn);		
		wh.waitForPageLoaded();		
		int rows=wh.getElementsCount(webtablePo);		                
        for(int rnum=1;rnum<=rows;rnum++){        	
        	final By webtableCombineXpathRow=By.xpath("//table[@id='tablee2']/tbody/tr["+rnum+"]/td[3]");
        	List<WebElement> rowcells=wh.getElements(webtableCombineXpathRow);        			      	
        	int blnFlag = 0;
			for(int cNum=0;cNum<rowcells.size();cNum++){
        		  String text=rowcells.get(cNum).getText();        		  
        		if(text.equals(ItemNumber1)){
        			final By webtableCombineXpathCheckBox=By.id("dataForm:treeTable:0:treeB:adaptor:0:pdadaptor2:"+cNum+"::pdselectId2");
        			wh.clickElement(webtableCombineXpathCheckBox);
        			blnFlag=1;
        			break;
        		}        		
        	}        	
        	if(blnFlag==1){	
            	 break;
              }
         }      
        
        int rowscnt=wh.getElementsCount(webtablePo);		                
        for(int rnum=1;rnum<=rowscnt;rnum++){        	
        	final By webtableCombineXpathRow=By.xpath("//table[@id='tablee2']/tbody/tr["+rnum+"]/td[3]");
        	List<WebElement> rowcells=wh.getElements(webtableCombineXpathRow);        			      	
        	int blnFlag = 0;
			for(int cNum=0;cNum<rowcells.size();cNum++){
        		  String text=rowcells.get(cNum).getText();        		  
        		if(text.equals(ItemNumber2)){
        			final By webtableCombineXpathCheckBox=By.id("dataForm:treeTable:0:treeB:adaptor:0:pdadaptor2:"+cNum+"::pdselectId2");
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
		wh.waitForElementPresent(btnAsnPlusView);
		wh.clickElement(btnAsnPlusView);	
		wh.waitForElementPresent(chckBoxAsn);
		wh.clickElement(chckBoxAsn);	
		wh.waitForPageLoaded();		            
		wh.waitForElementPresent(btnArrow);
		wh.clickElement(btnArrow);				
		wh.waitForPageLoaded();		
		wh.waitForElementPresent(QtyTxtbox1);
		wh.sendKeys(QtyTxtbox1, "1");	
		wh.waitForElementPresent(QtyTxtbox2);
		wh.sendKeys(QtyTxtbox2, "1");		
		wh.waitForPageLoaded();	
		report.addReportStep("Create ASN from PO, Assign ASN to PO Single Item",
				 "Create ASN from PO, Assign ASN to PO Single Item", 
				  StepResult.DONE);
		wh.clickElement(btnSave);	
		wh.waitForPageLoaded();		
	}
	
	
	
	
}
