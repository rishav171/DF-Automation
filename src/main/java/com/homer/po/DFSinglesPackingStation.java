package com.homer.po;

import org.openqa.selenium.By;

import com.homer.dao.InstanceContainer;
import com.homer.enums.EnumClass.StepResult;

public class DFSinglesPackingStation  extends PageBase < DFSinglesPackingStation >  {
	
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
    
    
    static final By webtableDistOrder = By.xpath("//table[@id='dataForm:DODetailsLpnList_lv:LPNListTable_body']/tbody/tr");

    String WaveNumber, TaskMessage;
    String TaskID;
    public static boolean blnflag = false;



	public DFSinglesPackingStation(InstanceContainer ic) {
		super(ic);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Method to fill payment page details
	 * @return
	 * @throws Exception
	 */
	public void SinglesPacking_Stat(String PackStationNum, String ToteNbr, String ItemNbr) throws Throwable {
        wh.waitForPageLoaded();
        wh.waitForElementPresent(lnkMenuOption);
        expectedResult = wh.isElementPresent(lnkMenuOption);
        if (expectedResult) {
            wh.clickElement(lnkMenuOption);
        }

        wh.waitForPageLoaded();
        expectedResult = wh.isElementPresent(lnkSinglePackStation);
        if (expectedResult) {
            wh.clickElement(lnkSinglePackStation);
        }
        wh.waitForPageLoaded();
        expectedResult = wh.isElementPresent(inputPackStatnNbr);
        if (expectedResult) {
            wh.sendKeys(inputPackStatnNbr, PackStationNum);
            wh.waitForPageLoaded();
            wh.moveKeyBoardEnter();
        }
        wh.waitForPageLoaded();
        expectedResult = wh.isElementPresent(btnsubmitButton);
        if (expectedResult) {
            wh.clickElement(btnsubmitButton);
        }
        wh.waitForPageLoaded();
        expectedResult = wh.isElementPresent(inputToteNbr);
        if (expectedResult) {
            wh.sendKeys(inputToteNbr, ToteNbr);
            wh.waitForPageLoaded();
            wh.moveKeyBoardEnter();
        }
        wh.waitForPageLoaded();
        expectedResult = wh.isElementPresent(inputItemNbr);
        if (expectedResult) {
            wh.sendKeys(inputItemNbr, ItemNbr);
            wh.waitForPageLoaded();
            wh.moveKeyBoardEnter();
        }
        wh.waitForPageLoaded();
        expectedResult = wh.isElementPresent(btnShippingLabel);
        if (expectedResult) {
            wh.clickElement(btnShippingLabel);
            wh.waitForPageLoaded();
        }
   }

}
