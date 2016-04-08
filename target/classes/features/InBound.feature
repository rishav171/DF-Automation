# encoding: UTF-8
Feature: This is a sample feature 

  #  Scenario Tag ID is the test case id in TestRail,TestLink,ALM. multiple cases separated with blank space
  #  1. if the tag id is empty then it will create this scenario test case in your testRail,TestLink or ALM,
  #  2. but if you specified the scenario tag id as the test case id,then it will just update the existing test case .
  #  Scenario title is the Test Case name in TestRail,TestLink,ALM
  #  Step sentence is the 'cucumber' field value in TestRail,TestLink,ALM

   @PO_1
  Scenario: TC_DF_PUT_CRT_015  	 
  	 Given I open the url
     When Creation of DF ASN     
     When Creation of DF Appointment
     Then Open the DF ASN for Verification
     And  RF Release DockDoor
     And  DF CheckIn Navigation
	 And  DF CheckIn Fill Details
	 And  RFConsole Login
	 And  RF Console Receive Single LPN
	 And  LPN Status Verification
	 And  Verification of Purchase Order UI Page
	 And  Getting Dockdoor information
	 And  Verification Checkin Multiple iLPN
	 And  Verification Checkin Multiple iLPN SLOT
	 And  Creation of DF iLPNs
	 And  Verification of Task UI Page  
	 And  Assigning ASN to PO with Multiple Items 
	 And  Verification of Multiple iLPNs
	 And  Verification of DF Reserve Locations PIX
	 And  Navigate to iLPN Reserve Locations
	 And  Verification of Transaction Type in Activity Tracking Page
	 And  Verification of Pix Transactions in Pix Transaction Page
	 
     
   @PO_2
  Scenario: TC_DF_PUT_CRT_003
  	 Given I open the url
     When Creation of DF ASN     
     When Creation of DF Appointment
     Then Open the DF ASN for Verification
     And  RF Release DockDoor
     And  DF CheckIn Navigation
	 And  DF CheckIn Fill Details
	 And  RFConsole Login
	 And  RF Console Receive Single LPN