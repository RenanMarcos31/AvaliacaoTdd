package br.com.rsinet.hub_tdd.teste;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.page_objects.HomePage;
import br.com.rsinet.hub_tdd.page_objects.LoginPage;

public class Cadastro {

	private static WebDriver driver = null;
	
	public static void main(String[] args)  {
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.advantageonlineshopping.com/#/");
		
		HomePage.botaoLogin(driver).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(LoginPage.criarCadastro(driver)));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",LoginPage.criarCadastro(driver));
		
		System.out.println("Janela aberta com sucesso"); 
		
		driver.quit();
	}
}
