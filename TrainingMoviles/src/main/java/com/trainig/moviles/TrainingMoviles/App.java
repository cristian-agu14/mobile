package com.trainig.moviles.TrainingMoviles;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = Base.capabilities();

		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		driver.findElementById("android:id/checkbox").click();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementById("android:id/edit").sendKeys("Hola mundo");
		driver.findElementById("android:id/button1").click();

	}
}
