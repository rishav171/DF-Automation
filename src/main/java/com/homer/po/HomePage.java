package com.homer.po;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.homer.dao.CommonDataColumn;
import com.homer.dao.InstanceContainer;
import com.homer.enums.EnumClass.StepResult;
import com.homer.helper.HelperClass;
public class HomePage extends PageBase<HomePage> {
	
	static By betaWebServerBtn = By.xpath("//button[@id='button1'][contains(text(),'Beta Webservers')]");
	static By testWebServerBtn = By.xpath("//button[@id='button1'][contains(text(),'Test Webserver')]");
	static By tableWave =By.xpath("//table[@id='dataForm:listView:dataTable_body']/tbody/tr");
	static By tableTask =By.xpath("//table[@id='dataForm:lview:dataTable_body']/tbody/tr[1]/td[2]");
	static By tableTaskHeaderStatus =By.xpath("//table[@id='dataForm:lview:dataTable_body']/tbody/tr[1]/td[3]");
	static By tableTaskID =By.xpath("//table[@id='dataForm:lview:dataTable_body']/tbody/tr[1]/td[2]");
	
	static final By username = By.name("j_username");
	static final By password = By.name("j_password");
	static final By btnEnter = By.name("btnEnter");
	static final By imgHome  = By.name("home");
	static final By lnkMenu  =By.id("phMenu");
	static final By overlink  =By.id("overridelink");
	
	static final By lnkWaves =By.linkText("Waves");
	static final By wavenum  =By.id("dataForm:listView:filterId:field0value1");
	static final By btnApply =By.id("dataForm:listView:filterId:filterIdapply");
	static final By btnView =By.id("checkAll_c0_dataForm:listView:dataTable");
	static final By btnMore = By.id("rmbuttons_1moreButton");
	static final By btnTask =By.id("rmButton_2Tasks1_100668000");
	static final By btnFormView =By.id("checkAll_c1_dataForm:lview:dataTable");	
	static final By btnReleaseTask =By.id("rmButton_1ReleaseTask1_167271344");
	static final By lnkRFMenu =By.linkText("RF Menu");
	static final By btnRFEnter = By.xpath("//input[@value='Enter']");
	static final By RfTgroup = By.id("dataForm:taskGrp");
	static final By RfTaskID =By.id("dataForm:input1");
	static final By RfiLpn =By.id("barcode");
	static final By lnkTask =By.linkText("Tasks");
	static final By taskValue =By.id("dataForm:lview:filterId:field1value1");
	static final By taskview =By.id("dataForm:lview:filterId:filterIdapply");
	
	
	
	static String TaskID;
	static final By SearchTxtBox = By.id("searchFocus");
	static final By SearchBtn = By.id("searchButton");
	 
	 public HomePage(InstanceContainer ic) {
		 super(ic);        	     
	 }
	 
	 /**
	  * Method to open Home Page
	  * @throws Exception
	  */
	 public void open() throws Exception {
		 	
		 String envUrl = dataTable.getCommonData(CommonDataColumn.EnvironmentUrl);
		   
			try {								
		        driver.manage().window().maximize();   
		        driver.get(envUrl);
				//driver.navigate().to(envUrl);			
				
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				wh.handleAlert();
			}

	 }		
	 
	 
	 public  void SigninPage() throws Exception {
			 Thread.sleep(3000);
			 wh.clickElement(overlink);
			//driver.get("javascript:document.getElementById('overridelink').click();");			 
		 	wh.sendKeys(username, dataTable.getCommonData(CommonDataColumn.SignInUser));
			wh.sendKeys(password, dataTable.getCommonData(CommonDataColumn.SignInPassword));
			wh.clickElement(btnEnter);			
			Thread.sleep(1000); 	    
			wh.clickElement(imgHome);
	        Thread.sleep(3000);
	        wh.clickElement(overlink);
	        //driver.get("javascript:document.getElementById('overridelink').click();");
	        Thread.sleep(3000);        
			report.addReportStep("Login into userID, enter Password and click on Enter",
					"entered user, enter Password and clicked on Enter", 
					StepResult.PASS);
		
	     }
	 
	 
	 public void Outbnd_Wave() throws Exception {		 
		    Thread.sleep(6000);	
		    wh.clickElement(lnkMenu);		    		    
	        Thread.sleep(1000);	        
	        wh.clickElement(lnkWaves);		        
	        Thread.sleep(5000);		        	        
	        wh.sendKeys(wavenum, dataTable.getCommonData(CommonDataColumn.WaveNumber));
	        wh.clickElement(btnApply);	        
	        Thread.sleep(5000);	
	        List<WebElement> tr = driver.findElements(tableWave);
	        List<WebElement> cells = tr.get(0).findElements(By.tagName("td"));        
	        for (WebElement cell : cells)
	        {           		             
	           if(dataTable.getCommonData(CommonDataColumn.WaveStatus).contains(cell.getText())){	        	   
	        	   report.addReportStep("The Wave Number Status, enter Wave Number and click on Apply",
	   					"The WaveNumber Status Displayed as Ship wave completed", 
	   					StepResult.PASS);
	        	   break;
	           };
	        }    		        
	        
	        wh.clickElement(btnView);		        	        
	        Thread.sleep(1000);	        
	        wh.clickElement(btnMore);	        
	        Thread.sleep(1000);	        
	        wh.clickElement(btnTask);		        	
     }
	 
	 public  void Task_Screen() throws Exception {			
					Thread.sleep(2000);														
					TaskID=wh.getText(tableTask);										            
			            if(dataTable.getCommonData(CommonDataColumn.TaskStatus).contains(wh.getText(tableTaskHeaderStatus))){	
			            	 report.addReportStep("The Task ID Status, enter Task ID and click on Apply",
			 	   					"The TaskID Status Displayed as Ship wave Locked/Disabled", 
			 	   					StepResult.PASS);
			            	   }
			            	   else{
			            		   report.addReportStep("The Task ID Status, enter Task ID and click on Apply",
					 	   					"The TaskID Status NOT Displayed as Ship wave Locked/Disabled", 
					 	   					StepResult.FAIL);
			            	}		            			            
			            wh.clickElement1(btnFormView);					        			        
				        Thread.sleep(1000);					        
				        wh.clickElement1(btnReleaseTask);				        
				        wh.handleAlert();				        			        				        				        	  																																									        				        
						Thread.sleep(8000);				        
				        wh.clickElement(lnkMenu);		    		    
				        wh.waitForElementPresent(lnkRFMenu);	        
				        wh.clickElement(lnkRFMenu);		        
				        Thread.sleep(2000);		     
				        wh.sendKeys(username, dataTable.getCommonData(CommonDataColumn.SignInUser));
						wh.sendKeys(password, dataTable.getCommonData(CommonDataColumn.SignInPassword));
						wh.clickElement(btnRFEnter);						        				        				        
		}
	 
	 public  void RF_Screen() throws Exception {
		    wh.clickElement(lnkMenu);		    		    
	        Thread.sleep(5000);	        
	        wh.clickElement(lnkRFMenu);		        
	        Thread.sleep(5000);		     
	        wh.sendKeys(username, dataTable.getCommonData(CommonDataColumn.SignInUser));
			wh.sendKeys(password, dataTable.getCommonData(CommonDataColumn.SignInPassword));
			wh.clickElement(btnRFEnter);
	        Thread.sleep(3000); 	  
	        wh.sendKeys(null, Keys.CONTROL + "t" + Keys.CONTROL);
	        Actions action = new Actions(driver); 
	        action.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).perform();
	        Thread.sleep(2000);	        
	        wh.sendKeys(RfTgroup,"ALL");	                   
	        Thread.sleep(1000);  
			Keyboard keyboard=((HasInputDevices) wh.driver).getKeyboard();
			keyboard.pressKey(Keys.ENTER);	
			Thread.sleep(1000);  
			keyboard.pressKey(Keys.ENTER);
			Thread.sleep(1000);  
			keyboard.pressKey(Keys.ENTER);
			Thread.sleep(2000);
			action.keyDown(Keys.CONTROL).sendKeys("e").keyUp(Keys.CONTROL).perform();
	        Thread.sleep(3000);	        
	        wh.sendKeys(RfTaskID,TaskID);		             
	        Thread.sleep(2000);  
			keyboard.pressKey(Keys.ENTER); 
			Thread.sleep(11000);  			
			wh.sendKeys(RfiLpn, dataTable.getCommonData(CommonDataColumn.iLPNNUMBER));	             		 						
			keyboard.pressKey(Keys.ENTER); 	
			Thread.sleep(6000);  
			if(wh.driver.getPageSource().contains(dataTable.getCommonData(CommonDataColumn.iLPNNUMBER))){
				report.addReportStep("The Task ID Status, enter Task ID and click on Apply",
 	   					"The TaskID Status Displayed as Ship wave Picking Complete", 
 	   					StepResult.PASS);
            	   }
            	   else{
            		   report.addReportStep("The Task ID Status, enter Task ID and click on Apply",
		 	   				"The TaskID Status NOT Displayed as Ship wave Picking Complete", 
		 	   				StepResult.FAIL);
	        }
						
			wh.driver.close();
		}
		
	 public  void Task_ScreenValidation() throws Exception {										
			wh.clickElement(lnkTask);				
	        Thread.sleep(5000);			        
	        wh.sendKeys(taskValue,TaskID);	        
	        wh.clickElement(taskview);		        
	        Thread.sleep(5000);		
	         if(dataTable.getCommonData(CommonDataColumn.TaskIDStatus).contains(wh.getText(tableTaskID))){	
	        	 report.addReportStep("The Task ID Status, enter Task ID and click on Apply",
	 	   					"The TaskID Status Displayed as Ship wave Complete in Application", 
	 	   					StepResult.PASS);
	            	   }
	            	   else{
	            		   report.addReportStep("The Task ID Status, enter Task ID and click on Apply",
			 	   				"The TaskID Status Not Displayed as Ship wave Complete in Application", 
			 	   				StepResult.FAIL);		            
	            	   }
	 		}

	 public static void PopUpCall(WebDriver driver) throws Exception
     {
            Runtime.getRuntime().exec( "wscript ./ScriptName.vbs" );

     }

	 
}





