package com.training.moviles.app.ecomerce;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;

@RunWith(JUnit4.class)
public class EcomerceTc2 {

	// public static void main(String[] args) throws MalformedURLException {
	// probbarToast();
	//
	// }
	@Test
	public void probbarToast() throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = Base.capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();

		String toastMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		System.out.println(toastMessage);
		Assert.assertEquals("Please enter your name", toastMessage);

	}
	

}
