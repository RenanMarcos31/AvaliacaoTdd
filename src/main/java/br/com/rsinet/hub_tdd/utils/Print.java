package br.com.rsinet.hub_tdd.utils;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Print {

//    public static void PrintScreenShot(WebDriver driver) throws Exception {
//        File sFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(sFile, new File(
//                "C:\\Users\\renan.silva\\eclipse-workspace\\tdd\\src\\main\\java\\br\\com\\rsinet\\hub_tdd\\print_screen\\"
//                        + ExcelUtils.getCellData(1, 0) + Generator.dateHourPath() + ".png"));
//    }

	public static void PrintScreenShot(WebDriver driver, String arquivo) throws Exception {

		File sFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(sFile, new File(arquivo));
		} catch (Exception e) {
			System.out.println("problemas ao copiar" + e.getMessage());
		}
	}
}