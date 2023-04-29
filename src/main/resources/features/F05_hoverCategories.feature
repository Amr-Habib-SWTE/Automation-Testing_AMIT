@smoke
Feature: hoverCategories

  Scenario:
    Given hover on the selected category
    And  select random one of the three sub categories
    Then verify sub-category title is equal or contains the one you get
