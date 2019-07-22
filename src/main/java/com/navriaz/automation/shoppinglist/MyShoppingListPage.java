package com.navriaz.automation.shoppinglist;

import io.appium.java_client.AppiumDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.navriaz.automation.shoppinglist.BasePage;

public class MyShoppingListPage extends BasePage {
	
	 @FindBy(id = "list_items")
	 private List<WebElement> listItems;
	 
	 @FindBy(id = "autocomplete_add_item")
	 private WebElement addEditText;
	 
	 @FindBy(id = "button_add_item")
	 private WebElement addButton;
	 
	 @FindBy(id = "check")
	 private WebElement checkBox;
	 
	 @FindBy(id = "action_bar")
	 private WebElement actionBar;
	 	 	 	 
	 
	 public MyShoppingListPage(AppiumDriver driver) {
	        super(driver);
	 }

	 public void waitForMyShoppingListPageToLoad() {
	        waitForElementToAppear(addButton);
	        waitForElementToAppear(addEditText);
	        waitForElementToAppear(actionBar.findElement(By.className("android.widget.ImageButton")));
	        waitForElementToAppear(actionBar.findElements(By.className("android.widget.TextView")).get(0));
	 }
	 
	 public boolean isDisplayed(String text) {
		 String listName = actionBar.findElements(By.className("android.widget.TextView")).get(0).getText();
		 return listName.contains(text);
	 }
	 
	 public OIShoppingListMenuPage openNavigationMenu() {
		 WebElement navigationMenuButton = actionBar.findElement(By.className("android.widget.ImageButton"));
		 navigationMenuButton.click();
		 OIShoppingListMenuPage shoppingListMenu = new OIShoppingListMenuPage(driver);
		 return shoppingListMenu;
	 } 
	 
	 public void addItem(String item) {
		 addEditText.sendKeys(item);
		 addButton.click();
	 }
	 
	 public int getNumberOfListItems() {
		 return listItems.size();
	 }
	 
	 public String[] getListItems() {
		 String[] arrOflistItems = {};
		 for (int i = 0; i < listItems.size(); i++) {
			 arrOflistItems[i] = listItems.get(i).getText();
		 }
		 
	     return arrOflistItems;
	 }
	 
	 public boolean isSorted(String[] list) {
		 String previous = "";
		 for (final String  current: list) {
			 if (current.compareTo(previous) < 0)
				 return false;
			 previous = current;
		 }
		 
		 return true;	 
	 }
	 
	 public void deleteItem(int atIndex) {
		 WebElement checkBox = listItems.get(atIndex).findElement(By.id("check"));
		 WebElement deleteButton = actionBar.findElements(By.className("android.widget.TextView")).get(2);
		 checkBox.click();
		 if (checkBox.isSelected()) {
			 deleteButton.click();	
		 }
	 }
	 
	 public boolean sortList() {
		 if (addButton.getText().contains("ADD")) {
			 addButton.click();
			 if (addButton.getText().contains("SHOPPING")) {
				 return true; 
			 }	
			 return false;
		 } 
		 return false;
	 }
}