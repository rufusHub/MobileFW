package org.testing.testScripts;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testing.Base.LaunchApplication;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class TC3_DemoApp extends LaunchApplication{

	public void clickOnViewsLink() {
		driver.findElement(AppiumBy.accessibilityId(pr.getProperty("views"))).click();
	}
	public void clickOnExpandableLists() {
		driver.findElement(By.xpath(pr.getProperty("expandablelists"))).click();
	}
	public void clickOnCustomAdapter() {
		driver.findElement(By.xpath(pr.getProperty("customadapter"))).click();
	}
	public void longPressOnPeopleNames() {
		WebElement ele = driver.findElement(By.xpath(pr.getProperty("peoplenames")));
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(),"duration",2000)); 
	}
	public void verifyPopUp() {
		String result = driver.findElement(By.xpath(pr.getProperty("samplemenu"))).getAttribute("text");
		System.out.println(result);
	}
	
	@Test
	public void execution() throws MalformedURLException {
		TC3_DemoApp obj = new TC3_DemoApp();
		obj.configuration("ApiDemo.apk");
		obj.clickOnViewsLink();
		obj.clickOnExpandableLists();
		obj.clickOnCustomAdapter();
		obj.longPressOnPeopleNames();
		obj.verifyPopUp();
		
	}
}






