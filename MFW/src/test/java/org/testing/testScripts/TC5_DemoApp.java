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

public class TC5_DemoApp extends LaunchApplication {

	public void clickOnViewsLink() {
		driver.findElement(AppiumBy.accessibilityId(pr.getProperty("views"))).click();
	}
	
	public void clickOnGallery() {
		driver.findElement(AppiumBy.accessibilityId(pr.getProperty("gallery"))).click();
	}
	
	public void clickOn1Photos() {
		driver.findElement(By.xpath(pr.getProperty("1photos"))).click();
	}
	
	public void getElementCallActio() throws InterruptedException {
		WebElement firstImage=driver.findElement(By.xpath(pr.getProperty("imageview1")));
		swipeAction(firstImage, "left");
	}
	
	public void swipeAction(WebElement element,String direction) throws InterruptedException{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",((RemoteWebElement)element).getId(),
				"left", 100, "top", 100, "width", 1000, "height", 200,
				"direction", direction,
				"percent", 1.0,"speed",15000
		));	
	}
	
	@Test
	public void execution() throws MalformedURLException, InterruptedException {
		TC5_DemoApp obj = new TC5_DemoApp();
		obj.configuration("ApiDemo.apk");
		obj.clickOnViewsLink();
		obj.clickOnGallery();
		obj.clickOn1Photos();
		obj.getElementCallActio();
	}
	
}





