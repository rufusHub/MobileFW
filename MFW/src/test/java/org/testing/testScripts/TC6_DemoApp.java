package org.testing.testScripts;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testing.Base.LaunchApplication;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TC6_DemoApp extends LaunchApplication{
	
	public void clickOnOS() {
		driver.findElement(AppiumBy.accessibilityId(pr.getProperty("os"))).click();
	}
	public void SMSmessaging() {
		driver.findElement(AppiumBy.accessibilityId(pr.getProperty("smsmessaging"))).click();
	}
	public void clickOnEnableSMScheckbox() {
		driver.findElement(By.className(pr.getProperty("smscheckbox"))).click();
	}
	public void enterRecipient() {
		driver.findElement(By.id(pr.getProperty("smsrecipient"))).sendKeys("Rodrigo");
	}
	public void copyMessageIntomsgBody() {
		driver.setClipboardText("Message test 1");	    										// COPIE text
		WebElement text  = driver.findElement(By.id(pr.getProperty("smscontent")));	// selects 'Wifi Settings'
		text.sendKeys(driver.getClipboardText());	
	}

	@Test
	public void execution() throws MalformedURLException, InterruptedException {
		TC6_DemoApp obj = new TC6_DemoApp();
		obj.configuration("ApiDemo.apk");
		obj.clickOnOS();
		obj.SMSmessaging();
		obj.clickOnEnableSMScheckbox();
		obj.enterRecipient();
		obj.copyMessageIntomsgBody();
	}
}







