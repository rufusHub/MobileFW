package org.testing.testScripts;

import java.net.MalformedURLException;

import org.testing.Base.LaunchApplication;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TC4_DemoApp extends LaunchApplication {
	
	public void clickOnViewsLink() {
		driver.findElement(AppiumBy.accessibilityId(pr.getProperty("views"))).click();
	}

	public void ScrollToLastElement(String text) throws InterruptedException {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" +text+"\"))"));
	    Thread.sleep(2000);
	}
	
	@Test
	public void execution() throws MalformedURLException, InterruptedException {
		TC4_DemoApp obj = new TC4_DemoApp();
		obj.configuration("ApiDemo.apk");
		obj.clickOnViewsLink();
		obj.ScrollToLastElement("WebView");
		
	}
}
