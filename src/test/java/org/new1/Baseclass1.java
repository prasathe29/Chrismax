package org.new1;

import java.awt.AWTException;
import java.awt.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.hc.client5.http.impl.classic.MainClientExec;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass1 {

	static WebDriver driver;

	public static void browserLaunch(String name) {
		if (name.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (name.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (name.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
	}

	public static void url(String urlname) {
		driver.get(urlname);
	}

	public static void gettitle() {
		String title2 = driver.getTitle();
		System.out.println(title2);
	}
	public static void closeBrowser() {
       driver.close();
	}
	

	public static void geturl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public static void xpathClick(String location) {
		WebElement findElement = driver.findElement(By.xpath(location));
		findElement.click();
	}

	public static void gettext(String name) {
		WebElement tex = driver.findElement(By.xpath(name));
		String text = tex.getText();
		System.out.println(text);
	}

	public static Actions a;

	public static void moveelement(String xpath) {
		a = new Actions(driver);
		WebElement findElement = driver.findElement(By.xpath(xpath));
		a.moveToElement(findElement).perform();
		a.click().perform();
	}

	public static void enter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void screenshort(String name) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srs = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\epras\\eclipse-workspace\\Maven_new\\picture\\" + name + ".png");
	}

	public static void scroll(String boolea, String xpath) {
		JavascriptExecutor j = (JavascriptExecutor) driver;

		if (boolea.equals("true")) {
			WebElement scr = driver.findElement(By.xpath(xpath));
			j.executeScript("arguments[0].scrollIntoView(true)", scr);
		} else if (boolea.equals("false")) {
			WebElement scr = driver.findElement(By.xpath(xpath));
			j.executeScript("arguments[0].scrollIntoView(false)", scr);
		}
	}

	public static void alert(String name) {

		Alert al = driver.switchTo().alert();
		if (name.equals("accept")) {
			al.accept();
		} else if (name.equals("dismiss")) {
			al.dismiss();
		} else if (name.equals("getTextaccept")) {
			String text = al.getText();
			System.out.println(text);
			al.accept();
		}
	}

	public static void frameIn(String xpath) {
		WebElement findElement = driver.findElement(By.xpath(xpath));
		driver.switchTo().frame(findElement);
	}

	public static void dropDown(String xpath, String text) {
		WebElement element = driver.findElement(By.xpath(xpath));
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	public static void switchWindows(int windowlocation) {
		Set<String> wh = driver.getWindowHandles();

		java.util.List<String> l = new LinkedList<String>();
		l.addAll(wh);
		String firstid = l.get(windowlocation);
		driver.switchTo().window(firstid);
	}
	public static void xlfilecreate(int createrow, int createcell,String sheetname) throws IOException {
		File f = new File("C:\\Users\\epras\\eclipse-workspace\\Maven_new\\excel file\\newfile.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet cs = w.createSheet();
		Row cr = cs.createRow(createrow);
		Cell cc = cr.createCell(createcell);
		cc.setCellValue(sheetname);
		FileOutputStream fo = new FileOutputStream(f);
		w.write(fo);
		System.out.println("writen");	}
	public static void createRow (int createrow, int createcell,String data) throws IOException {
		File f = new File("C:\\Users\\epras\\eclipse-workspace\\Maven_new\\excel file\\newfile.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook();
		Sheet cs = w.createSheet("File1");
		Row cr = cs.createRow(createrow);
		Cell cc = cr.createCell(createcell);
		cc.setCellValue(data);
		FileOutputStream fo = new FileOutputStream(f);
		w.write(fo);
		System.out.println("writen");

	}

}
