package com.homer.glue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.homer.dao.And;
import com.homer.dao.DataClass;
import com.homer.dao.DataColumn;
import com.homer.dao.Given;
import com.homer.dao.Then;
import com.homer.dao.When;
import com.homer.po.DFCheckInPage;


public class InBound extends BaseStepDefn{
	
	public InBound(DataClass data) {
		super(data);		
	}
	
	@Given("^I open the url$")
	public void i_open_the_url() throws Throwable { 
		loginPage.open();
		loginPage.SigninPage();							  
	}

	@When("^Creation of DF ASN$")
	public void creation_of_DF_ASN() throws Throwable { 
		AsnCreation.AsnCreation();
		AsnCreation.DF_Assign_ASN_to_PO_Single_Item(dataTable.getData(DataColumn.PoNumber),dataTable.getData(DataColumn.ItemBar_1));
	  
	}
	
	@And("^Verification of Multiple iLPNs$")
	public void verification_of_Multiple_iLPNs() throws Throwable { 
	 
		iLPNsPage.verification_of_Multiple_iLPNs(dataTable.getData(DataColumn.LPNNumb1),dataTable.getData(DataColumn.iLPNsStatus1),dataTable.getData(DataColumn.CurrentLocation1) ,dataTable.getData(DataColumn.DestinationLocation1),dataTable.getData(DataColumn.PreviousLocation1) ,dataTable.getData(DataColumn.LPNNumb2) ,dataTable.getData(DataColumn.iLPNsStatus2),dataTable.getData(DataColumn.CurrentLocation2),dataTable.getData(DataColumn.DestinationLocation2),dataTable.getData(DataColumn.PreviousLocation2),dataTable.getData(DataColumn.LPNNumb3),dataTable.getData(DataColumn.iLPNsStatus3),dataTable.getData(DataColumn.CurrentLocation3),dataTable.getData(DataColumn.DestinationLocation3),dataTable.getData(DataColumn.PreviousLocation3));
	  
	}
	
	@And("^Verification Checkin Multiple iLPN$")
	public void verification_Checkin_Multiple_iLPN() throws Throwable { 
		iLPNsPage.Multiple_iLPN_Verification_Checkin(dataTable.getData(DataColumn.LPNNumb1),dataTable.getData(DataColumn.iLPNsStatus1),dataTable.getData(DataColumn.CurrentLocation1),dataTable.getData(DataColumn.LPNNumb2) ,dataTable.getData(DataColumn.iLPNsStatus2),dataTable.getData(DataColumn.CurrentLocation2),dataTable.getData(DataColumn.LPNNumb3),dataTable.getData(DataColumn.iLPNsStatus3),dataTable.getData(DataColumn.CurrentLocation3),dataTable.getData(DataColumn.LPNNumb4),dataTable.getData(DataColumn.iLPNsStatus4),dataTable.getData(DataColumn.CurrentLocation4));		
	  
	}
	
	@And("^Verification Checkin Multiple iLPN SLOT$")
	public void verification_Checkin_Multiple_iLPN_SLOT() throws Throwable { 
	 
		iLPNsPage.Multiple_iLPN_SLOT_Verification_Checkin(dataTable.getData(DataColumn.LPNNumb1),dataTable.getData(DataColumn.SlotNumber1), dataTable.getData(DataColumn.LPNNumb2), dataTable.getData(DataColumn.SlotNumber2));
	}
	
	
	@When("^Creation of DF Appointment$")
	public void creation_of_DF_Appointment() throws Throwable { 
		AppointmentCreation.Appointment_Creation();
	  
	}

	@Then("^Open the DF ASN for Verification$")
	public void open_the_DF_ASN_for_Verification() throws Throwable { 
	 
		ASNsVerification.DF_Open_ASN_Verification();
	  
	}

	

	@And("^RF Release DockDoor$")
	public void rF_Release_DockDoor() throws Throwable { 
		ReleaseDockDoor.DF_Open_ASN_Verification(dataTable.getData(DataColumn.DockDoor));
	  
	}

	@And("^DF CheckIn Navigation$")
	public void dF_CheckIn_Navigation() throws Throwable { 
		CheckInPage.DFCheckInNavigation();
	}

	@And("^DF CheckIn Fill Details$")
	public void dF_CheckIn_Fill_Details() throws Throwable { 
	CheckInPage.DF_CheckIn_Fill_Details(dataTable.getCommonData("Fname"),dataTable.getCommonData("Lname"),dataTable.getCommonData("LicenseNumber"),dataTable.getCommonData("Carrier"),dataTable.getCommonData("Statelist"),dataTable.getCommonData("DockDoor"));
	 
	  
	}

	@And("^RFConsole Login$")
	public void rFConsole_Login() throws Throwable { 
	 
	  
	}

	@And("^RF Console Receive Single LPN$")
	public void rF_Console_Receive_Single_LPN() throws Throwable { 
	 
	  
	}
	
	
	@And("^LPN Status Verification$")
	public void lPN_Status_Verification() throws Throwable { 
	  iLPNsPage.LPNStatus_Verification(dataTable.getData(DataColumn.LPNNumber),dataTable.getData(DataColumn.PALLET),dataTable.getData(DataColumn.SLOT));
	  
	  
	}
	
	@And("^Verification of Purchase Order UI Page$")
	public void verification_of_Purchase_Order_UI_Page() throws Throwable { 
		PurchaseOrder.verification_of_Purchase_Order_UI_Page(dataTable.getData(DataColumn.PurchaseOrder),dataTable.getData(DataColumn.PO_SKU),dataTable.getData(DataColumn.PO_Status),dataTable.getData(DataColumn.PO_Remain_Qty),dataTable.getData(DataColumn.PO_Received_Qty),dataTable.getData(DataColumn.PO_SKU1),dataTable.getData(DataColumn.PO_Status1),dataTable.getData(DataColumn.PO_Remain_Qty1),dataTable.getData(DataColumn.PO_Received_Qty1));
				
	}
	
	@And("^Getting Dockdoor information$")
	public void getting_Dockdoor_information() throws Throwable { 
		 
		  
		}
	
	@And("^Creation of DF iLPNs$")
	  public void creation_of_DF_iLPNs() throws Throwable { 
		 ASNsVerification.DF_iLPNs_Creation();
		
	  }
	
	@And("^Verification of Task UI Page$")
	public void verification_of_Task_UI_Page() throws Throwable { 
	 
	  
	}
	
	@And("^Assigning ASN to PO with Multiple Items$")
	public void assigning_ASN_to_PO_with_Multiple_Items() throws Throwable { 
	 
		AsnCreation.Assign_ASN_to_PO_Multiple_Items(dataTable.getData(DataColumn.PoNumber),dataTable.getData(DataColumn.ItemBar_1),dataTable.getData(DataColumn.ItemBar_2));
	  
	}

	@And("^Verification of DF Reserve Locations PIX$")
	public void verification_of_DF_Reserve_Locations_PIX() throws Throwable { 
	 
		PixTransactionsPage.verification_of_DF_Reserve_Locations_PIX(dataTable.getData(DataColumn.ReserveLocation), dataTable.getData(DataColumn.CurrentWeight), dataTable.getData(DataColumn.CurrentQuantity), dataTable.getData(DataColumn.CurrentVolume), dataTable.getData(DataColumn.gReserveLoc));
	}
	
	@And("^Navigate to iLPN Reserve Locations$")
	public void navigate_to_iLPN_Reserve_Locations() throws Throwable { 
		iLPNsPage.Navigate_to_iLPN_Res_loc(dataTable.getData(DataColumn.LPNNumb1), dataTable.getData(DataColumn.iLPNsStatus1), dataTable.getData(DataColumn.LPN_QTY), dataTable.getData(DataColumn.CurrentLocation1), dataTable.getData(DataColumn.DestinationLocation1), dataTable.getData(DataColumn.LockCode));
	  
	}
	
	@And("^Verification of Transaction Type in Activity Tracking Page$")
	public void verification_of_Transaction_Type_in_Activity_Tracking_Page() throws Throwable { 
	 
		ActivityTrackingPage.Activity_TrackingPage(dataTable.getData(DataColumn.LPNNumb1),dataTable.getData(DataColumn.Transaction_Type1), dataTable.getData(DataColumn.ItemBar_1),dataTable.getData(DataColumn.From_LOCATION),dataTable.getData(DataColumn.To_LOCATION));
	  
	}
		
	@And("^Verification of Pix Transactions in Pix Transaction Page$")
	public void verification_of_Pix_Transactions_in_Pix_Transaction_Page() throws Throwable { 
		PixTransactionsPage.PIX_TransactionUpdated(dataTable.getData(DataColumn.pixTtype1),dataTable.getData(DataColumn.pixTratype1),dataTable.getData(DataColumn.pixcd1),dataTable.getData(DataColumn.pixactCd1),dataTable.getData(DataColumn.ItemBar),dataTable.getData(DataColumn.Generate_LPN1));
	  
	}

	
}
