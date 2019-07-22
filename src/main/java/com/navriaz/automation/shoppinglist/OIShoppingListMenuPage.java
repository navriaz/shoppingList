package com.navriaz.automation.shoppinglist;

import io.appium.java_client.AppiumDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.navriaz.automation.shoppinglist.BasePage;


public class OIShoppingListMenuPage extends BasePage {
	
	 @FindAll(@FindBy(id = "left_drawer"))
	 private List<WebElement> menuList;
	 
	 @FindBy(id = "action_bar")
	 private WebElement actionBar;
	 
	 @FindBy(className = "android.widget.ImageButton")
	 private WebElement backArrowButton;
	 	 
	 @FindBy(id = "alertTitle")
	 private WebElement alertTitle;
	 
	 @FindBy(id = "edittext")
	 private WebElement alertEditext;
	 
	 @FindBy(id = "button1")
	 private WebElement alertOKButton;
	 
	 @FindBy(id = "button2")
	 private WebElement alertCancelButton;
	  
	 public OIShoppingListMenuPage(AppiumDriver driver) {
	        super(driver);
	    }

	 public void waitForOIShoppingListPageToLoad() {
		 waitForElementToAppear(menuList.get(menuList.size() - 1));
		 waitForElementToAppear(actionBar.findElement(By.className("android.widget.ImageButton")));
	     waitForElementToAppear(actionBar.findElements(By.className("android.widget.TextView")).get(0));
	 }
	 
	 public boolean isDisplayed(String text) {
		 String listName = actionBar.findElements(By.className("android.widget.TextView")).get(0).getText();
		 return listName.contains(text);
	 }
	 
	 public void tapAddNewListIcon() {
		 menuList.get(menuList.size() - 1).click();
	 }
	 
	 public boolean isAddListAlertDisplayed() {
		 return alertTitle.isDisplayed() 
				 && alertEditext.isDisplayed() 
				 && alertOKButton.isDisplayed()
				 && alertCancelButton.isDisplayed(); 
	 }
	 
	 public void enterListname(String listName) {
		 alertEditext.sendKeys(listName);
	 }
	 
	 public MyShoppingListPage tapAlertOKButton() {
		 alertOKButton.click();
		 MyShoppingListPage shoppingListPage = new MyShoppingListPage(driver);
		 return shoppingListPage;
	 }
	 
	 public MyShoppingListPage tapAlertCancelButton() {
		 alertCancelButton.click();
		 MyShoppingListPage shoppingListPage = new MyShoppingListPage(driver);
		 return shoppingListPage;
	 }
	 
	 
}