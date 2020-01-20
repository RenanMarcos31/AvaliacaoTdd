package br.com.rsinet.hub_tdd.teste;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.page_objects.PesquisaPagInicial;
import br.com.rsinet.hub_tdd.utils.DriverFacture;
import br.com.rsinet.hub_tdd.utils.Generator;
import br.com.rsinet.hub_tdd.utils.Print;

public class TestPaginaInicial {

	public static WebDriver driver = null;
	
	@Before
	public void starting() {
		driver = DriverFacture.createChrome();
	}
	
	@Test
	public void pesquisa() throws Exception {
		
		PesquisaPagInicial.speakers(driver).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(PesquisaPagInicial.produto(driver)));
		PesquisaPagInicial.produto(driver).click();
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", PesquisaPagInicial.produto(driver));
       
	}
	
	@Test
	public void pesquisaFalha() throws Exception  {
		
		//Print.PrintScreenShot(driver, "target/print/" + Generator.dateHourPath() + "print.png");
		
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.visibilityOf(PesquisaPagInicial.verOferta(driver)));
		PesquisaPagInicial.verDetalhes(driver).click();
		
	}
	
	@After
	public void closeBrowser() throws Exception {
		Print.PrintScreenShot(driver, "target/print/" + Generator.dateHourPath() + "print.png");
		driver.close();
	}
}
