package br.com.rsinet.hub_tdd.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private static WebElement element = null;
	
	public static WebElement criarCadastro(WebDriver driver) {
		
		element = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]"));
		
		return element;
	}
}
