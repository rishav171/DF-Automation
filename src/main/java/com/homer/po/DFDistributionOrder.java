package com.homer.po;

import com.homer.dao.InstanceContainer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.homer.dao.InstanceContainer;
import com.homer.enums.EnumClass.StepResult;

public class DFDistributionOrder extends PageBase < DFDistributionOrder > {

    static final By lnkMenuOption = By.id("phMenu");
    static final By lnkMenu = By.xpath("//span[contains(text(),'enu')]");
    static final By lnkDistribution = By.linkText("Distribution Orders");
    static final By lnkDistributionTab = By.linkText("Distribution");
    static final By inputDistributionOrderID = By.id("dataForm:DOList_entityListView:DistributionOrderlist1:field6value1");
    static final By btnApply = By.id("dataForm:DOList_entityListView:DistributionOrderlist1:DistributionOrderlist1apply");
    static final By chckBoxDistOrder = By.id("checkAll_c0_dataForm:DOList_entityListView:DOList_MainListTable");
    static final By btnMore = By.id("j_id142moreButton");
    static final By btnWave = By.id("DO_List_Wave_Order_button");
    static final By chckBoxWaveParam = By.id("checkAll_c4_dataForm:listView:dataTable");
    static final By btnRunWave = By.id("rmButton_1RunWave1_100679000");
    static final By btnSubmit = By.id("rmButton_1SubmitWave1_100215000");
    static final By lblWaveNumber = By.id("dataForm:AwvNbrRun");
    static final By btnRefresh = By.id("dataForm:listView:dataTable:dataTable_rfsh_but");
    static final By tblWaveStatus = By.id("dataForm:listView:dataTable:0:c0012");
    static final By chckBoxWave = By.id("checkAll_c0_dataForm:listView:dataTable");
    static final By btnMore1 = By.id("rmbuttons_1moreButton");
    static final By lnkTask = By.id("rmButton_2Tasks1_100668000");
    static final By tblTaskIDEle = By.id("dataForm:lview:dataTable:0:taskIdVal");
    static final By chckBoxTaskID = By.id("checkAll_c0_dataForm:lview:dataTable");
    static final By btnReleaseTask = By.id("rmButton_1ReleaseTask1_167271344");
    static final By lblMessage = By.id("er_d1_bid");
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
    
    

    String Wave_Number,TaskMessage;
    
    String TaskID;
    public static boolean blnflag = false;



    public DFDistributionOrder(InstanceContainer ic) {
        super(ic);
        // TODO Auto-generated constructor stub
    }
    
    
    
    /**
	 * Method to fill payment page details
	 * @return
	 * @throws Exception
	 */
 
    
    public String[] iLpns_DistributionOrder(String DistrOrder) throws Throwable {    	
        wh.waitForPageLoaded();
        wh.waitForElementPresent(lnkMenuOption);
        expectedResult = wh.isElementPresent(lnkMenuOption);
        if (expectedResult) {
            wh.clickElement(lnkMenuOption);
        }
        wh.waitForPageLoaded();
        expectedResult = wh.isElementPresent(lnkDistribution);
        if (expectedResult) {
            wh.clickElement(lnkDistribution);
        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(inputDistributionOrderID);
        expectedResult = wh.isElementPresent(inputDistributionOrderID);
        if (expectedResult) {
            wh.sendKeys(inputDistributionOrderID, DistrOrder);
            wh.clickElement(btnApply);
            wh.waitForPageLoaded();
            wh.waitForElementPresent(chckBoxDistOrder);
            wh.clickElement(chckBoxDistOrder);
            wh.waitForPageLoaded();
            wh.clickElement(btnView);
            wh.waitForPageLoaded();
        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(lnkLPNs);
        expectedResult = wh.isElementPresent(lnkLPNs);
        if (expectedResult) {
            wh.clickElement(lnkLPNs);
        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(webtableDistOrder);                
        int index=0;
		 int rows=driver.findElements(webtableDistOrder).size();	
		 String[] alternative = new String[rows-1];
		 for(int rNum=1;rNum<=rows-1;rNum++){		   
		   alternative[index]=driver.findElement(By.xpath("//table[@id='dataForm:DODetailsLpnList_lv:LPNListTable_body']/tbody/tr"+"["+rNum+"]/td[2]")).getText();
		   System.out.println("Row is-> "+alternative[index]);
		   index=index+1;
		 }
		return alternative;
    }
    
    /**
	 * Method to fill payment page details
	 * @return
	 * @throws Exception
	 */
    public void SinglesPacking_DistributionOrder(String DistrOrder, String LPNFacility_Status) throws Throwable {
        wh.waitForPageLoaded();
        wh.waitForElementPresent(lnkMenuOption);
        expectedResult = wh.isElementPresent(lnkMenuOption);
        if (expectedResult) {
            wh.clickElement(lnkMenuOption);
        }
        wh.waitForPageLoaded();
        expectedResult = wh.isElementPresent(lnkDistribution);
        if (expectedResult) {
            wh.clickElement(lnkDistribution);
        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(inputDistributionOrderID);
        expectedResult = wh.isElementPresent(inputDistributionOrderID);
        if (expectedResult) {
            wh.sendKeys(inputDistributionOrderID, DistrOrder);
            wh.clickElement(btnApply);
            wh.waitForPageLoaded();
            wh.waitForElementPresent(chckBoxDistOrder);
            wh.clickElement(chckBoxDistOrder);
            wh.waitForPageLoaded();
            wh.clickElement(btnView);
            wh.waitForPageLoaded();
        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(lnkLPNs);
        expectedResult = wh.isElementPresent(lnkLPNs);
        if (expectedResult) {
            wh.clickElement(lnkLPNs);
        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(webtableDistOrder);
        int row = wh.getRowWithCellData(webtableDistOrder, "//table[@id='dataForm:DODetailsLpnList_lv:LPNListTable_body']/tbody/tr", 9, LPNFacility_Status);
        if (row >= 1) {
            report.addReportStep("Distribution Order Page",
                "LPN Facility Status is Dispalyed as Packed for SinglesPacking_Station",
                StepResult.PASS);
        } else {
            report.addReportStep("Distribution Order Page",
                "LPN Facility Status is Not Dispalyed as Packed for SinglesPacking_Station",
                StepResult.FAIL);
        }
    }


    /**
	 * Method to fill payment page details
	 * @return
	 * @throws Exception
	 */
    public void MULTISPacking_DistributionOrder(String DistrOrder, String LPNFacility_Status) throws Throwable {
        wh.waitForPageLoaded();
        wh.waitForElementPresent(lnkMenuOption);
        expectedResult = wh.isElementPresent(lnkMenuOption);
        if (expectedResult) {
            wh.clickElement(lnkMenuOption);
        }
        wh.waitForPageLoaded();
        expectedResult = wh.isElementPresent(lnkDistribution);
        if (expectedResult) {
            wh.clickElement(lnkDistribution);
        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(inputDistributionOrderID);
        expectedResult = wh.isElementPresent(inputDistributionOrderID);
        if (expectedResult) {
            wh.sendKeys(inputDistributionOrderID, DistrOrder);
            wh.clickElement(btnApply);
            wh.waitForPageLoaded();
            wh.waitForElementPresent(chckBoxDistOrder);
            wh.clickElement(chckBoxDistOrder);
            wh.waitForPageLoaded();
            wh.clickElement(btnView);
            wh.waitForPageLoaded();
        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(lnkLPNs);
        expectedResult = wh.isElementPresent(lnkLPNs);
        if (expectedResult) {
            wh.clickElement(lnkLPNs);
        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(webtableDistOrder);
        int row = wh.verifyallRowsWithCellData(webtableDistOrder, "//table[@id='dataForm:DODetailsLpnList_lv:LPNListTable_body']/tbody/tr", 9, LPNFacility_Status);
        System.out.println(row);
        if (row != 1) {
            report.addReportStep("Distribution Order Page",
                "LPN Facility Status is Dispalyed as Packed for MULTISPacking_Station",
                StepResult.PASS);
        } else {
            report.addReportStep("Distribution Order Page",
                "LPN Facility Status is not Dispalyed as Packed for MULTISPacking_Station",
                StepResult.FAIL);
        }
    }

    /**
	 * Method to fill payment page details
	 * @return
	 * @throws Exception
	 */
    public void MobilePacking_DistributionOrder(String DistrOrder, String LPNFacility_Status) throws Throwable {
        wh.waitForPageLoaded();
        wh.waitForElementPresent(lnkMenuOption);
        expectedResult = wh.isElementPresent(lnkMenuOption);
        if (expectedResult) {
            wh.clickElement(lnkMenuOption);
        }
        wh.waitForPageLoaded();
        expectedResult = wh.isElementPresent(lnkDistribution);
        if (expectedResult) {
            wh.clickElement(lnkDistribution);
        }

        wh.waitForPageLoaded();
        wh.waitForElementPresent(inputDistributionOrderID);
        expectedResult = wh.isElementPresent(inputDistributionOrderID);
        if (expectedResult) {
            wh.sendKeys(inputDistributionOrderID, DistrOrder);
            wh.clickElement(btnApply);
            wh.waitForPageLoaded();
            wh.waitForElementPresent(chckBoxDistOrder);
            wh.clickElement(chckBoxDistOrder);
            wh.waitForPageLoaded();
            wh.clickElement(btnView);
            wh.waitForPageLoaded();
        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(lnkLPNs);
        expectedResult = wh.isElementPresent(lnkLPNs);
        if (expectedResult) {
            wh.clickElement(lnkLPNs);
        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(webtableDistOrder);
        int row = wh.verifyallRowsWithCellData(webtableDistOrder, "//table[@id='dataForm:DODetailsLpnList_lv:LPNListTable_body']/tbody/tr", 9, LPNFacility_Status);
        System.out.println(row);
        if (row != 1) {
            report.addReportStep("Distribution Order Page",
                "LPN Facility Status is Dispalyed as Packed for MobilePacking_Station",
                StepResult.PASS);
        } else {
            report.addReportStep("Distribution Order Page",
                "LPN Facility Status is not Dispalyed as Packed for MobilePacking_Station",
                StepResult.FAIL);
        }

    }
    
    /**
	 * Method to fill payment page details
	 * @return
	 * @throws Exception
	 */
    public String Wave_Verification(String DistrOrder, String WaveStatusData) throws Throwable {
        wh.waitForPageLoaded();
        wh.waitForElementPresent(lnkMenu);
        expectedResult = wh.isElementPresent(lnkMenu);
        if (expectedResult) {
            wh.clickElement(lnkMenu);

        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(lnkDistributionTab);
        expectedResult = wh.isElementPresent(lnkDistributionTab);
        if (expectedResult) {
            wh.clickElement(lnkDistributionTab);
        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(lnkDistribution);
        expectedResult = wh.isElementPresent(lnkDistribution);
        if (expectedResult) {
            wh.clickElement(lnkDistribution);
        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(inputDistributionOrderID);
        expectedResult = wh.isElementPresent(inputDistributionOrderID);
        if (expectedResult) {
            wh.sendKeys(inputDistributionOrderID, DistrOrder);
        }
        wh.clickElement(btnApply);
        wh.waitForPageLoaded();
        wh.waitForElementPresent(chckBoxDistOrder);
        expectedResult = wh.isElementPresent(chckBoxDistOrder);
        if (expectedResult) {
            wh.clickElement(chckBoxDistOrder);
        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(btnMore);
        expectedResult = wh.isElementPresent(btnMore);
        if (expectedResult) {
            report.addReportStep("Distribution Page",
                "Enter Distribution order",
                StepResult.DONE);
            wh.clickElement(btnMore);
        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(btnWave);
        expectedResult = wh.isElementPresent(btnWave);
        if (expectedResult) {
            wh.clickElement(btnWave);
        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(chckBoxWaveParam);
        expectedResult = wh.isElementPresent(chckBoxWaveParam);
        if (expectedResult) {
            wh.clickElement(chckBoxWaveParam);
        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(btnRunWave);
        expectedResult = wh.isElementPresent(btnRunWave);
        if (expectedResult) {
            report.addReportStep("Waving Page",
                "Run Wave for the Distribution order",
                StepResult.DONE);
            wh.clickElement(btnRunWave);
        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(btnSubmit);
        expectedResult = wh.isElementPresent(btnSubmit);
        if (expectedResult) {
            wh.clickElement(btnSubmit);
        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(lblWaveNumber);
        expectedResult = wh.isElementPresent(lblWaveNumber);
        if (expectedResult) {
            Wave_Number = wh.getText(lblWaveNumber);
            wh.clickElement(lblWaveNumber);
            wh.waitForPageLoaded();
            boolean done = true;
            while (done) {
                wh.clickElement(btnRefresh);
                wh.waitForPageLoaded();
                String WaveStatus = wh.getText(tblWaveStatus);
                if (WaveStatusData.equals(WaveStatus)) {
                    done = true;
                    break;
                } else {
                    Thread.sleep(5000);
                }
            }

            wh.waitForPageLoaded();
            wh.waitForElementPresent(chckBoxWave);
            expectedResult = wh.isElementPresent(chckBoxWave);
            if (expectedResult) {
                wh.clickElement(chckBoxWave);
            }
            wh.waitForPageLoaded();
        }
        return Wave_Number;
    }

    /**
	 * Method to fill payment page details
	 * @return
	 * @throws Exception
	 */
    public String Release_Task() throws Throwable {
        wh.waitForElementPresent(btnMore1);
        expectedResult = wh.isElementPresent(btnMore1);
        if (expectedResult) {
            wh.clickElement(btnMore1);
        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(lnkTask);
        expectedResult = wh.isElementPresent(lnkTask);
        if (expectedResult) {
            wh.clickElement(lnkTask);
        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(tblTaskIDEle);
        expectedResult = wh.isElementPresent(tblTaskIDEle);
        if (expectedResult) {
            TaskID = wh.getText(tblTaskIDEle);
        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(chckBoxTaskID);
        expectedResult = wh.isElementPresent(chckBoxTaskID);
        if (expectedResult) {
            wh.clickElement(chckBoxTaskID);
        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(btnReleaseTask);
        expectedResult = wh.isElementPresent(btnReleaseTask);
        if (expectedResult) {
            wh.clickElement1(btnReleaseTask);
            wh.isAlertPresent();
            wh.handleAlert();
        }
        wh.waitForPageLoaded();
        wh.waitForElementPresent(lblMessage);
        expectedResult = wh.isElementPresent(lblMessage);
        if (expectedResult) {
            TaskMessage = wh.getText(lblMessage);
            System.out.println(TaskMessage);
            if (TaskMessage.contains("Selected Tasks were successfully released")) {
                report.addReportStep("Task Page",
                    "Selected Tasks were Successfully released' Message should be Dispalyed successfully",
                    StepResult.PASS);
            } else {
                report.addReportStep("Task Page",
                    "Selected Tasks were Successfully released' Message is not Dispalyed successfully",
                    StepResult.FAIL);
            }
        } else {
            report.addReportStep("Task Page",
                "A confirmation dialogue Box with 'Yes' and 'No' Buttons",
                StepResult.FAIL);
        }
        return TaskID;
    }
}