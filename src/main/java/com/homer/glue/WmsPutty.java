package com.homer.glue;
import com.homer.dao.And;
import com.homer.dao.CommonDataColumn;
import com.homer.dao.DataClass;
import com.homer.dao.Given;
import com.homer.dao.Then;
import com.homer.dao.When;
import com.homer.po.HomePage;

public class WmsPutty  extends BaseStepDefn {

	public WmsPutty(DataClass data) {
		super(data);		
	}
	
	@Given("^Login into WMS HomePage$")
	public void login_into_WMS_HomePage() throws Throwable { 
	 
		homePage.open();
		homePage.SigninPage();
		
	}
	
	@Then("^Perform the OutBound Waveing$")
	public void perform_the_OutBound_Waveing() throws Throwable { 
		homePage.Outbnd_Wave();
	  
	}

	@Then("^Perform the Task Screen$")
	public void perform_the_Task_Screen() throws Throwable { 
		homePage.Task_Screen();
	  
	}

	@When("^Navigate to RF Screen$")
	public void navigate_to_RF_Screen() throws Throwable { 
		homePage.RF_Screen();
	  
	  
	}

	@Then("^Login into WMS HomePage again$")
	public void login_into_WMS_HomePage_again() throws Throwable { 
		homePage.open();
		homePage.SigninPage();
		 
	  
	}

	@Then("^Validate the Task Status$")
	public void validate_the_Task_Status() throws Throwable { 
		homePage.Task_ScreenValidation();
	  
	}


	@When("^Logout from WMS Home Page$")
	public void logout_from_WMS_Home_Page() throws Throwable { 
	 
	  
	}

}
