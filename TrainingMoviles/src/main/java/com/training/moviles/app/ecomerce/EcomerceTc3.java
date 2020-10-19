package com.training.moviles.app.ecomerce;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EcomerceTc3 {

	@Test
	public void probarBuy() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = Base.capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("android:id/text1").click();
		driver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Colombia\"));"));
		driver.findElementByXPath("//android.widget.TextView[@text='Colombia']").click();
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Cristian");
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		driver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"PG 3\"));"));
		driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[1]").click();
		//Assert.assertEquals("Please enter your name", toastMessage);

//		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
//		for (int i = 0; i < count; i++){
//			String text = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
//			if (text.equalsIgnoreCase("Jordan 6 Rings")){
//				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
//				break;
//			}
//		}						                
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		String lastpageText = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals("PG 3", lastpageText);

	}

}
