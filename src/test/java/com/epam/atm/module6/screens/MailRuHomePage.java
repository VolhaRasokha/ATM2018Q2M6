package com.epam.atm.module6.screens;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MailRuHomePage extends AbstractPage {
	private static final String MAILRU_LOGIN_FIRST_ACCOUNT = "vra_atmmodule5";
	private static final String MAILRU_PASSWORD_FIRST_ACCOUNT = "123456789_Vra";
	private static final String MAILRU_LOGIN_SECOND_ACCOUNT = "vra_atmmodule6";
	private static final String MAILRU_PASSWORD_SECOND_ACCOUNT = "123456789_Vra";
	private static final String MAILRU_URL = "https://mail.ru/";
	
	private static final By SEARCH_LOGIN_LOCATOR = By.id("mailbox:login");
	private static final By SEARCH_PASSWORD_LOCATOR = By.id("mailbox:password");
	private static final By SEARCH_SUBMIT_LOCATOR = By.id("mailbox:submit");
	
	public MailRuHomePage(WebDriver driver) {
		super(driver);
	}
	
	public void startBrowser(){
		driver.get(MAILRU_URL);	
	}
	
	public void fillLoginFormFirstAccaunt(){
		WebElement login = driver.findElement(SEARCH_LOGIN_LOCATOR);
		login.clear();
		login.sendKeys(MAILRU_LOGIN_FIRST_ACCOUNT);
		
		WebElement password = driver.findElement(SEARCH_PASSWORD_LOCATOR);
		password.clear();
		password.sendKeys(MAILRU_PASSWORD_FIRST_ACCOUNT);
	}
	
	public void fillLoginFormSecondAccaunt(){
		WebElement login = driver.findElement(SEARCH_LOGIN_LOCATOR);
		login.clear();
		login.sendKeys(MAILRU_LOGIN_SECOND_ACCOUNT);
		
		WebElement password = driver.findElement(SEARCH_PASSWORD_LOCATOR);
		password.clear();
		password.sendKeys(MAILRU_PASSWORD_SECOND_ACCOUNT);
	}
	
	public MailRuAccountPage pressSubmit(){
		driver.findElement(SEARCH_SUBMIT_LOCATOR).click();
		return new MailRuAccountPage(driver);
	}
	
}
