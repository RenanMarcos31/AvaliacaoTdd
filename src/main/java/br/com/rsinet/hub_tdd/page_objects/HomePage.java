package br.com.rsinet.hub_tdd.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;

	private static WebElement element = null;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public static WebElement botaoLogin(WebDriver driver) {

		element = driver.findElement(By.id("menuUserSVGPath"));

		return element;
	}

	public static WebElement criarCadastro(WebDriver driver) throws Exception{

		element = driver.findElement(By.linkText("CREATE NEW ACCOUNT"));
		return element;
	}
}
