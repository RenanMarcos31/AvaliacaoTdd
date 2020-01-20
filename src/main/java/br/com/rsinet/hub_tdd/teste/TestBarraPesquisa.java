package br.com.rsinet.hub_tdd.teste;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.page_objects.PelaBarra;
import br.com.rsinet.hub_tdd.utils.Constant;
import br.com.rsinet.hub_tdd.utils.DriverFacture;
import br.com.rsinet.hub_tdd.utils.ExcelUtils;
import br.com.rsinet.hub_tdd.utils.Generator;
import br.com.rsinet.hub_tdd.utils.Print;

public class TestBarraPesquisa {

	public static WebDriver driver = null;
	public static WebDriverWait wait;

	@Before
	public void start() throws Exception {
		driver = DriverFacture.createChrome();
		wait = new WebDriverWait(driver, 10);
		ExcelUtils.setExcelFile(Constant.File_TestData, "renan");
	}

	@Test
	public void pesquisa() throws Exception {

		wait.until(ExpectedConditions.visibilityOf(PelaBarra.botaoLupa(driver)));
		PelaBarra.botaoLupa(driver).click();

		PelaBarra.barraPesquisa(driver).sendKeys(ExcelUtils.getCellData(1, 0) + Keys.ENTER);

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", PelaBarra.clickProducto(driver));

		Assert.assertTrue(driver.getPageSource().contains(ExcelUtils.getCellData(1, 0).toUpperCase()));
	}

	@Test
	public void pesquisaFalhou() throws Exception {

		wait.until(ExpectedConditions.visibilityOf(PelaBarra.botaoLupa(driver)));
		PelaBarra.botaoLupa(driver).click();

		PelaBarra.barraPesquisa(driver).sendKeys(ExcelUtils.getCellData(1, 1) + Keys.ENTER);
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", PelaBarra.clickProducto(driver));
		} catch (Exception e) {
			Assert.assertTrue(driver.getPageSource().contains("No results for \"" + ExcelUtils.getCellData(1, 1)+ "\""));
		}
	}

	@After
	public void FechaBrowser() throws Exception {
		Print.PrintScreenShot(driver, "target/print/" + Generator.dateHourPath() + "print.png");
		driver.close();
	}
}
