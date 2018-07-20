package com.epam.atm.module6.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailRuSentInfoPage extends MailRuAccountPage{
	
	private static final By SEARCH_MAIL_SENT_TITLE_LOCATOR = By.cssSelector("[class='message-sent__title']");


	public MailRuSentInfoPage(WebDriver driver) {
		super(driver);
	}
	
	public void searchMailSentTitle(){
		waitForElementVisible(SEARCH_MAIL_SENT_TITLE_LOCATOR);
		driver.findElement(SEARCH_MAIL_SENT_TITLE_LOCATOR);
	}

}
