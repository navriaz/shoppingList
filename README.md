# shoppingList
The test project consists of:
  1. Page objects
  2. Step definitions
  3. Class to run test via Maven
  4. Shopping list feature file
  
 - Page objects contain the components, methods and locators associated with each of the pages of the app. Created a class called `BasePage.java`. All page object classes will extend the BasePage, thus inheriting all the base methods. The inheriting classes are `MyShoppingListPage.java` and `OIShoppingListMenuPage.java`.
 - `StepDefinitions.java` contains the definition of all the steps to execute in the feature file.
 - The class `RunCukesTest.java` allows Maven to hook into Cucumber and ensure that our Cucumber scenarios can be run as part of a Maven build process.
 - The `Shoppinglist.feature` file contains the test scenarios to run.
 
To run tests:
  - Connect device and on terminal give the command `adb devices` to ensure device is detected.
  - Start the Appium server by running the following command `appium`.
  - Then can run the tests in two ways:
      - From the project root (where pom.xml resides) using command `mvn clean test`
      - From `Shoppinglist.feature` file in Eclipse. Head over to the feature file and right click on the first line of the     feature and select `Run as > 1 Cucumber Feature`.
