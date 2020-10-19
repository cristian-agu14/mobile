package com.training.moviles.app.ecomerce;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EcomerceTc4 {

	private Double total = 0.0;

	@Test
	public void probarCantidad() throws MalformedURLException {
		List<Double> listaValores = new ArrayList<Double>();
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

		int tamanioCarrito = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		for (int i = 0; i < tamanioCarrito; i++) {

			if (driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).isDisplayed()) {
				String valorProducto = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"))
						.get(i).getText();
				System.out.println("=========================" + valorProducto);

				valorProducto = valorProducto.substring(1);
				System.out.println(valorProducto);
				Double valor = Double.parseDouble(valorProducto);
				listaValores.add(valor);

			}

		}
		listaValores.forEach(v -> System.out.println("Valor: " + v));

		String valorEnPantalla = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText()
				.substring(1);
		Double valorPantalla = Double.parseDouble(valorEnPantalla);

		Assert.assertEquals(sumarValores(listaValores), valorPantalla);

	}

	public Double sumarValores(List<Double> listaValores) {
		Double total = 0.0;
		for (Double double1 : listaValores) {
			total = total + double1;
		}

		return total;
	}

}
