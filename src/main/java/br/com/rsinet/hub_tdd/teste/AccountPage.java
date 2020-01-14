package br.com.rsinet.hub_tdd.teste;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import br.com.rsinet.hub_tdd.page_objects.HomePage;
import br.com.rsinet.hub_tdd.page_objects.RegistorPage;
import br.com.rsinet.hub_tdd.suport.Web;

public class AccountPage {

	public static WebDriver driver = null;

	@Before
	public void starting() {
		driver = Web.createChrome();
	}

//	@Test
//	public void singIn() throws Exception {
//		
//	}

	@Test
	public void register() throws Exception {
		
		HomePage.botaoLogin(driver).click();
		HomePage.criarCadastro(driver).sendKeys(Keys.ENTER);

		ExcelUtils.setExcelFile(Constant.File_TestData, "Planilha1");

		RegistorPage.nomeUsuario(driver).sendKeys(ExcelUtils.getCellData(1, 0));
		RegistorPage.email(driver).sendKeys(ExcelUtils.getCellData(1, 1));
		RegistorPage.senha(driver).sendKeys(ExcelUtils.getCellData(1, 2));
		RegistorPage.confirmaSenha(driver).sendKeys(ExcelUtils.getCellData(1, 3));
		RegistorPage.primeiroNome(driver).sendKeys(ExcelUtils.getCellData(1, 4));
		RegistorPage.ultimoNome(driver).sendKeys(ExcelUtils.getCellData(1, 5));
		RegistorPage.telefone(driver).sendKeys(ExcelUtils.getCellData(1, 6));
		RegistorPage.pais(driver);
		RegistorPage.cidade(driver).sendKeys(ExcelUtils.getCellData(1, 8));
		RegistorPage.endereco(driver).sendKeys(ExcelUtils.getCellData(1, 9));
		RegistorPage.estado(driver).sendKeys(ExcelUtils.getCellData(1, 10));
		RegistorPage.botaoAceito(driver).click();
		RegistorPage.botaoRegistrar(driver).click();
	}

	@After
	public void closeBrowser() {
	}

}
