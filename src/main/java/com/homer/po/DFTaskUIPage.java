package com.homer.po;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.homer.dao.InstanceContainer;
import com.homer.enums.EnumClass.StepResult;

public class DFTaskUIPage  extends PageBase<DFTaskUIPage> {
	static final By lnkMenu  =By.xpath("//span[contains(text(),'enu')]");
	static final By lnkTasks =By.linkText("Tasks");
	static final By elemtTaskType  =By.xpath("//DIV[@id='filterId_quickFilterDiv']/DIV[3]/DIV[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/DIV[1]");	
	static final By listTaskType  =By.xpath("//DIV[7]/DIV[2]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/DIV[1]/OL[1]/LI[6]");
	static final By btnOK  =By.xpath("//DIV[7]/DIV[2]/TABLE[1]/TBODY[1]/TR[2]/TD[1]/DIV[1]/BUTTON[1]");
	static final By edtItem  =By.id("dataForm:lview:filterId:itemLookUpId");
	static final By ItemArrow  =By.id("filterId_fltrExpCol");
	static final By lstfrom  =By.xpath("//TABLE[@id='filterId_quckFltrTable']/TBODY[1]/TR[5]/TD[1]/DIV[1]/DIV[2]/DIV[1]/SPAN[2]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/DIV[1]/TABLE[1]/TBODY[1]/TR[1]/TD[2]/DIV[1]/IMG[1]");
	static final By elemfrom  =By.id("//a[contains(text(),'Today')]");
	static final By tofrom  =By.xpath("//TABLE[@id='filterId_quckFltrTable']/TBODY[1]/TR[5]/TD[1]/DIV[1]/DIV[2]/DIV[1]/SPAN[4]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/DIV[1]/TABLE[1]/TBODY[1]/TR[1]/TD[2]/DIV[1]/IMG[1]");
	static final By elemto =By.id("//a[contains(text(),'Today')]");
	static final By btnApply =By.id("dataForm:lview:filterId:filterIdapply");
	static final By webtableTask=By.xpath("//table[@id='dataForm:lview:dataTable_body']/tbody/tr");	
	
	
	//"//a/u[contains(text(),'Re-Submit')]"
	
	
	public DFTaskUIPage(InstanceContainer ic) {
		super(ic);
		// TODO Auto-generated constructor stub
	}

public  void Task_UI(String ItemBar,String HeaderStatus,String tType) throws Exception {	
	        int blnFlag = 0;
			wh.waitForPageLoaded();
			wh.waitForElementPresent(lnkMenu);
			wh.waitForPageLoaded();
			wh.waitForElementPresent(lnkTasks);
			wh.clickElement(lnkTasks);	
			wh.waitForPageLoaded();
			wh.waitForElementPresent(elemtTaskType);
			wh.clickElement(elemtTaskType);	
			wh.waitForPageLoaded();
			wh.waitForElementPresent(listTaskType);
			wh.clickElement(listTaskType);	
			wh.waitForPageLoaded();
			wh.waitForElementPresent(edtItem);
			wh.sendKeys(edtItem, ItemBar);
			wh.clickElement(ItemArrow);	
			wh.waitForPageLoaded();
			wh.waitForElementPresent(lstfrom);
			wh.clickElement(lstfrom);
			wh.waitForPageLoaded();
			wh.waitForElementPresent(elemfrom);
			wh.clickElement(elemfrom);
			wh.waitForPageLoaded();
			wh.waitForElementPresent(tofrom);
			wh.clickElement(tofrom);
			wh.waitForPageLoaded();
			wh.waitForElementPresent(elemto);
			wh.clickElement(elemto);
			wh.waitForPageLoaded();
			wh.waitForElementPresent(btnApply);
			wh.clickElement(btnApply);
			Thread.sleep(8000);
						
			int rows=wh.getElementsCount(webtableTask);                       
	        for(int rnum=1;rnum<=rows;rnum++){
	        	final By webtableHeaderStatus=By.xpath("//table[@id='dataForm:lview:dataTable_body']/tbody/tr["+rnum+"]/td[3]");
	        	final By webtableTaskType=By.xpath("//table[@id='dataForm:lview:dataTable_body']/tbody/tr["+rnum+"]/td[4]");
	        	final By webtableItemNumber=By.xpath("//table[@id='dataForm:lview:dataTable_body']/tbody/tr["+rnum+"]/td[8]");  
	        	
	        	List<WebElement> StrHdrStatus=wh.getElements(webtableHeaderStatus); 
	        	List<WebElement> StrTasktype=wh.getElements(webtableTaskType); 
	        	List<WebElement> StrItemNumb=wh.getElements(webtableItemNumber);        
	        	         	         	        	
				for(int cNum=0;cNum<StrHdrStatus.size();cNum++){												
					 if(StrHdrStatus.get(cNum).getText().equals(HeaderStatus) & StrTasktype.get(cNum).getText().equals(tType) & StrItemNumb.get(cNum).getText().equals(ItemBar)){ 	        		  		    			  		    			 
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
				report.addReportStep("Task Page is ,HeaderStatus status is:"+HeaderStatus ,
							"Task Page is ,Trans Type status is:"+tType+"Task Page is , task Item is:"+ItemBar, 
							StepResult.PASS);	    			  	    			  
	     	   }
	     	   else{
	     		  report.addReportStep("Task Page is ,HeaderStatus status is:"+HeaderStatus ,
							"Task Page is ,Trans Type status is:"+tType+"Task Page is , task Item is:"+ItemBar, 
							StepResult.FAIL);				  		    		
	         }
    }	
}
