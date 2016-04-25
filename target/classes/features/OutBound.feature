# encoding: UTF-8
Feature: This is a sample feature 

  #  Scenario Tag ID is the test case id in TestRail,TestLink,ALM. multiple cases separated with blank space
  #  1. if the tag id is empty then it will create this scenario test case in your testRail,TestLink or ALM,
  #  2. but if you specified the scenario tag id as the test case id,then it will just update the existing test case .
  #  Scenario title is the Test Case name in TestRail,TestLink,ALM
  #  Step sentence is the 'cucumber' field value in TestRail,TestLink,ALM

   @PO_1
  Scenario: TC_SinglesPackingStation  	 
     Given User Opens WMS application  	 
  	 When  Update the DF Order XML File
  	 Then  Post the XML File  	 
  	 Then  Waving the Distribution Order  	 
  	 Then  Release the Task
     Then  Get BarCode from Location
     Then  Picking the BarCode from PickLocation   
     Then  Picking the BarCode from ReserveLocation       
     Then  Performing the Picking in the RF Screens
     When  User Clicks on SinglesPackingStation Link
     Then  Submit the Print Shipping Label  
     And   Checks the LPN Facility Status
     
     
     
    @PO_1
  Scenario: TC_MULTIPackingStation  	 
  	 Given User Opens WMS application
  	 When  Get iLpns from DistributionOrder
     When  User Clicks on MULTIPackingStation Link
     Then  Submit the MultiPrint Shipping Label  
      And  Checks the MultiLPN Facility Status 
   @PO_1
  Scenario: TC_MobilePackingStation  	 
  	 Given User Opens WMS application
  	 When  Get iLpns from DistributionOrder
     When  User Clicks on MobilePackingStation Link
     Then  Submit the MobilePrint Shipping Label  
      And  Checks the MobileLPN Facility Status 
      @PO_1
  Scenario: TC_HospitalPackingStation  	 
  	 Given User Opens WMS application
  	 When  Get iLpns from DistributionOrder     
  	 When  User Clicks on HospitalPackingStation Link
     Then  Submit the HospitalPrint Shipping Label  
     And  Checks the HospitalLPN Facility Status 
   