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

public class TC2_LongPressEvent_APPdemo extends LaunchApplication{

	public void LongPress() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Custom Adapter']")).click();
		WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(),"duration",2000)); 
		Thread.sleep(2000);		
	}
	
	@Test
	public void execution() throws MalformedURLException, InterruptedException {
		TC2_LongPressEvent_APPdemo obj = new TC2_LongPressEvent_APPdemo();
		obj.configuration("ApiDemo.apk");
		obj.LongPress();
	}
}
