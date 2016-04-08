@OtherExamples
Feature: Feature to show other examples

  Background: 
    Given Beehive is down
    And Voltage service is up and running

  @Beehive1
  Scenario Outline: Place order using a NEW Credit Card as Guest user
    Given I am a "Guest" user on the xyz.com
    When I place <order> order using New <credit> + <gift> Card
    Then the order status must be <status>

    Examples: Order & Credit Card Type
      | order           | credit        | gift    | status  |
      | STH             | VISA          | no GIFT | success |
      | BOSS            | MASTER        | no GIFT | success |
      | BOPIS           | AMEX          | no GIFT | success |
      | Blinds          | Discover      | no GIFT | success |
      | Appliance       | VISA          | no GIFT | success |
      | Blinds          | VISA          | GIFT    | success |
      | STH + Appliance | AMEX          | GIFT    | success |
      | STH             | PLCC Consumer | no GIFT | success |
      | BOSS            | PLCC Consumer | no GIFT | success |
      | Appliance       | LCC Proxy     | no GIFT | success |

  @DocStringBackground1
  Scenario Outline: Test Doc String With background and Iteration TC 1
    Given I am a "Guest" user on the xyz.com
    When I place <order> order using card
      """
        Testing Doc String 1
        Testing line 2 Doc String 1
      """
    And I should see an "error" message in the "payment" page for card <card>:
      """
      Sorry, we were unable to verify your card information. Please confirm your billing address and card security ID and try again, or try another card
      2nd line testing for Doc String example
      """
    And "Billing info"  and card <card> is asked to confirm

    Examples: 
      | card   | order   | HD   |
      | Visa   | order 1 | HD 1 |
      | Master | order 2 | HD 2 |

  
