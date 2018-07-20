package com.epam.atm.module6.screens;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailRuIncomingPage extends AbstractPage {
	private static final By SEARCH_INCOMING_MAIL_LOCATOR = By
			.xpath("//*[contains(@href,'https://e.mail.ru/thread/')]");
	private static final By SEARCH_CHECKBOX_OF_INCOMING_MAIL_LOCATOR = By
			.xpath("//div[@class='b-datalist__item__body']//*[@class='b-checkbox__box']");
	private static final By SEARCH_DELETE_BTN_LOCATOR = By
			.xpath("//*[@id='b-toolbar__right']/div[2]//div[@data-name='remove']");

	public MailRuIncomingPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getFirstIncomingMail() {
		waitForElementVisible(SEARCH_INCOMING_MAIL_LOCATOR);
		List<WebElement> incomingMails = driver
				.findElements(SEARCH_INCOMING_MAIL_LOCATOR);
		WebElement incomingMail = incomingMails.get(0);
		return incomingMail;
	}

	public String getIncomingMailSubject() {
		String incomingMailSubject = getFirstIncomingMail().getAttribute(
				"data-subject");
		return incomingMailSubject;
	}

	public void selectCheckBoxIncomingMail() {
		waitForElementVisible(SEARCH_CHECKBOX_OF_INCOMING_MAIL_LOCATOR);
		List<WebElement> incomingMailsCheckBoxes = driver
				.findElements(SEARCH_CHECKBOX_OF_INCOMING_MAIL_LOCATOR);
		WebElement firstIncomingMailCheckBox = incomingMailsCheckBoxes.get(0);
		firstIncomingMailCheckBox.click();
	}

	public void deleteIncomingMail() {
		selectCheckBoxIncomingMail();
		driver.findElement(SEARCH_DELETE_BTN_LOCATOR).click();
	}

}
