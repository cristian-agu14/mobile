package com.trainig.moviles.TrainingMoviles;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {
	
	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver;

		File appDir = new File("src\\resources\\apps\\");
		File app = new File(appDir, "ApiDemos-debug.apk");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_2_API_29");
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		return driver;
	}
}
