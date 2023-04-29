@smoke
Feature:user could add products to wishlist

  Scenario: success message is visible after adding product to wishlist
    When user add product to wishlist
    Then wishlist notification success is visible

  Scenario: number of wishlist items in home page is increased
    When user add product to wishlist
    Then wishlist notification success is visible
    And user get the number of wishlist items after adding product
    Then number of wishlist items increased

  Scenario: added products are displayed on wishlist page
    When user add product to wishlist
    Then wishlist notification success is visible
    And user get the number of wishlist items after adding product
    And user go to wishlist page
    Then number of quantities are greater than zero in wishlist page
