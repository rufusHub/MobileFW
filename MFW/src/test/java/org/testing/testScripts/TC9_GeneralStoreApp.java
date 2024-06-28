package org.testing.testScripts;

import java.net.MalformedURLException;
import java.text.DecimalFormat;

import org.openqa.selenium.By;
import org.testing.Base.LaunchApplication;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TC9_GeneralStoreApp extends LaunchApplication{
	
	public void enterStore(String text) throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.id(pr.getProperty("namefield"))).sendKeys("Rodrigo");
		driver.findElement(By.id(pr.getProperty("radiomale"))).click();
		driver.findElement(By.id(pr.getProperty("text1"))).click();
//		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" +text+"\"))"));
	    driver.findElement(By.xpath(pr.getProperty("argentinaonlista"))).click();
	    driver.findElement(By.id(pr.getProperty("letshopbutton"))).click();
    }
	
	
	public void tc9(String text1, String text2) throws InterruptedException {
//		Scroll to item 1 - get price - add it to cart
//	    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 9 Retro\"))"));
	    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" +text1+"\"))"));
	    String price1 = driver.findElement(By.xpath(pr.getProperty("price1"))).getAttribute("text");
	    System.out.println(price1);
	    driver.findElement(By.xpath(pr.getProperty("addcart"))).click();

//	    Scroll to item 2 - get price - add it to cart
//	    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan Lift Off\"))"));
	    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" +text2+"\"))"));
	    String price2 = driver.findElement(By.xpath(pr.getProperty("price2"))).getAttribute("text");
	    System.out.println(price2);
	    driver.findElement(By.xpath(pr.getProperty("productaddcart"))).click();
	    
//	    Enter to Cart
	    driver.findElement(By.id(pr.getProperty("btncart"))).click();
	    Thread.sleep(4000);
	    String totalPrice = driver.findElement(By.xpath(pr.getProperty("totalamount"))).getAttribute("text");
	    System.out.println(totalPrice);
	    
//	    Sum price1 and price2
	    double num1 = Double.parseDouble(price1.replace("$", ""));
	    double num2 = Double.parseDouble(price2.replace("$", ""));
	    double total = Double.parseDouble(totalPrice.replace("$", ""));
	    double sum = num1 + num2;
	    DecimalFormat decimalFormat = new DecimalFormat("$ #,##0.00");
	    String formattedSum = decimalFormat.format(sum);
	    System.out.println(formattedSum);
	    if (total == sum) {
	    	System.out.println("Prices are the same, test passed!");
	    }
	    else {
	    	System.out.println("Prices are not the same, the is a bug in the APP!");
	    }

	}
	
	@Test
	public void execution() throws MalformedURLException, InterruptedException {
		TC9_GeneralStoreApp obj = new TC9_GeneralStoreApp();
		obj.configuration("GeneralStore.apk");
		obj.enterStore("Argentina");
		obj.tc9("Air Jordan 9 Retro", "Jordan Lift Off");
		
	}

}



	
	










	
	