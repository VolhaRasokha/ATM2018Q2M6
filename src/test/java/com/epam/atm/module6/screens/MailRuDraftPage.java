package com.epam.atm.module6.screens;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailRuDraftPage extends MailRuAccountPage {
	private static final By SEARCH_DRAFT_MAIL_LOCATOR = By
			.xpath("//*[contains(@href,'https://e.mail.ru/compose/')]");

	public MailRuDraftPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getFirstDraftMail() {
		waitForElementVisible(SEARCH_DRAFT_MAIL_LOCATOR);
		List<WebElement> draftMails = driver
				.findElements(SEARCH_DRAFT_MAIL_LOCATOR);
		WebElement draftMail = draftMails.get(0);
		return draftMail;
	}

	public MailRuCreationPage getDraftMailBySubject(String by_subject) {
		By SearchDraftMailBySubjectLicator = By.xpath("//*[text()='"
				+ by_subject + "']");
		waitForElementVisible(SearchDraftMailBySubjectLicator);
		driver.findElement(SearchDraftMailBySubjectLicator).click();
		return new MailRuCreationPage(driver);
	}

	public MailRuCreationPage openDraftMailBySubject(String by_subject) {
		By SearchDraftMailBySubjectLicator = By.xpath("//*[text()='"
				+ by_subject + "']");
		waitForElementVisible(SearchDraftMailBySubjectLicator);
		driver.findElement(SearchDraftMailBySubjectLicator).click();
		return new MailRuCreationPage(driver);
	}

	public String getFirstDraftMailSubject() {
		WebElement draftMail = getFirstDraftMail();
		String actualSubject = draftMail.getAttribute("data-subject");
		return actualSubject;
	}

	public MailRuCreationPage openFirstDraftMail() {
		WebElement draftMail = getFirstDraftMail();
		draftMail.click();
		return new MailRuCreationPage(driver);
	}
}
