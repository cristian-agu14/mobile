package com.training.moviles.app.ecomerce;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;

public class HybridApp {

	@Test
	public void probarCantidad() throws MalformedURLException {

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
		driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[2]").click();
		driver.findElementByXPath("(//android.widget.TextView[@text='ADD TO CART'])[1]").click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		WebElement checkBox = driver.findElementByClassName("android.widget.CheckBox");
		WebElement textTermimosYcondic = driver.findElementByXPath("//*[@text='Please read our terms of conditions']");

		TouchAction touchAction = new TouchAction<>(driver);
		touchAction.tap(TapOptions.tapOptions().withElement(element(checkBox))).perform();

		touchAction.longPress(longPressOptions().withElement(element(textTermimosYcondic)).withDuration(ofSeconds(2)))
				.release().perform();

		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
			System.out.println(contextName); // prints out something like NATIVE_APP \n WEBVIEW_1
		}

		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("Hello world");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));

	}

}
