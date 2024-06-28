package org.testing.testScripts;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testing.Base.LaunchApplication;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TC1_DemoApp extends LaunchApplication{

	public void clickOnPreference() {
		driver.findElement(AppiumBy.accessibilityId(pr.getProperty("preference"))).click();
	}
	
	public void clickOnDependecies() {
		driver.findElement(By.xpath(pr.getProperty("dependencies"))).click();
	}
	
	public void clickOnWifiCheckBox() {
		driver.findElement(By.xpath(pr.getProperty("wificheckbox"))).click();
	}
	
	public void clickOnWifiSettings() {
		driver.findElement(By.xpath(pr.getProperty("wifisettings"))).click();
	}
	
	public void enterNameOfYourWifiInThePopUp() {
		driver.setClipboardText("WIFI_NAME_123");	    							// COPIE text
		WebElement text  = driver.findElement(By.id(pr.getProperty("wifipopup")));	// selects 'Wifi Settings'
		text.sendKeys(driver.getClipboardText());									// PASTE text.
	}
	
	public void clickOnOkButton() {
		driver.findElement(By.id(pr.getProperty("wifiokbutton"))).click();
	}
	
	@Test
	public void execution() throws MalformedURLException {
		TC1_DemoApp obj = new TC1_DemoApp();
		obj.configuration("ApiDemo.apk");
		obj.clickOnPreference();
		obj.clickOnDependecies();
		obj.clickOnWifiCheckBox();
		obj.clickOnWifiSettings();
		obj.enterNameOfYourWifiInThePopUp();
		obj.clickOnOkButton();
	}
	
}


