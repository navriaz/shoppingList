Feature: Shopping list

Scenario: Create two lists and add items then delete an item
    Given I am on the My Shopping list page 
    When I create a list with name "List1"
    Then I add items "itemA,itemB" to the list
    When I create a list with name "List2"
    Then I add items "itemC,itemD" to the list
    Then I delete an item from the list
    
Scenario: Create a list and then sort it
    Given I am on the My Shopping list page 
    When I create a list with name "List1"
    Then I add items "R,B,S" to the list
    Then I sort the list
    Then I validate the list is sorted
    