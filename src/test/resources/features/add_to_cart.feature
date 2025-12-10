Feature:Add to cart

  Scenario: Add one quantity to the cart
    Given I am on the Store page
    When I add a "Blue Shoes" to the cart
    Then I should see 1 "Blue Shoes" in the cart

  Scenario Outline: Add one quantity to the cart - examples
    Given I am on the Store page
    When I add a "<product_name>" to the cart
    Then I should see 1 "<product_name>" in the cart
    Examples:
      | product_name      |
      | Blue Shoes        |
      | Blue Denim Shorts |
      | Anchor Bracelet   |