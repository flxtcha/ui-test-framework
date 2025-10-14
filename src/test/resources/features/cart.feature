Feature: Cart

  Scenario: User adds highest priced item to cart
    Given I login as a STANDARD_USER
    When I add the highest priced item to the cart
    Then the shopping cart count should be 1