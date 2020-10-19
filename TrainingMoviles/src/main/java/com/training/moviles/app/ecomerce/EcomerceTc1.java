package com.training.moviles.app.ecomerce;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EcomerceTc1 {

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = Base.capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementById("android:id/text1").click();
		driver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Colombia\"));"));
		driver.findElementByXPath("//android.widget.TextView[@text='Colombia']").click();
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("Cristian");
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

	}

}
