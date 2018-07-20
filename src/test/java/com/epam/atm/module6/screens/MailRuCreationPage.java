package com.epam.atm.module6.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailRuCreationPage extends AbstractPage{
	
	public static final String MAIL_TO_ADDRESS = "vra_atmmodule6@mail.ru";
	private static long currentKey = System.currentTimeMillis();
	public static final String SUBJECT = "TestSubject" + currentKey;
	private static final String TEXT_BODY = "TestTextBody" + currentKey;
	
	
	private static final By SEARCH_MAIL_TO_ADDRESS_LOCATOR = By.cssSelector("textarea[data-original-name = 'To']");
	private static final By SEARCH_MAIL_SUBJECT_LOCATOR = By.name("Subject");
	private static final By SEARCH_MAIL_BODY_LOCATOR = By.xpath("//iframe[starts-with(@id,'toolkit')]");
	private static final By SEARCH_TEXT_BODY_LOCATOR = By.id("tinymce");
	private static final By SEARCH_SAVE_DRAFT_BTN_LOCATOR = By.xpath("//*[@id='b-toolbar__right']//*[@data-name='saveDraft']");
	private static final By SEARCH_MAIL_SEND_BTN_LOCATOR = By.xpath("//*[@id='b-toolbar__right']//*[@data-name='send']");
	private static final By SEARCH_MAIL_SAVE_STATUS_LOCATOR = By.xpath("//*[@id='b-toolbar__right']//*[@data-mnemo='saveStatus']");
	private static final By SEARCH_ACTUAL_MAIL_TO_ADDRESS_LOCATOR = By.xpath("//*[@id='compose_to']");
	private static final By SEARCH_ACTUAL_MAIL_BODY_LOCATOR = By.xpath("//*[text()= '" + TEXT_BODY + "']");

	
	public MailRuCreationPage(WebDriver driver) {
		super(driver);
	}
	
	public void fillEMail(){
		waitForElementVisible(SEARCH_MAIL_TO_ADDRESS_LOCATOR);
		driver.findElement(SEARCH_MAIL_TO_ADDRESS_LOCATOR).clear();
		driver.findElement(SEARCH_MAIL_TO_ADDRESS_LOCATOR).sendKeys(MAIL_TO_ADDRESS);
		
		waitForElementVisible(SEARCH_MAIL_SUBJECT_LOCATOR);
		driver.findElement(SEARCH_MAIL_SUBJECT_LOCATOR).clear();
		driver.findElement(SEARCH_MAIL_SUBJECT_LOCATOR).sendKeys(SUBJECT);
		
		waitForElementVisible(SEARCH_MAIL_BODY_LOCATOR);
		WebElement mailBody = driver.findElement(SEARCH_MAIL_BODY_LOCATOR);
		driver.switchTo().frame(mailBody);
		driver.findElement(SEARCH_TEXT_BODY_LOCATOR).clear();
		driver.findElement(SEARCH_TEXT_BODY_LOCATOR).sendKeys(TEXT_BODY);
		driver.switchTo().defaultContent();		
	}
	
	public void pressSaveDraftBtn(){
		driver.findElement(SEARCH_SAVE_DRAFT_BTN_LOCATOR).click();
		waitForElementVisible(SEARCH_MAIL_SAVE_STATUS_LOCATOR);
	}
	
	public MailRuSentInfoPage pressMailSendBtn(){
		waitForElementVisible(SEARCH_MAIL_TO_ADDRESS_LOCATOR);
		waitForElementVisible(SEARCH_MAIL_SEND_BTN_LOCATOR);
		driver.findElement(SEARCH_MAIL_SEND_BTN_LOCATOR).click();
		return new MailRuSentInfoPage(driver);
	}
	
	public WebElement findActualMailToAddress(){
		waitForElementPresent(SEARCH_ACTUAL_MAIL_TO_ADDRESS_LOCATOR);
		return driver.findElement(SEARCH_ACTUAL_MAIL_TO_ADDRESS_LOCATOR);
	}
	
	public String getActualMailToAddress(){
		waitForElementPresent(SEARCH_ACTUAL_MAIL_TO_ADDRESS_LOCATOR);
		return findActualMailToAddress().getAttribute("value");
	}
	
	public boolean isMailBodyEnable(){
		return driver.findElement(SEARCH_ACTUAL_MAIL_BODY_LOCATOR).isEnabled();
		
	}
	

}
