package com.homer.po;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.homer.dao.InstanceContainer;
import com.homer.enums.EnumClass.StepResult;

public class DFPostMessage  extends PageBase<DFPostMessage>  {
	static final By lnkMenu  =By.xpath("//span[contains(text(),'enu')]");
	static final By lnkIntegration =By.xpath("//a[contains(text(),'Integration')]");
	static final By lnkPostMessage =By.xpath("//a[contains(text(),'Post Message')]");
	static final By btnUpload  =By.xpath("//INPUT[@id='dataForm:uploadedFileID']");
	static final By btnSave  =By.id("dataForm:postMessageCmdId");
	static final By btnReset  =By.id("dataForm:resetCmdId");
	
	String DistributionOrder;
	
	public DFPostMessage(InstanceContainer ic) {
		super(ic);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public  String  DF_XmlUpdate(String TagName,String TagName1,String Item,String xmlFilePath)
    {	
		try {		
				        
	        Random rand = new Random();
			int trailer = rand.nextInt(1000);
			String strtrailer = Integer.toString(trailer);
	        DistributionOrder="Auto"+strtrailer;	        	        
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(xmlFilePath);	                       
			Node Tagnode = document.getElementsByTagName(TagName).item(0);			
			Tagnode.setTextContent(DistributionOrder);	       
			Node Tagnode1 = document.getElementsByTagName(TagName1).item(0);			
			Tagnode1.setTextContent(Item);	           			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(xmlFilePath));
			transformer.transform(domSource, streamResult);
			System.out.println("The XML File was ");
				} catch (ParserConfigurationException pce) {
					pce.printStackTrace();
				} catch (TransformerException tfe) {
					tfe.printStackTrace();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				} catch (SAXException sae) {
					sae.printStackTrace();
		   }
		return DistributionOrder;
     }

	
	public void DF_Upload_File(String path) throws Throwable {
	    wh.waitForPageLoaded();
	    wh.waitForElementPresent(lnkMenu);
	    expectedResult = wh.isElementPresent(lnkMenu);
	    if (expectedResult) {
	        wh.clickElement(lnkMenu);
	        wh.waitForPageLoaded();
	        expectedResult = wh.isElementPresent(lnkIntegration);
	        if (expectedResult) {
	            wh.clickElement(lnkIntegration);
	            wh.waitForPageLoaded();
	            expectedResult = wh.isElementPresent(lnkPostMessage);
	            if (expectedResult) {
	                wh.clickElement(lnkPostMessage);
	                wh.waitForPageLoaded();
	                expectedResult = wh.isElementPresent(btnUpload);
	                if (expectedResult) {
	                    wh.clickElement(btnUpload);
	                }
	            }
	        }
	    }
	    wh.waitForPageLoaded();
	    StringSelection ss = new StringSelection(path);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	    Robot robot = new Robot();
	    robot.delay(250);
	    robot.keyPress(KeyEvent.VK_SPACE);
	    robot.keyRelease(KeyEvent.VK_SPACE);
	    robot.delay(50);
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    robot.keyPress(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_V);
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.delay(50);
	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.delay(50);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    wh.waitForPageLoaded();
	    expectedResult = wh.isElementPresent(btnSave);
	    if (expectedResult) {
	        wh.clickElement(btnSave);
	    }
	    if (wh.isElementPresent(btnReset)) {
	        report.addReportStep("Post Message Page, PO XML File Upload",
	            "Post Message Page, PO XML File Upload",
	            StepResult.PASS);
	    } else {
	        report.addReportStep("Post Message Page, PO XML File Upload",
	            "Post Message Page, PO XML File Upload",
	            StepResult.FAIL);
	    }

	}
	public static void DF_XML_PO(String Val,String xmlFilePath) throws Throwable
    {	
		int Item=0;
		String[] Tagal = Val.split("-");
		Random rand = new Random();
		int trailer = rand.nextInt(1000);
		String strtrailer = Integer.toString(trailer);
		String PoID="Aut"+strtrailer;
        String RefID="Aut"+strtrailer+" 2016-02-15 15:42:49.967";
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	    DocumentBuilder db = dbf.newDocumentBuilder();
	    Document doc = db.parse(xmlFilePath);
	    doc.getDocumentElement().normalize();	   	   
	    System.out.println("Root element " + doc.getDocumentElement().getNodeName());
	    NodeList nodeList=doc.getElementsByTagName("*");
	    for (int i=0; i<nodeList.getLength(); i++) 
	    {	        
	        Element element = (Element)nodeList.item(i);
	        System.out.println(element.getNodeName());
	       if ("ItemName".equals(element.getNodeName())) {
	    	   if(Item==0){
	    		   element.setTextContent(Tagal[Item]);										
					Item=Item+1;
				    }else{
					element.setTextContent(Tagal[Item]);	
					Item=Item+1;
			     }
	           }else if("Reference_ID".equals(element.getNodeName())){
	        	   element.setTextContent(RefID);	
	           }else if("OrderId".equals(element.getNodeName())){
	        	   element.setTextContent(PoID);	       
	         }
		}	  	    
		    TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(doc);
			StreamResult streamResult = new StreamResult(new File(xmlFilePath));
			transformer.transform(domSource, streamResult);
			System.out.println("The XML File was ");
	  }
    	
}
