package br.com.rsinet.hub_tdd.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PelaBarra {

	public WebDriver driver;
	
	private static WebElement element = null;
	
	public PelaBarra(WebDriver driver) {
		this.driver = driver;
	}
	
	public static WebElement botaoLupa(WebDriver driver) {
		element = driver.findElement(By.id("menuSearch"));
		return element;
	}
	
	public static WebElement barraPesquisa(WebDriver driver) {
		element = driver.findElement(By.id("autoComplete"));
		return element;
	}
	
	public static WebElement clickProducto(WebDriver driver) {
		element = driver.findElement(By.id("16"));
		return element;
	}
}
