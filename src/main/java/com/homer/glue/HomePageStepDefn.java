package com.homer.glue;

import com.homer.dao.DataClass;
import com.homer.dao.DataColumn;
import com.homer.dao.Given;
import com.homer.dao.When;
import com.homer.enums.EnumClass.StepResult;
import com.homer.po.HomePage;

public class HomePageStepDefn extends BaseStepDefn {
	
	public HomePageStepDefn(DataClass data) {
		super(data);
	}	
	
	
	@Given("^I am a customer on Home Depot$")
	public void i_am_a_customer_on_Home_Depot() throws Throwable { 			
		
		System.out.println("Test case name " +data.testCaseName);
		System.out.println("Report folder name " +data.reportFolder);
		System.out.println("Screenshot folder name "+data.screenShotFolder);
		
		homePage = new HomePage(ic);
		homePage.open();
	}
	
	@When("^I search for \"(.*?)\"$")
	public void i_search_for_arg1(String arg1) throws Throwable { 
		
		//homePage.searchKeyword(dataTable.getData(DataColumn.Keyword));
	}
	
	@When("^I search for ([^\"]*)$")
	public void i_search_for_Keyword(String Keyword) throws Throwable { 		
		
		//plpPage = homePage.searchKeyword(dataTable.getData(DataColumn.Keyword));
	}

	@When("^I type keyword \"(.*?)\"$")
	public void i_land_on_PLP_page(String arg1) throws Throwable { 
		
		System.out.println(arg1);
		System.out.println(dataTable.getData(DataColumn.Keyword));
		
		//homePage.searchKeyword(dataTable.getData(DataColumn.Keyword));	  
	}
	
	@When("^I search for sku \"(.*?)\"$")
	public void i_search_for_sku_arg1(String arg1) throws Throwable { 
		
		//pipPage = homePage.searchSkuNo(arg1);
	}
}
