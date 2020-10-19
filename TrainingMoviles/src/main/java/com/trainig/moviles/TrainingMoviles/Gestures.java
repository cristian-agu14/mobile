package com.trainig.moviles.TrainingMoviles;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Gestures {

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = Base.capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		// driver.findElementByXPath("//android.widget.TextView[@text='Expandable
		// Lists']").click();
		TouchAction touchAction = new TouchAction(driver);
		WebElement expandList = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
		touchAction.tap(tapOptions().withElement(element(expandList))).perform();
		driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
		WebElement pn = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
		touchAction.longPress(longPressOptions().withElement(element(pn)).withDuration(ofSeconds(2))).release()
				.perform();
		// try {
		// TimeUnit.SECONDS.sleep(2);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }

		//Assert.assertTrue(driver.findElementByXPath("//android.widget.TextView[@text='Sample menu']").isDisplayed());
		System.out.println(driver.findElementByXPath("//android.widget.TextView[@text='Sample menu']").isDisplayed());
	}

}
