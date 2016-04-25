package com.homer.po;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.homer.dao.DataColumn;
import com.homer.dao.InstanceContainer;
import com.homer.enums.EnumClass.StepResult;

public class DFRF_PuttyScreen   extends PageBase < DFRF_PuttyScreen> {
	String line;

	public DFRF_PuttyScreen(InstanceContainer ic) {
		super(ic);
		
		}
	
	
	public void RF_putty(String TestCaseName,String TaskNo,String Locn,String Item,String Tote,String ReserveBCode,String ExpectedResults )throws Exception 
    {               
        String Concat=TestCaseName+" "+TaskNo+" "+Locn+" "+Item+" "+Tote+" "+ReserveBCode;
        int blnFlag=0;        
        Process p= Runtime.getRuntime().exec("C:\\WMS\\Homer_Release3.2\\Homer\\AutoIT\\testAutoIT.exe "+""+Concat);           
        BufferedReader input =new BufferedReader(new InputStreamReader(p.getInputStream()));                   

        while ((line = input.readLine()) != null) {         
           if(line.indexOf(ExpectedResults) != -1){ 
        	   System.out.println("The STATUS DISPLAYED AS:"+ExpectedResults);         	   
        	   blnFlag=1;
        	   break;
           }           
        }
        input.close();   
        if(blnFlag==1){	
        	System.out.println("The STATUS DISPLAYED AS:"+ExpectedResults); 
        	report.addReportStep("Putty Screen displays the Expected Results"+ExpectedResults,
					"Matches the Actual Results"+line, 
					StepResult.PASS);
        	   }
        	   else{
        		   System.out.println("The STATUS NOT DISPLAYED AS:"+ExpectedResults); 
        		   report.addReportStep("Putty Screen displays the Expected Results"+ExpectedResults,
       					"Doesnot Matches the Actual Results"+line, 
       					StepResult.FAIL);
        	}
  }
}
