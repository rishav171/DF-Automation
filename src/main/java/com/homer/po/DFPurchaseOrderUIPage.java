package com.homer.po;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.homer.dao.InstanceContainer;
import com.homer.enums.EnumClass.StepResult;

public class DFPurchaseOrderUIPage extends PageBase<DFPurchaseOrderUIPage> {
	static final By lnkMenu  =By.xpath("//span[contains(text(),'enu')]");
	static final By lnkPurchaseOrder =By.linkText("Purchase Orders");
	static final By inputPoOrder = By.id("dataForm:POList_entityListView:POlistFil1:field6value1");
	static final By btnApply  =By.id("dataForm:POList_entityListView:POlistFil1:POlistFil1apply");
	static final By chckBoxCheckIn = By.id("checkAll_c0_dataForm:POList_entityListView:dataTable");
	static final By btnView  =By.id("dataForm:PO_List_View_button");
	static final By lnkLines =By.id("PODetail_Line_Item_Tab_lnk");
	static final By WebElemntSKU = By.id("dataForm:lvLineItems1:dataTablePOLineItem:0:packTypeId");
	static final By WebElemntStatus = By.id("dataForm:lvLineItems1:dataTablePOLineItem:0:cd6");
	static final By WebElemntReceived_Qty = By.id("dataForm:lvLineItems1:dataTablePOLineItem:0:cd13");
	static final By WebElemntRemaining_Qty = By.id("dataForm:lvLineItems1:dataTablePOLineItem:0:cd14");
	static final By WebElemntSKU1 = By.id("dataForm:lvLineItems1:dataTablePOLineItem:1:packTypeId");
	static final By WebElemntStatus1 = By.id("dataForm:lvLineItems1:dataTablePOLineItem:1:cd6");
	static final By WebElemntReceived_Qty1 = By.id("dataForm:lvLineItems1:dataTablePOLineItem:1:cd13");
	static final By WebElemntRemaining_Qty1 = By.id("dataForm:lvLineItems1:dataTablePOLineItem:1:cd14");
	static final By webtablePOOrder=By.xpath("//table[@id='dataForm:lvLineItems1:dataTablePOLineItem_body']/tbody/tr");
	
				
	public DFPurchaseOrderUIPage(InstanceContainer ic) {
		super(ic);
		// TODO Auto-generated constructor stub
	}

	public  void verification_of_Purchase_Order_UI_Page(String PurchaseOrder,String SKU,String Status,String Received_Qty,String Remaining_Qty,String SKU2,String Status2,String Received_Qty2,String Remaining_Qty2) throws Exception {	
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkMenu);
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkPurchaseOrder);
		wh.clickElement(lnkPurchaseOrder);			
		wh.waitForPageLoaded();
		wh.waitForElementPresent(inputPoOrder);
		wh.sendKeys(inputPoOrder, PurchaseOrder);
		wh.clickElement(btnApply);		
		wh.waitForPageLoaded();
		wh.waitForElementPresent(chckBoxCheckIn);		
		wh.clickElement(chckBoxCheckIn);
		wh.waitForPageLoaded();
		wh.waitForElementPresent(btnView);		
		wh.clickElement(btnView);
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkLines);		
		wh.clickElement(lnkLines);
		wh.waitForPageLoaded();		
		wh.waitForElementPresent(WebElemntSKU);
		String SKUTbltxt = wh.getText(WebElemntSKU);
		String StatusTbltxt = wh.getText(WebElemntStatus);
		String RecTbltxt = wh.getText(WebElemntReceived_Qty);
		String RemTbltxt = wh.getText(WebElemntRemaining_Qty);
		String SKUTbltxt1 = wh.getText(WebElemntSKU1);
		String StatusTbltxt1 = wh.getText(WebElemntStatus1);
		String RecTbltxt1 = wh.getText(WebElemntReceived_Qty1);
		String RemTbltxt1 = wh.getText(WebElemntRemaining_Qty1);
		
		if(SKU.equals(SKUTbltxt) & Status.equals(StatusTbltxt) & Received_Qty.equals(RecTbltxt)& Remaining_Qty.equals(RemTbltxt)){	
			 report.addReportStep("SKU no. for Item is:,Status for Item1"+SKUTbltxt+StatusTbltxt ,
						"Received Qty for Item1 is:,Remaining Qty for Item1 is:"+RecTbltxt+RemTbltxt, 
						StepResult.PASS);
       	   }
       	   else{
       		report.addReportStep("SKU no. for Item is:,Status for Item1"+SKUTbltxt+StatusTbltxt ,
					"Received Qty for Item1 is:,Remaining Qty for Item1 is:"+RecTbltxt+RemTbltxt, 
					StepResult.FAIL);
       	}	
		
		if(SKU2.equals(SKUTbltxt1) & Status2.equals(StatusTbltxt1) & Received_Qty2.equals(RecTbltxt1)& Remaining_Qty2.equals(RemTbltxt1)){	
			 report.addReportStep("SKU no. for Item is:,Status for Item1"+SKUTbltxt1+StatusTbltxt1,
						"Received Qty for Item1 is:,Remaining Qty for Item1 is:"+RecTbltxt1+RemTbltxt1, 
						StepResult.PASS);
      	   }
      	   else{
      		report.addReportStep("SKU no. for Item is:,Status for Item1"+SKUTbltxt1+StatusTbltxt1,
					"Received Qty for Item1 is:,Remaining Qty for Item1 is:"+RecTbltxt1+RemTbltxt1, 
					StepResult.FAIL);
      	}	
	}
	
	public  void DF_Purchase_Order_UI_Activitytracking(String Status,String ItemBar,String Received_Qty,String Remaining_Qty,String gPONumber) throws Exception {	
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkMenu);
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkPurchaseOrder);
		wh.clickElement(lnkPurchaseOrder);			
		wh.waitForPageLoaded();
		wh.waitForElementPresent(inputPoOrder);
		wh.sendKeys(inputPoOrder, gPONumber);
		wh.clickElement(btnApply);		
		wh.waitForPageLoaded();
		wh.waitForElementPresent(chckBoxCheckIn);		
		wh.clickElement(chckBoxCheckIn);
		wh.waitForPageLoaded();
		wh.waitForElementPresent(btnView);		
		wh.clickElement(btnView);
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkLines);		
		wh.clickElement(lnkLines);
		wh.waitForPageLoaded();			
		wh.waitForElementPresent(webtablePOOrder);					
		int TblRows=wh.getElementsCount(webtablePOOrder);                       
        for(int rnum=1;rnum<=TblRows;rnum++){
        	final By webtableItem=By.xpath("//table[@id='dataForm:lv1:dataTable_body']/tbody/tr["+rnum+"]/td[4]");   
        	final By webtableStatus=By.xpath("//table[@id='dataForm:lv1:dataTable_body']/tbody/tr["+rnum+"]/td[8]");   
        	final By webtableReceived=By.xpath("//table[@id='dataForm:lv1:dataTable_body']/tbody/tr["+rnum+"]/td[16]");
        	final By webtableRemaining=By.xpath("//table[@id='dataForm:lv1:dataTable_body']/tbody/tr["+rnum+"]/td[17]");
        	
        	List<WebElement> Itmrowcells=wh.getElements(webtableItem);    
        	List<WebElement> Statusrowcells=wh.getElements(webtableStatus);  
        	List<WebElement> Receivedrowcells=wh.getElements(webtableReceived);  
        	List<WebElement> Remaningrowcells=wh.getElements(webtableRemaining);          	
        	int blnFlag = 0;
			for(int cNum=0;cNum<Itmrowcells.size();cNum++){				
				 if(Itmrowcells.get(cNum).getText().equals(ItemBar) && Statusrowcells.get(cNum).getText().equals(Status) && Receivedrowcells.get(cNum).getText().equals(Received_Qty)&& Remaningrowcells.get(cNum).getText().equals(Remaining_Qty)){ 	        		  		    			  
					 report.addReportStep("SKU no. for Item is:,Status for Item1"+ItemBar+Status ,
								"Received Qty for Item1 is:,Remaining Qty for Item1 is:"+Received_Qty+Remaining_Qty, 
								StepResult.PASS);
    			  blnFlag=1;
    			  break;
	         	   }
	         	   else{
	         		  report.addReportStep("SKU no. for Item is:,Status for Item1"+ItemBar+Status ,
								"Received Qty for Item1 is:,Remaining Qty for Item1 is:"+Received_Qty+Remaining_Qty, 
								StepResult.FAIL);
	         		  blnFlag=1;
	    			  break;
				 }	        		        		  
              }
				if(blnFlag==1){						 
	           	 break;
	             }        		
        	 }         	
	}	
}
