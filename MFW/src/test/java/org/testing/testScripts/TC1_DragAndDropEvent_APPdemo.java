package org.testing.testScripts;

import org.testng.annotations.Test;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testing.Base.LaunchApplication;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class TC1_DragAndDropEvent_APPdemo extends LaunchApplication{
	
	public void DragAndDrop_TC() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement source =  driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) source).getId(),
			    "endX", 619,
			    "endY", 577
			));
		Thread.sleep(5000);
		
		String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		System.out.println("Result is " + result);
	}
	
	@Test
	public void execution() throws MalformedURLException, InterruptedException {
		TC1_DragAndDropEvent_APPdemo obj = new TC1_DragAndDropEvent_APPdemo();
		obj.configuration("ApiDemo.apk");
		obj.DragAndDrop_TC();
		
	}
}
