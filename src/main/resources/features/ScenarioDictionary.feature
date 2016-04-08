Feature: Has all the scenario steps from 'Checkout & MCC' and 'MAML' projects 

Scenario: All Steps 
	Given I add "cardType" credit card 
	Given I add "itemType" item to "view protection plan" tab 
	Given I add "itemType" item to cart 
	Given I add "itemType" item to cart through PIP 
	Given I add "itemType" item to cart through PLP 
	Given I add "itemType" item to cart through Search 
	Given I add "itemType" item to cart through Jump URL 
	Given I add "itemType" to list 
	Given I add "2" more "itemType" items to cart 
	Given I add "2" more similar "itemType" items to cart 
	Given I add another "itemType" item to cart with "same zip code" 
	Given I add another "itemType" item to cart 
	Given I add similar "itemType" item to cart 
	Given I again enter zip code and click check for delivery 
	Given I again see the schedule delivery page with delivery reservation text 
	Given I am a "userType" user 
	Given I am a "userType" user on Home Depot 
	Given I am a customer on Home Depot 
	Given I apply promotion in cart 
	Given I change "BODFS" zip code in cart page 
	Given I change service level from curbside to threshold/white glove in the service level drop down and click continue 
	Given I change store details in my account page 
	Given I change the fulfillment type from "STH" to "BODFS" 
	Given I change the localized store in the header 
	Given I change the localized store in the header to a store that belongs to "same or different" market as the previous store 
	Given I change the service level to threshold 
	Given I check Cancel button is "Available" for the order 
	Given I check Online price in Cassandra DB 
	Given I check appliance availability from My list 
	Given I check for availability by clicking on zip code look up arrow beside the zip code entry field 
	Given I check for no radio button in "pageName" page 
	Given I check for no radio button in "pageName" page for "itemType" item 
	Given I check for right rail express delivery text 
	Given I check for schedule delivery section 
	Given I check for zero in stock msg PIP 
	Given I check my order as "userType" user via Help 
	Given I check protection plan tab 
	Given I checkout as "userType" user 
	Given I clear the card details entered 
	Given I clear the qty of an item in cart 
	Given I click "back" button in "pageName" page 
	Given I click "buttonName" button in "pageName" page 
	Given I click "buttonName" button in cart 
	Given I click "buttonName" radio button in "pageName" page 
	Given I click "checkout Now" in "pageName" 
	Given I click "checkout Now" in "pageName" page 
	Given I click "menuItemFromHeader" from "pageName" page 
	Given I click "no" for assembly sku 
	Given I click "PayPal" radio button in "pageName" page 
	Given I click "ShipToStore" radio button in "pageName" page 
	Given I click "yes" for assembly sku 
	Given I click Add to cart from "pageName" page 
	Given I click Add to cart from My list 
	Given I click Add to List from "pageName" page 
	Given I click Add to List from in cart 
	Given I click cancel and return option 
	Given I click continue in calendar overlay 
	Given I click Continue Shopping in "overlay" 
	Given if click CTA button near the zip code look field 
	Given I click express checkout in "Shopping Cart" page 
	Given I click mini cart button in the header 
	Given I click on "linkName" from "pageName" page 
	Given I click on "Sign In" link in cart header 
	Given I click on add new address link in "pageName" page 
	Given I click on "AddToCart" link in "pageName" page 
	Given I click on calendar icon in "pageName" page 
	Given I click on calendar icon below the suggested delivery reservation 
	Given I click on change store and update cart 
	Given I click on "change zip code appliance" in cart 
	Given I click on "more information" link in "pageName" page 
	Given I click on see details link displayed against the promotion below each line item 
	Given I click on the "cart" breadcrumb 
	Given I click on zip code look up arrow beside the zip code entry field 
	Given I click product image to navigate to PIP 
	Given I click Sign In from "location" 
	Given I click submit order PayPal in "pageName" page 
	Given I click terms and conditions link in "pageName" page 
	Given I close the callout popup in "thankyou" page 
	Given I create "orderType" Order with "cardType" Card as "userType" user 
	Given I delete user session cookie 
	Given I edit account information in "My Account" page 
	Given I enter "fieldName" and checkout as "userType" user 
	Given I enter "id or password" for "persistent" user 
	Given I enter "Low Inv or No Inv or No Contract" Zip code and click checkout now button 
	Given I enter "one field" and leave all the other fields blank and click save button 
	Given I enter address , choose date and click on continue button 
	Given I enter address and click on continue button 
	Given I enter card details 
	Given I enter CVV for saved card 
	Given I enter delivery address and delivery date and click continue 
	Given I enter delivery details and submit order 
	Given I enter delivery information 
	Given I enter delivery zip code and add "some" item to cart 
	Given I enter details in express delivery page 
	Given I enter invalid zip code and click on zip code lookup arrow 
	Given I enter payment details under credit card section 
	Given I enter PayPal details and continue 
	Given I enter PO BOX in address line 1 or 2 
	Given I enter PO BOX in address line 1 or 2 and click Continue button 
	Given I enter the billing information 
	Given I enter zip code for restricted area 
	Given I establish the connection with Cassandra DB 
	Given I fill payment details in Payment page 
	Given I fill shipping details in Shipping page 
	Given I get unit price from PLP certona 
	Given I Increase the qty 
	Given I Increase the qty and click on update link 
	Given I localize the store 
	Given I login as registered user 
	Given I navigate again to schedule delivery page 
	Given I navigate to "Pro site" 
	Given I navigate to order confirmation email page for "itemType" item 
	Given I perform check availability for the BODFS item with the "same or different" zip code 
	Given I perform check availability in overlay 
	Given I receive an order received mail 
	Given I refresh "pageName" page 
	Given I register a user 
	Given I register in "pageName" page 
	Given I remove an item from cart 
	Given I remove promotion from cart 
	Given I save another credit card in My Account page 
	Given I save credit card in My Account page 
	Given I save tax exempt id in My Account page 
	Given I search for "any" keyword 
	Given I search for "any" keyword from "pageName" 
	Given I search for "any" sku 
	Given I search for "itemType" fulfillment item 
	Given I search for "itemType" fulfillment item with promotions 
	Given I see "ItemTotal" displayed in "cart" is equivalent to the price in Cassandra DB 
	Given I see "onlyShortErrorMsg" error message displayed at Page level 
	Given I see "pageName" page displayed 
	Given I see "Shipping Price" displayed in "order pods" is equivalent to the Shipping method 
	Given I see "shortMessageOnly" displayed for all items 
	Given I see "TotalPrice" displayed in " order confirmation" is the sum of all the totals 
	Given I see "TotalPrice" displayed in "ATC Modal" is equivalent to the price in Cassandra DB 
	Given I see "UnitPrice" displayed in "cart" is equivalent to the price in Cassandra DB 
	Given I see "UnitPrice" displayed in "cart" is equivalent to the price in Certona price 
	Given I see Add Address Overlay with blank expanded form field to be displayed 
	Given I see appliance delivery charge changes in "pageName" page 
	Given I see ATC modal with image, total and quantity added 
	Given I see cart merge overlay and click edit cart 
	Given I see Confirmation popup for the items added 
	Given I see delivery calendar modal is displayed with curbside service level as default 
	Given I see delivery calendar modal with curbside service level as default 
	Given I see delivery charge message displayed in atc overlay 
	Given I see delivery charges in "order pods" 
	Given I see delivery unattended text "This delivery will be left unattended" to be present in the calendar modal 
	Given I see earliest delivery date should be displayed 
	Given I see error message "shortMsgOnly" for item not in stock displayed at Page level 
	Given I see error message for "Name", "Address" and "Phone" 
	Given I see error message for restricted zip 
	Given I see expanded form field is displayed 
	Given I see how to get it section with delivery charge message displayed in cart page 
	Given I see item not in stock for delivery error message "shortMessageOnly" 
	Given I see limited qty error msg 
	Given I see loading icon on delay 
	Given I see one more BODFS item should be added to cart 
	Given I see only schedule delivery fulfillment with no radio buttons in buy box 
	Given I See rrders cannot be shipped to PO Box error message to be displayed 
	Given I see outside service level is selected by default 
	Given I see page level error message 
	Given I see page level error message for invalid zip code 
	Given I see page refreshes and display the zip code as a read only text 
	Given I see PayPal express button is not displayed 
	Given I see Persisted address in Shipping Page 
	Given I see price details in "pageName" page 
	Given I see price details in Add to cart overlay 
	Given I see price details in email for "itemType" item 
	Given I see schedule delivery is displayed 
	Given I see session expired error msg in secure "checkout" page 
	Given I see shopping cart page with the intended product displaying the qty 
	Given I see Sign In error message in overlay 
	Given I see subtotal displayed in "order pods" is as in Cart 
	Given I see system unavailable error message 
	Given I see thank you page for order and Express Delivery label in order total section 
	Given I see thank you page for order placed 
	Given I see thank you page for order placed in order confirmation 
	Given I see the "PLPorPLP" price equivalent to the price in Cassandra DB 
	Given I see the "same or different" delivery price 
	Given I see the appliance delivery charge applied in right rail 
	Given I see the availability with Zip code, cheapest cost and earliest delivery date 
	Given I see the delivery charges applied in PayPal order summary 
	Given I see the delivery reservation text 
	Given I see the Express Schedule delivery 
	Given I see the following error message displayed "errorMessage" 
	Given I see the initial search PLP page 
	Given I see the message "shortMessage" 
	Given I see the multiple products added in cart 
	Given I see the PIP screen with Express delivery from store fulfillment 
	Given I see the promotion details of the product 
	Given I see the Schedule delivery page with Delivery reservation text "someShortText" 
	Given I see the service level description is displayed below the service level drop down 
	Given I see the SKU is "DETA or Not DETA" eligible 
	Given I see the SKUs are of "same or different" ship type 
	Given I See user logged In and name displayed on top right corner 
	Given I select "bopis" assembly option in cart 
	Given I select "new or credit" card radio 
	Given I select "Threshold" from Service level drop down 
	Given I select "Threshold" from Service level drop down and click continue 
	Given I select parts and services in overlay 
	Given I select PayPal "payment or checkout" method 
	Given I select saved card from dropdown 
	Given I select two items to compare 
	Given I select Yes radio button of "Can this delivery be left unattended" 
	Given I should not see callout option in thank you page for mixed cart 
	Given I should see "someOption" option 
	Given I sign in as registered user add to list 
	Given I sign in through header 
	Given I Sign Out from My Account 
	Given I Sign In for persistent user in My Account page 
	Given I Sign In from the page with "valid OR Invalid" credentials 
	Given I update the qty of an item in cart 
	Given I validate timestamp for credit cards 
	Given I verify "An adult must be present for delivery" is displayed below the reservation details 
	Given I verify "assembly OR no assembly" option in Thank you page 
	Given I verify "messageType" message displayed in cart 
	Given I verify "messageType" message in My List 
	Given I verify "saved, new or PayPal" card is displayed as radio 
	Given I verify and close the save trip overlay 
	Given I verify Apply button is "displayed or not" 
	Given I verify billing section is hidden 
	Given I verify BODFS availability date is retained 
	Given I verify Buyer Name field is "present or not" in "payment" page 
	Given I verify cart subtotal is sum of all line items total 
	Given I verify certona section in PLP 
	Given I verify CVV error in payment page 
	Given I verify CVV is cleared 
	Given I verify delivery reservation text is retained 
	Given I verify expanded form fields 
	Given I verify gift card section is hidden 
	Given I verify if the text "shortTextOnly" is present in the order total view of calendar modal 
	Given I verify item level error message "shortMessage" displayed for all items 
	Given I verify item level error message "shortMessage" 
	Given I verify item store is "changed or not" in cart 
	Given I verify more information in new tab 
	Given I verify Name on card field is "not present" in "payment" page 
	Given I verify new card section displayed properly 
	Given I verify order summary section should be present on cart page 
	Given I verify PIP page for BODFS and STH option 
	Given I verify protection plan tab in "PLP" 
	Given I verify saved card section collapsed 
	Given I verify saved shipping address 
	Given I verify saved tax exempt no in payment page 
	Given I verify shipping charges displayed in thank you page 
	Given I verify signed in user is retained 
	Given I verify subtotal text in all pages 
	Given I verify tax calculated is "zero OR not zero" 
	Given I verify terms and conditions in new tab 
	Given I verify that user cannot enter more than 255 char in "special instruction" field 
	Given I verify the "chargeType" charges displayed in right rail 
	Given I verify the "someValue" to service level description for outside 
	Given I verify the calculated shipping charges for "number" line items is "less than or equal" to defined "LIM" 
	Given I verify the calculated shipping charges is "less than or equal" to defined "LIM" 
	Given I verify the different shipping mode for same ship type 
	Given I verify the error message icon to be aligned with it 
	Given I verify the estimated sales tax section 
	Given I verify the given scenario 
	Given I verify the IDM surcharge is applicable or not 
	Given I verify the order of the PODs 
	Given I verify the schedule delivery page and delivery reservation label is retained 
	Given I verify the shipping cost to defined Weight is greater than Threshold applicable 
	Given I verify the Weight is greater than Threshold applicable 
	Given I verify the zip code is retained 
	Given I verify the zip code is retained in the zip code entry field 
	Given I verify zip code is changed to read only text with delivery date 
	Given localized store should be changed 
	Given subtotal displayed in the ATC modal is equivalent to the sum of UnitPrice of all items in cart 
	Given subtotal displayed is the sum of the Item total of all the items in cart 
	Given total is the sum of all the totals 
	Given calendar modal will be opened 
	Given earliest delivery date should be displayed based on delivery FLOC and Zip code displayed as read only text mode 
	Given estimated subtotal is the sum of all the totals 
  