@smoke
Feature: Search Feature

  Scenario Outline: user could search using product name
    When user type product name <itemName>
    And user click on search button
    Then verify url contains <URL>
    And select display per page
    And Count number of search result
    And verify each result contains <searchWord>
    Examples:
      | itemName | URL                                          | searchWord |
      | book     | https://demo.nopcommerce.com/search?q=book   | book       |
      | laptop   | https://demo.nopcommerce.com/search?q=laptop | laptop     |
      | nike     | https://demo.nopcommerce.com/search?q=nike   | nike       |

  Scenario Outline: user could search for product using sku
    When user type serial number <sku>
    And user click on search button
    And user clicks on product
    Then verify result contains <wantedSKU>
    Examples:
      | sku       | wantedSKU |
      | SCI_FAITH | sci_faith |
      | APPLE_CAM | apple     |
      | SF_PRO_11 | sf_pro_11 |
