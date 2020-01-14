package br.com.rsinet.hub_tdd.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.com.rsinet.hub_tdd.teste.ExcelUtils;
import net.bytebuddy.asm.Advice.Return;

public class RegistorPage {

		private WebDriver driver;
		private static WebElement element = null;
		
		public void inf(WebDriver driver) {
			this.driver = driver;
		}
		
		public static WebElement nomeUsuario (WebDriver driver) {
			element = driver.findElement(By.name("usernameRegisterPage"));
			return element;
		}
		
		public static WebElement email (WebDriver driver) {
			element = driver.findElement(By.name("emailRegisterPage"));
			return element;
		}
		public static WebElement senha (WebDriver driver) {
			element = driver.findElement(By.name("passwordRegisterPage"));
			return element;
		}
		
		public static WebElement confirmaSenha (WebDriver driver) {
			element = driver.findElement(By.xpath("//*[@id=\"formCover\"]/div[1]/div[2]/sec-view[2]/div/input"));
			return element;
		}
		public static WebElement primeiroNome (WebDriver driver) {
			element = driver.findElement(By.name("first_nameRegisterPage"));
			return element;
		}
		public static WebElement ultimoNome (WebDriver driver) {
			element = driver.findElement(By.name("last_nameRegisterPage"));
			return element;
		}
		public static WebElement telefone (WebDriver driver) {
			element = driver.findElement(By.name("phone_numberRegisterPage"));
			return element;
		}
		public static Select pais (WebDriver driver) {
			Select select = new Select(driver.findElement(By.xpath("//*[@id=\"formCover\"]/div[3]/div[1]/sec-view[1]/div/select")));
			select.selectByVisibleText("Brazil");
			return select;
		}
		
		public static WebElement cidade (WebDriver driver) {
			element = driver.findElement(By.name("cityRegisterPage"));
			return element;
		}
		
		public static WebElement endereco (WebDriver driver) {
			element = driver.findElement(By.name("addressRegisterPage"));
			return element;
		}
		
		public static WebElement estado (WebDriver driver) {
			element = driver.findElement(By.name("state_/_province_/_regionRegisterPage"));
			return element;
		}
		
		public static WebElement cep (WebDriver driver) {
			element = driver.findElement(By.name("state_/_province_/_regionRegisterPage"));
			return element;
		}
		public static WebElement botaoAceito (WebDriver driver) {
			element = driver.findElement(By.name("i_agree"));
			return element;
		}
		
		public static WebElement botaoRegistrar (WebDriver driver) {
			element = driver.findElement(By.id("register_btnundefined"));
			return element;
		}
		
	}
	

