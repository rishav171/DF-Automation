package com.homer.po;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.homer.dao.InstanceContainer;

public class DFFacilitiesPage extends PageBase<DFFacilitiesPage> {
	
	static final By lnkMenu  =By.xpath("//span[contains(text(),'enu')]");
	static final By lnkConfiguration =By.linkText("Configuration");
	static final By lnkFacilities =By.linkText("Facilities");
	static final By inputFacilityId = By.id("dataForm:LocationList_lv:LocationList_filterId:field5value1");
	static final By btnApply  =By.id("dataForm:LocationList_lv:LocationList_filterId:LocationList_filterIdapply");
	static final By chckBoxFacility = By.id("checkAll_c0_dataForm:LocationList_lv:dataTable");	
	static final By btnView  =By.id("dataForm:FacilityList_Detailbutton");
	static final By lnkLocation_Dock = By.id("Location_Dock_lnk");
	static final By btnNext  =By.id("dataForm:locationDock_listView:dataTable_locationDock:pager:next");
	static final By webtableFacrows=By.xpath("//table[@id='dataForm:locationDock_listView:dataTable_locationDock_body']/tbody/tr");
	static final By webtableFaccols=By.xpath("//table[@id='dataForm:locationDock_listView:dataTable_locationDock_body']/tbody/tr[1]/td");
	static final By TAB_Dockdoor = By.id("TAB_Dock_Door_lnk");
	
	static final By webtableDdoorsrows=By.xpath("//table[@id='dataForm:dfltdockdoorsListDataTableId_body']/tbody/tr");
	
	

	public DFFacilitiesPage(InstanceContainer ic) {
		super(ic);
		// TODO Auto-generated constructor stub
	}

	
	public  void GetDockDoor(String data) throws Exception {	
		int Cnt = 0;
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkMenu);
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkConfiguration);
		wh.clickElement(lnkConfiguration);	
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkFacilities);
		wh.clickElement(lnkFacilities);
		wh.waitForPageLoaded();
		wh.waitForElementPresent(inputFacilityId);
		wh.sendKeys(inputFacilityId,"facility");
		wh.waitForPageLoaded();
		wh.waitForElementPresent(btnApply);		
		wh.clickElement(btnApply);
		wh.waitForPageLoaded();
		wh.waitForElementPresent(chckBoxFacility);		
		wh.clickElement(chckBoxFacility);
		wh.waitForPageLoaded();
		wh.waitForElementPresent(btnView);		
		wh.clickElement(btnView);
		wh.waitForPageLoaded();
		wh.waitForElementPresent(lnkLocation_Dock);		
		wh.clickElement(lnkLocation_Dock);
		wh.waitForPageLoaded();
		wh.waitForElementPresent(btnNext);		
		wh.clickElement(btnNext);
		wh.waitForPageLoaded();	
		wh.waitForElementPresent(webtableFacrows);					
		int rows=wh.getElementsCount(webtableFacrows); 
		int cols=wh.getElementsCount(webtableFaccols); 
		for(int rNum=1;rNum<=rows;rNum++ ){
			final By webtableFacilityDockdoorRow=By.xpath("//table[@id='dataForm:lv1:dataTable_body']/tbody/tr["+rNum+"]/td[2]");
			List<WebElement> rowCells=wh.getElements(webtableFacilityDockdoorRow);
			for(int cNum=0;cNum<rowCells.size();cNum++){
				String text =rowCells.get(cNum).getText();
				System.out.println(text+"-----------");
				if(text.equals(data)){
					Cnt=rNum;
					break;
				}
			}
			if(Cnt>0){
				break;
			}
		}
		if(Cnt!=0){			
			final By webtableFacCheckBox=By.id("checkAll_c"+Cnt+"_dataForm:locationDock_listView:dataTable_locationDock");
			wh.clickElement(webtableFacCheckBox);
		}
		wh.waitForPageLoaded();
		wh.waitForElementPresent(TAB_Dockdoor);		
		wh.clickElement(TAB_Dockdoor);
		int rowsInc=wh.getElementsCount(webtableDdoorsrows); 
    }
}

