package org.testing.testScripts;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testing.Base.LaunchApplication;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TC7_GeneralStoreApp extends LaunchApplication {

	public void tc7(String text) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id(pr.getProperty("namefield"))).sendKeys("Rodrigo");
		driver.findElement(By.id(pr.getProperty("radiomale"))).click();
		driver.findElement(By.id(pr.getProperty("text1"))).click();
//		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" +text+"\"))"));
	    driver.findElement(By.xpath(pr.getProperty("argentinaonlista"))).click();
	    driver.findElement(By.id(pr.getProperty("letshopbutton"))).click();
    }
	
	@Test
	public void execution() throws MalformedURLException, InterruptedException {
		TC7_GeneralStoreApp obj = new TC7_GeneralStoreApp();
		obj.configuration("GeneralStore.apk");
		obj.tc7("Argentina");
		
	}
}







