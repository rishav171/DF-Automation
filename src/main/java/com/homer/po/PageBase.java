package com.homer.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.homer.dao.CommonData;
import com.homer.dao.InstanceContainer;
import com.homer.enums.EnumClass.StepResult;
import com.homer.helper.DataTable;
import com.homer.reports.Report;
import com.homer.resuablecomponents.ReusableComponents;
import com.homer.resuablecomponents.WebDriverHelper;

public class PageBase <CHILD extends PageBase<CHILD>>{
	
	protected InstanceContainer ic;
	protected WebDriver driver;
	protected WebDriverHelper wh;
	protected DataTable dataTable;
	protected ReusableComponents rc;
	protected Report report;
	protected CommonData commonData;
	public static String ASNID;
	public static String AppointmentID;
	public static String ASNStatus;
	
	protected boolean expectedResult;
	protected boolean isListViewSelected;
	
	protected static By pageTitle = By.className("page-title");
	
	protected static By searchTxtBox = By.id("searchFocus");
	protected static By searchBtn = By.id("searchButton");
	protected static By verifyPLPPage = By.id("hd_plp");
	protected static By breadCrumbDiv = By.id("breadcrumb");
	
	static final By signInLink = By.xpath("//div[@id='accountInfo']//a[text()='Sign In']");
	static final By verifySignInPage = By.id("userLogin");
	static final By emailTxtBox = By.id("email_id");
	static final By passwordTxtBox = By.id("password");;	
	static final By signInBtn = By.id("signIn");
	static final By verifySignedInUser = By.xpath("//span[@id='navUserName'][contains(text(),'Hello')]");
	static final By verifyHomePage = By.className("switches");
	
	public PageBase(InstanceContainer ic) {
		
		this.ic = ic;
		this.driver = ic.driver;
		this.wh = ic.wh;
		this.rc = ic.rc;
		this.dataTable = ic.dataTable;
		this.report = ic.report;
		this.commonData = ic.commonData;
	}
	
	/**
	  * Method to search keyword
	  * @return
	  * @throws Exception
	  */
	
	
	/**
	 * Method to sign In User
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public CHILD signInUser(String email, String password) throws Exception {
		
		wh.clickElement(signInLink);

		if (wh.isElementPresentAfterWait(verifySignInPage)) {

			report.addReportStep(
					"Click on 'Sign in' link present on the top right side of the page",
					"Sign In page displayed successfully", StepResult.PASS);
			
			wh.sendKeys(emailTxtBox, email);
			wh.sendKeys(passwordTxtBox, password);
			wh.clickElement(signInBtn);

			if (wh.isElementPresentAfterWait(verifySignedInUser)) {

				report.addReportStep(
						"Enter valid email address and Password and click on the 'Sign in' button.",
						"Site navigated to the homepage after successful login",
						StepResult.PASS);
			} else {

				String stepDesc = "";

				if (!wh.isElementPresentAfterWait(verifySignedInUser)
						&& !wh.isElementPresentAfterWait(verifyHomePage)) {

					stepDesc = "Sign In failed for user and was not redirected to home page";

				} else if (!wh.isElementPresentAfterWait(verifySignedInUser)) {

					stepDesc = "User was not redirected to home page";

				} else {

					stepDesc = "User did not get signed in successfully";
				}

				report.addReportStep(
						"Enter valid email address and Password and click on the 'Sign in' button.",
						stepDesc, StepResult.FAIL);
			}

		} else {
			
			report.addReportStep("Click on Sign In link",
					"Sign In page did not get displayed", StepResult.FAIL);
		}
		
		return (CHILD) this;
	}
	
}
