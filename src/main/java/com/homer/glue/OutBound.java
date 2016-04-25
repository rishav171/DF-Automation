package com.homer.glue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import com.homer.dao.And;
import com.homer.dao.DataClass;
import com.homer.dao.DataColumn;
import com.homer.dao.Given;
import com.homer.dao.Then;
import com.homer.dao.When;
import com.homer.po.DFCheckInPage;


public class OutBound extends BaseStepDefn{
	String[] iLPNs;
	String DistrOrder;
	String WaveNumber,Pick_Location,Bar_Code,ReserveBCode,TaskNumber,ToteNumber,ExpectedResult;
	public OutBound(DataClass data) {
		super(data);		
	}
	
	
	
	@Given("^User Opens WMS application$")
	public void user_Opens_WMS_application() throws Throwable {
		
		loginPage.open();
		loginPage.SigninPage();	
	}
	
	@When("^Update the DF Order XML File$")
	public void update_the_DF_Order_XML_File() throws Throwable { 
	  
		DistrOrder=PostMessage.DF_XmlUpdate("DistributionOrderId","ItemName",dataTable.getData(DataColumn.Item),"C:\\WMS\\Homer_Release3.2\\Homer\\TestData\\DistOrder_SinglePacking.xml");
	}

	@Then("^Post the XML File$")
	public void post_the_XML_File() throws Throwable { 
	  
		PostMessage.DF_Upload_File("C:\\WMS\\Homer_Release3.2\\Homer\\TestData\\DistOrder_SinglePacking.xml");
	  
	}

	@Then("^Waving the Distribution Order$")
	public void waving_the_Distribution_Order() throws Throwable { 

		WaveNumber=DistributionOrder.Wave_Verification(DistrOrder,dataTable.getData(DataColumn.WavenumberStatus));
	}

	@Then("^Release the Task$")
	public void release_the_Task() throws Throwable { 
		TaskNumber=DistributionOrder.Release_Task();
		System.out.println(TaskNumber);
	  
	}

	@Then("^Get BarCode from Location$")
	public void get_BarCode_from_Location() throws Throwable { 
		Pick_Location=AllocationPage.AllocationDetails(WaveNumber);
		System.out.println(Pick_Location);
	  
	}
	
	@Then("^Picking the BarCode from PickLocation$")
	public void picking_the_BarCode_from_PickLocation() throws Throwable { 
		Bar_Code=PickLocationPage.DF_PickUpLocation(Pick_Location);	  
		System.out.println(Bar_Code);
	}
	
	@Then("^Picking the BarCode from ReserveLocation$")
	public void picking_the_BarCode_from_ReserveLocation() throws Throwable { 
		ReserveBCode=ReserveLocations.DF_ReserveLocation("SNG-LTL");
	  
	}
	
	@Then("^Users click on SignOut Link$")
	public void users_click_on_SignOut_Link() throws Throwable { 
	 
		loginPage.SignOutLink();
	}


	@Then("^Performing the Picking in the RF Screens$")
	public void performing_the_Picking_in_the_RF_Screens() throws Throwable { 
		Random rand = new Random();
		int trailer = rand.nextInt(1000);
		String strtrailer = Integer.toString(trailer);
        ToteNumber="Tote"+strtrailer;
		RF_PuttyScreen.RF_putty(dataTable.getData(DataColumn.TestCaseName),TaskNumber, Bar_Code,dataTable.getData(DataColumn.Item),ToteNumber,ReserveBCode,ExpectedResult);
		//RF_PuttyScreen.RF_putty(dataTable.getData(DataColumn.TestCaseName),TaskNumber,Bar_Code,"708277","TRENU31",ReserveBCode);
	  
	}
	
	@When("^User Clicks on SinglesPackingStation Link$")
	public void user_Clicks_on_SinglesPackingStation_Link() throws Throwable { 
		SinglesPackingStation.Clicks_on_SinglesPackingStation_Link(dataTable.getData(DataColumn.PackStationNum));	  
	}

	@Then("^Submit the Print Shipping Label$")
	public void submit_the_Print_Shipping_Label() throws Throwable { 
	 SinglesPackingStation.SinglesPacking_Stat(dataTable.getData(DataColumn.ToteNbr), dataTable.getData(DataColumn.OBItemNbr));
	  
	}

	@And("^Checks the LPN Facility Status$")
	public void checks_the_LPN_Facility_Status() throws Throwable { 
	 DistributionOrder.SinglesPacking_DistributionOrder(dataTable.getData(DataColumn.DistrOrder), dataTable.getData(DataColumn.LPNFacility_Status));
	}

	
	@When("^Get iLpns from DistributionOrder$")
	public void get_iLpns_from_DistributionOrder() throws Throwable { 	 		
		iLPNs=DistributionOrder.iLpns_DistributionOrder(dataTable.getData(DataColumn.DistrOrder));				
		System.out.println(Arrays.toString(iLPNs));
	}	

	@When("^User Clicks on MULTIPackingStation Link$")
	public void user_Clicks_on_MULTIPackingStation_Link() throws Throwable { 
		MULTISPackingStation.Clicks_on_MULTIPackingStation_Link(dataTable.getData(DataColumn.PackStationNum));
	  
	}

	@Then("^Submit the MultiPrint Shipping Label$")
	public void submit_the_MultiPrint_Shipping_Label() throws Throwable { 
		
		MULTISPackingStation.MULTISPacking_Station(iLPNs);
	  
	}

	@And("^Checks the MultiLPN Facility Status$")
	public void checks_the_MultiLPN_Facility_Status() throws Throwable { 
		DistributionOrder.MULTISPacking_DistributionOrder(dataTable.getData(DataColumn.DistrOrder), dataTable.getData(DataColumn.LPNFacility_Status));
	}

	@When("^User Clicks on MobilePackingStation Link$")
	public void user_Clicks_on_MobilePackingStation_Link() throws Throwable { 
		MobilePackingStation.Clicks_on_MpbilePackingStation_Link(dataTable.getData(DataColumn.PackStationNum));
	  
	}

	@Then("^Submit the MobilePrint Shipping Label$")
	public void submit_the_MobilePrint_Shipping_Label() throws Throwable { 
		
		MobilePackingStation.MobilePacking_Station(iLPNs);
	  
	}

	@And("^Checks the MobileLPN Facility Status$")
	public void checks_the_MobileLPN_Facility_Status() throws Throwable { 
		DistributionOrder.MULTISPacking_DistributionOrder(dataTable.getData(DataColumn.DistrOrder), dataTable.getData(DataColumn.LPNFacility_Status));
	  
	}
	
	@When("^User Clicks on HospitalPackingStation Link$")
	public void user_Clicks_on_HospitalPackingStation_Link() throws Throwable { 
		HOSPITALPackingStation.Clicks_on_HospitalPackingStation_Link(dataTable.getData(DataColumn.PackStationNum));
	  
	}

	@Then("^Submit the HospitalPrint Shipping Label$")
	public void submit_the_HospitalPrint_Shipping_Label() throws Throwable { 
		
		HOSPITALPackingStation.HospitalPack_Station(iLPNs);
	}

	@And("^Checks the HospitalLPN Facility Status$")
	public void checks_the_HospitalLPN_Facility_Status() throws Throwable { 
		
		oLPNsPage.HospitalPacking_oLPNs(iLPNs, dataTable.getData(DataColumn.LPNFacility_Status));
	  
	}
	
	

}
