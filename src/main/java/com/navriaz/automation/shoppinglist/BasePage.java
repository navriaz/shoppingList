package com.navriaz.automation.shoppinglist;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    AppiumDriver driver;
    WebDriverWait wait;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 100);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void waitForElementToAppear(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}