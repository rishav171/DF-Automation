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


public class OutBound extends BaseStepDefn{
	
	public OutBound(DataClass data) {
		super(data);		
	}
	
	@When("^Run Wave for Distribution order$")
	public void run_Wave_for_Distribution_order() throws Throwable { 
		//String DistributionOrder1=PostMessage.DF_XmlUpdate("Reference_ID-DistributionOrderId-ItemName","SGG01-SGG01-518691","C:\\XmlFiles\\PurchaseOrder.xml");		
		loginPage.open();
		loginPage.SigninPage();					
		//PostMessage.DF_Upload_File("C:\\XmlFiles\\PurchaseOrder.xml");
		//DistributionOrder.Wave_Verification(DistributionOrder1, "Ship wave completed");
		//DistributionOrder.Release_Task();
		/*
		SinglesPackingStation.SinglesPacking_Stat("210", "TRAMU22", "708277");
		DistributionOrder.SinglesPacking_DistributionOrder("DOLTLMN66", "Packed");
		*/
		
		
		 String iLPNs[]={"C2000776652","C2000776653"};
		 MobilePackingStation.MobilePacking_Station("210",iLPNs, "999622", "DOLTL340","Packed",2);
		 /*
		 String iLPNs1[]={"C2000776583","C2000776583"};
		 DistributionOrder.MULTISPacking_Station("210",iLPNs1, "999622", "DOLTL378","Packed",2);
			 
         		*/
	}	
}
