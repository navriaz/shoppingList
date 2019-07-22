package com.navriaz.automation.shoppinglist;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.File;
import java.net.URL;
//import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;

import org.junit.runner.RunWith;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resource"}
)
public class RunCukesTest {
	protected AppiumDriver driver;
	
	@Before
	public void setup() throws MalformedURLException {
		File filePath = new File(System.getProperty("user.dir"));
        File appDir = new File(filePath, "/app");
        File app = new File(appDir, "org.openintents.shopping_100213.apk");

        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dc.setCapability(MobileCapabilityType.DEVICE_NAME, "TestDevice");
        dc.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
	}
	
	@After
    public void tearDown() {
        driver.quit();
    }
}
