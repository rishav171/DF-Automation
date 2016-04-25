package com.homer.glue;

import org.openqa.selenium.WebDriver;

import com.homer.dao.CommonData;
import com.homer.dao.DataClass;
import com.homer.dao.InstanceContainer;
import com.homer.helper.DataTable;
import com.homer.po.DFActivityTrackingPage;
import com.homer.po.DFAllocationPage;
import com.homer.po.DFAsnVerification;
import com.homer.po.DFHOSPITALPackingStation;
import com.homer.po.DFMULTISPackingStation;
import com.homer.po.DFMobilePackingStation;
import com.homer.po.DFPickLocation;
import com.homer.po.DFPixTransactionsPage;
import com.homer.po.DFPurchaseOrderUIPage;
import com.homer.po.DFRF_PuttyScreen;
import com.homer.po.DFReleaseDockDoor;
import com.homer.po.DFReserveLocations;
import com.homer.po.DFSinglesPackingStation;
import com.homer.po.DFiLPNsPage;
import com.homer.po.DFoLPNsPage;
import com.homer.po.HomePage;
import com.homer.po.DFLoginPage;
import com.homer.po.DFAsnCreation;
import com.homer.po.DFCheckInPage;
import com.homer.po.DFAppmntCreationASNShipment;
import com.homer.po.DFDistributionOrder;
import com.homer.po.DFPostMessage;
import com.homer.reports.Report;
import com.homer.resuablecomponents.ReusableComponents;
import com.homer.resuablecomponents.WebDriverHelper;

public class BaseStepDefn {
	
	protected Report report;
	protected DataTable dataTable;
	
	protected WebDriverHelper wh;
	protected DataClass data;
	
	protected WebDriver driver;
	protected ReusableComponents rc;
	protected InstanceContainer ic;
	
	protected DFLoginPage loginPage;
	protected HomePage homePage;
	protected DFAsnCreation AsnCreation;
	protected DFAppmntCreationASNShipment AppointmentCreation;
	protected DFAsnVerification ASNsVerification;
	protected DFReleaseDockDoor ReleaseDockDoor;
	protected DFCheckInPage CheckInPage;
	protected DFiLPNsPage iLPNsPage;
	protected DFPurchaseOrderUIPage PurchaseOrder;
	protected DFPixTransactionsPage PixTransactionsPage;
	protected DFActivityTrackingPage ActivityTrackingPage;
	protected DFDistributionOrder DistributionOrder ;
	protected DFPostMessage PostMessage ;
	protected DFSinglesPackingStation SinglesPackingStation ;
	protected DFMobilePackingStation MobilePackingStation ;
	protected DFMULTISPackingStation MULTISPackingStation ;
	protected DFHOSPITALPackingStation HOSPITALPackingStation ;
	protected DFoLPNsPage oLPNsPage ;
	protected DFAllocationPage AllocationPage;
	protected DFPickLocation PickLocationPage;
	protected DFReserveLocations ReserveLocations;
	protected DFRF_PuttyScreen RF_PuttyScreen;
	
	
	
	
	
	
	CommonData commonData;	
	
	public BaseStepDefn(DataClass data) {
		
		
		this.data = data;
		this.driver = data.driver;
		this.report = data.report;
		this.dataTable = data.dataTable;		
		this.commonData = (CommonData)data.commonData;
		
		wh = new WebDriverHelper(driver, report, dataTable);
		rc = new ReusableComponents(driver, report, wh, dataTable);
		
		ic = new InstanceContainer(driver, report,dataTable, wh, rc,commonData);
		
		homePage   = new HomePage(ic);
		loginPage  = new DFLoginPage(ic);
		AsnCreation= new DFAsnCreation(ic);
		AppointmentCreation=new DFAppmntCreationASNShipment(ic);
		ASNsVerification=new DFAsnVerification(ic);
		ReleaseDockDoor=new DFReleaseDockDoor(ic);
		CheckInPage=new DFCheckInPage(ic);
		iLPNsPage=new DFiLPNsPage(ic);
		PurchaseOrder=new DFPurchaseOrderUIPage(ic);
		PixTransactionsPage=new DFPixTransactionsPage(ic);
		ActivityTrackingPage=new DFActivityTrackingPage(ic);
		DistributionOrder=new DFDistributionOrder(ic);
		PostMessage=new DFPostMessage(ic);
		SinglesPackingStation=new DFSinglesPackingStation(ic);
		MobilePackingStation=new DFMobilePackingStation(ic);
		MULTISPackingStation=new DFMULTISPackingStation(ic);
		HOSPITALPackingStation=new DFHOSPITALPackingStation(ic);
		oLPNsPage=new DFoLPNsPage(ic);
		AllocationPage=new DFAllocationPage(ic);
		PickLocationPage=new DFPickLocation(ic);
		ReserveLocations=new DFReserveLocations(ic);
		RF_PuttyScreen=new DFRF_PuttyScreen(ic);
		 
	}
	
	// Please do not add any step definition implementation methods in this class
}
