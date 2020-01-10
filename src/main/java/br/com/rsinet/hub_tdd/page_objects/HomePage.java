package br.com.rsinet.hub_tdd.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private static WebElement element = null;
	
	public static WebElement botaoLogin(WebDriver driver) {
		
		element = driver.findElement(By.id("menuUserLink"));
		
		return element;
	}
}
