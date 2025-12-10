Feature: Place an order

  Scenario: Using default payment option
    Given I am a guest customer
    And My billing details are
      | firstname | lastname | country            | address_line1     | city  | state | zip  | email             |
      | demo      | user     | United States (US) | 6300 Spring Creek | Plano | Texas | 12998 | musampa@gmail.com |
    And I have a product in the cart
    And I am on the Checkout page
    When I provide billing details
      #i want to read this info in "My billing details are"
      # | firstname | lastname | country            | address_line1     | city  | state | zip  | email             |
      # | demo      | user     | United States (US) | 6300 Spring Creek | Plano | Texas | 12998 | musampa@gmail.com |
    And I place an order
    Then the order should be placed successfully
