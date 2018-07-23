package com.epam.atm.module6.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailRuAccountPage extends AbstractPage {
	
	private static final By SEARCH_AUT_ICON_LOCATOR = By.xpath("//*[@id='PH_user-email']");
	private static final By SEARCH_MAIL_CREATION_BTN_LOCATOR = By.xpath("//*[@id='b-toolbar__left']//a[(@data-name = 'compose')]");
	private static final By SEARCH_MAIL_DRAFT_MENU_LINK_LOCATOR = By.xpath("//*[contains(@class,'ico_folder_drafts')]");
	private static final By SEARCH_MAIL_SENT_MENU_LINK_LOCATOR = By.xpath("//*[contains(@class,'ico_folder_send')]");
	private static final By SEARCH_MAIL_INCOMING_MENU_LINK_LOCATOR = By.xpath("//*[contains(@class,'ico_folder_inbox')]");
	private static final By SEARCH_MAIL_BASKET_MENU_LINK_LOCATOR = By.xpath("//*[@id='b-nav_folders']//i[contains(@class,'ico_folder_trash')]");
	private static final By SEARCH_LOGOUT_LOCATOR = By.id("PH_logoutLink");
	Make all locators just private
	
	public MailRuAccountPage(WebDriver driver) {
		super(driver);
	}
	
	public String getAutIcon(){
		waitForElementVisible(SEARCH_AUT_ICON_LOCATOR);
		return driver.findElement(SEARCH_AUT_ICON_LOCATOR).getText();
	}
	
	public MailRuCreationPage pressMailCreationBtn(){
		driver.findElement(SEARCH_MAIL_CREATION_BTN_LOCATOR).click();
		return new MailRuCreationPage(driver);
	}
	
	public MailRuDraftPage clickMailDraftMenuLink(){
		waitForElementVisible(SEARCH_MAIL_DRAFT_MENU_LINK_LOCATOR);
		driver.findElement(SEARCH_MAIL_DRAFT_MENU_LINK_LOCATOR).click();
		return new MailRuDraftPage(driver);
	}
	
	public MailRuSentPage clickMailSentMenuLink(){
		driver.findElement(SEARCH_MAIL_SENT_MENU_LINK_LOCATOR).click();
		return new MailRuSentPage(driver);
	}
	
	public MailRuIncomingPage clickMailIncomingMenuLink(){
		driver.findElement(SEARCH_MAIL_INCOMING_MENU_LINK_LOCATOR).click();
		return new MailRuIncomingPage(driver);
	}
	
	public MailRuBasketPage clickBasketMenuLink(){
		driver.findElement(SEARCH_MAIL_BASKET_MENU_LINK_LOCATOR).click();
		return new MailRuBasketPage(driver);
	}
	
	public void clickLogOut(){
		driver.findElement(SEARCH_LOGOUT_LOCATOR).click();
	}

}
