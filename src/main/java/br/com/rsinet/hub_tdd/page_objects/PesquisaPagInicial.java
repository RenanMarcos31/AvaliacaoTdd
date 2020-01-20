package br.com.rsinet.hub_tdd.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PesquisaPagInicial {

	public WebDriver driver;

	private static WebElement element = null;

	public void paginaInicial(WebDriver driver) {
		this.driver = driver;
	}

	public static WebElement speakers(WebDriver driver) {
		element = driver.findElement(By.id("speakersImg"));
		return element;
	}

	public static WebElement produto(WebDriver driver) {
		element = driver.findElement(By.id("20"));
		return element;
	}

	public static WebElement verDetalhes(WebDriver driver) {
		element = driver.findElement(By.id("details_10"));
		return element;
	}
	
}
