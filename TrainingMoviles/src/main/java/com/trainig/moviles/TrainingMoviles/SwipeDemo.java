package com.trainig.moviles.TrainingMoviles;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class SwipeDemo {

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = Base.capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='2. Inline']").click();
		driver.findElementByXPath("//*[@content-desc='8']").click();
		

		WebElement elementMinute15 = driver.findElementByXPath("//*[@content-desc='15']");
		WebElement elementMinute45 = driver.findElementByXPath("//*[@content-desc='45']");

		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(longPressOptions().withElement(element(elementMinute15)).withDuration(ofSeconds(2)))
				.moveTo(element(elementMinute45)).release().perform();
	}

}
