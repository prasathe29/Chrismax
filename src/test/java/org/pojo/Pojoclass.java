package org.pojo;

import org.new1.Baseclass1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pojoclass extends Baseclass1{
    // non parameter constructor	
	WebDriver driver = new ChromeDriver();
	public Pojoclass() {
		PageFactory.initElements(driver, this);
	}
	//private webelement
	@CacheLookup
		@FindAll({
			
		@FindBy(xpath="//input[@type='text']")
		})
		private WebElement search;
	@CacheLookup
		@FindAll({
			@FindBy(xpath="//button[@type='submit']")
		})
		private WebElement click;
		//getter
		public WebElement getSearch() {
			return search;
		}
		public WebElement getClick() {
			return click;
		}
	}

