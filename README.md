# shoppingList
The test project consists of:
  1. Page objects
  2. Step definitions
  3. Class to run test via Maven
  4. Shopping list feature file
  
 - Page objects contain the components, methods and locators associated with each of the pages of the app. Created a class called `BasePage.java`. All page object classes will extend the BasePage, thus inheriting all the base methods. The inheriting classes are `MyShoppingListPage.java` and `OIShoppingListMenuPage.java`.
 - `StepDefinitions.java` contain the defnition of all the steps to execute in the feature file
 - The class `RunCukesTest.java` allows Maven to hook into Cucumber and ensure that our Cucumber scenarios can be run as part of a Maven build process.
 - The `Shoppinglist.feature` file contains the test scenarios to run.
 
 Can run tests in two ways:
  - Run the tests from the project root (where pom.xml resides) using command `mvn clean test`
  - Run the tests from `Shoppinglist.feature` file in Eclipse. Head over to the feature file and right click on the first line of the feature and select `Run as > 1 Cucumber Feature`
