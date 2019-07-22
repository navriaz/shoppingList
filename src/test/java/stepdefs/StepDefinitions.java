package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import com.navriaz.automation.shoppinglist.MyShoppingListPage;
import com.navriaz.automation.shoppinglist.OIShoppingListMenuPage;

import io.appium.java_client.AppiumDriver;

public class StepDefinitions {
	
	AppiumDriver driver;
	
	@Given("I am on the My Shopping list page")
	public void i_am_on_the_my_shoppinglist_page() {
		 MyShoppingListPage shoppingListPage = new MyShoppingListPage(driver);
		 shoppingListPage.waitForMyShoppingListPageToLoad();
		 Assert.assertTrue("My Shopping List is not loaded", shoppingListPage.isDisplayed("My Shopping list"));
	}

	@When("I create a list with name {string}")
	public void i_create_a_list_with_name(String listName) {
		MyShoppingListPage shoppingListPage = new MyShoppingListPage(driver);
		OIShoppingListMenuPage shoppingListMenu = shoppingListPage.openNavigationMenu();
		
		shoppingListMenu.waitForOIShoppingListPageToLoad();
		Assert.assertTrue("OI Shopping List page is not loaded", shoppingListMenu.isDisplayed("OI Shopping List"));
		
		shoppingListMenu.tapAddNewListIcon();
		Assert.assertTrue("Alert to add new list is not displayed", shoppingListMenu.isAddListAlertDisplayed());
		
		shoppingListMenu.enterListname(listName);
		MyShoppingListPage newList = shoppingListMenu.tapAlertOKButton();
		
		Assert.assertTrue("Newly added list is not displayed", newList.isDisplayed(listName));
	}

	@Then("I add items {string} to the list")
	public void i_add_items_to_list(String Items) {
		MyShoppingListPage list = new MyShoppingListPage(driver);
		String[] arrOfItems = Items.split(",");
		int itemsToAdd = arrOfItems.length;
		for (String item : arrOfItems) {
			list.addItem(item);			
		}
		
		int numberOfListItemsAdded = list.getNumberOfListItems();
		
		Assert.assertEquals("Added items do not appear in list", itemsToAdd, numberOfListItemsAdded);
	}
	
	@Then("I delete an item from the list")
	public void i_delete_items_from_list(String Items) {
		MyShoppingListPage list = new MyShoppingListPage(driver);
		int numberOfListItems = list.getNumberOfListItems();
		list.deleteItem(0);
		int numberOfListItemsAfterDeletion = list.getNumberOfListItems();
		Assert.assertNotEquals("Deleted item is appearing on the list", numberOfListItems, numberOfListItemsAfterDeletion, 1);
	}
	
	@Then("I sort the list")
	public void i_sort_the_list() {
		MyShoppingListPage list = new MyShoppingListPage(driver);
		Assert.assertTrue("Failed to sort list", list.sortList());
	}
	
	@Then("I validate the list is sorted")
	public void i_validate_list_is_sorted() {
		MyShoppingListPage list = new MyShoppingListPage(driver);
		String[] listItems = list.getListItems();
		Assert.assertTrue("List is not sorted", list.isSorted(listItems));	
	}
}
