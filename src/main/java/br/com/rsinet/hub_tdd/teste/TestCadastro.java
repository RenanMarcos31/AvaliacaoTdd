package br.com.rsinet.hub_tdd.teste;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.page_objects.InicioCadastro;
import br.com.rsinet.hub_tdd.page_objects.DadosCadastro;
import br.com.rsinet.hub_tdd.utils.Constant;
import br.com.rsinet.hub_tdd.utils.DriverFacture;
import br.com.rsinet.hub_tdd.utils.ExcelUtils;
import br.com.rsinet.hub_tdd.utils.Generator;
import br.com.rsinet.hub_tdd.utils.Print;

public class TestCadastro {

	public static WebDriver driver = null;
	public static WebDriverWait wait;

		@Before
		public void start() {
			driver = DriverFacture.createChrome();
			wait = new WebDriverWait(driver, 10);
		}

	@Test
	public void cadastroSucesso() throws Exception {
		
		InicioCadastro.botaoLogin(driver).click();
		InicioCadastro.criarCadastro(driver).sendKeys(Keys.ENTER);

		ExcelUtils.setExcelFile(Constant.File_TestData, "Planilha3");

		DadosCadastro.nomeUsuario(driver).sendKeys(ExcelUtils.getCellData(1, 0));
		DadosCadastro.email(driver).sendKeys(ExcelUtils.getCellData(1, 1));
		DadosCadastro.senha(driver).sendKeys(ExcelUtils.getCellData(1, 2));
		DadosCadastro.confirmaSenha(driver).sendKeys(ExcelUtils.getCellData(1, 3));
		DadosCadastro.primeiroNome(driver).sendKeys(ExcelUtils.getCellData(1, 4));
		DadosCadastro.ultimoNome(driver).sendKeys(ExcelUtils.getCellData(1, 5));
		DadosCadastro.telefone(driver).sendKeys(ExcelUtils.getCellData(1, 6));
		DadosCadastro.pais(driver);
		DadosCadastro.cidade(driver).sendKeys(ExcelUtils.getCellData(1, 8));
		DadosCadastro.endereco(driver).sendKeys(ExcelUtils.getCellData(1, 9));
		DadosCadastro.estado(driver).sendKeys(ExcelUtils.getCellData(1, 10));
		DadosCadastro.botaoAceito(driver).click();
		DadosCadastro.botaoRegistrar(driver).click();
		wait.until(ExpectedConditions.urlToBe("https://www.advantageonlineshopping.com/#/"));
		Assert.assertTrue(driver.getPageSource().contains(ExcelUtils.getCellData(1, 0)));
		
	}

	@Test
	public void cadastroFalhando() throws Exception {
		
		InicioCadastro.botaoLogin(driver).click();
		InicioCadastro.criarCadastro(driver).sendKeys(Keys.ENTER);

		ExcelUtils.setExcelFile(Constant.File_TestData, "Planilha1");

		DadosCadastro.nomeUsuario(driver).sendKeys(ExcelUtils.getCellData(1, 0));
		DadosCadastro.email(driver).sendKeys(ExcelUtils.getCellData(1, 1));
		DadosCadastro.senha(driver).sendKeys(ExcelUtils.getCellData(1, 2));
		DadosCadastro.confirmaSenha(driver).sendKeys(ExcelUtils.getCellData(1, 3));
		DadosCadastro.primeiroNome(driver).sendKeys(ExcelUtils.getCellData(1, 4));
		DadosCadastro.ultimoNome(driver).sendKeys(ExcelUtils.getCellData(1, 5));
		DadosCadastro.telefone(driver).sendKeys(ExcelUtils.getCellData(1, 6));
		DadosCadastro.pais(driver);
		DadosCadastro.cidade(driver).sendKeys(ExcelUtils.getCellData(1, 8));
		DadosCadastro.endereco(driver).sendKeys(ExcelUtils.getCellData(1, 9));
		DadosCadastro.estado(driver).sendKeys(ExcelUtils.getCellData(1, 10));
		DadosCadastro.botaoAceito(driver).click();
		DadosCadastro.botaoRegistrar(driver).click();
		Assert.assertTrue(driver.getCurrentUrl().contains("/register"));
		
	}

	@After
	public void fechandoBrowser() throws Exception {
		Print.PrintScreenShot(driver, "target/print/" + Generator.dateHourPath() + "print.png");
		driver.close();
	}
}
